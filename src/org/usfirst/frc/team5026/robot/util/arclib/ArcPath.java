package org.usfirst.frc.team5026.robot.util.arclib;

import java.util.ArrayList;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Put documentation here.
 */
public class ArcPath extends Command {
	double encoderValue;
	ArrayList<Double> rightPowers;
	ArrayList<Double> leftPowers;
	ArrayList<Double> encoderPositions;
	int sectionNumber;
	public ArcPath(ArrayList<Double> rightPowers, ArrayList<Double> leftPowers, ArrayList<Double> encoderPositions) {
		rightPowers = new ArrayList<Double>();
		leftPowers = new ArrayList<Double>();
		encoderPositions = new ArrayList<Double>();
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

//	 Called repeatedly when this Command is scheduled to run
	protected void execute() {
		encoderValue = Robot.hardware.rightM1.getSelectedSensorPosition(Constants.kPIDLoopIdx);
		double thisSectionStartPos = encoderPositions.get(sectionNumber);
		double thisSectionEndPos = encoderPositions.get(sectionNumber + 1);
		if( (thisSectionStartPos < thisSectionEndPos) == !(encoderValue > thisSectionEndPos) ) {
			sectionNumber ++;
		}
		double desiredRightPower = rightPowers.get(sectionNumber);
		double desiredLeftPower = leftPowers.get(sectionNumber);
		double currentRightPower = (Robot.hardware.rightM1.getSelectedSensorVelocity(Constants.kPIDLoopIdx))
				/ Constants.MAX_VELOCITY;
		double currentLeftPower = (Robot.hardware.leftM1.getSelectedSensorVelocity(Constants.kPIDLoopIdx))
				/ Constants.MAX_VELOCITY;
		Robot.hardware.rightM1.set(ControlMode.PercentOutput,
				desiredRightPower + Constants.ARCLIB_P * (desiredRightPower - currentRightPower));
		Robot.hardware.leftM1.set(ControlMode.PercentOutput,
				desiredLeftPower + Constants.ARCLIB_P * (desiredLeftPower - currentLeftPower));
//		Robot.hardware.leftM1.set(ControlMode.PercentOutput, 1);
//		Robot.hardware.rightM1.set(ControlMode.PercentOutput, 1);
//		System.out.println(Robot.hardware.leftM1.getSelectedSensorPosition(Constants.kPIDLoopIdx));
//		System.out.println(Robot.hardware.rightM1.getSelectedSensorPosition(Constants.kPIDLoopIdx));
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