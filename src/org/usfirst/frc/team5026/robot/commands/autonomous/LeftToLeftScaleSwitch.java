package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorExtendPistons;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorTarget;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToScale;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToSwitch;
import org.usfirst.frc.team5026.robot.commands.intake.HoldBlockNoRequire;
import org.usfirst.frc.team5026.robot.commands.intake.IntakeCommandNoRequires;
import org.usfirst.frc.team5026.robot.commands.intake.IntakeSafeCommandGroup;
import org.usfirst.frc.team5026.robot.commands.intake.OuttakeForTime;
import org.usfirst.frc.team5026.robot.util.AutoPaths;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class LeftToLeftScaleSwitch extends CommandGroup {

    public LeftToLeftScaleSwitch() {
    	addParallel(new HoldBlockNoRequire());
    	addSequential(new ElevatorExtendPistons());
    	addSequential(new WaitCommand(2));
        addParallel(new ElevatorToScale());
        addSequential(new PathFollower(AutoPaths.getLeftStartingLeftScaleSwitchPath()[0]));
        addParallel(new ElevatorToScale());
        addParallel(new OuttakeForTime(1));
        addParallel(new PathFollower(AutoPaths.getLeftStartingLeftScaleSwitchPath()[1]));
        addParallel(new ElevatorTarget(0));
        addParallel(new IntakeCommandNoRequires());
        addSequential(new PathFollower(AutoPaths.getLeftStartingLeftScaleSwitchPath()[2]));
        addParallel(new IntakeSafeCommandGroup());
        addSequential(new PathFollower(AutoPaths.getLeftStartingLeftScaleSwitchPath()[3]));
        addParallel(new ElevatorToSwitch());
        addSequential(new PathFollower(AutoPaths.getLeftStartingLeftScaleSwitchPath()[4]));
        addParallel(new OuttakeForTime(0.5));
        addSequential(new PathFollower(AutoPaths.getReverseOffScale()));
    }
}
