package org.usfirst.frc.team5026.robot.commands;

import java.util.ArrayList;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.CSVData;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ReplayPowers extends Command {
	
	private ArrayList<ArrayList<Double>> data;
	
	int index = 0;
	int entries = 0;
	long startTime;
	boolean inverse = false;
		
	public ReplayPowers(boolean inverse) {
		requires(Robot.drive); // Requires so that Joystick drive is overridden
		this.inverse = inverse;
	}
	
	protected void initialize() {
		String path = SmartDashboard.getString("CSV Read Path", "");
		try {
			data = CSVData.readFromCsv(path, 3); // 3 for time, leftPower, rightPower
		} catch (NullPointerException e) {
			System.out.println("PATH READ FAILED!");
			Scheduler.getInstance().removeAll();
		}
		startTime = System.currentTimeMillis();
		index = 0;
		entries = data.get(0).size();
		if (inverse) {
			index = entries - 1;
		}
		SmartDashboard.putNumber("size", entries);
	}

	protected void execute() {
		if (data.get(0).size() == 0) {
			return;
		}

		double myTime = (System.currentTimeMillis() - startTime)  / 1000.0;

		if (this.inverse) {

			myTime = data.get(0).get(data.get(0).size() - 1) - myTime;
			// There should be failsafes for index here!
			for (int i = index; i >= 0; i--) {
				double entryTime = data.get(0).get(i);
				if (myTime < entryTime) {
					index = i;
				}
			}

		} else {

			// There should be failsafes for index here!
			for (int i = index; i < entries; i++) {
				double entryTime = data.get(0).get(i);
				if (myTime > entryTime) {
					index = i;
				}
			}

		}
		
		SmartDashboard.putNumber("index", index);

		double leftPower =  -data.get(1).get(index);
		double rightPower = data.get(2).get(index);

		if (inverse) {
			leftPower *= -1;
			rightPower *= -1;
		}
		Robot.drive.setLeftSide(leftPower);
		Robot.drive.setRightSide(rightPower);		
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
