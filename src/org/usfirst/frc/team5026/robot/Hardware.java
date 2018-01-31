package org.usfirst.frc.team5026.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;

public class Hardware {
	Talon rightM;
	Talon leftM;
	DoubleSolenoid gearShift;
	public Hardware(){
		rightM = new Talon(RobotMap.DRIVE_RIGHT_MOTOR);
		leftM = new Talon(RobotMap.DRIVE_LEFT_MOTOR);
		rightM.setInverted(true);
		gearShift = new DoubleSolenoid(1,1);
		
	}
}
