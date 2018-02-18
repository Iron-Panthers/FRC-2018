package org.usfirst.frc.team5026.robot.subsystems;
 
import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
 
/**
 *
 */
public class IntakeSubsystem extends Subsystem {
	public TalonSRX motor;
	public IntakeSubsystem() {
		motor = Robot.hardware.intakeM;
	}
	public void intake(double speed) {
		motor.set(ControlMode.PercentOutput,speed);
	}
	public void outtake(double speed) {
		motor.set(ControlMode.PercentOutput,speed);
	}
	public void stop() {
		motor.set(ControlMode.PercentOutput,0);
	}
	public boolean hasBlock() {
		if(motor.getOutputCurrent()>Constants.BLOCK_GRAB_THRESHOLD) {
			return true;
		}
		return false;
	}
	public void grabBlock() {
		//Grabs block by setting motor to desired voltage
		intake(Constants.INTAKE_VOLTAGE_GRAB);
	}
	public void holdBlock() {
		//Holds block with lowered voltage
		intake(Constants.INTAKE_VOLTAGE_HOLD);
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	 
	public void initDefaultCommand() {
		//setDefaultCommand(new IntakeCommand());
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}
}