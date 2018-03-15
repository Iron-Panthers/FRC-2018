package org.usfirst.frc.team5026.robot.util;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GoodJoystick {
	public Joystick driveStick;
	public JoystickButton driveStickTrigger; 
	public GoodJoystick(int port){
		driveStick = new Joystick(port);
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
		double scaledMagnitude = deadzone(Math.min(Math.max(magnitude, -1), 1), Constants.CIRCLE_DEADZONE);
		v.norm();
		v.mult(scaledMagnitude);
		
		double x = v.getX();
		double y = v.getY();
		double absX = Math.abs(x);
		double absY = Math.abs(y);
		double baseX = absY * Constants.XDEADZONE_SIZE;
		double baseY = absX * Constants.YDEADZONE_SIZE;
		if (absX > baseX) {
			v.setX(Math.copySign(lerp(absX, 0, 1, baseX, 1), x));
		} else {
			v.setX(0);
		}
		if (absY > baseY) {
			v.setY(Math.copySign(lerp(absY, 0, 1, baseY, 1), y));
		} else {
			v.setY(0);
		}
		System.out.println(x + "\t" + y + "\t" + v.getX() + "\t" + v.getY());
		SmartDashboard.putNumber("deadzone corrected X", v.getX());
		SmartDashboard.putNumber("deadzone corrected Y", v.getY());
		return v;
	}
	
	public static double deadzone(double x, double dzone) {
		if (x < dzone) {
			return 0;
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

	//k = Robot.oi.driveStick.getY()/Robot.oi.driveStick.getX();
	public double findRightPower(double x,double y) {
		return y - x;
	}
	public double findLeftPower(double x,double y) {
	        return y+x;
	}
	
	public static void main(String[] args) {
		System.out.println(lerp(3, 0, 5, 0, 10));
		System.out.println(lerp(6, 5, 10, 0, 10));
		System.out.println(lerp(26, 20, 25, 0, 10));
	}
	//Robot.drive.setLeftMotor(Robot.oi.driveStick.getY() + Robot.oi.driveStick.getX());
	//Robot.drive.setRightMotor(Robot.oi.driveStick.getY() - Robot.oi.driveStick.getX());
}


