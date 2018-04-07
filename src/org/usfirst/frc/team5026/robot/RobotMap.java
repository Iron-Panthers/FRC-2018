/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

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
	
	public static final int TALON_SR_DRIVE_LEFT_MOTOR = 1;
	public static final int TALON_SR_DRIVE_RIGHT_MOTOR = 0;
	
	public static final int ELEVATOR_JOYSTICK = 1;
	public static final int DRIVE_LEFT_MOTOR = 1; //Change back to drive
	public static final int DRIVE_RIGHT_MOTOR = 0;
	public static final int INTAKE_MOTOR = 9; //Change back to drive
	
	public static final int INTAKE_PDP_PORT = 1; //To Be Changed
	public static final int ELEVATOR_MOTOR_PDP_PORT = 0;
	
	public static final int ELEVATOR_SOLENOID_PORT_1 = 3;
	public static final int ELEVATOR_SOLENOID_PORT_2 = 2;
	public static final int ELEVATOR_MASTER = 7;
	public static final int ELEVATOR_SLAVE = 8;
	public static final int SHIFT_FORWARD = 0;
	public static final int SHIFT_REVERSE = 1;
	public static final int CONVEYOR_BELT_MOTOR = 10;
	public static final int BANNER_PORT = 0;
	public static final int ELEVATOR_LIMIT_PORT = 2;
	public static final int CLIMB_MOTOR_PORT_LEFT = 0;
	public static final int CLIMB_MOTOR_PORT_RIGHT = 1;
	//Camera
	public static int CAMERA_PORT = 0; 
	public static int CAMERA_PORT_2 = 1;
}
