package org.usfirst.frc.team5026.robot.commands.elevator;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;
import org.usfirst.frc.team5026.robot.util.ElevatorPosition;

import edu.wpi.first.wpilibj.command.Command;

/**
 * ZAAMP
 */
public class ElevatorToShortCube extends Command {
	
    protected void initialize() {
    	Robot.elevator.setWantedSetpoint(Constants.ELEVATOR_SHORT_CUBE_TARGET);
    }
    
    protected boolean isFinished() {
    	return true;
    }
	
}
