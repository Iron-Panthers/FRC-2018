package org.usfirst.frc.team5026.robot.commands.climb;

import org.usfirst.frc.team5026.robot.commands.elevator.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ClimbCommandGroup extends CommandGroup {

    public ClimbCommandGroup() {
    	addSequential(new ClimbForTime(1)); // Climbs up for a second
    	addSequential(new ElevatorToScale()); // Set elevator to scale height
    	addSequential(new ElevatorPistonToggle()); // Retract pistons
    	addSequential(new ClimbUp()); // Continues climbing
    	// This command never ends, but who cares?
    	
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
