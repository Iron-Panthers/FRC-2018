package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.util.StartPosition;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SelectScale extends Command {

	StartPosition start;
    public SelectScale(StartPosition position) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	start = position;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("Selecting a scale auto mode for "+start+" starting position");
    	switch (start) {
    	case LEFT:
    		break;
    	case RIGHT:
    		break;
    	case CENTER:
    		System.out.println("ATTEMPTED A SCALE AUTO WITH THE CENTER START POSITION!");
    	case UNKNOWN:
    	default:
    		// BASELINE GOES HERE
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
