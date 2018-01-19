package org.usfirst.frc.team5026.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PowerDistributionPanel;

public class Hardware {
	public TalonSRX rightM;
	public TalonSRX leftM;
	public PowerDistributionPanel pdp;
	public Hardware(){
		rightM = new TalonSRX(RobotMap.DRIVE_RIGHT_MOTOR);
		rightM.setInverted(Constants.IS_RIGHT_INVERTED);
		leftM = new TalonSRX(RobotMap.DRIVE_LEFT_MOTOR);
		pdp = new PowerDistributionPanel();
	}
}
