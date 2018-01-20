package org.usfirst.frc.team5026.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PowerDistributionPanel;

public class Hardware {
	public ControlMode controlMode;
	public TalonSRX rightM;
	public TalonSRX leftM;
	public TalonSRX intakeM;
	public PowerDistributionPanel pdp;
	public Hardware(){
		controlMode = ControlMode.Velocity;
		rightM = new TalonSRX(RobotMap.DRIVE_RIGHT_MOTOR);
		rightM.setInverted(Constants.IS_RIGHT_INVERTED);
		leftM = new TalonSRX(RobotMap.DRIVE_LEFT_MOTOR);
		intakeM = new TalonSRX(RobotMap.INTAKE_MOTOR);
		pdp = new PowerDistributionPanel();
	}
}
