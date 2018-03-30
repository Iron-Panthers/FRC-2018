package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorTarget;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class WaitElevatorToTarget extends CommandGroup {

    public WaitElevatorToTarget(double time, int target) {
        addSequential(new WaitCommand(time));
        addParallel(new ElevatorTarget(target));
    }
}
