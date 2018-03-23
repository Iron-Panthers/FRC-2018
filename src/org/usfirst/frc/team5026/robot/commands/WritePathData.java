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
public class WritePathData extends Command {

	ArrayList<Double> leftPowers;
	ArrayList<Double> rightPowers;
	ArrayList<Double> times;
	ArrayList<Integer> leftPositions;
	ArrayList<Integer> rightPositions;
	ArrayList<Integer> leftVelocities;
	ArrayList<Integer> rightVelocities;
	
	long startTime;
	
    public WritePathData() {
    }

    protected void initialize() {
    	times = new ArrayList<Double>();
    	leftPowers = new ArrayList<Double>();
    	rightPowers = new ArrayList<Double>();
    	leftPositions = new ArrayList<Integer>();
    	rightPositions = new ArrayList<Integer>();
    	leftVelocities = new ArrayList<Integer>();
    	rightVelocities = new ArrayList<Integer>();
    	startTime = System.currentTimeMillis();
    }

    protected void execute() {
    	times.add((double) (System.currentTimeMillis() - startTime));
    	leftPowers.add(Robot.drive.getLeftSpeedController().get());
    	rightPowers.add(Robot.drive.getRightSpeedController().get());
    	leftPositions.add(Robot.drive.getLeftEncoderPosition());
    	rightPositions.add(Robot.drive.getRightEncoderPosition());
    	leftVelocities.add(Robot.drive.left.motor1.getSelectedSensorVelocity(Constants.kPIDLoopIdx));
    	rightVelocities.add(Robot.drive.right.motor1.getSelectedSensorVelocity(Constants.kPIDLoopIdx));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    	// Called when button is released. Driving is complete! Save to file
    	String path = SmartDashboard.getString("CSV Write Path", "");
		File file = new File(path);
		BufferedWriter writer = null;

		try {
		    writer = new BufferedWriter(new FileWriter(file));
		    
		    writer.write("Times,Left Powers,Right Powers,Left Positions,Right Positions,Left Velocities,Right Velocities");
		    writer.newLine();
		    for (int i = 0; i < times.size(); i++) {
		    	writer.write(times.get(i)+","+leftPowers.get(i)+","+rightPowers.get(i)+","+leftPositions.get(i)+","+rightPositions.get(i)+","+leftVelocities.get(i)+","+rightVelocities.get(i));
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
