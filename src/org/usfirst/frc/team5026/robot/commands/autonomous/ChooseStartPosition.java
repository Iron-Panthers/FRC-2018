package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.util.AutoPaths;
import org.usfirst.frc.team5026.robot.util.StartPosition;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 *
 */
public class ChooseStartPosition extends Command {

	StartPosition position;
	public SendableChooser<Command> chooser = new SendableChooser<Command>();

    public ChooseStartPosition(StartPosition start) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	position = start;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	AutoPaths.startPosition = position;
    	chooser.addDefault("Switch", new SelectSwitch(position));
    	switch (position) {
    	case LEFT:
    		chooser.addObject("Scale", new SelectScale(position));
    		break;
    	case CENTER:
    		// Only switch works here!
    		break;
    	case RIGHT:
    		chooser.addObject("Scale", new SelectScale(position));
    		break;
    	case UNKNOWN:
    	default:
    	}
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
