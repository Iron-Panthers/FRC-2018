package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import paths.FastPathPlanner;

/**
 *
 */
public class PathFollower extends Command {

	int index;
	FastPathPlanner path;
	double F;
	long lastTime;
	long startTime;
	
    public PathFollower(FastPathPlanner p) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	path = p;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.stop();
    	index = 0;
    	startTime = System.currentTimeMillis();
    	F = SmartDashboard.getNumber("Path Planning F", Constants.PATHING_F);
    	SmartDashboard.putNumber("Path total index count", path.smoothPath.length);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (lastTime == 0) {
    		lastTime = System.currentTimeMillis();
    		startTime = lastTime;
    	}
    	
    	index = (int)((System.currentTimeMillis()-startTime) / 1000.0 / Constants.DELTA_TIME);
    	if (index >= path.smoothCenterVelocity.length) {
    		index = path.smoothCenterVelocity.length-1;
    	}
    	SmartDashboard.putNumber("Path Index", index);
    	double lspeed = F * (path.smoothLeftVelocity[index][1]);
    	double rspeed = F * (path.smoothRightVelocity[index][1]);
    	Robot.drive.setLeftSide(lspeed);
    	Robot.drive.setRightSide(lspeed);
    	SmartDashboard.putNumber("Left path speed", path.smoothLeftVelocity[index][1]);
    	SmartDashboard.putNumber("Left motor speed", lspeed);
    	SmartDashboard.putNumber("Left path x", path.leftPath[index][0]);
    	SmartDashboard.putNumber("Left path y", path.leftPath[index][1]);
    	
    	SmartDashboard.putNumber("Right path speed", path.smoothRightVelocity[index][1]);
    	SmartDashboard.putNumber("Right motor speed", lspeed);
    	SmartDashboard.putNumber("Right path x", path.rightPath[index][0]);
    	SmartDashboard.putNumber("Right path y", path.rightPath[index][1]);
    	SmartDashboard.putNumber("Delta Time (ms)", System.currentTimeMillis() - lastTime);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return index == path.smoothPath.length; // This is the last setpoint!
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
