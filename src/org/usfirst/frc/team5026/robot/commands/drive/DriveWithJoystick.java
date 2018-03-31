package org.usfirst.frc.team5026.robot.commands.drive;
import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Vector;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * :) hey fam squad whats poppin
 * Can we get some 1gs in the chat
 */
public class DriveWithJoystick extends Command {
	public double leftSpd;
	public double rightSpd;
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
//    	Robot.drive.useArcadeDrive(Robot.oi.joystick.findY(),Robot.oi.joystick.findX());
    	Vector leftRightPower = Robot.oi.driveStick.findLeftRightPower();
    	leftSpd = leftRightPower.getX();
    	SmartDashboard.putNumber("left motor set", leftSpd);
    	rightSpd = leftRightPower.getY();
    	SmartDashboard.putNumber("right motor set", rightSpd);
    	Robot.drive.setLeftSide(leftSpd);
    	Robot.drive.setRightSide(rightSpd);
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
