package org.usfirst.frc.team5026.robot.commands.autonomous.sequences;

import org.usfirst.frc.team5026.robot.commands.autonomous.CenterToLeftSwitch3Cube3;
import org.usfirst.frc.team5026.robot.commands.autonomous.CenterToRightSwitch3Cube3;
import org.usfirst.frc.team5026.robot.commands.autonomous.FindGameDataAndAddCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SequenceCenterToSwitch3Cube3 extends CommandGroup {

    public SequenceCenterToSwitch3Cube3() {
        addSequential(new FindGameDataAndAddCommand(new CenterToLeftSwitch3Cube3(), new CenterToRightSwitch3Cube3()));
    }
}
