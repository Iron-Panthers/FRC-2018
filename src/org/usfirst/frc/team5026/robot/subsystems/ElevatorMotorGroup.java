package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ElevatorMotorGroup implements SpeedController {
	public TalonSRX motor1;
	public TalonSRX[] motors;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public ElevatorMotorGroup(TalonSRX leftMotor, TalonSRX rightMotor) {
		SetUp(leftMotor, rightMotor);
	}
	
	public void SetUp(TalonSRX motor, TalonSRX... motors) {
		motor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
		motor.setSensorPhase(true);
		motor.setInverted(false);
		
		motor.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.kTimeoutMs);
		motor.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.kTimeoutMs);
		
		motor.configNominalOutputForward(0, Constants.kTimeoutMs);
		motor.configNominalOutputReverse(0, Constants.kTimeoutMs);
		motor.configPeakOutputForward(1, Constants.kTimeoutMs);
		motor.configPeakOutputReverse(-1, Constants.kTimeoutMs);
		
		motor.selectProfileSlot(Constants.kSlotIdx, Constants.kTimeoutMs);
		motor.config_kF(0, Constants.DRIVE_F, Constants.kTimeoutMs);
		motor.config_kP(0, Constants.DRIVE_P, Constants.kTimeoutMs);
		motor.config_kI(0, Constants.DRIVE_I, Constants.kTimeoutMs);
		motor.config_kD(0, Constants.DRIVE_D, Constants.kTimeoutMs);
		
		motor.configMotionCruiseVelocity(Constants.ELEVATOR_VELOCITY, Constants.kTimeoutMs);
		motor.configMotionAcceleration(Constants.ELEVATOR_ACCELERATION, Constants.kTimeoutMs);

		for (int i = 0; i < motors.length; i++) {
			motors[i].follow(motor);
		}
		motor1 = motor;
		this.motors = motors;
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