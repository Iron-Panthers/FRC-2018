package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.commands.autonomous.sequences.SequenceCenterToSwitch2Cube;
import org.usfirst.frc.team5026.robot.util.StartPosition;

public class Select2CubeSwitch extends SelectionCommand {
	public Select2CubeSwitch(StartPosition start) {
		super(start);
	}
	@Override
	public void initialize() {
		System.out.println("Selecting a 2 cube switch auto mode for "+start+" starting position");
    	switch (start) {
    	case CENTER:
    		choice = new SequenceCenterToSwitch2Cube();
    		System.out.println("Selecting a 2 cube switch autonomous from the center!");
    		break;
    	case LEFT:
    	case RIGHT:    	
    	case UNKNOWN:
    	default:
    		// BASELINE GOES HERE
    		System.out.println("CrossAutoLine autonomous selected!");
    	}
	}
}
