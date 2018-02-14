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
	public DriveMotorGroup right;
	public DriveMotorGroup left;
	DriveMotorType type;
	public Talon l;
	public Talon r;
	public DoubleSolenoid gearShift;
	public DifferentialDrive dDrive;
	public boolean isReversed;
	public GearState state;
	public Drive(DriveMotorGroup r, DriveMotorGroup l, DoubleSolenoid gearShift){
		this.gearShift = gearShift;
		this.right = r;
		this.left = l;
		type = DriveMotorType.TALONSRX;
		dDrive = new DifferentialDrive(left, right);
		dDrive.setSafetyEnabled(false);
		dDrive.setDeadband(Constants.JOYSTICK_DEADZONE);
		isReversed = false;
	}
	public Drive(Talon l, Talon r, DoubleSolenoid gearShift) {
		this.gearShift = gearShift;
		this.l = l;
		this.r = r;
	//	r.setInverted(true);
		type = DriveMotorType.TALONSR;
		dDrive = new DifferentialDrive(l, r);
		dDrive.setSafetyEnabled(false);
		dDrive.setDeadband(Constants.JOYSTICK_DEADZONE);
		isReversed = false;
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void setLeftSide(double speed){
		if (type == DriveMotorType.TALONSRX) {
			if(speed>1) {
				left.driveWithPower(Constants.SPEED);
			}
			else if(speed<-1) {
				left.driveWithPower(-Constants.SPEED);
			}
			else {
				left.driveWithPower(speed*Constants.SPEED);
			}
		} else if (type == DriveMotorType.TALONSR) {
			if(speed>1) {
				l.set(Constants.SPEED);
			}
			else if(speed<-1) {
				l.set(-Constants.SPEED);
			}
			else {
				l.set(speed*Constants.SPEED);
			}
		}
	}
	public void setRightSide(double speed){
		if (type == DriveMotorType.TALONSRX) {
			if(speed>1) {
				right.set(Constants.SPEED);
			}
			else if(speed<-1) {
				right.set(-Constants.SPEED);
			}
			else {
				right.set(speed*Constants.SPEED);
			}
		}else if (type == DriveMotorType.TALONSR) {
			if(speed>1) {
				r.set(Constants.SPEED);
			}
			else if(speed<-1) {
				r.set(-Constants.SPEED);
			}
			else {
				r.set(speed*Constants.SPEED);
			}
		}
	}
	public void driveWithTarget(double target) {
		if (type == DriveMotorType.TALONSRX) {
			left.driveWithTarget(target);
	//		left.printPowers();
			right.driveWithTarget(target);
	//		right.printPowers();
		} else if (type == DriveMotorType.TALONSR) {
			// THIS DOESN'T HAPPEN!
			System.out.println("You are in the wrong DriveMotorType! You should be in DriveMotorType.TALONSRX, but you are in DriveMotorType.TALONSR");
			return;
		}
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
		if (type == DriveMotorType.TALONSRX) {
			left.stop();
			right.stop();
		} else if (type == DriveMotorType.TALONSR) {
			l.stopMotor();
			r.stopMotor();
		}
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

