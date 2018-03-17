package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.commands.conveyorbelt.ConveyorForTime;
import org.usfirst.frc.team5026.robot.commands.drive.DriveRunRight;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorExtendPistons;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorTarget;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToSwitch;
import org.usfirst.frc.team5026.robot.commands.intake.IntakeSafeCommandGroup;
import org.usfirst.frc.team5026.robot.commands.intake.OuttakeForTime;
import org.usfirst.frc.team5026.robot.util.AutoPaths;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterToLeftSwitch3Cube3 extends CommandGroup {

	// Involes turning for time to drive towards power cube zone
	
    public CenterToLeftSwitch3Cube3() {
    	double turnPower = 0.7;
    	double turnTime = 0.5;
    	
    	addParallel(new ElevatorExtendPistons());
        addSequential(new PathFollower(AutoPaths.getLeftSwitch3Cube4()[0]));
        addSequential(new ConveyorForTime(false, 1.5));
        addParallel(new ElevatorTarget(0));
        addSequential(new DriveRunRight(-turnPower, turnTime));
        addParallel(new IntakeSafeCommandGroup());
        addSequential(new PathFollower(AutoPaths.getLeftSwitch3Cube4()[1]));
        addParallel(new ElevatorToSwitch());
        addSequential(new PathFollower(AutoPaths.getLeftSwitch3Cube4()[2]));
        addSequential(new DriveRunRight(turnPower, turnTime));
        addSequential(new OuttakeForTime(0.25));
        addParallel(new ElevatorTarget(0));
        addSequential(new DriveRunRight(-turnPower, turnTime));
        addParallel(new IntakeSafeCommandGroup());
        addSequential(new PathFollower(AutoPaths.getLeftSwitch3Cube4()[3]));
        addParallel(new ElevatorToSwitch());
        addSequential(new PathFollower(AutoPaths.getLeftSwitch3Cube4()[4]));
        addSequential(new DriveRunRight(turnPower, turnTime));
        addParallel(new OuttakeForTime(0.25));
    }
}
