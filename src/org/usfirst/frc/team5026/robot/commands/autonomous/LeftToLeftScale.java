package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.commands.HoldBlock;
import org.usfirst.frc.team5026.robot.commands.OuttakeForTime;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorExtendPistons;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToScale;
import org.usfirst.frc.team5026.robot.util.AutoPaths;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftToLeftScale extends CommandGroup {

    public LeftToLeftScale() {
    	addParallel(new HoldBlock());
    	addSequential(new ElevatorExtendPistons());
        addParallel(new ElevatorToScale());
        addSequential(new PathFollower(AutoPaths.getLeftStartingLeftScalePath()));
        addSequential(new OuttakeForTime(2)); 
    }
}
