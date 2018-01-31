package org.usfirst.frc.team5026.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Constants {
	public static final int RIGHT_PORT = 0;
	public static final int LEFT_PORT = 1;
	public static final int FULLSPEED = 1;
	//Intake and Outtake
	public static final boolean IS_INTAKE_INVERTED = true;
	public static final boolean IS_RIGHT_INVERTED = true;
	public static final double INTAKE_POWER = 0.4;
	public static final double OUTTAKE_POWER = -0.4;
	
	public static final double ROBOT_WIDTH = 0.5; // unit is meters
	public static final double WHEEL_DIAMETER = 6; // unit is inches
	public static final double DRIVE_P = 0;
	public static final double DRIVE_I = 0;
	public static final double DRIVE_D = 0;
	public static final double DRIVE_F = 0;
	public static final int DRIVE_TICKS_PER_REVOLUTION = 1024;
	public static final double DRIVE_VELOCITY = 500; // I am not sure what unit this is
	public static final double DRIVE_ACCELERATION = 1000; // I am not sure what unit this is either
	
	public static final double JOYSTICK_DEADZONE = 0.1;
	//Auto Code
	public static final double FEED_FORWARD = SmartDashboard.getNumber("Feed Forward Value", 0.4);
	public static final double AUTO_P = 0; //Do not change
	public static final boolean IS_ELEVATOR_INVERTED = true;
	public static final int LIMIT_SWITCH_MAX = 1;
	public static final int LIMIT_SWITCH_MIN = 0;
	public static final int CRUISE_VELOCITY = 15000;
	public static final int ACCELERATION = 6000;
	public static final int kTimeoutMs = 0; //Do not change
	public static final int kSlotIdx = 0; //Do not change
	public static final int kPIDLoopIdx = 0; //Do not change
	public static final double DRIVE_SPEED = 1;
	public static final double TICKS_TO_INCHES = 1024;
	public static final double AUTO_DISTANCE = 30; //Inches
	public static final double WHEEL_RADIUS = 2;
	public static final double WHEEL_CIRCUMFERENCE = WHEEL_RADIUS*2*Math.PI;
	public static final double ENCODER_TO_WHEEL_REV_RATIO = 1; // To be changed
	public static final double STATIC_TICK_TARGET = 4000;
	public static final double TICK_TARGET = Constants.AUTO_DISTANCE/Constants.WHEEL_CIRCUMFERENCE/Constants.ENCODER_TO_WHEEL_REV_RATIO*Constants.TICKS_TO_INCHES;
	//Camera
	public static int CAMERA_PIXEL_HEIGHT = 1920; 
	public static int CAMERA_PIXEL_WIDTH = 1080; 

}
