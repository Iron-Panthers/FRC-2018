package org.usfirst.frc.team5026.robot.commands.autonomous.sequences;

import org.usfirst.frc.team5026.robot.commands.autonomous.CommandOption;
import org.usfirst.frc.team5026.robot.commands.autonomous.DriveStraight;
import org.usfirst.frc.team5026.robot.commands.autonomous.FindGameDataAndAddCommand;
import org.usfirst.frc.team5026.robot.commands.autonomous.RightToRightSwitchNoElevator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SequenceRightToSwitchNoElevator extends CommandGroup {

    public SequenceRightToSwitchNoElevator() {
        addSequential(new FindGameDataAndAddCommand(new CommandOption(
        		new DriveStraight(),
        		new DriveStraight(),
        		new RightToRightSwitchNoElevator(),
        		new RightToRightSwitchNoElevator()
        		)));
    }
}
