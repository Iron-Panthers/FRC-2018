package org.usfirst.frc.team5026.robot.commands;

import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ResetSRXSettings extends Command {

    public ResetSRXSettings() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.hardware.rightM1.configOpenloopRamp(0, Constants.kTimeoutMs);
    	Robot.hardware.leftM1.configOpenloopRamp(0, Constants.kTimeoutMs);
    	Robot.hardware.rightM1.configForwardSoftLimitEnable(false, Constants.kTimeoutMs);
     	Robot.hardware.leftM1.configForwardSoftLimitEnable(false, Constants.kTimeoutMs);
     	Robot.hardware.leftM1.configReverseLimitSwitchSource(LimitSwitchSource.Deactivated, LimitSwitchNormal.Disabled,Constants.kTimeoutMs);
     	Robot.hardware.rightM1.configReverseLimitSwitchSource(LimitSwitchSource.Deactivated, LimitSwitchNormal.Disabled,Constants.kTimeoutMs);

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
