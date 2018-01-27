package org.usfirst.frc.team5026.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Oscillate extends CommandGroup {

    public Oscillate() {
    		addSequential(new InCommand());
    		addSequential(new VerySpeedyWaitBoi(SmartDashboard.getNumber("Oscillation Time Retract", 0.01)));
    		addSequential(new OutCommand());
    		addSequential(new VerySpeedyWaitBoi(SmartDashboard.getNumber("Oscillation Time Extend", 0.01)));
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
