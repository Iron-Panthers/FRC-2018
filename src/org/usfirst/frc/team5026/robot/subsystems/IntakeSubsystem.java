package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.commands.IntakeCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {
	public TalonSRX motor;
	public ControlMode controlMode;
	public IntakeSubsystem() {
		controlMode = Robot.hardware.controlMode;
		motor = Robot.hardware.intakeM;
	}
	public void intake(double speed) {
		motor.set(controlMode, speed);
	}
	public void outtake(double speed) {
		motor.set(controlMode, speed);
	}
	public void stop() {
		motor.set(controlMode, 0);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new IntakeCommand());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

