 package org.usfirst.frc.team5026.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;

public class Hardware {
	public TalonSRX conveyor;
	public TalonSRX intakeM;
	public PowerDistributionPanel pdp;
	public DigitalInput banner;
	
	public Hardware(){
		conveyor = new TalonSRX(RobotMap.CONVEYOR_BELT_MOTOR);
		intakeM = new TalonSRX(RobotMap.INTAKE_MOTOR);
		pdp = new PowerDistributionPanel();
		banner = new DigitalInput(9);
	}
}
