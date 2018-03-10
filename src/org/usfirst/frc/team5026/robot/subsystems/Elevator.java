package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.RobotMap;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToSetpoint;
import org.usfirst.frc.team5026.robot.util.Constants;
import org.usfirst.frc.team5026.robot.util.ElevatorDirection;
import org.usfirst.frc.team5026.robot.util.ElevatorMotorGroup;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevator extends Subsystem {
	public ElevatorMotorGroup motors;
	public DoubleSolenoid solenoid;
	public double lastVelocity;
	
	private int wantedSetpoint;
	public int wantedSetpoint() {
		return wantedSetpoint;
	}
	public void setWantedSetpoint(int target) {
		int delta = Math.abs(target - wantedSetpoint);
		if (delta > Constants.ELEVATOR_TARGET_TOLERANCE) {
			this.wantedSetpoint = target;
			this.atSetpointCount = 0;
			this.atSetpoint = false;
		}
	}
	
	public int atSetpointCount = 0;
	public boolean atSetpoint = false;
	
	public Elevator() {
		motors = Robot.hardware.elevatorMotors;
		solenoid = Robot.hardware.elevatorSolenoid;
		position = ElevatorPosition.DOWN;
	}
	
	public void extendPistons() {
		solenoid.set(DoubleSolenoid.Value.kForward);
		position = ElevatorPosition.UP;
	}
	public void retractPistons() {
		solenoid.set(DoubleSolenoid.Value.kReverse);
		position = ElevatorPosition.DOWN;
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
	
	public boolean atElevatorLimit() {
		if ((getElevatorDirection() == ElevatorDirection.BACKWARDS || getElevatorDirection() == ElevatorDirection.FORWARDS) && motors.motor1.getOutputCurrent() > Constants.ELEVATOR_HIT_TOLERANCE && isStopping()) {
			encoderReset(getElevatorDirection());
			return true;
		}
		return false;
	}
	
	public boolean isStopping() { //Bad name, not as accurate (Velocity)
		//Return if the change in velocity is above the velocity threshold, in which case it is stopping
		int velocity = motors.motor1.getSelectedSensorVelocity(Constants.kPIDLoopIdx);
		if(Math.abs(velocity)<(Math.abs(lastVelocity)-Constants.ELEVATOR_VELOCITY_THRESHOLD)) {
			lastVelocity = velocity;
			return true;
		}
		return false;
	}
	
	public void resetCushions() {
		motors.motor1.configPeakOutputForward(1, Constants.kTimeoutMs);
		motors.motor1.configPeakOutputReverse(-1, Constants.kTimeoutMs);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ElevatorToSetpoint());
    }
    public void zero() {
    	if(Robot.elevator.position == ElevatorPosition.UP) {
    		Robot.elevator.motors.driveWithPower(-Robot.oi.elevatorStick.getY());
    	}
    	if(Robot.hardware.pdp.getCurrent(RobotMap.ELEVATOR_MOTOR_PDP_PORT) > Constants.ELEVATOR_HIT_BOTTOM_CURRENT && Math.abs(Robot.hardware.elevatorMotor.getSelectedSensorPosition(Constants.kPIDLoopIdx)) < Constants.ELEVATOR_ZEROING_TOLERANCE) {
    		count++;
    	}
    	else {
    		count--;
    	}
    	if(count >= SmartDashboard.getNumber("Elevator zeroing samples", 3)) {
    		Robot.elevator.motors.motor1.setSelectedSensorPosition((int)SmartDashboard.getNumber("Elevator Reset Value", 0), Constants.kPIDLoopIdx, Constants.kTimeoutMs);
    	}
    }
}

