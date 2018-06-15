package org.usfirst.frc.team5026.robot.commands.autonomous.sequences;

import org.usfirst.frc.team5026.robot.commands.autonomous.CenterToSwitch1CubeFaster;
import org.usfirst.frc.team5026.robot.commands.autonomous.FindGameData;
import org.usfirst.frc.team5026.robot.commands.conveyorbelt.ConveyorBeltBackward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SequenceCenterToSwitch1CubeFast extends CommandGroup {

    public SequenceCenterToSwitch1CubeFast() {
//        addSequential(new FindGameDataAndAddCommand(new PathFollower(AutoPaths.getLeftPath()), new PathFollower(AutoPaths.getRightPath())));
//        addSequential(new ConveyorBeltBackward());
    	addSequential(new FindGameData());
    	addSequential(new CenterToSwitch1CubeFaster());
    	addSequential(new ConveyorBeltBackward());
    }
}
