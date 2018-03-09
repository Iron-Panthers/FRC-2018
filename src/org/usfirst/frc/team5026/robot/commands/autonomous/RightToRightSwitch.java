package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.commands.conveyorbelt.ConveyorForTime;
import org.usfirst.frc.team5026.robot.util.AutoPaths;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightToRightSwitch extends CommandGroup {

    public RightToRightSwitch() {
    	addSequential(new PathFollower(AutoPaths.getRightStartingRightSwitchPath()));
        addSequential(new ConveyorForTime(false, 4));
    }
}
