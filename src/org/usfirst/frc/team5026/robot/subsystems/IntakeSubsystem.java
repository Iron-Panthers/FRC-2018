package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.commands.IntakeCommand;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {
	public Talon motor;
	public IntakeSubsystem() {
		motor = Robot.hardware.intakeM;
	}
	public void intake(double speed) {
		motor.set(speed);
	}
	public void outtake(double speed) {
		motor.set(speed);
	}
	public void stop() {
		motor.set(0);
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

