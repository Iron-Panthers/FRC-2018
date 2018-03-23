package org.usfirst.frc.team5026.robot.commands.autonomous;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ReplayPowers extends Command {
	
	private Double[] leftPowers, rightPowers;
	private int i = 0;
	
	protected void initialize() {
		String path = SmartDashboard.getString("CSV Path", "");
		File file = new File(path);
		BufferedReader reader = null;
		ArrayList<Double> leftPowers = new ArrayList<>();
		ArrayList<Double> rightPowers = new ArrayList<>();

		try {
		    reader = new BufferedReader(new FileReader(file));
		    String text = null;
		    
		    while ((text = reader.readLine()) != null) {
		        String[] seperated = text.split(",");
		        leftPowers.add(Double.parseDouble(seperated[0]));
		        rightPowers.add(Double.parseDouble(seperated[1]));
		    }		    
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (reader != null) {
		            reader.close();
		        }
		    } catch (IOException e) {
		    }
		}
	
		this.leftPowers = leftPowers.toArray(new Double[leftPowers.size()]);
		this.rightPowers = rightPowers.toArray(new Double[rightPowers.size()]);
		i = 0;	
	}

	protected void execute() {
		if (leftPowers.length == 0) {
			return;
		}
		
		double leftPower = leftPowers[i];
		double rightPower = rightPowers[i];
		i++;
		
		Robot.drive.left.set(leftPower);
		Robot.drive.right.set(rightPower);
	}
	
	@Override
	protected boolean isFinished() {
		return i >= leftPowers.length;
	}
	
	protected void end() {
		Robot.drive.stop();
	}

}
