package org.usfirst.frc.team5026.robot.commands.autonomous.sequences;

import org.usfirst.frc.team5026.robot.commands.autonomous.AutoScale;
import org.usfirst.frc.team5026.robot.commands.autonomous.CommandOption;
import org.usfirst.frc.team5026.robot.commands.autonomous.FindGameDataAndAddCommand;
import org.usfirst.frc.team5026.robot.commands.autonomous.LeftToLeftScale2Cube;
import org.usfirst.frc.team5026.robot.commands.autonomous.LeftToLeftScaleSwitch;
import org.usfirst.frc.team5026.robot.util.AutoPaths;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SequenceLeftToScale2Cube extends CommandGroup {

    public SequenceLeftToScale2Cube() {
        addSequential(new FindGameDataAndAddCommand(new CommandOption(
        		new LeftToLeftScale2Cube(), 
        		new AutoScale(AutoPaths.getLeftStartingRightScalePath()),
        		new LeftToLeftScale2Cube(),
        		new AutoScale(AutoPaths.getLeftStartingRightScalePath()))));
    }
}
