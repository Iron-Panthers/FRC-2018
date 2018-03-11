package org.usfirst.frc.team5026.robot.commands.autonomous.sequences;

import org.usfirst.frc.team5026.robot.commands.autonomous.CenterToLeftSwitch2Cube;
import org.usfirst.frc.team5026.robot.commands.autonomous.CenterToRightSwitch2Cube;
import org.usfirst.frc.team5026.robot.commands.autonomous.FindGameDataAndAddCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SequenceCenterToSwitch2Cube extends CommandGroup {

    public SequenceCenterToSwitch2Cube() {
        addSequential(new FindGameDataAndAddCommand(new CenterToLeftSwitch2Cube(), new CenterToRightSwitch2Cube()));
    }
}
