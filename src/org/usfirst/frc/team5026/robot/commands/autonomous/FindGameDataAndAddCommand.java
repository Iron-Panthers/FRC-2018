package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.util.AutoPaths;
import org.usfirst.frc.team5026.robot.util.PlatformState;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * This command finds and updates the game data, as well as adds a command to the scheduler depending on if it is left or right
 */
public class FindGameDataAndAddCommand extends Command {

	Command left;
	Command right;
	boolean finished = false;
    public FindGameDataAndAddCommand(Command forLeft, Command forRight) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	left = forLeft;
    	right = forRight;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	finished = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	String message = DriverStation.getInstance().getGameSpecificMessage();
    	if (message.length() > 0) {
    		finished = true;
    		AutoPaths.updateData(message);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	if (AutoPaths.ALLY_SWITCH_STATE == PlatformState.LEFT) {
    		Scheduler.getInstance().add(left);
    	} else if (AutoPaths.ALLY_SWITCH_STATE == PlatformState.RIGHT) {
    		Scheduler.getInstance().add(right);
    	} else {
    		// This should never happen!
    		System.out.println("Failed to setup field data BUT command still ended!");
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("Interrupted field data getter!");
    }
}
