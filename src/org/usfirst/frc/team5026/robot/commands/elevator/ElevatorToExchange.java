package org.usfirst.frc.team5026.robot.commands.elevator;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorToExchange extends Command {
	public int timeWithinTolerance;
    public ElevatorToExchange() {
    	requires(Robot.elevator);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timeWithinTolerance = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.raiseToTarget(Constants.ELEVATOR_EXCHANGE_TARGET);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (Math.abs(Constants.ELEVATOR_EXCHANGE_TARGET-Robot.elevator.motors.motor1.getSelectedSensorPosition(0))<Constants.ELEVATOR_TARGET_TOLERANCE){
    		timeWithinTolerance++;
    	}
    	return timeWithinTolerance>Constants.ELEVATOR_TOLERANCE_TIME;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
