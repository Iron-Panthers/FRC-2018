package org.usfirst.frc.team5026.robot;

public class Constants {
	public static final double X_AXIS_MODIFIER = .8;
	public static final double DEADZONE_SIZE = .1;
	public static final double QUARTER_SPEED = .4;
	public static final int RIGHT_PORT = 0;
	public static final int LEFT_PORT = 1;
	public static final int FULLSPEED = 1;
	//Intake and Outtake
	public static final double INTAKE_VOLTAGE_GRAB = 10./12; //Converted to voltage for motor
	public static final double INTAKE_VOLTAGE_HOLD = 4./12; //"" 4 good enough, 6 secure but too much for burning 
	public static final boolean IS_INTAKE_INVERTED = false;
	public static final boolean IS_RIGHT_INVERTED = true;
	public static final boolean IS_LEFT_INVERTED = false;
	public static final double OUTTAKE_POWER = -.4;
	public static final double HAS_BLOCK_THRESHOLD = 15; //Max amount of amps intake has without block
	public static final int TIME_NOT_GRABBED_THRESHOLD = 20; //(in 100 milliseconds)If the counter for not grabbed goes over this, then the intake really does not have a block
	public static final int SPEED_UP_TIME = 100; //(in 100 milliseconds) Amount of time before function has time to work
	
	//Elevator
	public static final boolean IS_ELEVATOR_INVERTED = false;
	
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
	//Camera stuff
	public static int CAMERA_PIXEL_HEIGHT = 1920; 
	public static int CAMERA_PIXEL_WIDTH = 1080; 
}
