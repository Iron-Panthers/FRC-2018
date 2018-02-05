package org.usfirst.frc.team5026.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;

public class Hardware {
	public Talon rightM;
	public Talon leftM;
	public TalonSRX intakeM;
	public DigitalInput bannerSensor;
	public PowerDistributionPanel pdp;
	public Hardware(){
		rightM = new Talon(RobotMap.DRIVE_RIGHT_MOTOR);
		rightM.setInverted(Constants.IS_RIGHT_INVERTED);
		leftM = new Talon(RobotMap.DRIVE_LEFT_MOTOR);
		intakeM = new TalonSRX(RobotMap.INTAKE_MOTOR);
		intakeM.setInverted(Constants.IS_INTAKE_INVERTED);
		bannerSensor = new DigitalInput(0);
		pdp = new PowerDistributionPanel();
	}
}
