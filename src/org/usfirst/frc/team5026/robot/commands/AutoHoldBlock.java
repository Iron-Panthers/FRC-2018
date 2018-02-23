package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoHoldBlock extends Command {
	double error;
	int timeWithoutBlock;
    public AutoHoldBlock() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	error = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	error = Constants.HOLD_BLOCK_CURRENT_TARGET - Robot.intake.motor.getOutputCurrent();
    	Robot.intake.intake(Constants.HOLD_BLOCK_P * error + Constants.INTAKE_VOLTAGE_HOLD);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//Stops when there is no block
        if(Robot.intake.motor.getOutputCurrent()<(Constants.HOLD_BLOCK_NO_BLOCK_CURRENT + Constants.HOLD_BLOCK_NO_BLOCK_TOLERANCE)) {
        	timeWithoutBlock++;
        }
        else {
        	timeWithoutBlock = 0;
        }
        return timeWithoutBlock > Constants.HOLD_BLOCK_NO_BLOCK_STOP_TIME;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.intake.stop();
    }
}
