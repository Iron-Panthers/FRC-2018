package org.usfirst.frc.team5026.robot.commands.drive;
import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Vector;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
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
    	Vector joystickOut = Robot.oi.driveStick.findXY();
    	Vector power = Robot.oi.driveStick.findLeftRightPower(joystickOut.getX(), joystickOut.getY());
//    	Robot.drive.useArcadeDrive(Robot.oi.joystick.findY(),Robot.oi.joystick.findX());
    	leftSpd = power.getX();
    	rightSpd = power.getY();
    	SmartDashboard.putNumber("left spd", leftSpd);
    	SmartDashboard.putNumber("right spd", rightSpd);
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
