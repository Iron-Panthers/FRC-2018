package org.usfirst.frc.team5026.robot.commands.autonomous.sequences;

import org.usfirst.frc.team5026.robot.commands.autonomous.AutoScale;
import org.usfirst.frc.team5026.robot.commands.autonomous.CommandOption;
import org.usfirst.frc.team5026.robot.commands.autonomous.FindGameDataAndAddCommand;
import org.usfirst.frc.team5026.robot.commands.autonomous.LeftToLeftSwitch2Cube;
import org.usfirst.frc.team5026.robot.util.AutoPaths;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SequenceLeftToSwitch2Cube extends CommandGroup {

    public SequenceLeftToSwitch2Cube() {
        addSequential(new FindGameDataAndAddCommand(new CommandOption(
        		new LeftToLeftSwitch2Cube(),
        		new LeftToLeftSwitch2Cube(),
        		new AutoScale(AutoPaths.getLeftStartingLeftScalePath()),
        		new AutoScale(AutoPaths.getLeftStartingRightScalePath())
        )));
    }
}
