package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Constants;
import org.usfirst.frc.team5026.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	TalonSRX masterMotor;
	TalonSRX slaveMotor;
	public Elevator() {
		masterMotor = Robot.hardware.elevatorMotor;
		slaveMotor = Robot.hardware.slaveMotor;
	}
	public void raiseToTarget(double tickTarget) {
		masterMotor.set(ControlMode.MotionMagic, tickTarget);
	}
	public void raiseAuto() {
		masterMotor.set(ControlMode.MotionMagic, Constants.TICK_TARGET);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

