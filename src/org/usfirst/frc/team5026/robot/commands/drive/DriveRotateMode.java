package org.usfirst.frc.team5026.robot.commands.drive;

import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveRotateMode extends Command {
	public double throttle;
	public double wheel;
	public double leftSpd;
	public double rightSpd;
    public DriveRotateMode() {
    	requires(Robot.drive);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	throttle = -Robot.oi.driveStick.getThrottle();
    	wheel = Robot.oi.driveStick.getWheel();
    	
    	int direction = (int) Math.signum(wheel);
    	
		rightSpd = Math.pow(wheel, 2) * direction;
		leftSpd = -Math.pow(wheel, 2) * direction;
		Robot.drive.setLeftSide(leftSpd);
		Robot.drive.setRightSide(rightSpd);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return throttle == 0;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
