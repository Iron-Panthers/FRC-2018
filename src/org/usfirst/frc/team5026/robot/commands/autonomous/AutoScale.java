package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorExtendPistons;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToScale;
import org.usfirst.frc.team5026.robot.commands.intake.HoldBlock;
import org.usfirst.frc.team5026.robot.commands.intake.OuttakeForTime;
import org.usfirst.frc.team5026.robot.util.AutoPaths;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import scadlib.paths.FastPathPlanner;

/**
 *
 */
public class AutoScale extends CommandGroup {

    public AutoScale(FastPathPlanner path) {
    	addParallel(new HoldBlock());
    	addSequential(new ElevatorExtendPistons());
    	addSequential(new WaitCommand(2));
        addParallel(new ElevatorToScale());
        addSequential(new PathFollower(path));
        addSequential(new OuttakeForTime(2)); 
    }
}
