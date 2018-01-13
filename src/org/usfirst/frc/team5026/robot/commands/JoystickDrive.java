package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoystickDrive extends Command {
	public double k;
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
    	//Robot.drive.useArcadeDrive;
    	k = Robot.oi.stick.getY()/Robot.oi.stick.getX();
    	Robot.drive.setLeftMotor(Robot.oi.stick.getY()*k+Robot.oi.stick.getX()*(1-k));
    	Robot.drive.setRightMotor(Robot.oi.stick.getY()*k-Robot.oi.stick.getX()*(1-k));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.setLeftMotor(0);
    	Robot.drive.setRightMotor(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
