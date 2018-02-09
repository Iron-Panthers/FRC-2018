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
	public DoubleSolenoid elevatorPistons;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public ElevatorSubsystem() {
		elevatorMotor = Robot.hardware.elevatorMotor;
		elevatorPistons = Robot.hardware.elevatorPistons;
	}
	public void liftCubeExtendPiston(double target) {
		//Lifts cube slightly off ground with piston
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

