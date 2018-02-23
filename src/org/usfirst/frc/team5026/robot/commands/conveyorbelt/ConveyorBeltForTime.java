package org.usfirst.frc.team5026.robot.commands.conveyorbelt;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class ConveyorBeltForTime extends TimedCommand {

	public ConveyorBeltForTime(double timeout) {
		super(timeout);
		requires(Robot.conveyor);
		// TODO Auto-generated constructor stub
	}
	// Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.conveyor.forward(Constants.CONVEYOR_SPEED);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.conveyor.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.conveyor.stop();
    }
}
