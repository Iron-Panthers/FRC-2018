package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.commands.SwerveDriveCommand;
import org.usfirst.frc.team5026.util.Constants;
import org.usfirst.frc.team5026.util.SwerveJoystick;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SwerveDrive extends Subsystem {
	public TalonSRX swerveM1;
	public TalonSRX swerveM2;
	public TalonSRX swerveM3;
	public TalonSRX swerveM4;
	public TalonSRX frontLeft;
	public TalonSRX frontRight;
	public TalonSRX backLeft;
	public TalonSRX backRight;
	public SwerveDrive(TalonSRX swerveM1, TalonSRX swerveM2, TalonSRX swerveM3, TalonSRX swerveM4, TalonSRX frontLeft, TalonSRX frontRight, TalonSRX backLeft, TalonSRX backRight) {
		this.frontLeft = frontLeft;
		this.frontRight = frontRight;
		this.backLeft = backLeft;
		this.backRight = backRight;
		this.swerveM1 = swerveM1;
		this.swerveM2 = swerveM2;
		this.swerveM3 = swerveM3;
		this.swerveM4 = swerveM4;
	}
	
	public double cycleSet(double robotSection, double magnitude, double Z, double turn) {
		if (robotSection == 0) {
			return magnitude + turn;
		}
		if (robotSection == 1) {
			return magnitude - turn;
		}
		if (robotSection == 0) {
			return magnitude - Z;
		}
		if (robotSection == 0) {
			return magnitude - Z;
		}
		if (robotSection == 0) {
			return magnitude - turn;
		}
		if (robotSection == 0) {
			return magnitude + turn;
		}
		if (robotSection == 0) {
			return magnitude + Z;
		}
		if (robotSection == 0) {
			return magnitude + Z;
		}
			
	}
	
	public void setDriveMotors(double adjustedMagnitude, double adjustedZ, double turn) {
		double pi = Math.PI;
		double swerveAngle = SwerveJoystick.calcPositiveMod(swerveM1.getSelectedSensorPosition(Constants.kPIDLoopIdx) / Constants.ENCODER_TICKS_PER_REVOLUTION, 1);
		//encoders will start at 0, so angle will be refrenced to pointing forward relative to front of robot
		//measured from 0 to 1
		
		for (int i = 0; i < 8; i++) {
			if (i*.125 < swerveAngle && swerveAngle < (i*.125)+.125) {
				frontLeft.set(ControlMode.PercentOutput, cycleSet(i, adjustedMagnitude, adjustedZ, turn));
				frontRight.set(ControlMode.PercentOutput, cycleSet(i+2, adjustedMagnitude, adjustedZ, turn));
				backRight.set(ControlMode.PercentOutput, cycleSet(i+4, adjustedMagnitude, adjustedZ, turn));
				backLeft.set(ControlMode.PercentOutput, cycleSet(i+6, adjustedMagnitude, adjustedZ, turn));
			}
		}
	}
	
	public void setMotorDirection(double targetRadians) {
		double angleFromNegative1To1 = targetRadians / (2 * Math.PI);
		double velocity = Constants.P * (angleFromNegative1To1 - SwerveJoystick.calcPositiveMod(swerveM1.getSelectedSensorPosition(Constants.kPIDLoopIdx) / Constants.ENCODER_TICKS_PER_REVOLUTION, 1)); //PidLoopX is the type of PID loop being used. 0 is for closed loop, which is what we are using
		swerveM1.set(ControlMode.PercentOutput, velocity);
		swerveM2.set(ControlMode.PercentOutput, velocity);
		swerveM3.set(ControlMode.PercentOutput, velocity);
		swerveM4.set(ControlMode.PercentOutput, velocity);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new SwerveDriveCommand());
    }
}

