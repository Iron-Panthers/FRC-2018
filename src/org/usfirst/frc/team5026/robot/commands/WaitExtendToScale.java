package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorExtendPistons;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToScale;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class WaitExtendToScale extends CommandGroup {

    public WaitExtendToScale(double driveTime, double extendTime) {
    	addSequential(new WaitCommand(driveTime));
    	addSequential(new ElevatorExtendPistons());
    	addSequential(new WaitCommand(extendTime));
        addParallel(new ElevatorToScale());
    }
}
