package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
	Talon right;
	Talon left;
	public Drive(Talon r, Talon l){
		right = r;
		left = l;
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void setLeftMotor(double speed){
		left.set(speed);
	}
	public void setRightMotor(double speed){
		right.set(speed);
	}
    public void initDefaultCommand() {
    	setDefaultCommand(Robot.joystickDrive);
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

