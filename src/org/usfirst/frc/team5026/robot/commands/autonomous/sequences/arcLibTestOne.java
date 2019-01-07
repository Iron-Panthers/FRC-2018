package org.usfirst.frc.team5026.robot.commands.autonomous.sequences;

import java.util.ArrayList;

import org.usfirst.frc.team5026.robot.util.arclib.ArcPath;
import org.usfirst.frc.team5026.robot.util.arclib.ArrayListMaker;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class arcLibTestOne extends CommandGroup {
	Double[] r = {};
	Double[] l = {};
	Double[] e = {};
	ArrayList<Double> rightPowers = ArrayListMaker.make(r);
	ArrayList<Double> leftPowers = ArrayListMaker.make(l);
	ArrayList<Double> encoderPositions = ArrayListMaker.make(e);

    public arcLibTestOne() {
    	addParallel(new ArcPath(rightPowers, leftPowers, encoderPositions));
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
