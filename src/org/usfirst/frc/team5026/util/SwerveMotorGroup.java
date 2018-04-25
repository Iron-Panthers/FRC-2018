package org.usfirst.frc.team5026.util;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class SwerveMotorGroup {
	TalonSRX m1;
	TalonSRX m2;
	TalonSRX m3;
	TalonSRX m4;
	public SwerveMotorGroup(TalonSRX m1, TalonSRX m2, TalonSRX m3, TalonSRX m4) {
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
		this.m4 = m4;
	}
	
	public void setMotorDirection(double targetRadians) {
		double angleFromNegative1To1 = targetRadians/(2*Math.PI);
		double velocity = Constants.P*(angleFromNegative1To1-((m1.getSelectedSensorPosition(pidIdx)/Constants.ENCODER_TICKS_PER_REVOLUTION)%1)); //what is pidIdx?
		m1.set(ControlMode.PercentOutput, velocity);
		m2.set(ControlMode.PercentOutput, velocity);
		m3.set(ControlMode.PercentOutput, velocity);
		m4.set(ControlMode.PercentOutput, velocity);
	}
}
