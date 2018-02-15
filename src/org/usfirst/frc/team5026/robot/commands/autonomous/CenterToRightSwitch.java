package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterToRightSwitch extends CommandGroup {

    public CenterToRightSwitch() {
    	addSequential(new DriveStraight(Constants.SWTICH_DISTANCE / 2)); // Move forward halfway through
    	addSequential(new DriveTurn(Constants.TURN)); // Turn right 90 degrees
    	addSequential(new DriveStraight(Constants.CENTER_TO_SWITCH)); // Move forward 4 feet or 48 inches
    	addSequential(new DriveTurn(-Constants.TURN)); // Turn left 90 degrees 
    	addSequential(new DriveStraight(Constants.SWTICH_DISTANCE / 2)); // Move forward to switch
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
