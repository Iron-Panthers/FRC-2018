package org.usfirst.frc.team5026.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class JoystickMotor extends Subsystem {
	
	public Talon motor;
	
	public JoystickMotor(Talon motor) {
		this.motor = motor;
	}
	
	public void move(double speed) {
		motor.set(speed);
	}
	
	public void stop() {
		motor.set(0);
	}
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

