package org.usfirst.frc.team5026.robot.commands.elevator;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorToExchange extends Command {
	
    protected void initialize() {
    	Robot.elevator.setWantedSetpoint(Constants.ELEVATOR_EXCHANGE_TARGET);
    }
    
    protected boolean isFinished() {
    	return true;
    }
}
