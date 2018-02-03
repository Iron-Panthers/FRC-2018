package org.usfirst.frc.team5026.robot;

import org.usfirst.frc.team5026.robot.subsystems.DriveMotorGroup;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;

public class Hardware {
	public Talon rightM1;
	public Talon rightM2;
	public Talon rightM3;
	public Talon leftM1;
	public Talon leftM2;
	public Talon leftM3;
	public Talon intakeM;
	public DriveMotorGroup right;
	public DriveMotorGroup left;
	public DigitalInput bannerSensor;
//	public PowerDistributionPanel pdp;
	public Hardware(){
		rightM1 = new Talon(RobotMap.DRIVE_RIGHT_MOTOR_1);
		rightM2 = new Talon(RobotMap.DRIVE_RIGHT_MOTOR_2);
		rightM3 = new Talon(RobotMap.DRIVE_RIGHT_MOTOR_3);
		leftM1 = new Talon(RobotMap.DRIVE_LEFT_MOTOR_1);
		leftM2 = new Talon(RobotMap.DRIVE_LEFT_MOTOR_2);
		leftM3 = new Talon(RobotMap.DRIVE_LEFT_MOTOR_3);

//		rightM.setInverted(Constants.IS_RIGHT_INVERTED);
		
		intakeM = new Talon(RobotMap.INTAKE_MOTOR);
		intakeM.setInverted(Constants.IS_INTAKE_INVERTED);
		bannerSensor = new DigitalInput(0);
//		pdp = new PowerDistributionPanel();
	}
}