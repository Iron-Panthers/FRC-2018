package org.usfirst.frc.team5026.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 **/
//starts in exact center
//moves 75 inches forward, turns 90 degrees left, moves 48 inches forward, turns right 90 degrees, moves forward 75 inches, outtakes a preloaded block into left switch
public class CenterToLeftSwitch extends CommandGroup {

    public CenterToLeftSwitch() {
    	addSequential(new DriveStraight(75));
    	addSequential(new DriveTurn(-90));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
