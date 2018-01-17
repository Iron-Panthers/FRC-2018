package org.usfirst.frc.team5026.robot.subsystems;
import org.usfirst.frc.team5026.robot.Constants;
import org.usfirst.frc.team5026.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drive extends Subsystem {
	Talon right;
	Talon left;
	DifferentialDrive dDrive;
	public Drive(Talon r, Talon l){
		right = r;
		left = l;
		dDrive = new DifferentialDrive(l, r);
		dDrive.setSafetyEnabled(false);
		dDrive.setDeadband(Constants.JOYSTICK_DEADZONE);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void setLeftMotor(double speed){
		left.set(speed);
	}
	public void setRightMotor(double speed){
		right.set(speed);
	}
	public void setLeftRightMotors(double power) {
		dDrive.tankDrive(power, power);
	}
	public void useArcadeDrive(double yAxis, double xAxis) {
		dDrive.arcadeDrive(yAxis, xAxis);
	}
	public void stop() {
		dDrive.stopMotor();
	}
    public void initDefaultCommand() {
    	setDefaultCommand(new JoystickDrive());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

