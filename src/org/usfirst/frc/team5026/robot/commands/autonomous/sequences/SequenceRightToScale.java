package org.usfirst.frc.team5026.robot.commands.autonomous.sequences;

import org.usfirst.frc.team5026.robot.commands.autonomous.CommandOption;
import org.usfirst.frc.team5026.robot.commands.autonomous.FindGameDataAndAddCommand;
import org.usfirst.frc.team5026.robot.commands.autonomous.RightToRightScale;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SequenceRightToScale extends CommandGroup {

    public SequenceRightToScale() {
        addSequential(new FindGameDataAndAddCommand(new CommandOption(new RightToRightScale(), null, new RightToRightScale(), null)));
    }
}
