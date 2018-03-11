package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.commands.conveyorbelt.ConveyorForTime;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorExtendPistons;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorTarget;
import org.usfirst.frc.team5026.robot.commands.intake.IntakeCommand;
import org.usfirst.frc.team5026.robot.commands.intake.IntakeCommandGroup;
import org.usfirst.frc.team5026.robot.commands.intake.IntakeOuttakeCommand;
import org.usfirst.frc.team5026.robot.util.AutoPaths;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterToRightSwitch2Cube extends CommandGroup {

    public CenterToRightSwitch2Cube() {
        addSequential(new PathFollower(AutoPaths.getRightSwitch2Cube()[0]));
        addSequential(new ConveyorForTime(false, 0.5));
        addParallel(new ElevatorExtendPistons());
        addSequential(new PathFollower(AutoPaths.getRightSwitch2Cube()[1]));
        addParallel(new ElevatorTarget(0));
        addParallel(new IntakeCommand());
        addSequential(new PathFollower(AutoPaths.getRightSwitch2Cube()[2]));
        addParallel(new IntakeCommandGroup());
        addSequential(new PathFollower(AutoPaths.getRightSwitch2Cube()[3]));
        addSequential(new PathFollower(AutoPaths.getRightSwitch2Cube()[4]));
        addSequential(new IntakeOuttakeCommand());
        // This command doesn't end, but who cares?
    }
}
