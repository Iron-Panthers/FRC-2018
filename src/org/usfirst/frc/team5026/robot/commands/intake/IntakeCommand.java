package org.usfirst.frc.team5026.robot.commands.intake;
 
import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
 
/**
 *
 */

public class IntakeCommand extends Command {
	
	public double time;
	
	public IntakeCommand() {
		requires(Robot.intake);
		time = 0;
	}
	 
	// Called just before this Command runs the first time
	protected void initialize() {
		time = 0;
		Robot.intake.stop();
	}
	 
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.intake.intake(Constants.INTAKE_VOLTAGE_GRAB);
		time++;
	} 
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (time>Constants.INTAKE_SPEED_UP_TIME) {
			return Robot.intake.hasBlock();
		}
		return false;
		
	}
	// Called once after isFinished returns true
	protected void end() {
		Robot.intake.stop();
		System.out.println("Adding HoldBlock!");
		Scheduler.getInstance().add(new HoldBlock());
	}
	 
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.intake.stop();
	}
}