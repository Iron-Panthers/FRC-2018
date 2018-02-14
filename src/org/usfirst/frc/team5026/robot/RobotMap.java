package org.usfirst.frc.team5026.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int DRIVE_JOYSTICK = 0;
	public static final int DRIVE_LEFT_MOTOR_1 = 1;
	public static final int DRIVE_LEFT_MOTOR_2 = 2; //Change back to drive
	public static final int DRIVE_LEFT_MOTOR_3 = 3;
	public static final int DRIVE_RIGHT_MOTOR_1 = 4;
	public static final int DRIVE_RIGHT_MOTOR_2 = 5;
	public static final int DRIVE_RIGHT_MOTOR_3 = 6;
	
	// TalonSR ports
	public static final int TALON_SR_LEFT = 0;
	public static final int TALON_SR_RIGHT = 1;
	
//	public static final int INTAKE_MOTOR = 3; //Change back to drive
//	public static final int INTAKE_PDP_PORT = 2; //To Be Changed
	public static final int INTAKE_MOTOR = 3; //Change back to drive
	public static final int INTAKE_PDP_PORT = 2; //To Be Changed
	public static final int SHIFT_FORWARD = 0;
	public static final int SHIFT_REVERSE = 1;
}
