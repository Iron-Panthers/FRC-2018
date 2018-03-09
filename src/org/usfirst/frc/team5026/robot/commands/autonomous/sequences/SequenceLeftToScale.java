package org.usfirst.frc.team5026.robot.commands.autonomous.sequences;

import org.usfirst.frc.team5026.robot.commands.autonomous.CommandOption;
import org.usfirst.frc.team5026.robot.commands.autonomous.FindGameDataAndAddCommand;
import org.usfirst.frc.team5026.robot.commands.autonomous.LeftToLeftScale;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SequenceLeftToScale extends CommandGroup {

    public SequenceLeftToScale() {
        addSequential(new FindGameDataAndAddCommand(new CommandOption(new LeftToLeftScale(), null, new LeftToLeftScale(), null)));
    }
}
