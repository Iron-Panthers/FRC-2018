package org.usfirst.frc.team5026.robot.util;

public class Constants {
	public static final double X_AXIS_MODIFIER = .8;
	public static final double DEADZONE_SIZE = .08;
	public static final double SPEED = .5;
	public static final int RIGHT_PORT = 0;
	public static final int LEFT_PORT = 1;
	public static final int FULLSPEED = 1;
	//Intake and Outtake
	public static final boolean IS_INTAKE_INVERTED = true;
	public static final boolean IS_RIGHT_INVERTED = true;
	public static final double INTAKE_POWER = 1;
	public static final double OUTTAKE_POWER = 1;
	
	public static final double ROBOT_WIDTH = 0.5; // unit is meters
	public static final double WHEEL_DIAMETER = 6; // unit is inches
	public static final double DRIVE_P = 0;
	public static final double DRIVE_I = 0;
	public static final double DRIVE_D = 0;
	public static final double DRIVE_F = 0;
	public static final int DRIVE_TICKS_PER_REVOLUTION = 5526; // we tested this, I wonder if it's actually correct! ::thinking::
	
	public static final double DRIVE_WANTED_INCHES_PER_SECOND = 10;
	public static final double DRIVE_WANTED_ACCELERATION_INCHES_PER_SECOND = 4;
	public static final int DRIVE_VELOCITY = (int)( DRIVE_TICKS_PER_REVOLUTION * DRIVE_WANTED_INCHES_PER_SECOND / (WHEEL_DIAMETER * Math.PI) / 100 ); // Units of encoder ticks per 100 ms 
	public static final int DRIVE_ACCELERATION = (int)( DRIVE_TICKS_PER_REVOLUTION * DRIVE_WANTED_INCHES_PER_SECOND / (WHEEL_DIAMETER * Math.PI) / 100 ); // I am not sure what unit this is either
	
	public static final double JOYSTICK_DEADZONE = 0.1;
	//Auto Code
	public static final int kTimeoutMs = 0; //Do not change
	public static final int kSlotIdx = 0; //Do not change
	public static final int kPIDLoopIdx = 0; //Do not change
	public static final double DRIVE_SPEED = 1;
	public static final double TICKS_TO_INCHES = 1024;
	public static final double AUTO_DISTANCE = 30; //Inches
	public static final double WHEEL_RADIUS = 2;
	public static final double WHEEL_CIRCUMFERENCE = WHEEL_RADIUS*2*Math.PI;
	public static final double ENCODER_TO_WHEEL_REV_RATIO = 5; // To be changed
	
}
