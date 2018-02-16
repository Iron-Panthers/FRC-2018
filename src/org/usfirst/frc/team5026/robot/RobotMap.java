package org.usfirst.frc.team5026.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int DRIVE_JOYSTICK = 0;
	public static final int LEFT_TALON = 0;
	public static final int RIGHT_TALON = 1;
//	public static final int DRIVE_LEFT_MOTOR_1 = 1;
//	public static final int DRIVE_LEFT_MOTOR_2 = 2; //Change back to drive
//	public static final int DRIVE_LEFT_MOTOR_3 = 3;
//	public static final int DRIVE_RIGHT_MOTOR_1 = 4;
//	public static final int DRIVE_RIGHT_MOTOR_2 = 5;
//	public static final int DRIVE_RIGHT_MOTOR_3 = 6;
	
//	public static final int INTAKE_MOTOR = 3; //Change back to drive
//	public static final int INTAKE_PDP_PORT = 2; //To Be Changed
	public static final int INTAKE_MOTOR = 3; //Change back to drive
	public static final int INTAKE_PDP_PORT = 2; //To Be Changed
	
	public static final int RIGHTM1_PDP_PORT = 13;
	public static final int RIGHTM2_PDP_PORT = 14;
	public static final int RIGHTM3_PDP_PORT = 15;
	public static final int LEFTM1_PDP_PORT = 3;
	public static final int LEFTM2_PDP_PORT = 2;
	public static final int LEFTM3_PDP_PORT = 0;
}
