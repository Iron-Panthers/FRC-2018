package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.commands.conveyorbelt.ConveyorForTime;
import org.usfirst.frc.team5026.robot.util.AutoPaths;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightToRightSwitchNoElevator extends CommandGroup {

    public RightToRightSwitchNoElevator() {
        addSequential(new PathFollower(AutoPaths.getLeftStartingLeftSwitchPath()));
        addSequential(new ConveyorForTime(false, 4));
    }
}
