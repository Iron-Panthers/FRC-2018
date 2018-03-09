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
public class RightToRightScale extends CommandGroup {

    public RightToRightScale() {
        addParallel(new HoldBlock());
    	addSequential(new ElevatorExtendPistons()); 
        addSequential(new PathFollower(AutoPaths.getRightStartingRightScalePath()));
        addSequential(new ElevatorToScale());
        addSequential(new OuttakeForTime(0.5)); 
    }
}
