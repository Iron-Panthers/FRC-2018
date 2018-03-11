package org.usfirst.frc.team5026.robot.util;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveMotorGroup implements SpeedController {
	public TalonSRX motor1; 
	public TalonSRX motor2;
	public TalonSRX motor3;
	public TalonSRX[] motors;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public DriveMotorGroup(TalonSRX motor1, TalonSRX motor2, TalonSRX motor3) {
		this.motor1 = motor1;
		this.motor2 = motor2;
		this.motor3 = motor3;
		motors = new TalonSRX[3];
		motors[0] = this.motor1;
		motors[1] = this.motor2;
		motors[2] = this.motor3;
		this.motor2.follow(motor1);
		this.motor3.follow(motor1);
		setUp(motor1, motor2, motor3);
	}
	public void setUp(TalonSRX encoderMotor, TalonSRX... motors) {
		encoderMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
		encoderMotor.setSensorPhase(true);
		encoderMotor.setInverted(false);
		
		encoderMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.kTimeoutMs);
		encoderMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.kTimeoutMs);
		
		encoderMotor.configNominalOutputForward(0, Constants.kTimeoutMs);
		encoderMotor.configNominalOutputReverse(0, Constants.kTimeoutMs);
		encoderMotor.configPeakOutputForward(1, Constants.kTimeoutMs);
		encoderMotor.configPeakOutputReverse(-1, Constants.kTimeoutMs);
		
		encoderMotor.selectProfileSlot(Constants.kSlotIdx, Constants.kTimeoutMs);
		encoderMotor.config_kF(0, Constants.DRIVE_F, Constants.kTimeoutMs);
		encoderMotor.config_kP(0, Constants.DRIVE_P, Constants.kTimeoutMs);
		encoderMotor.config_kI(0, Constants.DRIVE_I, Constants.kTimeoutMs);
		encoderMotor.config_kD(0, Constants.DRIVE_D, Constants.kTimeoutMs);
		
		encoderMotor.configMotionCruiseVelocity(Constants.DRIVE_VELOCITY, Constants.kTimeoutMs);
		encoderMotor.configMotionAcceleration(Constants.DRIVE_ACCELERATION, Constants.kTimeoutMs);

		for (int i = 0; i < motors.length; i++) {
			motors[i].follow(encoderMotor);
		}
		motor1 = encoderMotor;
		this.motors = motors;
	}
	public void setupBrakeMode(NeutralMode mode) {
		motor1.setNeutralMode(mode);
		for (TalonSRX s : motors) {
			s.setNeutralMode(mode);
		}
	}
	public void driveWithPower(double speed) {  // -1 to 1
		motor1.set(ControlMode.PercentOutput, speed);
		for (TalonSRX t : motors) {
			SmartDashboard.putNumber("Motor "+t.getDeviceID(), t.getMotorOutputPercent());
		}
	}
	public void driveWithTarget(double target) {
		motor1.set(ControlMode.MotionMagic, target);
		SmartDashboard.putNumber("Motor "+motor1.getDeviceID(), motor1.getMotorOutputPercent());
		for (TalonSRX t : motors) {
			SmartDashboard.putNumber("Motor "+t.getDeviceID(), t.getMotorOutputPercent());
		}
		
	}
	public void stop() {
		motor1.set(ControlMode.PercentOutput, 0);
	}
	public void setInverted(boolean isInverted) {
		motor1.setInverted(isInverted);
		for (TalonSRX t : motors) {
			t.setInverted(isInverted);
		}
	}
	public void setSensorInverted(boolean inverted) {
		motor1.setSensorPhase(!inverted);
	}
	public void pidWrite(double arg0) {
		// TODO LATER
	}
	public void disable() {
		stop();
	}
	@Override
	public double get() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean getInverted() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void set(double power) {
		// TODO Auto-generated method stub
		driveWithPower(power);
	}
	@Override
	public void stopMotor() {
		// TODO Auto-generated method stub
		stop();
	}
	
	public int getEncoderTicks() {
		return this.motor1.getSelectedSensorPosition(Constants.kSlotIdx);
	}
}

