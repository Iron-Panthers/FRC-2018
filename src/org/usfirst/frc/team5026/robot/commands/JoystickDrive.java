package org.usfirst.frc.team5026.robot.commands;
import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class JoystickDrive extends Command {
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
    	Robot.oi.joystick.seeAxis();
//    	Robot.drive.useArcadeDrive(Robot.oi.joystick.findY(),Robot.oi.joystick.findX());
    	Robot.drive.setLeftSide(Robot.oi.joystick.findLeftPower(Robot.oi.joystick.findY(),Robot.oi.joystick.findX()));
    	Robot.drive.setRightSide(Robot.oi.joystick.findRightPower(Robot.oi.joystick.findY(),Robot.oi.joystick.findX()));
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
