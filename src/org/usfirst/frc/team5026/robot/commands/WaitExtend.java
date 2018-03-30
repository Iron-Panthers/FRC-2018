package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorExtendPistons;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class WaitExtend extends CommandGroup {

    public WaitExtend(double time) {
    	addSequential(new WaitCommand(time));
    	addSequential(new ElevatorExtendPistons());
    }
}
