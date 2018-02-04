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
	}
	public void setUp(TalonSRX motor) {
		motor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
		motor.setSensorPhase(false); //Flips signal, allows motor to go positive and negative
		motor.setInverted(false);

		/* Set relevant frame periods to be at least as fast as periodic rate */
		motor.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.kTimeoutMs);
		motor.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.kTimeoutMs);

		/* set the peak and nominal outputs */
		motor.configNominalOutputForward(0, Constants.kTimeoutMs);
		motor.configNominalOutputReverse(0, Constants.kTimeoutMs);
		motor.configPeakOutputForward(1, Constants.kTimeoutMs);
		motor.configPeakOutputReverse(-1, Constants.kTimeoutMs);

		/* set closed loop gains in slot0 - see documentation */
		motor.selectProfileSlot(Constants.kSlotIdx, Constants.kPIDLoopIdx);
		motor.config_kF(0, Constants.FEED_FORWARD, Constants.kTimeoutMs);
		motor.config_kP(0, Constants.AUTO_P, Constants.kTimeoutMs);
		motor.config_kI(0, 0, Constants.kTimeoutMs);
		motor.config_kD(0, 0, Constants.kTimeoutMs);
		/* set acceleration and cruise velocity - see documentation */
		motor.configMotionCruiseVelocity(Constants.CRUISE_VELOCITY, Constants.kTimeoutMs);
		motor.configMotionAcceleration(Constants.ACCELERATION, Constants.kTimeoutMs);
		/* zero the sensor */
		motor.setSelectedSensorPosition(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
	}
}
