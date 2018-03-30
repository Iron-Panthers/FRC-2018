package org.usfirst.frc.team5026.robot.util;
import java.util.function.Function;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GoodJoystick {
	private final Function<Double, Double> interpolator = (x) -> x*x;
	public Joystick driveStick;
	public JoystickButton driveStickTrigger; 
	public GoodJoystick(int port){
		driveStick = new Joystick(port);
		driveStickTrigger = new JoystickButton(driveStick, 1);
	}
	
	public GoodJoystick(Joystick stick){
		driveStick = stick;
		driveStickTrigger = new JoystickButton(driveStick, 1);
	}
	
	public void seeAxis() {
		SmartDashboard.putNumber("Raw X", driveStick.getX());
		SmartDashboard.putNumber("Raw Y", driveStick.getY());
	}
	//Robot.drive.useArcadeDrive(Robot.oi.driveStick.getX()*Constants.X_AXIS_MODIFIER, Robot.oi.driveStick.getY());

	public Vector findXY() {		
		Vector v = new Vector(driveStick.getX(), -driveStick.getY());
		double magnitude = v.getMagnitude();
		double scaledMagnitude = deadzone(magnitude, Constants.CIRCLE_DEADZONE);
		v.norm();
		v.mult(scaledMagnitude);

		double x = Math.abs(v.getX());
		double y = Math.abs(v.getY());

		x = deadzone(x, Constants.XCROSS_DEADZONE);
		y = deadzone(y, Constants.YCROSS_DEADZONE);

		x = Math.copySign(x, v.getX());
		y = Math.copySign(y, v.getY());

		v.set(x, y);

		SmartDashboard.putNumber("deadzone corrected X", v.getX());
		SmartDashboard.putNumber("deadzone corrected Y", v.getY());
		return v;
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
	 * Interpolates some value in one range to another value in another range, with a 
	 * provided interpolation function.
	 * @param x the value
	 * @param a1 lower bound of original range
	 * @param b1 upper bound of original range
	 * @param a2 lower bound of new range
	 * @param b2 upper bound of new range
	 * @param f an interpolation function that passes through (0, 0) and (1, 1).
	 * @return the interpolated number
	 */
	public static double interp(double x, double a1, double b1, double a2, double b2, Function<Double, Double> f) {
		return (b2 - a2) * f.apply((x - a1) / (b1 - a1)) + a2;	
	}
	
	/**
	 * Finds left and right power for motors using joystick x and y.
	 * Uses arcade drive
	 * 
	 * @param x X value on joystick (-1 = left, 1 = right)
	 * @param y Y value on joystick (-1 = bottom, 1 = top)
	 * @return vector with x = left motor power, y = right motor power
	 */
	public Vector findLeftRightPower(double x, double y) {
		double absX = Math.abs(x);
		double absY = Math.abs(y);
		double maxX = lerp(absY, 0, 1, 1, Constants.TURN_MIN_CLAMP_X);
		double maxY = lerp(absX, 0, 1, 1, Constants.TURN_MIN_CLAMP_Y);
		double outX = lerp(absX, 0, 1, 0, maxX);
		double outY = lerp(absY, 0, 1, 0, maxY);
		outX = Math.copySign(outX, x);
		outX = outX * -1;
		outY = Math.copySign(outY, y);
		
		return new Vector(outY + outX, outY - outX);		
	}

	//Robot.drive.setLeftMotor(Robot.oi.driveStick.getY() + Robot.oi.driveStick.getX());
	//Robot.drive.setRightMotor(Robot.oi.driveStick.getY() - Robot.oi.driveStick.getX());
}


