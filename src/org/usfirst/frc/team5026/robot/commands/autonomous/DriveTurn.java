package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTurn extends Command {

	double target = 0;
	int count, maxCount;
	double tolerance;
	Timer time;
	
	double lastError, sumError;
	
    public DriveTurn() {
        requires(Robot.drive);
        time = new Timer();
    }
    public DriveTurn(double angle) {
    		target = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.hardware.gyro.setFusedHeading(0, Constants.kTimeoutMs);
    	Robot.hardware.gyro.setYaw(0, Constants.kTimeoutMs);
    	Robot.drive.stop();
    	if (target == 0)
    		target = SmartDashboard.getNumber("gyro target", 0);
    	maxCount = (int) SmartDashboard.getNumber("max count", 0);
		tolerance = SmartDashboard.getNumber("gyro tolerance", 0);
		time.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double error = error();
    	double dError = error - lastError;
    	lastError = error;
    	sumError += error;
    	
    	double power = Constants.TURN_P * error + Constants.TURN_I * sumError + Constants.TURN_D * dError + Constants.TURN_F * predictedSpeed(time.get());
    	Robot.drive.setLeftSide(power);
    	Robot.drive.setRightSide(-power);
    	
    	SmartDashboard.putNumber("count", count);
    	if (Math.abs(target - Robot.hardware.gyro.getFusedHeading()) < tolerance) {
    		count++;
    	}
    }
    
    private double error() {
    	return target - Robot.hardware.gyro.getFusedHeading();
    }
    
    private double predictedSpeed(double time) {
    	return 90;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return count >= maxCount;
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
