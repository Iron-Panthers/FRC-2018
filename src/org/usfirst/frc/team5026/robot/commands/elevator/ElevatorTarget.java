package org.usfirst.frc.team5026.robot.commands.elevator;

import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ElevatorTarget extends Command {


	int target = Integer.MAX_VALUE;
	public ElevatorTarget() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.elevator);
	}

	public ElevatorTarget(int t) {
		requires(Robot.elevator);
		target = t;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.elevator.stop();
		if (target == Integer.MAX_VALUE) {
			target = (int)SmartDashboard.getNumber("Elevator Target", 0);
		}
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		//      Robot.elevator.checkPosition();
		Robot.elevator.raiseToTarget(target);
		SmartDashboard.putNumber("Elevator Position", Robot.elevator.motors.getEncoderTicks());
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