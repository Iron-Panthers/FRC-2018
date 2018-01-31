package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Constants;
import org.usfirst.frc.team5026.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	TalonSRX masterMotor;
	TalonSRX slaveMotor;
	DoubleSolenoid leftSolenoid;
	DoubleSolenoid rightSolenoid;
	public Elevator() {
		masterMotor = Robot.hardware.elevatorMotor;
		slaveMotor = Robot.hardware.slaveMotor;
		this.leftSolenoid = Robot.hardware.leftSolenoid;
		this.rightSolenoid = Robot.hardware.rightSolenoid;
	}
	public void extendPistons() {
		leftSolenoid.set(DoubleSolenoid.Value.kForward);
		rightSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	public void retractPistons() {
		leftSolenoid.set(DoubleSolenoid.Value.kReverse);
		rightSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	public void raiseToTarget(double tickTarget) {
		masterMotor.set(ControlMode.MotionMagic, tickTarget);
	}
	public void raiseAuto() {
		masterMotor.set(ControlMode.MotionMagic, Constants.TICK_TARGET);
	}
	public void resetElevator() {
		masterMotor.set(ControlMode.MotionMagic, 0); //Go back to starting position
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

