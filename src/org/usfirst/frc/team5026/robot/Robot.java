
package org.usfirst.frc.team5026.robot;

import org.usfirst.frc.team5026.robot.subsystems.Drive;
import org.usfirst.frc.team5026.robot.subsystems.IntakeSubsystem;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static Hardware hardware;
	public static Drive drive;
	public static IntakeSubsystem intake;
	public static UsbCamera cam1;
	public static boolean hasBlock;
	public static double lastVoltage;
	public static double lastCurrent;
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		lastVoltage = 0;
		lastCurrent = 0;
		hasBlock = false;
		CameraServer camera = CameraServer.getInstance(); 
	    cam1 = camera.startAutomaticCapture("cam0", RobotMap.CAMERA_PORT); 
	    cam1.setResolution(Constants.CAMERA_PIXEL_HEIGHT, Constants.CAMERA_PIXEL_WIDTH);
		hardware = new Hardware();
		drive = new Drive(hardware.rightM,hardware.leftM);
		intake = new IntakeSubsystem();
		oi = new OI();
		// chooser.addObject("My Auto", new MyAutoCommand());
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		oi.mapButtons();
		SmartDashboard.putData("Auto mode", chooser);
		LiveWindow.disableAllTelemetry(); 
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

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
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		//SmartDashboard
		//Robot.intake.intake(Robot.oi.driveStick.getY());
		double current = Robot.intake.motor.getOutputCurrent();
		double voltage = Robot.intake.motor.getMotorOutputVoltage();
		//Changes voltage to work around consistent values not showing up on SmartDashboard
//		if(voltage == lastVoltage) {
//			voltage+=0.0001;
//		}
//		if(current == lastCurrent) {
//			current+=Math.round(Math.random());
//		}
//		if (Math.abs(current) < 1) {
//			current = lastCurrent;
//		}
		//Smart Dashbaord Stuff
		SmartDashboard.putNumber("Intake Speed", Robot.intake.motor.getMotorOutputPercent());
		SmartDashboard.putNumber("throttle:", Robot.oi.driveStick.getThrottle());
		SmartDashboard.putNumber("magnitude:", Robot.oi.driveStick.getMagnitude());
		SmartDashboard.putNumber("Intake Power", current*voltage);
		SmartDashboard.putNumber("Intake Voltage", voltage);
		SmartDashboard.putNumber("Intake Current", current);
		SmartDashboard.putNumber("Joystick Y", Robot.oi.driveStick.getY());
		SmartDashboard.putNumber("Joystick X", Robot.oi.driveStick.getX());
		lastVoltage = voltage;
		lastCurrent = current;
		// lastCurrent = current;
		Scheduler.getInstance().run();
		try {
			Thread.sleep(20);
		} catch (Exception e) {
			// yep
		}
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
