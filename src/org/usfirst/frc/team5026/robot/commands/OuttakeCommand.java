package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Constants;
import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class OuttakeCommand extends Command {

    public OuttakeCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.outtake(Constants.OUTTAKE_POWER*Robot.oi.driveStick.getThrottle());
    	SmartDashboard.putNumber("magnitude:", Robot.oi.driveStick.getMagnitude());
    	SmartDashboard.putNumber("throttle:", Robot.oi.driveStick.getThrottle());
//    	SmartDashboard.putNumber("Outtake Voltage", Robot.intake.motor.get() * Robot.hardware.pdp.getVoltage());
//    	SmartDashboard.putNumber("Outtake Current", Robot.hardware.pdp.getCurrent(RobotMap.INTAKE_PDP_PORT));
//    	SmartDashboard.putNumber("in", 0.2);
    }

    // Called once after timeout
    protected void end() {
    	Robot.intake.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.intake.stop();
    }

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
