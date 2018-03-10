package org.usfirst.frc.team5026.robot.commands.autonomous.sequences;

import org.usfirst.frc.team5026.robot.commands.autonomous.CommandOption;
import org.usfirst.frc.team5026.robot.commands.autonomous.FindGameDataAndAddCommand;
import org.usfirst.frc.team5026.robot.commands.autonomous.RightToRightSwitch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SequenceRightToSwitch extends CommandGroup {

    public SequenceRightToSwitch() {
        addSequential(new FindGameDataAndAddCommand(new CommandOption(null, null, new RightToRightSwitch(), new RightToRightSwitch())));
    }
}
