package org.usfirst.frc.team5026.robot.commands.elevator;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorTargetSliding extends Command {
	double target;
    public ElevatorTargetSliding() {
    	target =  Constants.ELEVATOR_TOP_TARGET;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.elevatorStick.getX() < Constants.SLIDER_DEADZONE) {
    		target = 0;
    	}
    	else {
    		target = target+Robot.oi.elevatorStick.getX()*Constants.SLIDER_SPEED; //increases or decreases target depending on how much the slider is moved
    	}
    	
    	Robot.elevator.motors.driveWithTarget(target);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
