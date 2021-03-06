package org.usfirst.frc.team5026.robot.commands.climb;

import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class ClimbForTime extends TimedCommand {

    public ClimbForTime(double timeout) {
        super(timeout);
        requires(Robot.climb);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.climb.up();
    }

    // Called once after timeout
    protected void end() {
    	Robot.climb.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
