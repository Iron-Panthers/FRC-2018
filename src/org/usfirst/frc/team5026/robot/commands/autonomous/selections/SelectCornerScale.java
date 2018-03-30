package org.usfirst.frc.team5026.robot.commands.autonomous.selections;

import org.usfirst.frc.team5026.robot.commands.autonomous.sequences.SequenceLeftToScaleSwitchSide;
import org.usfirst.frc.team5026.robot.commands.autonomous.sequences.SequenceRightToScaleSwitchSide;
import org.usfirst.frc.team5026.robot.util.StartPosition;

public class SelectCornerScale extends SelectionCommand {

	public SelectCornerScale(StartPosition position) {
		super(position);
	}

	@Override
	protected void initialize() {
		System.out.println("Selecting a scale auto mode for "+start+" starting position");
    	switch (start) {
    	case LEFT:
    		choice = new SequenceLeftToScaleSwitchSide();
    		System.out.println("Selected a left scale corner auto!");
    		break;
    	case RIGHT:
    		choice = new SequenceRightToScaleSwitchSide();
    		System.out.println("Selected a right scale corner auto!");
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
