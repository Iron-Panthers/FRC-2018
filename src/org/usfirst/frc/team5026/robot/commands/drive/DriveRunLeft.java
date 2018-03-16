package org.usfirst.frc.team5026.robot.commands.drive;

import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class DriveRunLeft extends TimedCommand {
	double p;

    public DriveRunLeft(double power, double time) {
    	super(time);
    	requires(Robot.drive);
    	p = power;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.setLeftSide(p);
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
