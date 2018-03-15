package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorExtendPistons;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToSwitch;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class WaitExtendToSwitch extends CommandGroup {

    public WaitExtendToSwitch(double driveTime, double extendTime) {
    	addSequential(new WaitCommand(driveTime));
    	addSequential(new ElevatorExtendPistons());
    	addSequential(new WaitCommand(extendTime));
        addParallel(new ElevatorToSwitch());
    }
}
