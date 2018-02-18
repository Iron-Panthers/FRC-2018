package org.usfirst.frc.team5026.robot.commands.elevator;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ElevatorFindF extends Command {

	
	double percentOut;
    public ElevatorFindF() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.stop();
    	percentOut = SmartDashboard.getNumber("Elevator Percent", 0.25);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.motors.motor1.set(ControlMode.PercentOutput, percentOut);
    	SmartDashboard.putNumber("Elevator Position", Robot.elevator.motors.motor1.getSelectedSensorPosition(Constants.kPIDLoopIdx));
    	SmartDashboard.putNumber("Elevator Velocity", Robot.elevator.motors.motor1.getSelectedSensorVelocity(Constants.kPIDLoopIdx));
    	SmartDashboard.putNumber("F Guess", (1023.0 * percentOut) / Robot.elevator.motors.motor1.getSelectedSensorVelocity(Constants.kPIDLoopIdx));
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
