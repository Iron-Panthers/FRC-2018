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
	public double lastVoltage;
	public double lastCurrent;
    public IntakeCommand() {
	    requires(Robot.intake);
	    lastVoltage = 0;
	    lastCurrent = 0;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
 
    // Called just before this Command runs the first time
    protected void initialize() {
    }
 
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		//Robot.intake.intake(Robot.oi.driveStick.getY());
    	double current = Robot.hardware.pdp.getCurrent(RobotMap.INTAKE_PDP_PORT);
		double voltage = Robot.intake.motor.getMotorOutputVoltage();
		if(voltage == lastVoltage) {
			voltage+=0.0001;
		}
		if(current == lastCurrent) {
			current+=0.0001;
		}
		Robot.intake.intake(Constants.INTAKE_POWER*Robot.oi.driveStick.getThrottle());
		//SmartDashboard.putNumber("Intake Speed", Constants.INTAKE_POWER);
		SmartDashboard.putNumber("throttle:", Robot.oi.driveStick.getThrottle());
		SmartDashboard.putNumber("magnitude:", Robot.oi.driveStick.getMagnitude());
		
		SmartDashboard.putNumber("Intake Current over Voltage", voltage/current);
		SmartDashboard.putNumber("Intake Voltage", voltage);
		SmartDashboard.putNumber("Intake Current", current);
		lastVoltage = voltage;
		lastCurrent = current;
    }
 
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }
    // Called once after isFinished returns true
    protected void end() {
    	Robot.intake.stop();
    }
 
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.intake.stop();
    }
}