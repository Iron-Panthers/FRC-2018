package org.usfirst.frc.team5026.robot.commands.drive;

import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveUntilCube extends Command {

	private int ticks = 0;
	private boolean forward = true;
	private double power = 0.4;
	private int tolerance = 500;
	private int count = 0;
	
    public DriveUntilCube() {
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	ticks = Robot.drive.left.getEncoderTicks();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (forward) {
    		Robot.drive.left.set(power);
    		Robot.drive.right.set(power);
    		
    		if (Robot.intake.hasBlock()) {
    			Robot.drive.left.set(0);
        		Robot.drive.right.set(0);
        		forward = false;
    		}
    	} else {
    		Robot.drive.driveWithTarget(ticks);
    		if (Math.abs(ticks - Robot.drive.left.getEncoderTicks()) < tolerance) {
        		count++;
        	}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return count > 3;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
