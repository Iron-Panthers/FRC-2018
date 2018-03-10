package org.usfirst.frc.team5026.robot.commands.autonomous.sequences;

import org.usfirst.frc.team5026.robot.commands.autonomous.CommandOption;
import org.usfirst.frc.team5026.robot.commands.autonomous.FindGameDataAndAddCommand;
import org.usfirst.frc.team5026.robot.commands.autonomous.RightToRightScaleSwitchSide;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SequenceRightToScaleSwitchSide extends CommandGroup {

    public SequenceRightToScaleSwitchSide() {
        addSequential(new FindGameDataAndAddCommand(new CommandOption(null, new RightToRightScaleSwitchSide(), null, new RightToRightScaleSwitchSide())));
    }
}
