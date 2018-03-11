package org.usfirst.frc.team5026.robot.commands.autonomous.sequences;

import org.usfirst.frc.team5026.robot.commands.autonomous.AutoScale;
import org.usfirst.frc.team5026.robot.commands.autonomous.CommandOption;
import org.usfirst.frc.team5026.robot.commands.autonomous.FindGameDataAndAddCommand;
import org.usfirst.frc.team5026.robot.util.AutoPaths;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SequenceLeftToScale extends CommandGroup {

    public SequenceLeftToScale() {
        addSequential(new FindGameDataAndAddCommand(new CommandOption(new AutoScale(AutoPaths.getLeftStartingLeftScalePath()), 
        		null, new AutoScale(AutoPaths.getLeftStartingLeftScalePath()), null)));
    }
}
