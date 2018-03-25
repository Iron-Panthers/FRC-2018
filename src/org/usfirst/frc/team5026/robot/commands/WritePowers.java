package org.usfirst.frc.team5026.robot.commands;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class WritePowers extends Command {

	ArrayList<Double> leftPowers;
	ArrayList<Double> rightPowers;
	ArrayList<Double> times;
	
	long startTime;
	
    public WritePowers() {
    }

    protected void initialize() {
    	times = new ArrayList<Double>();
    	leftPowers = new ArrayList<Double>();
    	rightPowers = new ArrayList<Double>();
    	startTime = System.currentTimeMillis();
    	
//    	Robot.drive.left.motor1.setSelectedSensorPosition(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
//    	Robot.drive.right.motor1.setSelectedSensorPosition(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
    }

    protected void execute() {
    	times.add((double) (System.currentTimeMillis() - startTime) / 1000.0);
    	leftPowers.add(Robot.drive.getLeftSpeedController().get());
    	rightPowers.add(Robot.drive.getRightSpeedController().get());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    	// Called when button is released. Driving is complete! Save to file
    	String path = SmartDashboard.getString("CSV Write Path", "");
    	System.out.println("WRITING TO PATH: "+path);
		File file = new File(path);
		BufferedWriter writer = null;

		try {
		    writer = new BufferedWriter(new FileWriter(file));
		    
		    writer.write("Times,Left Powers,Right Powers");
		    writer.newLine();
		    for (int i = 0; i < times.size(); i++) {
		    	writer.write(times.get(i)+","+leftPowers.get(i)+","+rightPowers.get(i));
		    	writer.newLine();
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (writer != null) {
		            writer.close();
		        }
		    } catch (IOException e) {}
		}
    }
}
