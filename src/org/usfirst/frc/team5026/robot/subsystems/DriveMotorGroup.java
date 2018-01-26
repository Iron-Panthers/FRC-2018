package org.usfirst.frc.team5026.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
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
		this.motor2.follow(this.motor1);
		this.motor3.follow(this.motor1);
	}
	public void driveWithPower(double speed) {  // -1 to 1
		motor1.set(ControlMode.PercentOutput, speed);
		SmartDashboard.putNumber("Motor 1", motor1.getMotorOutputPercent());
		SmartDashboard.putNumber("Motor 2", motor2.getMotorOutputPercent());
		SmartDashboard.putNumber("Motor 3", motor3.getMotorOutputPercent());
	}
	public void driveWithTarget(double target) {
		motor1.set(ControlMode.MotionMagic, target);
		SmartDashboard.putNumber("Motor "+motor1.getDeviceID(), motor1.getMotorOutputPercent());
		SmartDashboard.putNumber("Motor "+motor2.getDeviceID(), motor2.getMotorOutputPercent());
		SmartDashboard.putNumber("Motor "+motor3.getDeviceID(), motor3.getMotorOutputPercent());
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

