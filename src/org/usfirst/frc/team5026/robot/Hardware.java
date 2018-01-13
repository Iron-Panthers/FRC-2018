package org.usfirst.frc.team5026.robot;

import edu.wpi.first.wpilibj.Talon;

public class Hardware {
	Talon rightM;
	Talon leftM;
	public Hardware(){
		rightM = new Talon(Constants.RIGHT_PORT);
		leftM = new Talon(Constants.LEFT_PORT);
	}
}
