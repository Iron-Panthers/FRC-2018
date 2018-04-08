package org.usfirst.frc.team5026.robot.commands.elevator;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.ElevatorDirection;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		double speed = -Robot.oi.elevatorStick.getY();
		//      Robot.elevator.checkPosition();
		if (Robot.elevator.getElevatorDirection() == ElevatorDirection.BACKWARDS) {
			// Elevator going down
			if (Robot.elevator.motors.getEncoderTicks() < 7000) { // 5000
				speed /= 2.5;
			}
		}
		if (Robot.elevator.getElevatorDirection() == ElevatorDirection.FORWARDS) {
			// Elevator going up
			if (Robot.elevator.motors.getEncoderTicks() > 82000) {
				speed /= 2.5;
			}
		}
		Robot.elevator.motors.driveWithPower(speed);
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