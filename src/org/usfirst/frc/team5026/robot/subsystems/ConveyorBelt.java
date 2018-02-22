package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ConveyorBelt extends Subsystem {
	public TalonSRX motor;
	public ConveyorBelt() {
		motor = Robot.hardware.conveyor;
	}
	public void forward() {
		motor.set(ControlMode.PercentOutput, -Constants.CONVEYOR_SPEED);
	}
	public void backward() {
		motor.set(ControlMode.PercentOutput, Constants.CONVEYOR_SPEED);
	}
	public void stop() {
		motor.set(ControlMode.PercentOutput, 0);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

