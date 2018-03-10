package org.usfirst.frc.team5026.robot.commands.autonomous.sequences;

import org.usfirst.frc.team5026.robot.commands.autonomous.CommandOption;
import org.usfirst.frc.team5026.robot.commands.autonomous.FindGameDataAndAddCommand;
import org.usfirst.frc.team5026.robot.commands.autonomous.LeftToLeftScaleSwitchSide;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SequenceLeftToScaleSwitchSide extends CommandGroup {

    public SequenceLeftToScaleSwitchSide() {
        addSequential(new FindGameDataAndAddCommand(new CommandOption(new LeftToLeftScaleSwitchSide(), null, new LeftToLeftScaleSwitchSide(), null)));
    }
}
