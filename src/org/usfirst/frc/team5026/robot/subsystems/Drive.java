package org.usfirst.frc.team5026.robot.subsystems;
import org.usfirst.frc.team5026.robot.commands.drive.JoystickDrive;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drive extends Subsystem {
	public Talon l;
	public Talon r;
	DoubleSolenoid gearShift;
	DifferentialDrive dDrive;
	public boolean isReversed;
	GearState state;
	
//	public Drive(DriveMotorGroup r, DriveMotorGroup l, DoubleSolenoid d){
//		gearShift = d;
//		this.right = r;
//		this.left = l;
//		dDrive = new DifferentialDrive(left, right);
//		dDrive.setSafetyEnabled(false);
//		dDrive.setDeadband(Constants.JOYSTICK_DEADZONE);
//		isReversed = false;
//		isTalonSR = false;
//	}
	
	public Drive(Talon r, Talon l, DoubleSolenoid d){
		gearShift = d;
		this.r = r;
		this.l = l;
		dDrive = new DifferentialDrive(l, r);
		dDrive.setSafetyEnabled(false);
		dDrive.setDeadband(Constants.JOYSTICK_DEADZONE);
		isReversed = false;
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void setLeftSide(double speed){ //Input from -1 to 1
		l.set(speed);
	}
	public void setRightSide(double speed){
		r.set(speed);
	}
	public void driveWithPower(double speed) {
		l.set(speed);
		r.set(speed);
	}
//	public void setLeftRightMotors(double power) {
//		dDrive.tankDrive(power, power);
//	}
	public void useArcadeDrive(double yAxis, double xAxis) {
		dDrive.arcadeDrive(yAxis, xAxis);
	}
	public void stop() {
//		dDrive.stopMotor();
		l.set(0);
		r.set(0);
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
    public void initDefaultCommand() {
    	
    	setDefaultCommand(new JoystickDrive());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

