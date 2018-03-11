package org.usfirst.frc.team5026.robot.commands.elevator;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorToTallCube extends Command {

    protected void initialize() {
    	Robot.elevator.setWantedSetpoint(Constants.ELEVATOR_TALL_CUBE_TARGET);
    }
    
    protected boolean isFinished() {
    	return Robot.elevator.atSetpoint;
    }
	
}
