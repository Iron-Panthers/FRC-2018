package org.usfirst.frc.team5026.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Hardware {
	public TalonSRX elevatorMotor;
	public TalonSRX slaveMotor;
//	public DigitalInput limitSwitchF;
//	public DigitalInput limitSwitchR;
	public DoubleSolenoid leftSolenoid;
	public DoubleSolenoid rightSolenoid;
	public Hardware() {
		elevatorMotor = new TalonSRX(RobotMap.TALON_PORT);
		slaveMotor = new TalonSRX(RobotMap.SLAVE_PORT);
		setUp(elevatorMotor);
//		elevatorMotor.setInverted(Constants.IS_ELEVATOR_INVERTED);
		elevatorMotor.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
		elevatorMotor.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
		slaveMotor.follow(elevatorMotor);
//		slaveMotor.setInverted(Constants.IS_ELEVATOR_INVERTED);
		
//		limitSwitchF = new DigitalInput(RobotMap.LIMIT_SWTICH_F);
//		limitSwitchR = new DigitalInput(RobotMap.LIMIT_SWTICH_R);
		leftSolenoid = new DoubleSolenoid(RobotMap.LEFT_SOLENOID_PORT_1, RobotMap.LEFT_SOLENOID_PORT_2);
		rightSolenoid = new DoubleSolenoid(RobotMap.RIGHT_SOLENOID_PORT_1, RobotMap.RIGHT_SOLENOID_PORT_2);

		pdp = new PowerDistributionPanel();