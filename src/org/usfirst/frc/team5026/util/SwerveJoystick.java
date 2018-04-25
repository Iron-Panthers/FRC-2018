package org.usfirst.frc.team5026.util;

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
	public double findMagnitude() {
		double magnitude = Math.sqrt(joystick.getY()*joystick.getY()+joystick.getX()*joystick.getX());
		double circleDeadzoneScaler = magnitude-Constants.CIRCLE_DEADZONE/1-Constants.CIRCLE_DEADZONE;
		if(magnitude > 1) {
			return 1;
		}
		else if(magnitude > Constants.CIRCLE_DEADZONE){
			return magnitude*circleDeadzoneScaler;
		}
		else {
			return 0;
		}
	}
	public double findXYAngle() {
		double x = joystick.getX();
		double y = joystick.getY();
		if (x>0) {
			return Math.atan(y/x); //atan only returns between pi/2 and -pi/2
		}
		else {
			return -Math.atan(y/x);
		}
	}
	
}
