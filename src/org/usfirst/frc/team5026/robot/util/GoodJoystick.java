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
		SmartDashboard.putNumber("Raw X", driveStick.getX());
		SmartDashboard.putNumber("Raw Y", driveStick.getY());
	}
	//Robot.drive.useArcadeDrive(Robot.oi.driveStick.getX()*Constants.X_AXIS_MODIFIER, Robot.oi.driveStick.getY());

	public double findX() {
		double x;
		x = -driveStick.getX();
//		if(Robot.drive.isReversed) {
//			x = -x;
//		}
		if(Math.abs(x) < Constants.XDEADZONE_SIZE*Math.abs(driveStick.getY()) 
		|| Math.sqrt(driveStick.getY()*driveStick.getY() + driveStick.getX()*driveStick.getX()) < Constants.CIRCLE_DEADZONE) { 
			x=0; //circle deadzone
		}
		else {
			if(x<0) {
				x = (x + Constants.XDEADZONE_SIZE)/(1-Constants.XDEADZONE_SIZE);
			}
			else{
				x = (x - Constants.XDEADZONE_SIZE)/(1-Constants.XDEADZONE_SIZE);
			}
		}
		SmartDashboard.putNumber("Output X", x);
		return x*Constants.X_AXIS_MODIFIER;
	}
	public double findY() {
		double y;
		y = -driveStick.getY();
		if(driveStick.getTrigger()) {
			System.out.println("REVERSED");
			y = -y;
		}
		if(Math.abs(y) < Constants.YDEADZONE_SIZE*Math.abs(driveStick.getX())
		|| (Math.sqrt(driveStick.getY()*driveStick.getY() + driveStick.getX()*driveStick.getX()) < Constants.CIRCLE_DEADZONE)) {
			y = 0;
		}
		else {
			if(y<0) {
				y = (y + Constants.YDEADZONE_SIZE)/(1-Constants.YDEADZONE_SIZE);
			}
			else {
				y = (y - Constants.YDEADZONE_SIZE)/(1-Constants.YDEADZONE_SIZE);
			}
		}
		SmartDashboard.putNumber("Output Y", y);
		return y;
	}
	//k = Robot.oi.driveStick.getY()/Robot.oi.driveStick.getX();
	public double findRightPower(double x,double y) {
			return y-x;
	}
	public double findLeftPower(double x,double y) {
	        return y+x;
	}
	//Robot.drive.setLeftMotor(Robot.oi.driveStick.getY() + Robot.oi.driveStick.getX());
	//Robot.drive.setRightMotor(Robot.oi.driveStick.getY() - Robot.oi.driveStick.getX());
}


