package org.usfirst.frc.team5026.robot.commands.autonomous.sequences;

import org.usfirst.frc.team5026.robot.commands.autonomous.CenterToLeftSwitch2CubeStartAtSwitch;
import org.usfirst.frc.team5026.robot.commands.autonomous.CenterToRightSwitch2CubeStartAtSwitch;
import org.usfirst.frc.team5026.robot.commands.autonomous.CommandOption;
import org.usfirst.frc.team5026.robot.commands.autonomous.FindGameDataAndAddCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SequenceCenterToSwitch2CubeFromSwitch extends CommandGroup {

    public SequenceCenterToSwitch2CubeFromSwitch() {
        addSequential(new FindGameDataAndAddCommand(new CommandOption(
        		new CenterToLeftSwitch2CubeStartAtSwitch(),
        		new CenterToLeftSwitch2CubeStartAtSwitch(),
        		new CenterToRightSwitch2CubeStartAtSwitch(),
        		new CenterToRightSwitch2CubeStartAtSwitch())));
    }
}
