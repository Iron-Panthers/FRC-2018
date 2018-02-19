/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5026.robot;

import org.usfirst.frc.team5026.robot.commands.FindTimeCommand;
import org.usfirst.frc.team5026.robot.commands.autonomous.DriveStraight;
import org.usfirst.frc.team5026.robot.commands.autonomous.PathFollower;
import org.usfirst.frc.team5026.robot.subsystems.Drive;
import org.usfirst.frc.team5026.robot.subsystems.Elevator;
import org.usfirst.frc.team5026.robot.subsystems.ConveyorBelt;
import org.usfirst.frc.team5026.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team5026.robot.util.AutoPaths;
import org.usfirst.frc.team5026.robot.util.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static Hardware hardware;
	public static Drive drive;
	public static ConveyorBelt conveyor;
	public static IntakeSubsystem intake;
	public static Elevator elevator;
	Command autoCommand;
	SendableChooser<Command> autoChooser = new SendableChooser<>();
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		hardware = new Hardware();
		drive = new Drive(hardware.left, hardware.right, hardware.gearShift);
//		drive = new Drive(hardware.leftM, hardware.rightM, hardware.gearShift);
		intake = new IntakeSubsystem();
		elevator = new Elevator();
		conveyor = new ConveyorBelt();
		oi = new OI();
//		right.setInverted(Constants.IS_RIGHT_INVERTED);
		// autoChooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", autoChooser);
		SmartDashboard.putNumber("Elevator Percent", 0.25); // TODO to remove later
		SmartDashboard.putNumber("Elevator F", Constants.ELEVATOR_F); // TODO to remove later
		SmartDashboard.putNumber("Elevator P Term", Constants.ELEVATOR_P); // TODO to remove later
		SmartDashboard.putNumber("Elevator I", Constants.ELEVATOR_I); // TODO to remove later
		SmartDashboard.putNumber("Elevator D", Constants.ELEVATOR_D); // TODO to remove later
		SmartDashboard.putNumber("Elevator V Term", Constants.ELEVATOR_VELOCITY); // TODO to remove later
		SmartDashboard.putNumber("Elevator A Term", Constants.ELEVATOR_ACCELERATION); // TODO to remove later
		SmartDashboard.putNumber("Elevator Reset Value", 0); // TODO to remove later
		SmartDashboard.putNumber("Elevator Target", 1000); // TODO to remove later
		oi.mapButtons();
		autoChooser.addDefault("My Auto", new DriveStraight());
		autoChooser.addObject("Left Path Test (Feed forward only)", new PathFollower(AutoPaths.getLeftPath()));
		autoChooser.addObject("Right Path Test (Feed forward only)", new PathFollower(AutoPaths.getRightPath()));
		autoChooser.addObject("Find Time", new FindTimeCommand());
		SmartDashboard.putNumber("target", 100);
		SmartDashboard.putNumber("max count", 50);
		SmartDashboard.putNumber("tolerance", 69);
		SmartDashboard.putNumber("Path Planning F", Constants.PATHING_F);
		SmartDashboard.putNumber("Path Planning P", Constants.PATHING_P);
		SmartDashboard.putData("Auto mode", autoChooser);
//		SmartDashboard.getNumber("Intake Speed", Constants.INTAKE_POWER);
		LiveWindow.disableAllTelemetry();
    }
	

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
//		hardware.elevatorMotor.setSelectedSensorPosition(0, 0, 0);
//		System.out.println(hardware.elevatorMotor.getSelectedSensorPosition(0));
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the autoChooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * autoChooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the autoChooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * autoChooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autoCommand = autoChooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autoCommand != null) {
			autoCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
//		hardware.elevatorMotor.set(ControlMode.MotionMagic, Constants.TICK_TARGET_TO_SCALE);
//		SmartDashboard.putNumber("Auto Encoder Position", hardware.elevatorMotor.getSelectedSensorPosition(0));
//		SmartDashboard.putNumber("Auto Talon Speed", hardware.elevatorMotor.getMotorOutputPercent());
////		System.out.println(hardware.elevatorMotor.getSelectedSensorPosition(0));
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		Robot.elevator.motors.motor1.set(ControlMode.MotionMagic, Robot.elevator.motors.motor1.getSelectedSensorPosition(Constants.kPIDLoopIdx));
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autoCommand != null) {
			autoCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		//Teleop Window
		String time;
		int seconds = (int) (DriverStation.getInstance().getMatchTime() % 60);
		int minutes = (int) (DriverStation.getInstance().getMatchTime() - seconds) / 60;
		time = minutes+":"+seconds;
		SmartDashboard.putString("Time Left", time);
		SmartDashboard.putNumber("Battery Voltage", hardware.pdp.getVoltage());
		//Debug Window
    	SmartDashboard.putString("Elevator Status", Robot.elevator.getElevatorDirection().name());
		SmartDashboard.putNumber("Elevator Motor", Robot.elevator.motors.motor1.getOutputCurrent());
    	SmartDashboard.putNumber("Encoder Position", hardware.elevatorMotor.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Encoder Velocity", hardware.elevatorMotor.getSelectedSensorVelocity(0));
		SmartDashboard.putNumber("Elevator Motor Current", hardware.elevatorMotor.getOutputCurrent());
		SmartDashboard.putNumber("Elevator Motor Voltage", hardware.elevatorMotor.getMotorOutputVoltage());
		SmartDashboard.putNumber("Intake Motor Current", hardware.intakeM.getOutputCurrent());
		SmartDashboard.putNumber("Intake Motor Voltage", hardware.intakeM.getMotorOutputVoltage());
		//Drive Motor Current and Voltage
		SmartDashboard.putNumber("Joystick Raw X", oi.driveStick.driveStick.getX());
		SmartDashboard.putNumber("Joystick Raw Y", oi.driveStick.driveStick.getY());
		SmartDashboard.putBoolean("banner", hardware.banner.get());
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
	
	public static void dispNum(String key, double value) {
		SmartDashboard.putNumber(key, value);
	}
}
