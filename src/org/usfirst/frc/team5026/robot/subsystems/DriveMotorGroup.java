package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveMotorGroup extends Subsystem {
	public TalonSRX motor1; 
	public TalonSRX motor2;
	public TalonSRX motor3;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public DriveMotorGroup(TalonSRX motor1, TalonSRX motor2, TalonSRX motor3) {
		this.motor1 = motor1;
		this.motor2 = motor2;
		this.motor3 = motor3;
		this.motor2.follow(motor1);
		this.motor3.follow(motor1);
		setUp(this.motor1);
		setUp(this.motor2);
		setUp(this.motor3);
	}
	public void setUp(TalonSRX motor) {
		motor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
		motor.setSensorPhase(true);
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
		motor.config_kF(0, 0.2, Constants.kTimeoutMs);
		motor.config_kP(0, 0.2, Constants.kTimeoutMs);
		motor.config_kI(0, 0, Constants.kTimeoutMs);
		motor.config_kD(0, 0, Constants.kTimeoutMs);
		/* set acceleration and vcruise velocity - see documentation */
		motor.configMotionCruiseVelocity(15000, Constants.kTimeoutMs);
		motor.configMotionAcceleration(6000, Constants.kTimeoutMs);
		/* zero the sensor */
		motor.setSelectedSensorPosition(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
	}
	public void driveWithPower(double speed) {  // -1 to 1
		motor1.set(ControlMode.PercentOutput, speed);
//		motor2.set(ControlMode.PercentOutput, speed);
//		motor3.set(ControlMode.PercentOutput, speed);
		SmartDashboard.putNumber("Motor 1", motor1.getMotorOutputPercent());
		SmartDashboard.putNumber("Motor 2", motor2.getMotorOutputPercent());
		SmartDashboard.putNumber("Motor 3", motor3.getMotorOutputPercent());
	}
	public void driveWithTarget(double target) {
		motor1.set(ControlMode.MotionMagic, target);
//		motor2.set(ControlMode.MotionMagic, target);
//		motor3.set(ControlMode.MotionMagic, target);
		SmartDashboard.putNumber("Motor "+motor1.getDeviceID(), motor1.getMotorOutputPercent());
		SmartDashboard.putNumber("Motor "+motor2.getDeviceID(), motor2.getMotorOutputPercent());
		SmartDashboard.putNumber("Motor "+motor3.getDeviceID(), motor3.getMotorOutputPercent());
	}
	public void printPowers() {
		System.out.println("Motor "+motor1.getDeviceID()+","+motor1.getMotorOutputPercent());
		System.out.println("Motor "+motor2.getDeviceID()+","+motor2.getMotorOutputPercent());
		System.out.println("Motor "+motor3.getDeviceID()+","+motor3.getMotorOutputPercent());
	}
	public void stop() {
		motor1.set(ControlMode.PercentOutput, 0);
	}
	public void setInverted(boolean isInverted) {
		motor1.setInverted(isInverted);
		motor2.setInverted(isInverted);
		motor3.setInverted(isInverted);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

