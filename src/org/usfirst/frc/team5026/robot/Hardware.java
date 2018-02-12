package org.usfirst.frc.team5026.robot;

import org.usfirst.frc.team5026.robot.util.Constants;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PowerDistributionPanel;

public class Hardware {
	public TalonSRX intakeM;
	public PowerDistributionPanel pdp;
	
	public Hardware(){
		intakeM = new TalonSRX(RobotMap.INTAKE_MOTOR);
		intakeM.setInverted(Constants.IS_INTAKE_INVERTED);
		pdp = new PowerDistributionPanel();
	}
}
