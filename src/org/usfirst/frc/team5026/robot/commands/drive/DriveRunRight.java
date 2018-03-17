package org.usfirst.frc.team5026.robot.commands.drive;

import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class DriveRunRight extends TimedCommand {
	double p;

    public DriveRunRight(double power, double time) {
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
    	Robot.drive.setRightSide(p);
    	Robot.drive.setLeftSide(p < 0 ? -p-0.5 : -p+0.5);
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
