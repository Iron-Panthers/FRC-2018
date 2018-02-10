package org.usfirst.frc.team5026.robot.subsystems;

import org.usfirst.frc.team5026.robot.Constants;
import org.usfirst.frc.team5026.robot.Robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ConveyorBelt extends Subsystem {
	public Talon motor;
	public ConveyorBelt() {
		motor = Robot.hardware.conveyor;
	}
	
	public void forward(double speed) {
		motor.set(speed);
	}

	public void backward(double speed) {
		motor.set(-speed);
	}
	
	public void stop() {
		motor.set(0);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

