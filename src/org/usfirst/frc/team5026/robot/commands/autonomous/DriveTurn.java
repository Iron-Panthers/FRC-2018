package org.usfirst.frc.team5026.robot.commands.autonomous;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;
import org.usfirst.frc.team5026.robot.util.copypastalib.CombinedPath;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTurn extends Command {

	double target = 0;
	double startYaw;
	int count, maxCount;
	double tolerance;
	double startTime = 0; //in seconds
	double[] ypr = new double[3];
	CombinedPath.LongitudalTrapezoid path;
	
	double maxSpeed = 0;
	
	double lastError, sumError;
	
    public DriveTurn() {
        requires(Robot.drive);
    }
    public DriveTurn(double angle) {
    	requires(Robot.drive);
    	target = angle;
    	path = new CombinedPath.LongitudalTrapezoid(0, target, 90, 270);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	Robot.hardware.gyro.setFusedHeading(0, Constants.kTimeoutMs);
    	startTime = System.currentTimeMillis() / 1000.0;
    	Robot.hardware.gyro.setYaw(0, Constants.kTimeoutMs);
    	Robot.drive.stop();
    	startYaw = 0;
    	maxSpeed = 0;
    	startYaw = this.yaw();
    	count = 0;
    	if (target == 0)
    		target = SmartDashboard.getNumber("gyro target", 0);
    	maxCount = (int) SmartDashboard.getNumber("max count", 0);
		tolerance = SmartDashboard.getNumber("gyro tolerance", 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {  
    	double time = this.timeInSeconds();
    	
    	double error = path.getPosition(time) - this.yaw();
    	double dError = error - lastError;
    	lastError = error;
    	sumError += error;
    	
    	if ( this.predictedSpeed(time) > maxSpeed ) {
    		maxSpeed = this.predictedSpeed(time);
    	}
    	
    	SmartDashboard.putNumber("sped", this.predictedSpeed(time));
    	
    	double power = Constants.TURN_P * error + Constants.TURN_I * sumError + Constants.TURN_D * dError + Constants.TURN_F * predictedSpeed(this.timeInSeconds());
    	Robot.drive.setLeftSide(power);
    	Robot.drive.setRightSide(-power);
    	
    	SmartDashboard.putNumber("max speed", maxSpeed);
    	SmartDashboard.putNumber("error", error);
    	
    	SmartDashboard.putNumber("count", count);
    	if (Math.abs(error) < tolerance && time > this.path.getTotalTime()) {
    		count++;
    	}
    }
    
    private double yaw() {
    	Robot.hardware.gyro.getYawPitchRoll(ypr);
    	return ypr[0] - startYaw;
    }
    
    private double timeInSeconds() {
    	return System.currentTimeMillis() / 1000.0 - startTime;
    }
    
    private double predictedSpeed(double time) {
    	return path.getSpeed(time);
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
