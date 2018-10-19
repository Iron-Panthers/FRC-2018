package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.commands.conveyorbelt.ConveyorForTime;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorExtendPistons;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorTarget;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToSwitch;
import org.usfirst.frc.team5026.robot.commands.intake.IntakeCommandNoRequires;
import org.usfirst.frc.team5026.robot.commands.intake.IntakeSafeCommandGroup;
import org.usfirst.frc.team5026.robot.commands.intake.OuttakeForTime;
import org.usfirst.frc.team5026.robot.util.AutoPaths;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterToRightSwitch2CubeStartAtSwitch extends CommandGroup {

    public CenterToRightSwitch2CubeStartAtSwitch() {
//        addParallel(new ElevatorExtendPistons());
//        addSequential(new PathFollower(AutoPaths.getRightSwitch2Cube()[0]));
//        addSequential(new ConveyorForTime(false, 1));
        addParallel(new ElevatorTarget(0));
        addSequential(new PathFollower(AutoPaths.getRightSwitch2Cube()[1]));
        addParallel(new IntakeSafeCommandGroup());
        addSequential(new PathFollower(AutoPaths.getRightSwitch2Cube()[2]));
//        addParallel(new IntakeSafeCommandGroup());
        addSequential(new PathFollower(AutoPaths.getRightSwitch2Cube()[3]));
        addParallel(new ElevatorToSwitch());
        addSequential(new PathFollower(AutoPaths.getRightSwitch2Cube()[4]));
        addSequential(new OuttakeForTime(2));
    }
}
