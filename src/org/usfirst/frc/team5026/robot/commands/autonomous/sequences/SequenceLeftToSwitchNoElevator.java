package org.usfirst.frc.team5026.robot.commands.autonomous.sequences;

import org.usfirst.frc.team5026.robot.commands.autonomous.CommandOption;
import org.usfirst.frc.team5026.robot.commands.autonomous.DriveStraight;
import org.usfirst.frc.team5026.robot.commands.autonomous.FindGameDataAndAddCommand;
import org.usfirst.frc.team5026.robot.commands.autonomous.LeftToLeftSwitchNoElevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SequenceLeftToSwitchNoElevator extends CommandGroup {

    public SequenceLeftToSwitchNoElevator() {
        addSequential(new FindGameDataAndAddCommand(new CommandOption(
        		new LeftToLeftSwitchNoElevator(),
        		new LeftToLeftSwitchNoElevator(),
        		new DriveStraight(),
        		new DriveStraight()
        		)));
    }
}
