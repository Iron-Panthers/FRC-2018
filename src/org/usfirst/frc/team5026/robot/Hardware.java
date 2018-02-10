 package org.usfirst.frc.team5026.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;

public class Hardware {
	public Talon conveyor;
	public TalonSRX intakeM;
	public PowerDistributionPanel pdp;
	public Hardware(){
		conveyor = new Talon(RobotMap.CONVEYOR_BELT_MOTOR);
		intakeM = new TalonSRX(RobotMap.INTAKE_MOTOR);
		intakeM.setInverted(Constants.IS_INTAKE_INVERTED);
		pdp = new PowerDistributionPanel();
	}
}
