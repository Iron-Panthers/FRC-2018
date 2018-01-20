package org.usfirst.frc.team5026.robot.subsystems;
import org.usfirst.frc.team5026.robot.Constants;
import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.commands.JoystickDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drive extends Subsystem {
	TalonSRX right;
	TalonSRX left;
	ControlMode controlMode;
	DifferentialDrive dDrive;
	public Drive(){
		controlMode = Robot.hardware.controlMode;
		right = Robot.hardware.rightM;
		left = Robot.hardware.leftM;
//		dDrive = new DifferentialDrive(left, right);
		//dDrive.setSafetyEnabled(false);
		//dDrive.setDeadband(Constants.JOYSTICK_DEADZONE);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void setLeftMotor(double speed){
		left.set(controlMode, speed);
	}
	public void setRightMotor(double speed){
		right.set(controlMode, speed);
	}
//	public void setLeftRightMotors(double power) {
//		dDrive.tankDrive(power, power);
//	}
//	public void useArcadeDrive(double yAxis, double xAxis) {
//		dDrive.arcadeDrive(yAxis, xAxis);
//	}
	public void stop() {
//		dDrive.stopMotor();
		left.set(controlMode, 0);
		right.set(controlMode, 0);
	}
    public void initDefaultCommand() {
    	
    	setDefaultCommand(new JoystickDrive());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

