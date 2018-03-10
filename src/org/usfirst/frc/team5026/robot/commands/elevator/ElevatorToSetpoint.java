package org.usfirst.frc.team5026.robot.commands.elevator;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorToSetpoint extends Command {
	
	private boolean encoderMode = true;
	private int stallCount = 0;
	private int previousTicks;
	
    public ElevatorToSetpoint() {
    	requires(Robot.elevator);
    }

    protected void initialize() {
    	encoderMode = true;
		previousTicks = Robot.elevator.motors.getEncoderTicks();
		Robot.elevator.setWantedSetpoint(previousTicks);
    }

    protected void execute() {
    	if (!encoderMode) {
    		
    	}
    	
    	if (Robot.elevator.atSetpoint) {
    		return;
    	}
    	
		Robot.elevator.motors.driveWithTarget(Robot.elevator.wantedSetpoint());
		
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
		if (delta < Constants.ELEVATOR_TARGET_TOLERANCE) {
			stallCount++;
			
			if (stallCount > Constants.ELEVATOR_TOLERANCE_TIME) {
				encoderMode = false;
				Robot.elevator.motors.driveWithPower(0);
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
