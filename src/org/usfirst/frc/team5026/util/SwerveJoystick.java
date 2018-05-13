package org.usfirst.frc.team5026.util;

import org.opencv.core.Mat;
import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;

public class SwerveJoystick {
	public Joystick joystick;
	public SwerveJoystick(Joystick joystick) {
		this.joystick = joystick;
	}
	public double findZ() {
		double zDeadzoneScaler = joystick.getZ()-Constants.Z_DEADZONE/1-Constants.Z_DEADZONE;
		if(joystick.getZ() > Constants.Z_DEADZONE) {
			return joystick.getZ()*zDeadzoneScaler;
		}
		else {
			return 0;
		}
	}
	
	public static double calcPositiveMod(double a, double b) {
		return ((a%b)+b)%b;
	}
	
	public double findTurn() {
		return findZ()*Math.cos(calcPositiveMod(calcPositiveMod(Robot.swerveDrive.swerveM1.getSelectedSensorPosition(pidIdx)/Constants.ENCODER_TICKS_PER_REVOLUTION, 1), .25)*4);
	}
	
	public double findMagnitude() {
		double magnitude = Math.sqrt(joystick.getY()*joystick.getY()+joystick.getX()*joystick.getX());
		double circleDeadzoneScaler = magnitude-Constants.CIRCLE_DEADZONE/1-Constants.CIRCLE_DEADZONE;
		if(magnitude > Constants.CIRCLE_DEADZONE){
			if(magnitude*circleDeadzoneScaler > 1) 
				return 1;			
			else 
				return magnitude*circleDeadzoneScaler;
		}
		else {
			return 0;
		}
	}
	public double findXYAngle() {
		double angle;
		double x = joystick.getX();
		double y = joystick.getY();
		if (x>0) {
			angle =  Math.atan(y/x); 
		}
		else {
			angle = (Math.atan(y/x)+Math.PI); //atan returns between -pi/2 and pi/2 (obviously) 
			//Add pi if you're actually on the other side
			}
		return angle - Math.PI/2; //subtract pi/2 because we want front facing to be 0 rad.
	}
	
}
