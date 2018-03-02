package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossAutoLine extends CommandGroup {

    public CrossAutoLine() {
    	requires(Robot.drive);
    	addSequential(new DriveStraight(Constants.AUTO_BASELINE_DISTANCE));
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
}
