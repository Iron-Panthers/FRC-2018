package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.commands.autonomous.sequences.SequenceCenterToSwitchDropCube;
import org.usfirst.frc.team5026.robot.util.StartPosition;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class SelectSwitch extends Command {

	StartPosition start;
    public SelectSwitch(StartPosition position) {
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
    	System.out.println("Selecting a switch auto mode for "+start+" starting position");
    	switch (start) {
    	case LEFT:
    		// Left to Switch
    		break;
    	case CENTER:
    		// Center to Switch
    		Scheduler.getInstance().add(new SequenceCenterToSwitchDropCube());
    		System.out.println("Center to Switch autonomous selected!");
    		break;
    	case RIGHT:
    		// Right to Switch
    		break;
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
