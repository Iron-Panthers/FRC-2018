package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class JoystickDrive extends Command {
	public double k;
	public double y;
	public double x;
	public double leftSide;
	public double rightSide;
    public JoystickDrive() {
    	requires(Robot.drive);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double right;
    	double left;
    	Robot.drive.useArcadeDrive(-Robot.oi.driveStick.getX(), Robot.oi.driveStick.getY());
//    	SmartDashboard.putNumber("Joystick X Axis", Robot.oi.driveStick.getX());
//    	SmartDashboard.putNumber("Joystick Y Axis", Robot.oi.driveStick.getY());
    	//k = Robot.oi.driveStick.getY()/Robot.oi.driveStick.getX();
//    	right = Robot.oi.driveStick.getY() - Robot.oi.driveStick.getX();
//    	left = Robot.oi.driveStick.getY() + Robot.oi.driveStick.getX();
//    	Robot.drive.setLeftMotor(Robot.oi.driveStick.getY() + Robot.oi.driveStick.getX());
//    	Robot.drive.setRightMotor(Robot.oi.driveStick.getY() - Robot.oi.driveStick.getX());
//    	if(right < 1) {
//    		Robot.drive.setRightMotor(right);
//    	}
//    	else {
//    		Robot.drive.setRightMotor(1);
//    	}
//    	if(left < 1) {
//    		Robot.drive.setLeftMotor(left);
//    	}
//    	else {
//    		Robot.drive.setLeftMotor(1);
//    	}	
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
