package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.commands.HoldBlock;
import org.usfirst.frc.team5026.robot.commands.IntakeCommandGroup;
import org.usfirst.frc.team5026.robot.commands.OuttakeCommand;
import org.usfirst.frc.team5026.robot.commands.OuttakeForTime;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorExtendPistons;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToScale;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftScale1Cube extends CommandGroup {

    public LeftScale1Cube() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
    	
    	addSequential(new ElevatorExtendPistons());
    	addParallel(new HoldBlock());
    	addSequential(new ElevatorToScale());
    	//addSequential(new DriveTheShit());
    	addSequential(new OuttakeForTime(Constants.TIME_OUTTAKING_IN_SCALE_AUTO));
    	
    	

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
