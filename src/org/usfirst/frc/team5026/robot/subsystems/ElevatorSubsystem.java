package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ElevatorSubsystem extends Subsystem {
	public TalonSRX elevatorMotor;
	public DoubleSolenoid leftElevatorPiston;
	public DoubleSolenoid rightElevatorPiston;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public ElevatorSubsystem() {
		elevatorMotor = Robot.hardware.elevatorMotor;
		leftElevatorPiston = Robot.hardware.leftElevatorPiston;
		rightElevatorPiston = Robot.hardware.rightElevatorPiston;
	}
	public void liftElevator(double target) {
		//Lifts carriage slightly off ground with MotionMagic
	}
	public void extendElevator() {
		//Extends pistons on elevator 
	}
	public void retractElevator() {
		//Retracts pistons on elevator
	}
	public void liftElevatorToSwitch(double target) {
		//Lifts carriage to Switch level
	}
	public void liftElevatorToScale(double target) {
		//Lifts carriage to Scale level
	}
	public void liftElevatorToGround(double target) {
		//Lowers carriage to ground
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

