package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Robot;

import badlib.Path;
import badlib.Point;
import edu.wpi.first.wpilibj.command.Command;

public class FollowPath extends Command {
	
	private static final double F = 0.3;
	private Path path = new Path(3, -2.8, 1.15, 0, 20, 0, 0.3, 0.2, 0.3, 0, 0, 0);
	private double startTime;
	private Point speeds = new Point();
	
    public FollowPath() {
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double time = System.currentTimeMillis() - startTime;
    	path.wheelSpeeds(time, speeds);
    	
    	Robot.drive.setLeftSide(F * speeds.x);
		Robot.drive.setRightSide(F * speeds.y);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis() - startTime > path.duration();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drive.stop();
    }
}
