package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;
import org.usfirst.frc.team5026.robot.util.ElevatorMotorGroup;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	public ElevatorMotorGroup motors;
	public DoubleSolenoid leftSolenoid;
	public DoubleSolenoid rightSolenoid;
	public Elevator() {
		motors = Robot.hardware.elevatorMotors;
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
		motors.driveWithTarget(tickTarget);
	}
	public void raiseToScale() {
		motors.driveWithTarget(Constants.ELEVATOR_SCALE_TARGET);
	}
	public void raiseToSwitch() {
		motors.driveWithTarget(Constants.ELEVATOR_SWITCH_TARGET);
	}
	public void resetElevator() {
		motors.driveWithTarget(Constants.ELEVATOR_GROUND_TARGET);
	}
	public void stop() {
		motors.stop();
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

