package org.usfirst.frc.team5026.robot.commands.autonomous.selections;

import org.usfirst.frc.team5026.robot.util.StartPosition;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public abstract class SelectionCommand extends Command {

	StartPosition start;
	public Command choice;
	
    public SelectionCommand(StartPosition position) {
    	start = position;
    	choice = null;
    }

    // Called just before this Command runs the first time
    protected abstract void initialize();

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
