package org.usfirst.frc.team5026.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Hardware {
	public TalonSRX swerveM1;
	public TalonSRX swerveM2;
	public TalonSRX swerveM3;
	public TalonSRX swerveM4;
	public TalonSRX frontLeft;
	public TalonSRX frontRight;
	public TalonSRX backLeft;
	public TalonSRX backRight;
	public Hardware() {
		swerveM1 = new TalonSRX(RobotMap.SWERVE_MOTOR_1_PORT);
		swerveM2 = new TalonSRX(RobotMap.SWERVE_MOTOR_2_PORT);
		swerveM3 = new TalonSRX(RobotMap.SWERVE_MOTOR_3_PORT);
		swerveM4 = new TalonSRX(RobotMap.SWERVE_MOTOR_4_PORT);
		frontLeft = new TalonSRX(RobotMap.FRONT_LEFT_PORT);
		frontRight = new TalonSRX(RobotMap.FRONT_RIGHT_PORT);
		backLeft = new TalonSRX(RobotMap.BACK_LEFT_PORT);
		backRight = new TalonSRX(RobotMap.BACK_RIGHT_PORT);
	}
}
