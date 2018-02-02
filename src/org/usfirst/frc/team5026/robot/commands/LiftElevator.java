package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Constants;
import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LiftElevator extends Command {

    public LiftElevator() {
    	requires(Robot.elevator);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.raiseToTarget(Constants.TICK_TARGET);
    	Robot.dispNum("Target", Robot.hardware.elevatorMotor.getActiveTrajectoryPosition()); // Probably puts target
    	Robot.dispNum("Velocity", Robot.hardware.elevatorMotor.getActiveTrajectoryVelocity()); // Probably puts velocity
    	Robot.dispNum("Current", Robot.hardware.elevatorMotor.getOutputCurrent()); // Probably puts current
    	//SmartDashboard.putBoolean("Limit Switch Triggered", );
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }
}
