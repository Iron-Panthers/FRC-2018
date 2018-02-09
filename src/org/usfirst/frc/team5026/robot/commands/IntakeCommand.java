package org.usfirst.frc.team5026.robot.commands;
 
import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
 
/**
 *
 */
public class IntakeCommand extends Command {
	public double lastVoltage;
	public double lastCurrent;
	public int timeNotGrabbed;
	public int time;
	public IntakeCommand() {
		requires(Robot.intake);
		lastVoltage = 0;
		lastCurrent = 0;
		timeNotGrabbed = 0;
		time = 0;
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
	}
	 
	// Called just before this Command runs the first time
	protected void initialize() {
	}
	 
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
//		//Algorithm for lowering power to not burn out the motor
//		if(time>Constants.SPEED_UP_TIME) {
//			if(Robot.intake.hasBlock()) {
//				timeNotGrabbed = 0; //If it is grabbed, reset the timer
//				Robot.intake.intake(Constants.SLOW_INTAKE_POWER);
//				Robot.hasBlock = true;
//			}
//			else {
//				timeNotGrabbed++;
//				if(timeNotGrabbed>Constants.TIME_NOT_GRABBED_THRESHOLD) {
//					Robot.intake.intake(Constants.INTAKE_POWER);
//					Robot.hasBlock = false;
//				}
//			}
//		}
//		else {
		Robot.intake.intake(Robot.oi.driveStick.getY());
//		}
		
		
	}
	 
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
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