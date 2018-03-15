package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.commands.conveyorbelt.ConveyorForTime;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorExtendPistons;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorTarget;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToSwitch;
import org.usfirst.frc.team5026.robot.commands.intake.IntakeCommand;
import org.usfirst.frc.team5026.robot.commands.intake.IntakeCommandGroup;
import org.usfirst.frc.team5026.robot.commands.intake.IntakeCommandNoRequires;
import org.usfirst.frc.team5026.robot.commands.intake.IntakeOuttakeCommand;
import org.usfirst.frc.team5026.robot.commands.intake.IntakeSafeCommandGroup;
import org.usfirst.frc.team5026.robot.commands.intake.OuttakeForTime;
import org.usfirst.frc.team5026.robot.util.AutoPaths;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterToLeftSwitch3Cube extends CommandGroup {

    public CenterToLeftSwitch3Cube() {
    	addParallel(new ElevatorExtendPistons());
        addSequential(new PathFollower(AutoPaths.getLeftSwitch3Cube()[0]));
        addSequential(new ConveyorForTime(false, 1));
        addParallel(new ElevatorTarget(0));
        addSequential(new PathFollower(AutoPaths.getLeftSwitch3Cube()[1]));
        addParallel(new IntakeCommandNoRequires());
        addSequential(new PathFollower(AutoPaths.getLeftSwitch3Cube()[2]));
        addParallel(new IntakeSafeCommandGroup());
        addSequential(new PathFollower(AutoPaths.getLeftSwitch3Cube()[3]));
        addParallel(new ElevatorToSwitch());
        addSequential(new PathFollower(AutoPaths.getLeftSwitch3Cube()[4]));
        addSequential(new OuttakeForTime(0.5));
        addParallel(new ElevatorTarget(0));
        addSequential(new PathFollower(AutoPaths.getLeftSwitch3Cube()[5]));
        addParallel(new IntakeCommandNoRequires());
        addSequential(new PathFollower(AutoPaths.getLeftSwitch3Cube()[6]));
        addParallel(new IntakeSafeCommandGroup());
        addSequential(new PathFollower(AutoPaths.getLeftSwitch3Cube()[7]));
        addParallel(new ElevatorToSwitch());
        addSequential(new PathFollower(AutoPaths.getLeftSwitch3Cube()[8]));
        addSequential(new OuttakeForTime(0.5));
    }
}
