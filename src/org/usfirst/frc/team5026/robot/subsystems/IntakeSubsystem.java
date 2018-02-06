package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {
	public TalonSRX motor;
	public DigitalInput banner;
	public IntakeSubsystem() {
		motor = Robot.hardware.intakeM;
		banner = Robot.hardware.bannerSensor;
	}
	public void intake(double speed) {
		motor.set(ControlMode.PercentOutput,speed);
	}
	public void outtake(double speed) {
		motor.set(ControlMode.PercentOutput,-speed);
	}
	public void stop() {
		motor.set(ControlMode.PercentOutput,0);
	}
	public boolean hasBlock() {
		return banner.get();
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	//setDefaultCommand(new IntakeCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

