package org.usfirst.frc.team5026.robot;

import edu.wpi.first.wpilibj.Talon;

public class Hardware {
	Talon rightM;
	Talon leftM;
	Talon switchM;
	public Hardware(){
		rightM = new Talon(RobotMap.DRIVE_RIGHT_MOTOR);
		leftM = new Talon(RobotMap.DRIVE_LEFT_MOTOR);
		switchM = new Talon(RobotMap.SWITCH);
	}
}
