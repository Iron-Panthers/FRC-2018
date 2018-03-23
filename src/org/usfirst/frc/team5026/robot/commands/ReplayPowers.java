package org.usfirst.frc.team5026.robot.commands;

import java.util.ArrayList;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.CSVData;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ReplayPowers extends Command {
	
	private ArrayList<ArrayList<Double>> data;
	
	long startTime;
	
	public ReplayPowers() {
		requires(Robot.drive); // Requires so that Joystick drive is overridden
	}
	
	protected void initialize() {
		String path = SmartDashboard.getString("CSV Read Path", "");
		data = CSVData.readFromCsv(path, 3); // 3 for time, leftPower, rightPower
	}

	protected void execute() {
		if (data.get(0).size() == 0) {
			return;
		}
		
		// Given that the CSV file contains times now, it would be trivial to do a binary search, or even something faster
		// For now, we can just snap the index to the last, based off of time
		int index = (int)((System.currentTimeMillis() - startTime) / 1000.0 / Constants.DELTA_TIME);
		
		double leftPower = data.get(1).get(index);
		double rightPower = data.get(2).get(index);
		
		Robot.drive.left.set(leftPower);
		Robot.drive.right.set(rightPower);
	}
	
	@Override
	protected boolean isFinished() {
		// Can either be when our index is past our array, or when our time is past the end of the array.
		// For now, use time.
		return (System.currentTimeMillis() - startTime)/1000.0 >= data.get(0).get(data.get(0).size()-1);
	}
	
	protected void end() {
		Robot.drive.stop();
	}

	protected void interrupted() {
		Robot.drive.stop();
	}
}
