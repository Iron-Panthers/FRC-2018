package org.usfirst.frc.team5026.robot.commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ReplayPowers extends Command {
	
	private Double[] times,leftPowers, rightPowers;
	
	long startTime;
	
	public ReplayPowers() {
		requires(Robot.drive); // Requires so that Joystick drive is overridden
	}
	
	protected void initialize() {
		String path = SmartDashboard.getString("CSV Read Path", "");
		File file = new File(path);
		BufferedReader reader = null;
		ArrayList<Double> times = new ArrayList<>();
		ArrayList<Double> leftPowers = new ArrayList<>();
		ArrayList<Double> rightPowers = new ArrayList<>();

		try {
		    reader = new BufferedReader(new FileReader(file));
		    String text = null;
		    
//		    String header = reader.readLine(); // This is for the header of the CSV. If there is no header, do NOT do this line
		    while ((text = reader.readLine()) != null) {
		        String[] seperated = text.split(",");
		        try {
			        times.add(Double.parseDouble(seperated[0]));
			        leftPowers.add(Double.parseDouble(seperated[1]));
			        rightPowers.add(Double.parseDouble(seperated[2]));
		        } catch (NumberFormatException e) {
		        	// The value was NOT a double/int
		        	// That means it is in the header (probably)
		        	// At this point, could make sure that the arrays are ordered in the way that they are assumed to be, but for now just continue
		        } catch (IndexOutOfBoundsException e) {
		        	// The CSV file was formatted incorrectly. That is really bad, so literally kill the entire command.
		        	System.out.println("THE CSV FILE AT PATH: "+path+" CONTAINS INVALID DATA (IndexOutOfBounds)!\nKILLING ALL COMMNADS!");
		        	Scheduler.getInstance().removeAll();
		        }
		    }		    
		} catch (FileNotFoundException e) {
			System.out.println("THE CSV FILE AT PATH: "+path+" COULD NOT BE FOUND!\nKILLING ALL COMMANDS!");
		    Scheduler.getInstance().removeAll();
		} catch (IOException e) {
			// Command should be killed any time an error is thrown out here
		    e.printStackTrace();
		    Scheduler.getInstance().removeAll();
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (IOException e) {}
		}
	
		this.times = times.toArray(new Double[times.size()]);
		this.leftPowers = leftPowers.toArray(new Double[leftPowers.size()]);
		this.rightPowers = rightPowers.toArray(new Double[rightPowers.size()]);
	}

	protected void execute() {
		if (times.length == 0) {
			return;
		}
		
		// Given that the CSV file contains times now, it would be trivial to do a binary search, or even something faster
		// For now, we can just snap the index to the last, based off of time
		int index = (int)((System.currentTimeMillis() - startTime) / 1000.0 / Constants.DELTA_TIME);
		
		double leftPower = leftPowers[index];
		double rightPower = rightPowers[index];
		
		Robot.drive.left.set(leftPower);
		Robot.drive.right.set(rightPower);
	}
	
	@Override
	protected boolean isFinished() {
		// Can either be when our index is past our array, or when our time is past the end of the array.
		// For now, use time.
		return (System.currentTimeMillis() - startTime)/1000.0 >= times[times.length-1];
	}
	
	protected void end() {
		Robot.drive.stop();
	}

	protected void interrupted() {
		Robot.drive.stop();
	}
}
