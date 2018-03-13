 package org.usfirst.frc.team5026.robot;

import org.usfirst.frc.team5026.robot.util.Constants;
import org.usfirst.frc.team5026.robot.util.DriveMotorGroup;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.DigitalInput;
//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;

public class Hardware {
	public TalonSRX elevatorMotor;
	public TalonSRX elevatorSlaveMotor;
	//public ElevatorMotorGroup elevatorMotors;
	public DoubleSolenoid elevatorSolenoid;
	public TalonSRX conveyor;
	public TalonSRX intakeM;
	public TalonSRX rightM1;
	public TalonSRX rightM2;
	public TalonSRX rightM3;
	public TalonSRX leftM1;
	public TalonSRX leftM2;
	public TalonSRX leftM3;
	public Talon leftTalonSR;
	public Talon rightTalonSR;
	public DriveMotorGroup right;
	public DriveMotorGroup left;
	public DoubleSolenoid gearShift;
	public PowerDistributionPanel pdp;
	public DigitalInput banner;
	public PigeonIMU gyro;
	
	public Hardware() {
		elevatorMotor = new TalonSRX(RobotMap.ELEVATOR_MASTER);
		elevatorSlaveMotor = new TalonSRX(RobotMap.ELEVATOR_SLAVE);
		//elevatorMotors = new ElevatorMotorGroup(elevatorMotor, elevatorSlaveMotor);
		elevatorMotor.setInverted(Constants.IS_ELEVATOR_INVERTED);
		elevatorSlaveMotor.setInverted(Constants.IS_ELEVATOR_INVERTED);
		elevatorMotor.setSensorPhase(!Constants.IS_ELEVATOR_SENSOR_INVERTED);
		elevatorSolenoid = new DoubleSolenoid(0, RobotMap.ELEVATOR_SOLENOID_PORT_1, RobotMap.ELEVATOR_SOLENOID_PORT_2);
		conveyor = new TalonSRX(RobotMap.CONVEYOR_BELT_MOTOR);
		conveyor.setInverted(Constants.IS_COVEYOR_INVERTED);
		conveyor.setNeutralMode(NeutralMode.Brake);
		intakeM = new TalonSRX(RobotMap.INTAKE_MOTOR);
		rightM1 = new TalonSRX(RobotMap.DRIVE_RIGHT_MOTOR_1);
		rightM2 = new TalonSRX(RobotMap.DRIVE_RIGHT_MOTOR_2);
		rightM3 = new TalonSRX(RobotMap.DRIVE_RIGHT_MOTOR_3);
		leftM1 = new TalonSRX(RobotMap.DRIVE_LEFT_MOTOR_1);
		leftM2 = new TalonSRX(RobotMap.DRIVE_LEFT_MOTOR_2);
		leftM3 = new TalonSRX(RobotMap.DRIVE_LEFT_MOTOR_3);
		right = new DriveMotorGroup(rightM1, rightM2, rightM3);
		left = new DriveMotorGroup(leftM1, leftM2, leftM3);
		leftTalonSR = new Talon(RobotMap.TALON_SR_DRIVE_LEFT_MOTOR);
		rightTalonSR = new Talon(RobotMap.TALON_SR_DRIVE_RIGHT_MOTOR);
		right.setInverted(Constants.IS_RIGHT_INVERTED);
		left.setInverted(Constants.IS_LEFT_INVERTED);
		left.setSensorInverted(Constants.IS_LEFT_SENSOR_INVERTED);
		right.setSensorInverted(Constants.IS_RIGHT_SENSOR_INVERTED);
		intakeM.setInverted(Constants.IS_INTAKE_INVERTED);
		gearShift = new DoubleSolenoid(0, RobotMap.SHIFT_FORWARD, RobotMap.SHIFT_REVERSE);
		pdp = new PowerDistributionPanel();
		banner = new DigitalInput(RobotMap.BANNER_PORT);
		gyro = new PigeonIMU(RobotMap.GYRO_ID);
	}
}