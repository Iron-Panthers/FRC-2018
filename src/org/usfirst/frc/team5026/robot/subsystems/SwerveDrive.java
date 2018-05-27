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
	
	public void setDriveMotors(double adjustedMagnitude, double adjustedZ, double turn) {
		double pi = Math.PI;
		double swerveAngle = SwerveJoystick.calcPositiveMod(swerveM1.getSelectedSensorPosition(Constants.kPIDLoopIdx) / Constants.ENCODER_TICKS_PER_REVOLUTION, 1);
		//encoders will start at 0, so angle will be refrenced to pointing forward relative to front of robot
		//measured from 0 to 1
		
		if (0 <= swerveAngle && swerveAngle <= .125) {
			frontLeft.set(ControlMode.PercentOutput, adjustedMagnitude + turn);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude - adjustedZ);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude - turn);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude + adjustedZ);
		}
		if (.125 < swerveAngle && swerveAngle < .25) {
			frontLeft.set(ControlMode.PercentOutput, adjustedMagnitude - turn);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude - adjustedZ);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude + turn);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude + adjustedZ);
		}
		if(.25 <= swerveAngle && swerveAngle <= .375) {
			frontLeft.set(ControlMode.PercentOutput, adjustedMagnitude - adjustedZ);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude - turn);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude + adjustedZ);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude + turn);
		}
		if(.375 < swerveAngle && swerveAngle < .5) {
			frontLeft.set(ControlMode.PercentOutput, adjustedMagnitude - adjustedZ);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude + turn);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude + adjustedZ);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude - turn);
		}
		if(.5 <= swerveAngle && swerveAngle <= .625) {
			frontLeft.set(ControlMode.PercentOutput, adjustedMagnitude - turn);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude + adjustedZ);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude + turn);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude - adjustedZ);
		}
		if(.625 < swerveAngle && swerveAngle < .75) {
			frontLeft.set(ControlMode.PercentOutput, adjustedMagnitude + turn);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude + adjustedZ);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude - turn);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude - adjustedZ);
		}
		if(.75 <= swerveAngle && swerveAngle <= .875) {
			frontLeft.set(ControlMode.PercentOutput, adjustedMagnitude + adjustedZ);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude + turn);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude - adjustedZ);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude - turn);
		}
		if(.875 < swerveAngle && swerveAngle < 1) {
			frontLeft.set(ControlMode.PercentOutput, adjustedMagnitude + adjustedZ);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude - turn);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude - adjustedZ);
			frontRight.set(ControlMode.PercentOutput, adjustedMagnitude + turn);
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

