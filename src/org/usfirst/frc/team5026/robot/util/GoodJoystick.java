package org.usfirst.frc.team5026.robot.util;
import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GoodJoystick {
	public double x;
	public double y;
	public Joystick driveStick;
	int port;
	public GoodJoystick(int port){
		driveStick = new Joystick(port);
		this.port = port;
	}
	double right;
	double left;
	public void seeAxis() {
		SmartDashboard.putNumber("Joystick X Axis", driveStick.getX());
		SmartDashboard.putNumber("Joystick Y Axis", driveStick.getY());
	}
	//Robot.drive.useArcadeDrive(Robot.oi.driveStick.getX()*Constants.X_AXIS_MODIFIER, Robot.oi.driveStick.getY());

	public void findXY() {
		y = -driveStick.getY();
		x = driveStick.getX();
		if(Math.abs(y) < Constants.YDEADZONE_SIZE) {
			y=0;
		}
		if(Math.abs(x) < Constants.XDEADZONE_SIZE) {
			x=0;
		}
		x = (x - Constants.XDEADZONE_SIZE);
		y = (y - Constants.YDEADZONE_SIZE);
		if(Robot.drive.isReversed) {
			y = -y;
			x = -x;
		}
	}
	//k = Robot.oi.driveStick.getY()/Robot.oi.driveStick.getX();
	public double findRightPower() {
			right = y - x;
			return right;
	}
	public double findLeftPower() {
	        left = y + x;
	        return left;
	}
//	Robot.drive.setLeftMotor(Robot.oi.driveStick.getY() + Robot.oi.driveStick.getX());
//	Robot.drive.setRightMotor(Robot.oi.driveStick.getY() - Robot.oi.driveStick.getX());
}


