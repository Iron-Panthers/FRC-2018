package org.usfirst.frc.team5026.robot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class FindTarget extends TimedCommand {
	double timeOut;
	public static double target;
	double currentTime;
    public FindTarget(double timeout) {
        super(timeout);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		timeOut = SmartDashboard.getNumber("Time to go out in", 1);
    		currentTime += 0.02;
    		target = (currentTime/timeOut) * SmartDashboard.getNumber("Fully Extended", 0.5);
    }
    

    // Called once after timeout
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
}
