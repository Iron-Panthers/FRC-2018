package org.usfirst.frc.team5026.robot.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BetterJoystick {

	public Joystick driveStick;
	public int arcadeButton = 0;
	public int reverseButton = 1;
	
	private GoodJoystick arcadeFallback;
	
	public BetterJoystick(int joystick){
		this.driveStick = new Joystick(joystick);
		arcadeFallback = new GoodJoystick(joystick);
	}
	
	public BetterJoystick(int joystick, int arcadeButton, int reverseButton) {
		this(joystick);
		this.arcadeButton = arcadeButton;
		this.reverseButton = reverseButton;
	}
	
	private double rawTurn() {
		return driveStick.getRawAxis(0);
	}
	
	private double rawThrottle() {
		return driveStick.getRawAxis(4);
	}
	
	public void seeAxis() {
		SmartDashboard.putNumber("Raw X", rawTurn());
		SmartDashboard.putNumber("Raw Y", rawThrottle());
	}

	private Vector findXY() {		
		double turn = deadzone(rawTurn(), Constants.CIRCLE_DEADZONE);		
		double throttle = deadzone(driveStick.getRawAxis(4), Constants.CIRCLE_DEADZONE);
		
		Vector result = new Vector(turn, -turn);
		result.mult(throttle);
		
		if (driveStick.getRawButton(reverseButton)) {
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
		if (driveStick.getRawButton(arcadeButton)) {
			Vector joy = arcadeFallback.findXY();
			return arcadeFallback.findLeftRightPower(joy.getX(), joy.getY());
		} else {
			return this.findXY();
		}
	}
	
}
