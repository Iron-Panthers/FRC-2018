package org.usfirst.frc.team5026.robot.util;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Constants {
	public static final double X_AXIS_MODIFIER = .8;
	public static final double XDEADZONE_SIZE = SmartDashboard.getNumber("X Deadzone Size", 0.2);
	public static final double YDEADZONE_SIZE = SmartDashboard.getNumber("Y Deadzone Size", 0.2);
	public static final double CIRCLE_DEADZONE = SmartDashboard.getNumber("Circle Deadzone Size", 0.2);
	public static final double SPEED = 1.0;
	public static final double DEADZONE_SIZE = .1;
	public static final double QUARTER_SPEED = .4;
	//Intake and Outtake
	public static final double INTAKE_VOLTAGE_GRAB = 10./12; //Converted to voltage for motor
	public static final double INTAKE_VOLTAGE_HOLD = 6./12; //"" 4 good enough, 6 secure but too much for burning
	public static final double INTAKE_CURRENT_SAMPLE = 4; //number of samples required to determine if cube is possessed
	public static final int INTAKE_SPEED_UP_TIME = 2;
	public static final boolean IS_INTAKE_INVERTED = true;
	public static final double OUTTAKE_POWER = -.4;
	public static final double BLOCK_GRAB_THRESHOLD = 15; //min amount of amps intake has with block
	
	//Elevator
	public static final boolean IS_ELEVATOR_INVERTED = false;
	public static final boolean IS_ELEVATOR_SENSOR_INVERTED = false;
	public static final double ELEVATOR_P = 0.8;
	public static final double ELEVATOR_I = 0.002;
	public static final double ELEVATOR_D = 0;
	public static final double ELEVATOR_F = 0.28;
	public static final int ELEVATOR_TALL_CUBE_TARGET = 3500;	
	public static final int ELEVATOR_SHORT_CUBE_TARGET = 2000; //Needs to be tested (This is supposed to lift cube enough so it does not drag on ground)
	public static final int ELEVATOR_SWITCH_TARGET = 38000; //Tested by Adam and Driveteam
	public static final int ELEVATOR_SCALE_TARGET = 85000; //See above
	public static final int ELEVATOR_TOP_TARGET = 89000; //Tested by James. TODO Needs perfecting!!!
	public static final int ELEVATOR_VELOCITY = 9000;
	public static final int ELEVATOR_ACCELERATION = 20000;
	public static final double ELEVATOR_TARGET_TOLERANCE = 100; //In ticks
	public static final double ELEVATOR_TOLERANCE_TIME = 5; //
	public static final double ELEVATOR_HIT_TOLERANCE = 5; //amps, needs changing
	public static final double ELEVATOR_VELOCITY_THRESHOLD = 30; //Velocity Threshold (Not tested, arbitrary)
	public static final int ELEVATOR_CURRENT_COUNT_THRESHOLD = 5; //Amount of count when the current is high (For Elevator)
	public static final double ELEVATOR_CURRENT_THRESHOLD = 30; //Untested, Current when we know the elevator is stalling
	
	public static final double ROBOT_WIDTH = 25.75; // unit is inches
	public static final double ROBOT_LENGTH = 37.25; // unit is inches
	public static final double DRIVE_P = 0;
	public static final double DRIVE_I = 0;
	public static final double DRIVE_D = 0;
	public static final double DRIVE_F = 0.3069; // Calculated as per the Talon SRX Software Refrence Manual, Section: 12.4.2. Math is: 0.75 * 1023 / 2500
	public static final int DRIVE_TICKS_PER_REVOLUTION = 5526; // we tested this, I wonder if it's actually correct! ::thinking::
	// ScadLib variables
	public static final double PATHING_F = 0.011069; // TEST FOR PATH FOLLOWING
	public static final double PATHING_P = 0;
	
	public static final double JOYSTICK_DEADZONE = 0.1;
	//Auto Code
	public static final boolean IS_RIGHT_INVERTED = false;
	public static final boolean IS_LEFT_INVERTED = true;
	public static final boolean IS_LEFT_SENSOR_INVERTED = true;
	public static final boolean IS_RIGHT_SENSOR_INVERTED = true;
	public static final int kTimeoutMs = 0; //Do not change
	public static final int kSlotIdx = 0; //Do not change
	public static final int kPIDLoopIdx = 0; //Do not change
	public static final double DRIVE_SPEED = 1;
	public static final double AUTO_DISTANCE = 30; //Inches
	public static final double WHEEL_RADIUS = 3; // inch
	public static final double WHEEL_CIRCUMFERENCE = WHEEL_RADIUS*2*Math.PI;
	public static final double TICKS_TO_INCHES = DRIVE_TICKS_PER_REVOLUTION / WHEEL_CIRCUMFERENCE;
	
	public static final double DRIVE_WANTED_INCHES_PER_SECOND = 48;
	public static final double DRIVE_WANTED_ACCELERATION_INCHES_PER_SECOND_SQUARED = 80;
	public static int MOTION_MAGIC_VELOCITY(double inchesPerSecond) {
		return (int)( DRIVE_TICKS_PER_REVOLUTION * inchesPerSecond / WHEEL_CIRCUMFERENCE / 10 );
	}
	public static int MOTION_MAGIC_ACCELERATION(double inchesPerSecondPerSecond) {
		return (int)( DRIVE_TICKS_PER_REVOLUTION * inchesPerSecondPerSecond / (WHEEL_CIRCUMFERENCE) / 10 );
	}
	public static final int DRIVE_VELOCITY = MOTION_MAGIC_VELOCITY(DRIVE_WANTED_INCHES_PER_SECOND); // Units of encoder ticks per 100 ms 
	public static final int DRIVE_ACCELERATION = MOTION_MAGIC_ACCELERATION(DRIVE_WANTED_ACCELERATION_INCHES_PER_SECOND_SQUARED); // Units of encoder ticks per 100 ms per second
	//Camera stuff
	public static int CAMERA_PIXEL_HEIGHT = 1920; 
	public static int CAMERA_PIXEL_WIDTH = 1080;
	
	public static double DELTA_TIME = 0.02;
}