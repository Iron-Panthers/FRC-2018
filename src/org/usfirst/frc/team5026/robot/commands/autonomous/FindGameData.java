package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.util.AutoPaths;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FindGameData extends Command {

	boolean finished = false;
    public FindGameData() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
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
    	System.out.println("Found game data!");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("Interrupted game data finder!");
    }
}
