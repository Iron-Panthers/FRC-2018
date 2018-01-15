package org.usfirst.frc.team5026.robot;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;

public class Hardware {
	public Talon rightM;
	public Talon leftM;
	public Talon intakeM;
	public PowerDistributionPanel pdp;
	public Hardware(){
		rightM = new Talon(RobotMap.DRIVE_RIGHT_MOTOR);
		leftM = new Talon(RobotMap.DRIVE_LEFT_MOTOR);
		intakeM = new Talon(RobotMap.INTAKE_MOTOR);
		pdp = new PowerDistributionPanel();
	}
}
