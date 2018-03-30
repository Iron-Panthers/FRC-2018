package org.usfirst.frc.team5026.robot.commands.autonomous.selections;

import org.usfirst.frc.team5026.robot.commands.autonomous.sequences.SequenceLeftToScale;
import org.usfirst.frc.team5026.robot.commands.autonomous.sequences.SequenceRightToScale;
import org.usfirst.frc.team5026.robot.util.StartPosition;

/**
 *
 */
public class SelectScale extends SelectionCommand {

    public SelectScale(StartPosition position) {
    	super(position);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Selecting a scale auto mode for "+start+" starting position");
    	switch (start) {
    	case LEFT:
    		choice = new SequenceLeftToScale();
    		System.out.println("Selected a left scale auto!");
    		break;
    	case RIGHT:
    		choice = new SequenceRightToScale();
    		System.out.println("Selected a right scale auto!");
    		break;
    	case CENTER:
    		System.out.println("ATTEMPTED A SCALE AUTO WITH THE CENTER START POSITION!");
    	case UNKNOWN:
    	default:
    		// BASELINE GOES HERE
    		System.out.println("CrossAutoLine autonomous selected!");
    	}
    }
}
