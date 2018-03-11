package org.usfirst.frc.team5026.robot.commands.elevator;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;
import org.usfirst.frc.team5026.robot.util.FixedBuffer;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

public class ElevatorToSetpoint extends Command {
	
	private boolean encoderMode = true;
	private int stallCount = 0;
	private int previousTicks;
	private FixedBuffer runningAverage = new FixedBuffer(5);
	
    public ElevatorToSetpoint() {
    	requires(Robot.elevator);
    }

    protected void initialize() {
    	encoderMode = true;
		previousTicks = Robot.elevator.motors.getEncoderTicks();
		Robot.elevator.setWantedSetpoint(previousTicks);
    }

    protected void execute() {
    	runningAverage.addValue(Robot.elevator.getCurrent());
    	double average = runningAverage.sum/5;
    	if (average > Math.abs(Constants.ELEVATOR_CURRENT_THRESHOLD)) {
    		Robot.elevator.motors.stop();
    		
    		if (average < 0) {
    			Robot.elevator.setEncoderPos(0);
    			Robot.elevator.forceSetpoint(0);
    		} else {
    			Robot.elevator.setEncoderPos(Constants.ELEVATOR_TOP_TARGET);
    			Robot.elevator.forceSetpoint(Constants.ELEVATOR_TOP_TARGET);
    		}
    		
    		if (encoderMode) {
    			Robot.elevator.motors.driveWithTarget(Robot.elevator.wantedSetpoint());
    		}
    	}
    	
    	if (!encoderMode) {
    		if (!DriverStation.getInstance().isAutonomous()) {
    			double power = Robot.oi.elevatorStick.getX();
    			
    			if (Robot.elevator.wantedSetpoint() <= 0) {
    				power = Math.max(0, power);
    			}
    			else if (Robot.elevator.wantedSetpoint() >= Constants.ELEVATOR_TOP_TARGET) {
    				power = Math.min(0, power);
    			}
    			
    			Robot.elevator.motors.driveWithPower(power);
    		}
    		
    		return;
    	}
    	
    	Robot.elevator.changeWantedSetpoint((int)(Robot.oi.elevatorStick.getX() * Constants.ELEVATOR_SLIDER_SENSITIVITY));
		Robot.elevator.motors.driveWithTarget(Robot.elevator.wantedSetpoint());
    	
    	if (Robot.elevator.atSetpoint) {
    		return;
    	}
		
		int delta = Math.abs(Robot.elevator.motors.getEncoderTicks() - Robot.elevator.wantedSetpoint());
		if (delta < Constants.ELEVATOR_TARGET_TOLERANCE) {
			Robot.elevator.atSetpointCount++;
			
			if (Robot.elevator.atSetpointCount > Constants.ELEVATOR_TOLERANCE_TIME) {
				Robot.elevator.atSetpoint = true;
				Robot.elevator.atSetpointCount = 0;
				stallCount = 0;
			}
			
			return;
		}
		
		delta = Math.abs(Robot.elevator.motors.getEncoderTicks() - previousTicks);
		if (delta < 20) {
			stallCount++;
			
			if (stallCount > Constants.ELEVATOR_TOLERANCE_TIME) {
				encoderMode = false;
				Robot.elevator.useSetpoint = false;
				System.out.println("MOVING TO ELEVATOR NON-ENCODER MDOE!! USE SLIDER!!");
				Robot.elevator.motors.stop();
			}
		}
		
		previousTicks = Robot.elevator.motors.getEncoderTicks();
    }

    @Override
    protected boolean isFinished() {
    	return false;
    }

    protected void interrupted() {
    	System.out.println("You probably shouldn't have interupted this. Please don't. Have a nice day!");
    }

}
