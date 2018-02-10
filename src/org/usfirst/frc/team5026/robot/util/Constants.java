package org.usfirst.frc.team5026.robot.util;

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
	public static final double INTAKE_CURRENT_SAMPLE = 4; //number of samples required to determine if cube is possessed
	public static final boolean IS_INTAKE_INVERTED = false;
	public static final boolean IS_RIGHT_INVERTED = true;
	public static final boolean IS_LEFT_INVERTED = false;
	public static final double OUTTAKE_POWER = -.4;
	public static final double BLOCK_GRAB_THRESHOLD = 15; //min amount of amps intake has with block
	public static final double TIME_NOT_GRABBED_THRESHOLD = 25.0; //changed to match testing results
	public static final int SPEED_UP_TIME = 100; //(in 100 milliseconds) Amount of time before function has time to work
	
	//Elevator
	public static final boolean IS_ELEVATOR_INVERTED = false;
	public static final double ELEVATOR_SWITCH_TARGET = 3000.; //Arbitrary value, change plz
	public static final double ELEVATOR_SCALE_TARGET = 7000.; //See above
	public static final double ELEVATOR_GROUND_TARGET = 0.; //See above (This is supposed to lift cube enough so it does not drag on ground)
	public static final int ELEVATOR_VELOCITY = 500;
	public static final int ELEVATOR_ACCELERATION = 1000;
	public static final double ELEVATOR_TARGET_TOLERANCE = 100; //In ticks
	public static final double ELEVATOR_TOLERANCE_TIME = 5; //
	
	public static final double ROBOT_WIDTH = 0.5; // unit is meters
	public static final double WHEEL_DIAMETER = 6; // unit is inches
	public static final double DRIVE_P = 0;
	public static final double DRIVE_I = 0;
	public static final double DRIVE_D = 0;
	public static final double DRIVE_F = 0;
	public static final int DRIVE_TICKS_PER_REVOLUTION = 1024;
	public static final int DRIVE_VELOCITY = 500; // I am not sure what unit this is
	public static final int DRIVE_ACCELERATION = 1000; // I am not sure what unit this is either
	
	//Auto Code
	public static final int kTimeoutMs = 0; //Do not change
	public static final int kSlotIdx = 0; //Do not change
	public static final int kPIDLoopIdx = 0; //Do not change

	
	public static final double JOYSTICK_DEADZONE = 0.1;
	//Camera stuff
	public static int CAMERA_PIXEL_HEIGHT = 1920; 
	public static int CAMERA_PIXEL_WIDTH = 1080; 
	//MotionMagic
    public static final double ELEVATOR_SWITCH_DISTANCE = 13; //Inches
    //Find Belt teeth and other things to find conversion to ticks

}
