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
	private FixedBuffer runningAverage = new FixedBuffer(8);
	private int acceleratingCount = 0;
	private int lastSetpoint = 0;
	
    public ElevatorToSetpoint() {
    	requires(Robot.elevator);
    }

    protected void initialize() {
    	encoderMode = true;
		previousTicks = Robot.elevator.motors.getEncoderTicks();
		Robot.elevator.setWantedSetpoint(previousTicks);
    }

    protected void execute() {
    	double power = Robot.oi.elevatorStick.findY();
    	
    	acceleratingCount++;
    	if (Math.abs(lastSetpoint - Robot.elevator.wantedSetpoint()) > Constants.ELEVATOR_SLIDER_SENSITIVITY+300) {
    		acceleratingCount = 0;
    		System.out.println("(-: We reset :-)");
    	} 
    	lastSetpoint = Robot.elevator.wantedSetpoint();
    	
    	runningAverage.addValue(Robot.elevator.getCurrent());
    	double average = runningAverage.sum/runningAverage.length;
		double voltage = Robot.elevator.motors.motor1.getMotorOutputVoltage();
    	if (average > Math.abs(Constants.ELEVATOR_CURRENT_THRESHOLD) && acceleratingCount > Constants.ELEVATOR_ACCELERATING_COUNT) {
    		Robot.elevator.motors.stop();
    		
    		if (voltage < 0) {
    			Robot.elevator.setEncoderPos(0);
    			Robot.elevator.forceSetpoint(0);
    			System.out.println("Reset to bottom! :)");
    		} else {
    			Robot.elevator.setEncoderPos(Constants.ELEVATOR_TOP_TARGET);
    			Robot.elevator.forceSetpoint(Constants.ELEVATOR_TOP_TARGET);
    			System.out.println("Reset to top! :D");
    		}
    		
    		if (encoderMode) {
    			Robot.elevator.motors.driveWithTarget(Robot.elevator.wantedSetpoint());
    		}    		
    	}
    	
    	if (!encoderMode) {
    		if (!DriverStation.getInstance().isAutonomous()) {    			
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
    	
    	if (Robot.elevator.motors.getEncoderTicks() < Constants.ELEVATOR_TOP_TARGET - 100 && Robot.elevator.motors.getEncoderTicks() > 100) {
        	Robot.elevator.changeWantedSetpoint((int)(power * Constants.ELEVATOR_SLIDER_SENSITIVITY));
    	} else if ((Robot.elevator.motors.getEncoderTicks() > Constants.ELEVATOR_TOP_TARGET - 100 && power < 0) || (Robot.elevator.motors.getEncoderTicks() < 100 && power > 0)) {
        	Robot.elevator.changeWantedSetpoint((int)(power * Constants.ELEVATOR_SLIDER_SENSITIVITY));
    	}
    	
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
		
		/*delta = Math.abs(Robot.elevator.motors.getEncoderTicks() - previousTicks);
		if (delta < 20) {
			stallCount++;
			
			if (stallCount > Constants.ELEVATOR_TOLERANCE_TIME) {
				encoderMode = false;
				Robot.elevator.useSetpoint = false;
				System.out.println("MOVING TO ELEVATOR NON-ENCODER MDOE!! USE SLIDER!!");
				Robot.elevator.motors.stop();
			}
		}*/
		
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
