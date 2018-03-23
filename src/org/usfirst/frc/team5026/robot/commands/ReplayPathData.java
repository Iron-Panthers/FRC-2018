package org.usfirst.frc.team5026.robot.commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.CSVData;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ReplayPathData extends Command {
	
	ArrayList<ArrayList<Double>> data;
	long startTime;
	boolean usePID;
	double P = 0.05;
	
	public ReplayPathData(boolean usePID) {
		requires(Robot.drive); // Requires so that Joystick drive is overridden
		this.usePID = usePID;
	}
	
	protected void initialize() {
		String path = SmartDashboard.getString("CSV Read Path", "");
		if (usePID) {
			data = CSVData.interp(CSVData.readFromCsv(path, 7)); // 7 for time, leftPower, rightPower, leftPos, rightPos, leftV, rightV
		} else {
			data = CSVData.interp(CSVData.readFromCsv(path, 3)); // 3 for time, leftPower, rightPower
		}
		startTime = System.currentTimeMillis();
	}

	protected void execute() {
		if (data.get(0).size() == 0) {
			return;
		}

		int index = (int)(System.currentTimeMillis() - startTime);
		
		if (this.usePID) {
			double leftError = getLeftError(index);
			double rightError = getRightError(index);
			double leftPower = data.get(1).get(index);
			double rightPower = data.get(2).get(index);
			
			leftPower += leftError * P;
			rightPower += rightError * P;
			
			Robot.drive.left.set(leftPower);
			Robot.drive.right.set(rightPower);
		} else {
			double leftPower = data.get(1).get(index);
			double rightPower = data.get(2).get(index);
			
			Robot.drive.left.set(leftPower);
			Robot.drive.right.set(rightPower);
		}
	}
	
	private double getLeftError(int index) {
		double arc = Robot.drive.getLeftEncoderPosition();
		return arc - data.get(3).get(index);
	}
	private double getRightError(int index) {
		double arc = Robot.drive.getRightEncoderPosition();
		return arc - data.get(4).get(index);
	}

	
	@Override
	protected boolean isFinished() {
		// Can either be when our index is past our array, or when our time is past the end of the array.
		// For now, use time.
		return (System.currentTimeMillis() - startTime) >= data.get(0).size();
	}
	
	protected void end() {
		Robot.drive.stop();
	}

}
