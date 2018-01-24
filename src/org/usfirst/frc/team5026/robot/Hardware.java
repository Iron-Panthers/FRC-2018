package org.usfirst.frc.team5026.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;

public class Hardware {
	Talon rightM;
	Talon leftM;
	public static DoubleSolenoid solenoidBoi;
	public Hardware(){
		solenoidBoi = new DoubleSolenoid(0,1);
		rightM = new Talon(RobotMap.DRIVE_RIGHT_MOTOR);
		leftM = new Talon(RobotMap.DRIVE_LEFT_MOTOR);
		rightM.setInverted(true);
	}
}
