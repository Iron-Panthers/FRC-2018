package org.usfirst.frc.team5026.robot.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BetterJoystick {

	public Joystick driveStick;
	public Button arcadeButton;
	public Button reverseButton;
	
	private GoodJoystick arcadeFallback;
	
	public BetterJoystick(int joystick){
		this.driveStick = new Joystick(joystick);
		arcadeFallback = new GoodJoystick(driveStick);
		this.reverseButton = new JoystickButton(this.driveStick, 1);
		this.arcadeButton = new JoystickButton(this.driveStick, 2);
	}
	
	public BetterJoystick(int joystick, int arcadeButton, int reverseButton) {
		this(joystick);
		this.arcadeButton = new JoystickButton(this.driveStick, arcadeButton);
		this.reverseButton = new JoystickButton(this.driveStick, reverseButton);
	}
	
	private double rawTurn() {
		return driveStick.getX();
	}
	
	private double rawThrottle() {
		return -driveStick.getZ();
	}
	
	public void seeAxis() {
		SmartDashboard.putNumber("Raw X", rawTurn());
		SmartDashboard.putNumber("Raw Y", rawThrottle());
	}

	private Vector findXY() {		
		int sign = 1;
		double throttle = rawThrottle();
		if (throttle > 0) {
			sign = -1;
			throttle = deadzone(throttle, Constants.CIRCLE_DEADZONE);
		} else {
			throttle = -deadzone(-throttle, Constants.CIRCLE_DEADZONE);
		}
		
		double turn = sign * rawTurn();
		if (turn > 0) {
			turn = deadzone(turn, Constants.CIRCLE_DEADZONE);
		} else {
			turn = -deadzone(-turn, Constants.CIRCLE_DEADZONE);
		}
		
		Vector result = new Vector(turn, -turn);
		result.mult(throttle);
		
		if (reverseButton.get()) {
			throttle *= -1;
		}
		
		result.add(throttle);
		return result;
	}

	public static double deadzone(double x, double dzone) {
		if (x < dzone) {
			return 0;
		}
		if (x > 1) {
			return 1;
		}
		return (x - dzone) / (1 - dzone);
	}

	/**
	 * Linearly interpolates some value in one range to another value in another range.
	 * @param x the value
	 * @param a1 lower bound of original range
	 * @param b1 upper bound of original range
	 * @param a2 lower bound of new range
	 * @param b2 upper bound of new range
	 * @return the linearly interpolated number
	 */
	public static double lerp(double x, double a1, double b1, double a2, double b2) {
		return (b2 - a2) * (x - a1) / (b1 - a1) + a2;
	}

	/**
	 * Finds left and right power for motors using joystick x and y.
	 * @return vector with x = left motor power, y = right motor power
	 */
	public Vector findLeftRightPower() {
		if (arcadeButton.get()) {
			arcadeFallback.seeAxis();
			Vector joy = arcadeFallback.findXY();
			SmartDashboard.putNumber("go", joy.getY());
			return arcadeFallback.findLeftRightPower(joy.getX(), joy.getY());
		} else {
			return this.findXY();
		}
	}
	
}
