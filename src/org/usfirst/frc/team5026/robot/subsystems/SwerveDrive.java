package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.commands.SwerveDriveCommand;
import org.usfirst.frc.team5026.util.Constants;
import org.usfirst.frc.team5026.util.SwerveMotorGroup;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SwerveDrive extends Subsystem {
	public SwerveMotorGroup swerveMotors;
	DiagonalMotorGroup left;
	DiagonalMotorGroup right;
	public SwerveDrive(SwerveMotorGroup swerveMotors, DiagonalMotorGroup left, DiagonalMotorGroup right) {
		this.swerveMotors = swerveMotors;
		this.left = left;
		this.right = right;
	}
	public void setLeftRightMotors(double adjustedZ, double adjustedMagnitude) {
		left.set(adjustedMagnitude + adjustedZ*Math.sin(2*(swerveMotors.m1.getSelectedSensorPosition(pidIdx)/Constants.ENCODER_TICKS_PER_REVOLUTION)%1) - (Math.PI/4));
		right.set(adjustedMagnitude - adjustedZ*Math.sin(2*(swerveMotors.m1.getSelectedSensorPosition(pidIdx)/Constants.ENCODER_TICKS_PER_REVOLUTION)%1) + (Math.PI/4));
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new SwerveDriveCommand());
    }
}

