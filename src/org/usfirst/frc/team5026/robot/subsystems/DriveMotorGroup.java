package org.usfirst.frc.team5026.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

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
	}
	public void driveWithPower(double speed) {  // -1 to 1
		motor1.set(ControlMode.PercentOutput, speed);
		motor2.set(ControlMode.PercentOutput, speed);
		motor3.set(ControlMode.PercentOutput, speed);
	}
	public void driveWithTarget(double target) {
		motor1.set(ControlMode.MotionMagic, target);
		motor2.set(ControlMode.MotionMagic, target);		
		motor3.set(ControlMode.MotionMagic, target);	
	}
	public void stop() {
		motor1.set(ControlMode.PercentOutput, 0);
		motor2.set(ControlMode.PercentOutput, 0);
		motor3.set(ControlMode.PercentOutput, 0);
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

