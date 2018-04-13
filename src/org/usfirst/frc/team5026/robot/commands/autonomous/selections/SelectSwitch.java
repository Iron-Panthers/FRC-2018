package org.usfirst.frc.team5026.robot.commands.autonomous.selections;

import org.usfirst.frc.team5026.robot.commands.autonomous.sequences.SequenceCenterToSwitch1Cube;
import org.usfirst.frc.team5026.robot.util.StartPosition;

/**
 *
 */
public class SelectSwitch extends SelectionCommand {

    public SelectSwitch(StartPosition position) {
    	super(position);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Selecting a switch auto mode for "+start+" starting position");
    	switch (start) {
    	case LEFT:
    		// Left to Switch
    		break;
    	case CENTER:
    		// Center to Switch
    		choice = new SequenceCenterToSwitch1Cube();
    		System.out.println("Center to Switch autonomous selected!");
    		break;
    	case RIGHT:
    		// Right to Switch
    		System.out.println("Right to Switch autonomous selected!");
    		break;
    	case UNKNOWN:
    	default:
    		// BASELINE GOES HERE
    		System.out.println("CrossAutoLine autonomous selected!");
    	}
    }
}
