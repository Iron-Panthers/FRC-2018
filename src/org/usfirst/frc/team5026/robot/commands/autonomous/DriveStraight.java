package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveStraight extends Command {
	
	int target = 0;
	int count, maxCount;
	int tolerance;
    public DriveStraight() {
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	target = (int) SmartDashboard.getNumber("target", 0);
    	target = (int) (target/Constants.WHEEL_CIRCUMFERENCE/Constants.ENCODER_TO_WHEEL_REV_RATIO*Constants.TICKS_TO_INCHES);
		Robot.drive.stop();
		maxCount = (int) SmartDashboard.getNumber("max count", 0);
		tolerance = (int) SmartDashboard.getNumber("tolerance", 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.driveWithTarget(target);
    	SmartDashboard.putNumber("Desired target", target);
    	SmartDashboard.putNumber("current left position", Robot.drive.left.motor1.getSelectedSensorPosition(0));
    	SmartDashboard.putNumber("current right position", Robot.drive.right.motor1.getSelectedSensorPosition(0));
    	SmartDashboard.putNumber("count", count);
    	if (target - Robot.drive.left.motor1.getSelectedSensorPosition(0) < tolerance) {
    		count++;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return count > maxCount;
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
