package org.usfirst.frc.team5026.robot.commands.autonomous.selections;

import org.usfirst.frc.team5026.robot.commands.autonomous.sequences.SequenceCenterToSwitch2Cube;
import org.usfirst.frc.team5026.robot.util.StartPosition;

public class Select2CubeScale extends SelectionCommand {

	public Select2CubeScale(StartPosition position) {
		super(position);
	}

	@Override
	protected void initialize() {
		System.out.println("Selecting a 2 cube scale auto mode for "+start+" starting position");
    	switch (start) {
    	case LEFT:
//    		choice = new SequenceLeftToScale2Cube();
    		System.out.println("Selecting a 2 cube scale autonomous from the left!");
    		break;
    	case RIGHT: 
//    		choice = new SequenceRightToScale2Cube();
    		System.out.println("Selecting a 2 cube scale autonomous from the right!");
    		break;
    	case CENTER:
    	case UNKNOWN:
    	default:
    		// BASELINE GOES HERE
    		System.out.println("CrossAutoLine autonomous selected!");
    	}
	}

}
