package org.usfirst.frc.team5026.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;

import edu.wpi.first.wpilibj.PowerDistributionPanel;

public class Hardware {
	public TalonSRX right1M;
	public TalonSRX right2M;
	public TalonSRX right3M;
	public TalonSRX left1M;
	public TalonSRX left2M;
	public TalonSRX left3M;
	public Talon intakeM;
	public PowerDistributionPanel pdp;
	public Hardware(){
		right1M = new TalonSRX(RobotMap.DRIVE_RIGHT_MOTOR_1);
		right2M = new TalonSRX(RobotMap.DRIVE_RIGHT_MOTOR_2);
	    right3M = new TalonSRX(RobotMap.DRIVE_RIGHT_MOTOR_3);
	    left1M = new TalonSRX(RobotMap.DRIVE_LEFT_MOTOR_1);
	    left2M = new TalonSRX(RobotMap.DRIVE_LEFT_MOTOR_2);
	    left3M = new TalonSRX(RobotMap.DRIVE_LEFT_MOTOR_3);
	    Robot.right.setInverted(Constants.IS_RIGHT_INVERTED);
	//    intakeM = new TalonSRX(RobotMap.INTAKE_MOTOR);
	    pdp = new PowerDistributionPanel();
	    
	}
}