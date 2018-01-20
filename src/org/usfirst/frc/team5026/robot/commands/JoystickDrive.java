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
	public double leftMotor;
	public double rightMotor;
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
//    	Robot.drive.useArcadeDrive(Robot.oi.driveStick.getY(), Robot.oi.driveStick.getX());
    	SmartDashboard.putNumber("Joystick X Axis", Robot.oi.driveStick.getX());
    	SmartDashboard.putNumber("Joystick Y Axis", Robot.oi.driveStick.getY());
    	//the below stuff is cool and it works as an arcade drive.
    	x = Robot.oi.driveStick.getX();
    	y = -Robot.oi.driveStick.getY();
    	leftMotor = y-x;
    	rightMotor = y+x;
    	if(rightMotor>1) {
    		rightMotor = 1;
    	}
    	if(leftMotor>1) {
    		leftMotor = 1;
    	}
    	Robot.drive.setLeftMotor(rightMotor);
    	Robot.drive.setRightMotor(leftMotor);
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
