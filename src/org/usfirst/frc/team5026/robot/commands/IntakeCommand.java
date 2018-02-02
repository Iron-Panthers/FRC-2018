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
	public int oddOrEven;
    public IntakeCommand() {
      requires(Robot.intake);
      oddOrEven = 0;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
 
    // Called just before this Command runs the first time
    protected void initialize() {
    }
 
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
      //Robot.intake.intake(Robot.oi.driveStick.getY());
      Robot.intake.intake(Constants.INTAKE_POWER*Robot.oi.driveStick.getThrottle());
      //SmartDashboard.putNumber("Intake Speed", Constants.INTAKE_POWER);
      SmartDashboard.putNumber("throttle:", Robot.oi.driveStick.getThrottle());
      SmartDashboard.putNumber("magnitude:", Robot.oi.driveStick.getMagnitude());
      double current = Robot.hardware.pdp.getCurrent(RobotMap.INTAKE_PDP_PORT);
      double voltage = Robot.intake.motor.getMotorOutputVoltage();
      SmartDashboard.putNumber("Intake Current over Voltage", voltage/current);
      if (oddOrEven%2==0) {
    	  SmartDashboard.putNumber("Intake Voltage", voltage*1.0001);
    	  SmartDashboard.putNumber("Intake Current", current*1.0001);
      }
      	
      oddOrEven++;
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