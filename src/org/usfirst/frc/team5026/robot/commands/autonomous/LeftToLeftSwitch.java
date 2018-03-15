package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorExtendPistons;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToSwitch;
import org.usfirst.frc.team5026.robot.commands.intake.OuttakeForTime;
import org.usfirst.frc.team5026.robot.util.AutoPaths;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftToLeftSwitch extends CommandGroup {

    public LeftToLeftSwitch() {
    	addSequential(new ElevatorExtendPistons());
    	addParallel(new ElevatorToSwitch());
        addSequential(new PathFollower(AutoPaths.getLeftStartingLeftSwitchPath()));
        addSequential(new OuttakeForTime(1));
    }
}
