package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.AutoPaths;
import org.usfirst.frc.team5026.robot.util.Constants;
import org.usfirst.frc.team5026.robot.util.PlatformState;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import scadlib.paths.FastPathPlanner;

/**
 * This command ONLY runs after the game data has been received
 */
public class CenterToSwitch1Cube extends Command {

	int index = 0;
	long startTime;
	long lastTime;
	double F;
	double P;
	FastPathPlanner path;
	
    public CenterToSwitch1Cube() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (AutoPaths.ALLY_SWITCH_STATE == PlatformState.LEFT) {
    		path = AutoPaths.getLeftPath();
    	} else if (AutoPaths.ALLY_SWITCH_STATE == PlatformState.RIGHT) {
    		path = AutoPaths.getRightPath();
    	}
    	else {
    		System.out.println("NO DATA!");
    		// NO PATH! Go straight instead...
    	}
    	Robot.drive.stop();
    	Robot.drive.left.motor1.setSelectedSensorPosition(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
    	Robot.drive.right.motor1.setSelectedSensorPosition(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
    	index = 0;
    	startTime = System.currentTimeMillis();
    	F = SmartDashboard.getNumber("Path Planning F", Constants.PATHING_F);
    	P = SmartDashboard.getNumber("Path Planning P", Constants.PATHING_P);
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
    	double lp = P * leftPositionalError();
    	double rp = P * rightPositionalError();
    	if (index == 0) {
    		lp = rp = 0;
    	}
    	
    	// Don't ask
    	lspeed += lp;
    	rspeed += rp;
    	
    	Robot.drive.setLeftSide(lspeed);
    	Robot.drive.setRightSide(rspeed);
    	
    	SmartDashboard.putNumber("Left Error", leftPositionalError());
    	SmartDashboard.putNumber("Right Error", rightPositionalError());
    	SmartDashboard.putNumber("Left Arclength", path.getLeftArclength()[index]);
    	SmartDashboard.putNumber("Right Arclength", path.getRightArclength()[index]);
    	SmartDashboard.putNumber("Left Position", Robot.drive.getLeftEncoderPosition() / Constants.TICKS_TO_INCHES);
    	SmartDashboard.putNumber("Right Position", Robot.drive.getRightEncoderPosition() / Constants.TICKS_TO_INCHES);
    	
    	SmartDashboard.putNumber("Left path speed", path.smoothLeftVelocity[index][1]);
    	SmartDashboard.putNumber("Left motor speed", lspeed);
    	SmartDashboard.putNumber("Left path x", path.leftPath[index][0]);
    	SmartDashboard.putNumber("Left path y", path.leftPath[index][1]);
    	
    	SmartDashboard.putNumber("Right path speed", path.smoothRightVelocity[index][1]);
    	SmartDashboard.putNumber("Right motor speed", lspeed);
    	SmartDashboard.putNumber("Right path x", path.rightPath[index][0]);
    	SmartDashboard.putNumber("Right path y", path.rightPath[index][1]);
    	SmartDashboard.putNumber("Delta Time (ms)", System.currentTimeMillis() - lastTime);
    	SmartDashboard.putNumber("Overall time (ms)", System.currentTimeMillis() - startTime);
    	lastTime = System.currentTimeMillis();
    }

    private double leftPositionalError() {
    	return (path.getLeftArclength()[index] - Robot.drive.getLeftEncoderPosition() / Constants.TICKS_TO_INCHES);
    }
    private double rightPositionalError() {
    	return (path.getRightArclength()[index] - Robot.drive.getRightEncoderPosition() / Constants.TICKS_TO_INCHES);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return index == path.smoothPath.length-1; // This is the last setpoint!
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
