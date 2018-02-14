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
	public static final int ELEVATOR_JOYSTICK = 1;
	public static final int DRIVE_LEFT_MOTOR = 1; //Change back to drive
	public static final int DRIVE_RIGHT_MOTOR = 0;
	public static final int INTAKE_MOTOR = 9; //Change back to drive
	public static final int INTAKE_PDP_PORT = 1; //To Be Changed
	public static final int LEFT_SOLENOID_PORT_1 = 2;
	public static final int LEFT_SOLENOID_PORT_2 = 3;
	public static final int RIGHT_SOLENOID_PORT_1 = 4;
	public static final int RIGHT_SOLENOID_PORT_2 = 5;
	public static final int ELEVATOR_MASTER = 9;
	public static final int ELEVATOR_SLAVE = 10;
	//Camera
	public static int CAMERA_PORT = 0; 
}
