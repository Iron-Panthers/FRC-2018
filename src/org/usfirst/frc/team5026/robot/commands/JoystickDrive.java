package org.usfirst.frc.team5026.robot.commands;
import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class JoystickDrive extends Command {
	public double left;
	public double right;
    public JoystickDrive() {
    	requires(Robot.drive);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	Robot.oi.joystick.findXY();
//    	left = Robot.oi.joystick.findLeftPower();
//    	right = Robot.oi.joystick.findRightPower();
//    	if(left>Constants.SPEED) {
//			Robot.drive.setLeftSide(Constants.SPEED);
//		}
//		else {
//	    	Robot.drive.setLeftSide(left*Constants.SPEED);
//		}
//		if(right>Constants.SPEED) {
//			Robot.drive.setRightSide(Constants.SPEED);
//		}
//		else {
//	    	Robot.drive.setLeftSide(right*Constants.SPEED);
//		}
//    	double right;
//    	double left;
    	Robot.drive.useArcadeDrive(Robot.oi.joystick.driveStick.getX()*Constants.X_AXIS_MODIFIER, Robot.oi.joystick.driveStick.getY());
//    	SmartDashboard.putNumber("Joystick X Axis", Robot.oi.driveStick.getX());
//    	SmartDashboard.putNumber("Joystick Y Axis", Robot.oi.driveStick.getY());
//    	y = -Robot.oi.driveStick.getY();
//    	x = Robot.oi.driveStick.getX();
//    	//k = Robot.oi.driveStick.getY()/Robot.oi.driveStick.getX();
//    	if(!Robot.drive.isReversed) {
//    		if(Math.abs(y) < .08 && Math.abs(x) < .08) {
//    			right = 0;
//    			left = 0;
//    		}
//    		else if(Math.abs(x)<.08) {
//    			right = y;
//    			left = y;
//    		}
//    		else if(Math.abs(y)<.08) {
//    			right = -x;
//    			left = x;
//    		}
//    		else {
//    			right = (y - x);
//            	left = (y + x);
//    		}
//    	}
//    	else{
//    		if(Math.abs(y) < .08 && Math.abs(x) < .08) {
//    			right = 0;
//    			left = 0;
//    		}
//    		else if(Math.abs(x)<.08) {
//    			right = -y;
//    			left = -y;
//    		}
//    		else if(Math.abs(y)<.08) {
//    			right = x;
//    			left = -x;
//    		}
//    		else {
//    			right = -(y - x);
//            	left = -(y + x);
//    		}
//    	}
//    	if(left>Constants.SPEED) {
//    		Robot.drive.setLeftMotor(1*Constants.SPEED);
//    	}
//    	else {
//        	Robot.drive.setLeftMotor(left*Constants.SPEED);
//    	}
//    	if(right>Constants.SPEED) {
//    		Robot.drive.setRightMotor(1*Constants.SPEED);
//    	}
//    	else {
//        	Robot.drive.setLeftMotor(right*Constants.SPEED);
//    	}
////    	Robot.drive.setLeftMotor(Robot.oi.driveStick.getY() + Robot.oi.driveStick.getX());
////    	Robot.drive.setRightMotor(Robot.oi.driveStick.getY() - Robot.oi.driveStick.getX());

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
