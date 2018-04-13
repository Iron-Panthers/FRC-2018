package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.commands.WaitElevatorToTarget;
import org.usfirst.frc.team5026.robot.commands.WaitExtendToScale;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToScale;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToSwitch;
import org.usfirst.frc.team5026.robot.commands.intake.HoldBlock;
import org.usfirst.frc.team5026.robot.commands.intake.IntakeCommandNoRequires;
import org.usfirst.frc.team5026.robot.commands.intake.IntakeSafeCommandGroup;
import org.usfirst.frc.team5026.robot.commands.intake.OuttakeForTime;
import org.usfirst.frc.team5026.robot.util.AutoPaths;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftToLeftScaleSwitch extends CommandGroup {

    public LeftToLeftScaleSwitch() {
    	addParallel(new HoldBlock());
    	addParallel(new WaitExtendToScale(0.5,3));
        addSequential(new PathFollower(AutoPaths.getLeftStartingLeftScaleSwitchPath()[0]));
        addParallel(new ElevatorToScale());
        addParallel(new OuttakeForTime(1));
        addParallel(new WaitElevatorToTarget(0.25,0));
        addSequential(new PathFollower(AutoPaths.getLeftStartingLeftScaleSwitchPath()[1]));
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
