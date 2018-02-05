package org.usfirst.frc.team5026.robot.subsystems;
import org.usfirst.frc.team5026.robot.commands.JoystickDrive;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drive extends Subsystem {
	public DriveMotorGroup right;
	public DriveMotorGroup left;
	DifferentialDrive dDrive;
	public boolean isReversed;
	public Drive(DriveMotorGroup left, DriveMotorGroup right){
		this.right = right;
		this.left = left;
		dDrive = new DifferentialDrive(left, right);
		dDrive.setSafetyEnabled(false);
		dDrive.setDeadband(Constants.JOYSTICK_DEADZONE);
		isReversed = false;
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void setLeftSide(double speed){ //Input from -1 to 1
		left.driveWithPower(speed);
	}
	public void setRightSide(double speed){
		right.driveWithPower(speed);
	}
	public void driveWithTarget(double target) {
		left.driveWithTarget(target);
//		left.printPowers();
		right.driveWithTarget(target);
//		right.printPowers();
	}
	public void driveWithPower(double speed) {
		left.driveWithPower(speed);
		right.driveWithPower(speed);
	}
//	public void setLeftRightMotors(double power) {
//		dDrive.tankDrive(power, power);
//	}
	public void useArcadeDrive(double yAxis, double xAxis) {
		dDrive.arcadeDrive(yAxis, xAxis);
	}
	public void stop() {
//		dDrive.stopMotor();
		left.stop();
		right.stop();
	}
	public void reverseDrive() {
		isReversed = !isReversed;
	}
    public void initDefaultCommand() {
    	
    	setDefaultCommand(new JoystickDrive());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
