package org.usfirst.frc.team5026.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class FindTimeCommand extends Command {
	
	long lastTime;

    public FindTimeCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (lastTime == 0 || System.currentTimeMillis()-lastTime > 1000) {
    		lastTime = System.currentTimeMillis();
    	}
    	long time = System.currentTimeMillis();
    	SmartDashboard.putNumber("Time", time - lastTime);
    	lastTime = time;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
