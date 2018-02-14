package org.usfirst.frc.team5026.robot;

import org.usfirst.frc.team5026.robot.subsystems.DriveMotorGroup;
import org.usfirst.frc.team5026.robot.util.Constants;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;

public class Hardware {
	public TalonSRX rightM1;
	public TalonSRX rightM2;
	public TalonSRX rightM3;
	public TalonSRX leftM1;
	public TalonSRX leftM2;
	public TalonSRX leftM3;
	public TalonSRX intakeM;
	
	public Talon leftT;
	public Talon rightT;
	
	public DriveMotorGroup right;
	public DriveMotorGroup left;
	public DigitalInput bannerSensor;
	public PowerDistributionPanel pdp;
	public DoubleSolenoid gearShift;
	public Hardware(){
		rightM1 = new TalonSRX(RobotMap.DRIVE_RIGHT_MOTOR_1);
		rightM2 = new TalonSRX(RobotMap.DRIVE_RIGHT_MOTOR_2);
		rightM3 = new TalonSRX(RobotMap.DRIVE_RIGHT_MOTOR_3);
		leftM1 = new TalonSRX(RobotMap.DRIVE_LEFT_MOTOR_1);
		leftM2 = new TalonSRX(RobotMap.DRIVE_LEFT_MOTOR_2);
		leftM3 = new TalonSRX(RobotMap.DRIVE_LEFT_MOTOR_3);
		
		leftT = new Talon(RobotMap.TALON_SR_LEFT);
		rightT = new Talon(RobotMap.TALON_SR_RIGHT);
		
		right = new DriveMotorGroup(rightM1, rightM2, rightM3);
		left = new DriveMotorGroup(leftM1, leftM2, leftM3);
		right.setInverted(Constants.IS_RIGHT_INVERTED);
		left.setInverted(Constants.IS_LEFT_INVERTED);
		intakeM = new TalonSRX(RobotMap.INTAKE_MOTOR);
		intakeM.setInverted(Constants.IS_INTAKE_INVERTED);
		bannerSensor = new DigitalInput(9);
		pdp = new PowerDistributionPanel();
		gearShift = new DoubleSolenoid(1, RobotMap.SHIFT_FORWARD, RobotMap.SHIFT_REVERSE);

	}
}