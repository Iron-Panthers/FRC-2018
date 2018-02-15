package org.usfirst.frc.team5026.robot.commands.elevator;

import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ElevatorTarget extends Command {

	
	int target;
    public ElevatorTarget() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.stop();
    	target = (int)SmartDashboard.getNumber("Elevator Target", 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (false) {
//    	if(Robot.elevator.atElevatorLimit()) {
//    		Robot.elevator.motors.stop();
    	} else {
    		Robot.elevator.motors.driveWithTarget(target);
    	}
    	SmartDashboard.putNumber("Elevator Position", Robot.elevator.motors.getEncoderTicks());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.elevator.stop();
    }
}
