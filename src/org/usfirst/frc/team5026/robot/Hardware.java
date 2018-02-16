package org.usfirst.frc.team5026.robot;

import org.usfirst.frc.team5026.robot.subsystems.DriveMotorGroup;
import org.usfirst.frc.team5026.robot.util.Constants;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;

public class Hardware {
//	public TalonSRX rightM1;
//	public TalonSRX rightM2;
//	public TalonSRX rightM3;
//	public TalonSRX leftM1;
//	public TalonSRX leftM2;
//	public TalonSRX leftM3;
	public Talon intakeM;
//	public DriveMotorGroup right;
//	public DriveMotorGroup left;
	public DigitalInput bannerSensor;
	public PowerDistributionPanel pdp;
	public DoubleSolenoid gearShift;
	public PigeonIMU gyro;
	public Talon l;
	public Talon r;
	public Hardware(){
		l = new Talon(RobotMap.LEFT_TALON); // Port 0
		r = new Talon(RobotMap.RIGHT_TALON); // Port 1
		l.setInverted(Constants.IS_LEFT_INVERTED);
		r.setInverted(Constants.IS_RIGHT_INVERTED);
		
//		right = new DriveMotorGroup(rightM1, rightM2, rightM3);
//		left = new DriveMotorGroup(leftM1, leftM2, leftM3);
//		right.setInverted(Constants.IS_RIGHT_INVERTED);
//		left.setInverted(Constants.IS_LEFT_INVERTED);
		intakeM = new Talon(RobotMap.INTAKE_MOTOR);
		intakeM.setInverted(Constants.IS_INTAKE_INVERTED);
		bannerSensor = new DigitalInput(9);
		pdp = new PowerDistributionPanel();
		gearShift = new DoubleSolenoid(1,0,1);
		gyro = new PigeonIMU(0);
	}
}