package org.usfirst.frc.team5026.robot.util;
import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.RobotMap;

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

	public double findX() {
		//if(Math.abs(x) < Constants.XDEADZONE_SIZE*Math.abs(driveStick.getY()) || Math.sqrt(driveStick.getY()*driveStick.getY() + driveStick.getX()*driveStick.getX()) < Constants.CIRCLE_DEADZONE) { 
		
		double x, y, magnitude;
		x = driveStick.getX();
		y = -driveStick.getY();
		magnitude = Math.sqrt(x*x + y*y);
				
		//if(Math.abs(y) < Constants.YDEADZONE_SIZE*Math.abs(driveStick.getX()) || magnitude < Constants.CIRCLE_DEADZONE) {
		if ( magnitude < Constants.CIRCLE_DEADZONE ) {
			x = 0;
		} else {
			double normX = x / magnitude;
			magnitude = (magnitude - Constants.CIRCLE_DEADZONE) / (1 - Constants.CIRCLE_DEADZONE);
			if (magnitude > 1) { 
				magnitude = 1;
			}
			
			x = normX * magnitude;
		}
		
		SmartDashboard.putNumber("deadzone corrected X", x);
		return x;
	}
	public double findY() {
		double x, y, magnitude;
		x = driveStick.getX();
		y = -driveStick.getY();
		magnitude = Math.sqrt(x*x + y*y);
				
		if(driveStickTrigger.get()) {
			System.out.println("REVERSED");
			y = -y;
		}
		
		//if(Math.abs(y) < Constants.YDEADZONE_SIZE*Math.abs(driveStick.getX()) || magnitude < Constants.CIRCLE_DEADZONE) {
		if ( magnitude < Constants.CIRCLE_DEADZONE ) {
			y = 0;
		} else {
			double normY = y / magnitude;
			magnitude = (magnitude - Constants.CIRCLE_DEADZONE) / (1 - Constants.CIRCLE_DEADZONE);
			if (magnitude > 1) { 
				magnitude = 1;
			}
			
			y = normY * magnitude * Constants.Y_AXIS_MODIFIER;
		}
		
		SmartDashboard.putNumber("deadzone corrected Y", y);
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


