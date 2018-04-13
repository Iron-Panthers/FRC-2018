package org.usfirst.frc.team5026.robot.commands.elevator;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorToToggleSwitchExchange extends Command {
	

	public int timeWithinTolerance;
	int target;

    public ElevatorToToggleSwitchExchange() {
        requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	target = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	switch(Robot.elevator.toggle) {
	    	case SWITCH:
	    		target = Constants.ELEVATOR_SWITCH_TARGET;
	    		Robot.elevator.raiseToSwitch();
	    		break;
	    	case EXCHANGE:
	    		target = Constants.ELEVATOR_EXCHANGE_TARGET;
	    		Robot.elevator.raiseToExchange();
	    		break;
    	}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Math.abs(target-Robot.elevator.motors.motor1.getSelectedSensorPosition(0))<Constants.ELEVATOR_TARGET_TOLERANCE){
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
