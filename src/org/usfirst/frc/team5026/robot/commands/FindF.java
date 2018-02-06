package org.usfirst.frc.team5026.robot.commands;
import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class FindF extends Command {
	public FindF() {
    	requires(Robot.drive);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.stop();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		Robot.drive.driveWithPower(0.75);
		SmartDashboard.putNumber("Left motor velocity", Robot.hardware.leftM1.getSelectedSensorVelocity(0));
		SmartDashboard.putNumber("Right motor velocity", Robot.hardware.rightM1.getSelectedSensorVelocity(0));
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
    	Robot.drive.stop();
    }
}
