package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToSetpoint;
import org.usfirst.frc.team5026.robot.util.Constants;
import org.usfirst.frc.team5026.robot.util.ElevatorDirection;
import org.usfirst.frc.team5026.robot.util.ElevatorMotorGroup;
import org.usfirst.frc.team5026.robot.util.ElevatorPosition;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
	
	public ElevatorPosition position; 
	public int count = 0; 
	/**
	 * Whether the delta setpoint slider or joystick needs to be re-zero'd.
	 * This happens whenever someone other than the slider sets the setpoint.
	 */
	public boolean deltaNeedRezero = false;
	
	public ElevatorMotorGroup motors;
	public DoubleSolenoid solenoid;
	
	private int wantedSetpoint;
	private int lastSetpoint;
	public boolean useSetpoint = true;
	
	public int wantedSetpoint() {
		return wantedSetpoint;
	}
	public void setWantedSetpoint(int target) {
		if (!useSetpoint) {
			return;
		}
		
		int delta = Math.abs(target - wantedSetpoint);
		if (delta > Constants.ELEVATOR_TARGET_TOLERANCE) {
			this.wantedSetpoint = target;
			this.lastSetpoint = target;
			this.atSetpointCount = 0;
			this.atSetpoint = false;
			this.deltaNeedRezero = true;
		}
	}
	public void changeWantedSetpoint(int amount) {
		if (!useSetpoint) {
			return;
		}
		
		if (amount == 0) {
			this.deltaNeedRezero = false;
		}
		
		if (!this.deltaNeedRezero) {
			this.wantedSetpoint += amount;
			
			int delta = Math.abs(this.lastSetpoint - wantedSetpoint);
			if (delta > Constants.ELEVATOR_TARGET_TOLERANCE) {
				this.lastSetpoint = this.wantedSetpoint;
				this.atSetpointCount = 0;
				this.atSetpoint = false;
			}
		}
	}
	
	/**
	 * Only use this if you are sure that you are at the given target
	 */
	public void forceSetpoint(int target) {
		this.wantedSetpoint = target;
		this.atSetpoint = true;
		this.atSetpointCount = 0;
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

	public double getCurrent() {
		return motors.motor1.getOutputCurrent();
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ElevatorToSetpoint());
    }
    
}

