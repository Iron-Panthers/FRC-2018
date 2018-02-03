package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.util.Constants;

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
		motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
		motor.setSensorPhase(true);
		motor.setInverted(false);
		
		motor.setStatusFramePeriod(StatusFrameEnhanced.Status_13_Base_PIDF0, 10, Constants.kTimeoutMs);
		motor.setStatusFramePeriod(StatusFrameEnhanced.Status_10_MotionMagic, 10, Constants.kTimeoutMs);
		
		motor.configNominalOutputForward(0, Constants.kTimeoutMs);
		motor.configNominalOutputReverse(0, Constants.kTimeoutMs);
		motor.configPeakOutputForward(1, Constants.kTimeoutMs);
		motor.configPeakOutputReverse(1, Constants.kTimeoutMs);
		
		motor.selectProfileSlot(Constants.kSlotIdx, Constants.kTimeoutMs);
		motor.config_kF(0, Constants.DRIVE_F, Constants.kTimeoutMs);
		motor.config_kP(0, Constants.DRIVE_P, Constants.kTimeoutMs);
		motor.config_kI(0, Constants.DRIVE_I, Constants.kTimeoutMs);
		motor.config_kD(0, Constants.DRIVE_D, Constants.kTimeoutMs);
		
		motor.configMotionCruiseVelocity(Constants.DRIVE_VELOCITY, Constants.kTimeoutMs);
		motor.configMotionAcceleration(Constants.DRIVE_ACCELERATION, Constants.kTimeoutMs);
		
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

