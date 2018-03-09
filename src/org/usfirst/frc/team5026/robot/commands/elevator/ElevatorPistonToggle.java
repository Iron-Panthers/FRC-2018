package org.usfirst.frc.team5026.robot.commands.elevator;

import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorPistonToggle extends Command {

    public ElevatorPistonToggle() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		if( Robot.elevator.solenoid.get() == Value.kForward) {
    			Robot.elevator.extendPistons();
    		}
    		else {
    			Robot.elevator.retractPistons();
    		}
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
