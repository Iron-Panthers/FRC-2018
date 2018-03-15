package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.commands.WaitExtendToSwitch;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorTarget;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToSwitch;
import org.usfirst.frc.team5026.robot.commands.intake.IntakeCommand;
import org.usfirst.frc.team5026.robot.commands.intake.IntakeCommandGroup;
import org.usfirst.frc.team5026.robot.commands.intake.OuttakeForTime;
import org.usfirst.frc.team5026.robot.util.AutoPaths;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftToLeftSwitch2Cube extends CommandGroup {

    public LeftToLeftSwitch2Cube() {
    	 addParallel(new WaitExtendToSwitch(0.5, 2));
         addSequential(new PathFollower(AutoPaths.getLeftStartingLeftSwitch2Cube()[0]));
         addSequential(new OuttakeForTime(1));
         addParallel(new ElevatorTarget(0));
         addSequential(new PathFollower(AutoPaths.getLeftStartingLeftSwitch2Cube()[1]));
         addParallel(new IntakeCommand());
         addSequential(new PathFollower(AutoPaths.getLeftStartingLeftSwitch2Cube()[2]));
         addParallel(new IntakeCommandGroup());
         addSequential(new PathFollower(AutoPaths.getLeftStartingLeftSwitch2Cube()[3]));
         addParallel(new ElevatorToSwitch());
         addSequential(new PathFollower(AutoPaths.getLeftStartingLeftSwitch2Cube()[4]));
         addSequential(new OuttakeForTime(1));
    }
}
