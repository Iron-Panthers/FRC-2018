package org.usfirst.frc.team5026.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class JoystickMotor extends Subsystem {
	
	public TalonSRX motor;
	
	public JoystickMotor(TalonSRX motor) {
		this.motor = motor;
	}
	
	public void move(double speed) {
		motor.set(ControlMode.PercentOutput, speed);
	}
	
	public void stop() {
		motor.set(ControlMode.PercentOutput, 0);
	}
	

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

