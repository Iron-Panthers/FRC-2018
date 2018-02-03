package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Oscillation extends Command {
	double target = FindTarget.target;
    public Oscillation() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		if(Robot.hardware.potentiometer.getVoltage() < target) {
    			Robot.solenoidBoi.extend();
    		}
    		if(Robot.hardware.potentiometer.getVoltage() > target) {
    			Robot.solenoidBoi.contract();
    		}

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.hardware.potentiometer.getVoltage() > SmartDashboard.getNumber("Fully Extended", 0.5);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
