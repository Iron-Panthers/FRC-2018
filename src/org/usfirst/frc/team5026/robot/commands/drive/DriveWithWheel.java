package org.usfirst.frc.team5026.robot.commands.drive;

import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveWithWheel extends Command {
	public double rightSpd;
	public double leftSpd;
	public DriveWithWheel() {
		requires(Robot.drive);
	}
	
	protected void initialize() {	
	}
	
	protected void execute() {
		
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

}
