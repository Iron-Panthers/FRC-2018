package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorTarget;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToScale;
import org.usfirst.frc.team5026.robot.commands.intake.IntakeCommandNoRequires;
import org.usfirst.frc.team5026.robot.commands.intake.OuttakeForTime;
import org.usfirst.frc.team5026.robot.util.AutoPaths;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftToLeftScale2Cube extends CommandGroup {

    public LeftToLeftScale2Cube() {
        addSequential(new AutoScale(AutoPaths.getLeftStartingLeftScale2Cube()[0]));
        addSequential(new PathFollower(AutoPaths.getLeftStartingLeftScale2Cube()[1]));
        addParallel(new ElevatorTarget(0));
        addParallel(new IntakeCommandNoRequires());
        addSequential(new PathFollower(AutoPaths.getLeftStartingLeftScale2Cube()[2]));
        addParallel(new ElevatorToScale());
        addSequential(new PathFollower(AutoPaths.getLeftStartingLeftScale2Cube()[3]));
        addSequential(new PathFollower(AutoPaths.getLeftStartingLeftScale2Cube()[4]));
        addSequential(new OuttakeForTime(1));
    }
}
