package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDrive extends Command {
	public double tickTarget;
    public AutoDrive() {
    	requires(Robot.drive);
    	tickTarget = Constants.AUTO_DISTANCE/Constants.WHEEL_CIRCUMFERENCE/Constants.ENCODER_TO_WHEEL_REV_RATIO*Constants.TICKS_TO_INCHES;
//        System.out.println(tickTarget);
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.driveWithTarget(tickTarget);
//    	Robot.hardware.right1M.set(ControlMode.MotionMagic, 4000);
//    	Robot.hardware.right1M.set(ControlMode.MotionMagicArc, 1024);
//    	Robot.hardware.right1M.set(ControlMode.MotionProfile, 1024);
//    	Robot.hardware.right1M.set(ControlMode.MotionProfileArc, 1024);
//    	Robot.drive.driveWithPower(Constants.DRIVE_SPEED);
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
