package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.commands.SwerveDriveCommand;
import org.usfirst.frc.team5026.util.SwerveMotorGroup;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SwerveDrive extends Subsystem {
	public SwerveMotorGroup swerveMotors;
	DriveMotorGroup left;
	DriveMotorGroup right;
	public SwerveDrive(SwerveMotorGroup swerveMotors, DriveMotorGroup left, DriveMotorGroup right) {
		this.swerveMotors = swerveMotors;
		this.left = left;
		this.right = right;
	}
	public void setLeftRightMotors(double adjustedZ, double adjustedMagnitude) {
		left.set(adjustedMagnitude+adjustedZ);
		right.set(adjustedMagnitude-adjustedZ);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new SwerveDriveCommand());
    }
}

