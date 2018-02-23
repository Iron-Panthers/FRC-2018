package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.commands.conveyorbelt.ConveyorBeltBackward;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterToSwitchDropCube extends CommandGroup {

    public CenterToSwitchDropCube() {
//        addSequential(new FindGameDataAndAddCommand(new PathFollower(AutoPaths.getLeftPath()), new PathFollower(AutoPaths.getRightPath())));
//        addSequential(new ConveyorBeltBackward());
    	addSequential(new FindGameData());
    	addSequential(new CenterToSwitch());
    	addSequential(new ConveyorBeltBackward());
    }
}
