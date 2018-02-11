/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5026.robot;

import org.usfirst.frc.team5026.robot.subsystems.Elevator;
import org.usfirst.frc.team5026.robot.util.Constants;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
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
	public static UsbCamera cam1;
	public static Elevator elevator;
	public static CvSink cvsink1;
	public static VideoSink server;
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		startCamera();
		hardware = new Hardware();
		elevator = new Elevator();
		oi = new OI();
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		SmartDashboard.putNumber("Elevator Percent", 0.25); // TODO to remove later
		SmartDashboard.putNumber("Elevator F", 0); // TODO to remove later
		SmartDashboard.putNumber("Elevator Target", 1000); // TODO to remove later
		oi.mapButtons();
		LiveWindow.disableAllTelemetry();
    }
	private static void startCamera() {
		CameraServer camera = CameraServer.getInstance();
		cam1 = camera.startAutomaticCapture("cam0", RobotMap.CAMERA_PORT);
		cam1.setResolution(Constants.CAMERA_PIXEL_HEIGHT, Constants.CAMERA_PIXEL_WIDTH);
		server = camera.getServer();
		cvsink1 = new CvSink("cam1cv");
		cvsink1.setSource(cam1);
		cvsink1.setEnabled(true);
	}
	

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		hardware.elevatorMotor.setSelectedSensorPosition(0, 0, 0);
		System.out.println(hardware.elevatorMotor.getSelectedSensorPosition(0));
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
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
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		SmartDashboard.putNumber("Encoder Position", hardware.elevatorMotor.getSelectedSensorPosition(0));
		Scheduler.getInstance().run();
		try {
			Thread.sleep(20);
		} catch (Exception e) {
			// yep
		}
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
