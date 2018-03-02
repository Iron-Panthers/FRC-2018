package org.usfirst.frc.team5026.robot.commands.conveyorbelt;

import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class ConveyorForTime extends TimedCommand {

	boolean isIntaking;
    public ConveyorForTime(boolean intake, double time) {
    	super(time);
        requires(Robot.conveyor);
        isIntaking = intake;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.conveyor.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (isIntaking) {
    		Robot.conveyor.forward();
    	} else {
    		Robot.conveyor.backward();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
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
