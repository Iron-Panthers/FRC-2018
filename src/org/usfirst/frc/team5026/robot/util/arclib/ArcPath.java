package org.usfirst.frc.team5026.robot.util.arclib;

import java.util.ArrayList;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArcPath extends Command {
	ArrayList<Double> rightSideLengths;
	ArrayList<Double> leftSideLengths;
	double rightEncoderValue;
	double leftEncoderValue;
	double nextStartRightPower;
	double nextStartLeftPower;

	public ArcPath(ArrayList<Double> rightSideLengths, ArrayList<Double> leftSideLengths) {

		this.rightSideLengths = rightSideLengths;
		this.leftSideLengths = leftSideLengths;
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		rightEncoderValue = Robot.hardware.rightM1.getSelectedSensorPosition(Constants.kPIDLoopIdx);
		leftEncoderValue = Robot.hardware.leftM1.getSelectedSensorPosition(Constants.kPIDLoopIdx);
		System.out.println(rightEncoderValue + ", " + leftEncoderValue);
		
		for (int i = 0; i < rightSideLengths.size(); i++) {
			double DesiredRightEncoderValue = 0;
			double DesiredLeftEncoderValue = 0;
			double desiredRightPower = 0;
			double desiredLeftPower = 0;
			for (int p = 0; p <= i; p++) {
				DesiredRightEncoderValue += rightSideLengths.get(p)*Constants.TICKS_TO_INCHES;
				DesiredLeftEncoderValue += rightSideLengths.get(p)*Constants.TICKS_TO_INCHES;
			}
			if (rightEncoderValue < DesiredRightEncoderValue && leftEncoderValue < DesiredLeftEncoderValue) {
				double nextDesiredRightPower;
				double nextDesiredLeftPower;
				desiredRightPower = calcRightPower(leftSideLengths.get(i), rightSideLengths.get(i));
				desiredLeftPower = calcLeftPower(leftSideLengths.get(i), rightSideLengths.get(i));
				if(!(i == rightSideLengths.size()-1)) {
					nextDesiredRightPower = calcRightPower(leftSideLengths.get(i + 1), rightSideLengths.get(i + 1));
					nextDesiredLeftPower = calcLeftPower(leftSideLengths.get(i + 1), rightSideLengths.get(i + 1));
				}
				else{
					nextDesiredRightPower = 0;
					nextDesiredLeftPower = 0;
				}
				double rightDifference = Math.abs(desiredRightPower - nextDesiredRightPower);
				double leftDifference = Math.abs(desiredLeftPower - nextDesiredLeftPower);
				double maxAccel = .3; // TODO

				// TODO needs to be tuned and no magic numbers
				if (rightEncoderValue > DesiredRightEncoderValue - 150
						|| leftEncoderValue > DesiredLeftEncoderValue - 150) {
					if (rightDifference > leftDifference) {
						desiredRightPower = (desiredRightPower / rightDifference) * maxAccel;
						desiredLeftPower = (desiredLeftPower / rightDifference) * maxAccel;
						nextStartRightPower = (nextDesiredRightPower / rightDifference) * maxAccel;
						nextStartLeftPower = (nextDesiredLeftPower / rightDifference) * maxAccel;
					} else {
						desiredRightPower = (desiredRightPower / leftDifference) * maxAccel;
						desiredLeftPower = (desiredLeftPower / leftDifference) * maxAccel;
						nextStartRightPower = (nextDesiredRightPower / leftDifference) * maxAccel;
						nextStartLeftPower = (nextDesiredLeftPower / leftDifference) * maxAccel;
					}
				}

				// TODO needs to be tuned and no magic numbers
				else if (rightEncoderValue < DesiredRightEncoderValue + 150
						|| leftEncoderValue < DesiredLeftEncoderValue + 150) {
					desiredRightPower = nextStartRightPower;
					desiredLeftPower = nextStartLeftPower;
				}
			}
			double currentRightPower = (Robot.hardware.rightM1.getSelectedSensorVelocity(Constants.kPIDLoopIdx))/Constants.MAX_VELOCITY;
			double currentLeftPower = (Robot.hardware.leftM1.getSelectedSensorVelocity(Constants.kPIDLoopIdx))/Constants.MAX_VELOCITY;
			Robot.hardware.rightM1.set(ControlMode.PercentOutput, desiredRightPower + Constants.ARCLIB_P*(desiredRightPower - currentRightPower));
			Robot.hardware.leftM1.set(ControlMode.PercentOutput, desiredLeftPower + Constants.ARCLIB_P*(desiredLeftPower - currentLeftPower));
		}
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

	public double calcRightPower(double leftPathLength, double rightPathLength) {
		if (rightPathLength > leftPathLength) {
			return 1;
		} else {
			return rightPathLength / leftPathLength;
		}
	}

	public double calcLeftPower(double leftPathLength, double rightPathLength) {
		if (rightPathLength > leftPathLength) {
			return leftPathLength / rightPathLength;
		} else {
			return 1;
		}
	}
}
