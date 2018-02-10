package org.usfirst.frc.team5026.robot.util;
import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GoodJoystick {
	public Joystick driveStick;
	public GoodJoystick(int port){
		driveStick = new Joystick(port);
	}
	public void seeAxis() {
		SmartDashboard.putNumber("Joystick X Axis", driveStick.getX());
		SmartDashboard.putNumber("Joystick Y Axis", driveStick.getY());
	}
	//Robot.drive.useArcadeDrive(Robot.oi.driveStick.getX()*Constants.X_AXIS_MODIFIER, Robot.oi.driveStick.getY());

	public double findX() {
		double x;
		x = driveStick.getX();
		if(Robot.drive.isReversed) {
			x = -x;
		}
		if(Math.abs(x) < Constants.XDEADZONE_SIZE*Math.abs(driveStick.getY())) {
			x=0;
		}
		else if(Math.sqrt(driveStick.getY()*driveStick.getY() + driveStick.getX()*driveStick.getX()) < Constants.CIRCLE_DEADZONE) {
			x=0;
		}
		else {
			x = (x - Constants.YDEADZONE_SIZE);
		}
		return x;
	}
	public double findY() {
		double y;
		y = -driveStick.getY();
		if(Robot.drive.isReversed) {
			y = -y;
		}
		if(Math.abs(y) < Constants.YDEADZONE_SIZE*Math.abs(driveStick.getX())) {
			y=0;
		}
		else if(Math.sqrt(driveStick.getY()*driveStick.getY() + driveStick.getX()*driveStick.getX()) < Constants.CIRCLE_DEADZONE) {
			y=0;
		}
		else {
			y = (y - Constants.YDEADZONE_SIZE)/1-Constants.YDEADZONE_SIZE;
		}
		return y;
	}
	//k = Robot.oi.driveStick.getY()/Robot.oi.driveStick.getX();
	public double findRightPower(double x,double y) {
			double right;
			right = y - x;
			return right;
	}
	public double findLeftPower(double x,double y) {
			double left;
	        left = y + x;
	        return left;
	}
//	Robot.drive.setLeftMotor(Robot.oi.driveStick.getY() + Robot.oi.driveStick.getX());
//	Robot.drive.setRightMotor(Robot.oi.driveStick.getY() - Robot.oi.driveStick.getX());
}


