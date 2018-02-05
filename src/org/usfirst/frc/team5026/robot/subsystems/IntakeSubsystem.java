package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {
	public TalonSRX motor;
	public IntakeSubsystem() {
		motor = Robot.hardware.intakeM;
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
	public void hasBlock() {
		if (Robot.hardware.bannerSensor.get()) {
			SmartDashboard.putBoolean("Has block", true);
		} else {
			SmartDashboard.putBoolean("Has block", false);
		}
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	//setDefaultCommand(new IntakeCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

