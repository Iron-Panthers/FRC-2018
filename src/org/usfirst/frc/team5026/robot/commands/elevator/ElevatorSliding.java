package org.usfirst.frc.team5026.robot.commands.elevator;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.ElevatorPosition;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorSliding extends Command {

    public ElevatorSliding() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	Robot.elevator.checkPosition();
    	if(Robot.elevator.position == ElevatorPosition.UP) {
    		Robot.elevator.motors.driveWithPower(-Robot.oi.elevatorStick.getY());
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.elevator.stop();
    }
}
