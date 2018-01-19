package org.usfirst.frc.team5026.robot;

import edu.wpi.first.wpilibj.Talon;

public class Hardware {
	public Talon rightM;
	public Talon leftM;
	public Talon switchM;
	public Hardware(){
		rightM = new Talon(RobotMap.DRIVE_RIGHT_MOTOR);
		rightM.setInverted(Constants.RIGHT_MOTOR_INVERTED);
		leftM = new Talon(RobotMap.DRIVE_LEFT_MOTOR);
		switchM = new Talon(RobotMap.SWITCH);
	}
}
