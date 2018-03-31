package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.commands.WaitExtendToScale;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToScale;
import org.usfirst.frc.team5026.robot.commands.intake.HoldBlock;
import org.usfirst.frc.team5026.robot.commands.intake.OuttakeForTime;
import org.usfirst.frc.team5026.robot.util.AutoPaths;

import edu.wpi.first.wpilibj.command.CommandGroup;
import scadlib.paths.FastPathPlanner;

/**
 *
 */
public class AutoScale extends CommandGroup {

    public AutoScale(FastPathPlanner path) {
//    	addParallel(new HoldBlockNoRequire());
    	addParallel(new HoldBlock());
    	addParallel(new WaitExtendToScale(0.5,4.5));
        addSequential(new PathFollower(path));
        addParallel(new ElevatorToScale());
        addParallel(new OuttakeForTime(2));
        addSequential(new PathFollower(AutoPaths.getReverseOffScale())); // Reverse off of the scale
//        addSequential(new CancelCommand(this));
    }
}
