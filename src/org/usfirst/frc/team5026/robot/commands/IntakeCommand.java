package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Constants;
import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class IntakeCommand extends Command {
	int count;
    public IntakeCommand() {
    	count = 0;
    	requires(Robot.intake);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Robot.intake.intake(Robot.oi.driveStick.getY());
    	Robot.intake.intake(Constants.INTAKE_POWER*Robot.oi.joystick.driveStick.getThrottle());
    	//SmartDashboard.putNumber("Intake Speed", Constants.INTAKE_POWER);
    	SmartDashboard.putNumber("throttle:", Robot.oi.joystick.driveStick.getThrottle());
    	SmartDashboard.putNumber("magnitude:", Robot.oi.joystick.driveStick.getMagnitude());
    	Robot.intake.hasBlock();
//    	double voltage = Robot.hardware.pdp.getVoltage()*Robot.intake.motor.get();
    	double current = Robot.hardware.pdp.getCurrent(RobotMap.INTAKE_PDP_PORT);
//    	SmartDashboard.putNumber("Intake Current over Voltage", voltage/current);
//    	SmartDashboard.putNumber("Intake Voltage", voltage);
    	SmartDashboard.putNumber("Intake Current", current);
    	if(current > Constants.THRESHOLD_CURRENT) {
    		count++;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return count >= Constants.THRESHOLD_COUNT;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.intake(Constants.THRESHOLD_POWER);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.intake.stop();
    }
}
