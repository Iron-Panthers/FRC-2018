package org.usfirst.frc.team5026.robot.subsystems;

import java.util.ArrayList;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;
import org.usfirst.frc.team5026.robot.util.ElevatorDirection;
import org.usfirst.frc.team5026.robot.util.ElevatorMotorGroup;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	public ElevatorMotorGroup motors;
	public DoubleSolenoid solenoid;
	public double lastVelocity;
	public Elevator() {
		motors = Robot.hardware.elevatorMotors;
		solenoid = Robot.hardware.elevatorSolenoid;
	}
	
	public void extendPistons() {
		solenoid.set(DoubleSolenoid.Value.kForward);
	}
	public void retractPistons() {
		solenoid.set(DoubleSolenoid.Value.kReverse);
	}
	public void raiseToTarget(double tickTarget) {
		motors.driveWithTarget(tickTarget);
	}
	public void raiseToScale() {
		motors.driveWithTarget(Constants.ELEVATOR_SCALE_TARGET);
	}
	public void raiseToSwitch() {
		motors.driveWithTarget(Constants.ELEVATOR_SWITCH_TARGET);
	}
	public void raiseToShortCube() {
		motors.driveWithTarget(Constants.ELEVATOR_SHORT_CUBE_TARGET);
	}
	public void raiseToTallCube() {
		motors.driveWithTarget(Constants.ELEVATOR_TALL_CUBE_TARGET);
	}
	public void stop() {
		motors.stop();
		lastVelocity = 0;
	}
	public void setEncoderPos(int encoderPos) {
    	motors.motor1.setSelectedSensorPosition(encoderPos, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
	}
	public ElevatorDirection getElevatorDirection() {
		ElevatorDirection status = ElevatorDirection.UNKNOWN;
		if(motors.motor1.getMotorOutputVoltage() < 0) {
			status = ElevatorDirection.BACKWARDS;
		} else if(motors.motor1.getMotorOutputVoltage() > 0) {
			status =  ElevatorDirection.FORWARDS;
		}
		return status;
	}
	
	public void encoderReset(ElevatorDirection elevatorDirection) {
		if(elevatorDirection == ElevatorDirection.BACKWARDS) {
			setEncoderPos(0);
		} else if(elevatorDirection == ElevatorDirection.FORWARDS) {
			setEncoderPos(Constants.ELEVATOR_TOP_TARGET);
		}
	}
	
//	public boolean atElevatorLimit() {
//		if ((getElevatorDirection() == ElevatorDirection.BACKWARDS || getElevatorDirection() == ElevatorDirection.FORWARDS) 
//		&& motors.motor1.getOutputCurrent() > Constants.ELEVATOR_HIT_TOLERANCE && isStopping()) {
//			encoderReset(getElevatorDirection());
//			return true;
//		}
//		return false;
//					
//	}
//	public boolean isStopping() { //Bad name, not as accurate (Velocity)
//		//Return if the change in velocity is above the velocity threshold, in which case it is stopping
//		int velocity = motors.motor1.getSelectedSensorVelocity(Constants.kPIDLoopIdx);
//		if(Math.abs(velocity)<(Math.abs(lastVelocity)-Constants.ELEVATOR_VELOCITY_THRESHOLD)) {
//			lastVelocity = velocity;
//			return true;
//		}
//		return false;
//	}
//	public boolean isCurrentHigh() { //Samples Currents
//		return motors.motor1.getOutputCurrent() > Constants.ELEVATOR_CURRENT_THRESHOLD;
//	}
//	public void enableForwardCushion() {
//		motors.motor1.configPeakOutputForward(0, Constants.kTimeoutMs);
//	}
//	public void enableReverseCushion() {
//		motors.motor1.configPeakOutputReverse(0, Constants.kTimeoutMs);
//	}
	public void resetCushions() {
		motors.motor1.configPeakOutputForward(1, Constants.kTimeoutMs);
		motors.motor1.configPeakOutputReverse(-1, Constants.kTimeoutMs);
	}
//	public void checkPosition() {
//		int position = motors.motor1.getSelectedSensorPosition(Constants.kPIDLoopIdx);
//		if (position > Constants.ELEVATOR_TOP_TARGET-Constants.ELEVATOR_TARGET_TOLERANCE) {
//			//At the top, set the limit
//			enableReverseCushion();
//		}
//		else if (position < 0+Constants.ELEVATOR_TARGET_TOLERANCE) {
//			enableForwardCushion();
//		}
//		else {
//			resetCushions();
//		}
//	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

