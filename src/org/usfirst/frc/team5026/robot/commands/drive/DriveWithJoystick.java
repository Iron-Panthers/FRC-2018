package org.usfirst.frc.team5026.robot.commands.drive;
import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;
import org.usfirst.frc.team5026.robot.util.Vector;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveWithJoystick extends Command {
	public double leftSpd;
	public double rightSpd;
	public double turn;
	public double throttle;
	public double angle;
	public double radius = Constants.ROBOT_WIDTH;
    public DriveWithJoystick() {
    	requires(Robot.drive);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() { 
    	Robot.oi.driveStick.seeAxis();
    	Vector v = Robot.oi.driveStick.findXY();
//    	Robot.drive.useArcadeDrive(Robot.oi.joystick.findY(),Robot.oi.joystick.findX());
    	leftSpd = Robot.oi.driveStick.findLeftPower(v.getX(), v.getY());
    	SmartDashboard.putNumber("left spd", leftSpd);
    	rightSpd = Robot.oi.driveStick.findRightPower(v.getX(), v.getY());
    	SmartDashboard.putNumber("right spd", rightSpd);
    	Robot.drive.setLeftSide(leftSpd);
    	Robot.drive.setRightSide(rightSpd); 
    	
    	Robot.oi.driveStick.seeAxis();
    	throttle = -Robot.oi.driveStick.getThrottle();
    	angle = Robot.oi.driveStick.getValue();
    	turn = 1 - Math.abs(angle);
    /*	if (angle > 0) {
    		Robot.drive.setLeftSide(throttle * (turn + radius));
    		Robot.drive.setRightSide(throttle * (turn - radius));
    	} else if (angle < 0) {
    		Robot.drive.setLeftSide(throttle * (turn - radius));
    		Robot.drive.setRightSide(throttle * (turn + radius));
    	}*/
    	
    	System.out.println("Value"+Robot.oi.driveStick.getValue());
    	System.out.println("Throttle"+Robot.oi.driveStick.getThrottle());
    	System.out.println("1." + (throttle * (turn + radius)));
    	System.out.println("1." + (throttle * (turn - radius)));
    	
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
