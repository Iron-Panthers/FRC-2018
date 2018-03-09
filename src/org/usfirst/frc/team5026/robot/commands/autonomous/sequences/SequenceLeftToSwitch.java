package org.usfirst.frc.team5026.robot.commands.autonomous.sequences;

import org.usfirst.frc.team5026.robot.commands.autonomous.CommandOption;
import org.usfirst.frc.team5026.robot.commands.autonomous.FindGameDataAndAddCommand;
import org.usfirst.frc.team5026.robot.commands.autonomous.LeftToLeftSwitch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SequenceLeftToSwitch extends CommandGroup {

    public SequenceLeftToSwitch() {
        addSequential(new FindGameDataAndAddCommand(new CommandOption(new LeftToLeftSwitch(), new LeftToLeftSwitch(), null, null)));
    }
}
