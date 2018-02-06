package org.usfirst.frc.team5026.robot.commands;
import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import com.ctre.phoenix.motorcontrol.SensorCollection;

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
		SmartDashboard.putNumber("Left motor velocity", Robot.hardware.leftM1.getSelectedSensorVelocity(Constants.kPIDLoopIdx));
		SmartDashboard.putNumber("Right motor velocity", Robot.hardware.rightM1.getSelectedSensorVelocity(Constants.kPIDLoopIdx));
		SmartDashboard.putNumber("Left motor position", Robot.hardware.left.motor1.getSelectedSensorPosition(Constants.kPIDLoopIdx));
		SmartDashboard.putNumber("Right motor position", Robot.hardware.right.motor1.getSelectedSensorPosition(Constants.kPIDLoopIdx));
		SensorCollection left = Robot.hardware.left.motor1.getSensorCollection();
		SensorCollection right = Robot.hardware.right.motor1.getSensorCollection();
		SmartDashboard.putNumber("Left motor qv", left.getQuadratureVelocity());
		SmartDashboard.putNumber("Right motor qv", right.getQuadratureVelocity());
		SmartDashboard.putNumber("Left motor av", left.getAnalogInVel());
		SmartDashboard.putNumber("Right motor av", right.getAnalogInVel());
		SmartDashboard.putNumber("Left motor pwv", left.getPulseWidthVelocity());
		SmartDashboard.putNumber("Right motor pwv", right.getPulseWidthVelocity());
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
