package org.usfirst.frc.team5026.robot.commands.autonomous.sequences;

import org.usfirst.frc.team5026.robot.commands.autonomous.CenterToLeftSwitch2CubeAvoid;
import org.usfirst.frc.team5026.robot.commands.autonomous.CenterToRightSwitch2Cube;
import org.usfirst.frc.team5026.robot.commands.autonomous.CommandOption;
import org.usfirst.frc.team5026.robot.commands.autonomous.FindGameDataAndAddCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SequenceCenterToSwitch2CubeAvoid extends CommandGroup {

    public SequenceCenterToSwitch2CubeAvoid() {
        addSequential(new FindGameDataAndAddCommand(new CommandOption(
        		new CenterToLeftSwitch2CubeAvoid(),
        		new CenterToLeftSwitch2CubeAvoid(),
        		new CenterToRightSwitch2Cube(),
        		new CenterToRightSwitch2Cube())));
    }
}
