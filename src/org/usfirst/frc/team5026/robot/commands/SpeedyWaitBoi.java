package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SpeedyWaitBoi extends Command {

    public SpeedyWaitBoi() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    		System.out.println("SpeedWaitBoi Start");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		SmartDashboard.putNumber("Potentiometer value", Robot.hardware.potentiometer.getVoltage());
    }

    // Called once after timeout
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Robot.hardware.potentiometer.getVoltage() < SmartDashboard.getNumber("Length Out", 5);
	}
}
