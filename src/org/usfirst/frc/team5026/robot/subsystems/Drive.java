package org.usfirst.frc.team5026.robot.subsystems;
import org.usfirst.frc.team5026.robot.commands.JoystickDrive;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drive extends Subsystem {
	Talon rightM1;
	Talon leftM1;
	public DriveMotorGroup right;
	public DriveMotorGroup left;
	DoubleSolenoid gearShift;
	DoubleSolenoid elevatorGearShift;
	DifferentialDrive dDrive;
	public boolean isReversed;
	GearState state;
	
		rightM1 = new Talon(1);
		rightM1.setInverted(true);
		leftM1 = new Talon(0);
		leftM1.setInverted(false);
	public Drive(DriveMotorGroup r, DriveMotorGroup l, DoubleSolenoid d, DoubleSolenoid e){
		gearShift = d;
		elevatorGearShift = e;
		this.right = r;
		this.left = l;
		dDrive = new DifferentialDrive(left, right);
		dDrive.setSafetyEnabled(false);
		dDrive.setDeadband(Constants.JOYSTICK_DEADZONE);
		isReversed = false;
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void setLeftSide(double speed){
		if(speed>1) {
			leftM1.set(Constants.SPEED);
		}
		else if(speed<-1) {
			leftM1.set(-Constants.SPEED);
		}
		else {
			leftM1.set(speed*Constants.SPEED);
		}
	}
	public void setRightSide(double speed){
		if(speed>1) {
			rightM1.set(Constants.SPEED);
		}
		else if(speed<-1) {
			rightM1.set(-Constants.SPEED);
		}
		else {
			rightM1.set(speed*Constants.SPEED);
		}
	}
	public void driveWithTarget(double target) {
		left.driveWithTarget(target);
//		left.printPowers();
		right.driveWithTarget(target);
//		right.printPowers();
	}
//	public void driveWithPower(double speed) {
//		left.driveWithPower(speed);
//		right.driveWithPower(speed);
//	}
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
	public void shiftHigh() {
		state = GearState.HIGH;
		gearShift.set(DoubleSolenoid.Value.kReverse);
	}
	public void shiftLow() {
		state = GearState.LOW;
		gearShift.set(DoubleSolenoid.Value.kForward);
	}
	public void elevatorShiftHigh() {
		state = GearState.HIGH;
		elevatorGearShift.set(DoubleSolenoid.Value.kReverse);
	}
	public void elevatorShiftLow() {
		state = GearState.LOW;
		elevatorGearShift.set(DoubleSolenoid.Value.kForward);
	}
    public void initDefaultCommand() {
    	
    	setDefaultCommand(new JoystickDrive());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

