package org.usfirst.frc.team5026.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//Joystick Ports
	public static int JOYSTICK_PORT = 0;

	//Drive Motor Ports
	public static int SWERVE_MOTOR_1_PORT = 1;
	public static int SWERVE_MOTOR_2_PORT = 2;
	public static int SWERVE_MOTOR_3_PORT = 3;
	public static int SWERVE_MOTOR_4_PORT = 4;
	public static int FRONT_LEFT_PORT = 5;
	public static int FRONT_RIGHT_PORT = 6;
	public static int BACK_LEFT_PORT = 7;
	public static int BACK_RIGHT_PORT = 8;
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
