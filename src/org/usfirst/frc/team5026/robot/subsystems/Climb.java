package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climb extends Subsystem {
	public Spark leftClimber;
	public Spark rightClimber;
	public Climb() {
		leftClimber = Robot.hardware.leftClimb;
		rightClimber = Robot.hardware.rightClimb;
	}
	public void up() {
		leftClimber.set(Constants.CLIMB_SPEED);
		rightClimber.set(Constants.CLIMB_SPEED);
	}
	public void down() {
		leftClimber.set(-Constants.CLIMB_SPEED);
		rightClimber.set(-Constants.CLIMB_SPEED);
	}
	public void stop() {
		leftClimber.stopMotor();
		rightClimber.stopMotor();
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

