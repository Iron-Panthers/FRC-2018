package org.usfirst.frc.team5026.robot.commands.autonomous.sequences;

import org.usfirst.frc.team5026.robot.commands.autonomous.CenterToLeftSwitch3Cube;
import org.usfirst.frc.team5026.robot.commands.autonomous.CenterToRightSwitch3Cube;
import org.usfirst.frc.team5026.robot.commands.autonomous.FindGameDataAndAddCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SequenceCenterToSwitch3Cube extends CommandGroup {

    public SequenceCenterToSwitch3Cube() {
        addSequential(new FindGameDataAndAddCommand(new CenterToLeftSwitch3Cube(), new CenterToRightSwitch3Cube()));
    }
}
