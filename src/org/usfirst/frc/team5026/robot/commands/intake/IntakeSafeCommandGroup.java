package org.usfirst.frc.team5026.robot.commands.intake;

import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToSwitch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class IntakeSafeCommandGroup extends CommandGroup {

    public IntakeSafeCommandGroup() {
        addSequential(new IntakeCommandNoRequires());
        addParallel(new ElevatorToSwitch());
        addParallel(new HoldBlock());
    }
}
