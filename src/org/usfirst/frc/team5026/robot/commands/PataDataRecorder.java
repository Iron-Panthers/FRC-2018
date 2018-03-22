package org.usfirst.frc.team5026.robot.commands;

import java.util.ArrayList;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PataDataRecorder extends Command {

	private ArrayList<Double> leftPathData;
	private ArrayList<Double> rightPathData;
	private int count;
	
	public PataDataRecorder() {
	// Use requires() here to declare subsystem dependencies
	// eg. requires(chassis);
		requires(Robot.drive);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		this.leftPathData = new ArrayList<Double>();
		this.rightPathData = new ArrayList<Double>();
		count = 0;
		Robot.drive.resetEncoders();
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (count % Constants.EXECUTE_LOOPS_PER_SAMPLE == 0) {
			this.leftPathData.add(Robot.drive.getLeftEncoderPosition());
			this.rightPathData.add(Robot.drive.getRightEncoderPosition());
		}
		count++;
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
		System.out.println("Left Path Data: " + this.leftPathData);
		System.out.println("Right Path Data: " + this.rightPathData);
	} 
	
	public ArrayList<Double> getLeftPathData() {
		return this.leftPathData;
	}
	
	public ArrayList<Double> getRightPathData() {
		return this.rightPathData;
	}
}
