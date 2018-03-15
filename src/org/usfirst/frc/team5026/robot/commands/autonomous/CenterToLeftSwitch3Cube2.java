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
import scadlib.paths.FastPathPlanner;

/**
 *
 */
public class CenterToLeftSwitch3Cube2 extends CommandGroup {

    public CenterToLeftSwitch3Cube2() {
    	addParallel(new ElevatorExtendPistons());
        addSequential(new PathFollower(AutoPaths.getLeftSwitch3Cube2()[0]));
        addSequential(new ConveyorForTime(false, 1));
        addParallel(new ElevatorTarget(0));
        addSequential(new PathFollower(AutoPaths.getLeftSwitch3Cube2()[1]));
        addParallel(new IntakeCommandNoRequires());
        addSequential(new PathFollower(AutoPaths.getLeftSwitch3Cube2()[2]));
        addParallel(new IntakeSafeCommandGroup());
        addSequential(new PathFollower(AutoPaths.getLeftSwitch3Cube2()[3]));
        addParallel(new ElevatorToSwitch());
        addSequential(new PathFollower(AutoPaths.getLeftSwitch3Cube2()[4]));
        addSequential(new OuttakeForTime(0.5));
        addParallel(new ElevatorTarget(0));
        addSequential(new PathFollower(AutoPaths.getLeftSwitch3Cube2()[5]));
        addParallel(new IntakeCommandNoRequires());
        addSequential(new PathFollower(AutoPaths.getLeftSwitch3Cube2()[6]));
        addParallel(new IntakeSafeCommandGroup());
        addSequential(new PathFollower(AutoPaths.getLeftSwitch3Cube2()[7]));
        addParallel(new ElevatorToSwitch());
        addSequential(new PathFollower(AutoPaths.getLeftSwitch3Cube2()[8]));
        addParallel(new OuttakeForTime(0.5));
    }
}
