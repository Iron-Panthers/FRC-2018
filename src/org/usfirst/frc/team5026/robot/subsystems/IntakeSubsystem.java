package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Constants;
import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {
	public Talon motor;
	public IntakeSubsystem() {
		motor = Robot.hardware.intakeM;
	}
	public void intake() {
		motor.set(Constants.INTAKE_POWER);
	}
	public void outtake() {
		motor.set(Constants.OUTTAKE_POWER);
	}
	public void stop() {
		motor.set(0);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

