package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Constants;
import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftToScale extends Command {

    public LiftToScale() {
    	requires(Robot.elevator);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.raiseToTarget(Constants.TICK_TARGET_TO_SCALE);
    	Robot.dispNum("Tick target", Constants.TICK_TARGET_TO_SCALE);
    	Robot.dispNum("Target", Robot.hardware.elevatorMotor.getActiveTrajectoryPosition()); // Probably puts target
    	Robot.dispNum("Velocity", Robot.hardware.elevatorMotor.getActiveTrajectoryVelocity()); // Probably puts velocity
    	Robot.dispNum("Current", Robot.hardware.elevatorMotor.getOutputCurrent()); // Probably puts current
//    	if (Robot.elevator.masterMotor.getSelectedSensorPosition(0)<=0) { //Keeps Encoder Positive
//    		Robot.elevator.masterMotor.setSelectedSensorPosition(-Robot.elevator.masterMotor.getSelectedSensorPosition(0), Constants.kPIDLoopIdx, Constants.kTimeoutMs);
//    	}
    	Robot.dispNum("Sensor Position", Robot.hardware.elevatorMotor.getSelectedSensorPosition(0));
    	Robot.dispNum("P Constant", Constants.AUTO_P);
    	Robot.dispNum("I Constant", Constants.AUTO_I);
    	Robot.dispNum("D Constant", Constants.AUTO_D);
    	Robot.dispNum("F Constant", Constants.FEED_FORWARD);
    	Robot.dispNum("Error", Robot.hardware.elevatorMotor.getErrorDerivative(0));
    	Robot.dispNum("Voltage", Robot.hardware.elevatorMotor.getBusVoltage());
//    	SmartDashboard.putBoolean("Forward Limit Switch Pressed", Robot.hardware.limitSwitchF.get()); 
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