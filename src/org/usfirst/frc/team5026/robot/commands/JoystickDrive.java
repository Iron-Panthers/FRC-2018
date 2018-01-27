package org.usfirst.frc.team5026.robot.commands;
import org.usfirst.frc.team5026.robot.Constants;
import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class JoystickDrive extends Command {
	public double x;
	public double y;
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
//    	double right;
//    	double left;
    	Robot.drive.useArcadeDrive(Robot.oi.driveStick.getX()*Constants.X_AXIS_MODIFIER, Robot.oi.driveStick.getY());
    	SmartDashboard.putNumber("Joystick X Axis", Robot.oi.driveStick.getX());
    	SmartDashboard.putNumber("Joystick Y Axis", Robot.oi.driveStick.getY());
    	//k = Robot.oi.driveStick.getY()/Robot.oi.driveStick.getX();
//    	right = Constants.QUARTER_SPEED*(-Robot.oi.driveStick.getY() - Robot.oi.driveStick.getX());
//    	left = Constants.QUARTER_SPEED*(-Robot.oi.driveStick.getY() + Robot.oi.driveStick.getX());
//    	if(Robot.oi.driveStick.getY()<.13&&Robot.oi.driveStick.getX()<.13) {
//    		Robot.drive.setRightMotor(0);
//    		Robot.drive.setLeftMotor(0);
//    	}
//    	else {
//    		if(right < Constants.QUARTER_SPEED) {
//        		Robot.drive.setRightMotor(right);
//        	}
//        	else {
//        		Robot.drive.setRightMotor(Constants.QUARTER_SPEED);
//        	}
//        	if(left < Constants.QUARTER_SPEED) {
//        		Robot.drive.setLeftMotor(left);
//        	}
//        	else {
//        		Robot.drive.setLeftMotor(Constants.QUARTER_SPEED);
//        	}	
//    	}
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
