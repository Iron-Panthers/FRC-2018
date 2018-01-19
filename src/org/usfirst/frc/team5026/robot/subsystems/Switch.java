package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Switch extends Subsystem {
	Talon switchM;
	public Switch() {
		switchM = Robot.hardware.switchM;
	}
	public void intake(double speed) {
		switchM.set(speed);
	}
	public void outtake(double speed) {
		switchM.set(speed);
	}
	public void stop() {
		switchM.set(0);
	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
