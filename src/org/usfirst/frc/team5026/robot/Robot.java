/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5026.robot;

import org.usfirst.frc.team5026.robot.commands.autonomous.CenterToLeftSwitch3Cube3;
import org.usfirst.frc.team5026.robot.commands.autonomous.CenterToRightSwitch3Cube3;
import org.usfirst.frc.team5026.robot.commands.autonomous.ChooseStartPosition;
import org.usfirst.frc.team5026.robot.commands.autonomous.DriveStraight;
import org.usfirst.frc.team5026.robot.commands.autonomous.LeftToLeftScale2Cube;
import org.usfirst.frc.team5026.robot.commands.autonomous.PathFollower;
import org.usfirst.frc.team5026.robot.commands.autonomous.sequences.SequenceCenterToSwitch1Cube;
import org.usfirst.frc.team5026.robot.commands.autonomous.sequences.SequenceCenterToSwitch2Cube;
import org.usfirst.frc.team5026.robot.commands.autonomous.sequences.SequenceCenterToSwitch3Cube;
import org.usfirst.frc.team5026.robot.commands.autonomous.sequences.SequenceCenterToSwitch3Cube3;
import org.usfirst.frc.team5026.robot.commands.autonomous.sequences.SequenceLeftToScale;
import org.usfirst.frc.team5026.robot.commands.autonomous.sequences.SequenceLeftToScaleSwitchSide;
import org.usfirst.frc.team5026.robot.commands.autonomous.sequences.SequenceLeftToSwitchNoElevator;
import org.usfirst.frc.team5026.robot.commands.autonomous.sequences.SequenceRightToScale;
import org.usfirst.frc.team5026.robot.commands.autonomous.sequences.SequenceRightToSwitchNoElevator;
import org.usfirst.frc.team5026.robot.commands.autonomous.sequences.SequenceLeftToScale2Cube;

import org.usfirst.frc.team5026.robot.commands.drive.DriveRunLeft;
import org.usfirst.frc.team5026.robot.commands.drive.DriveRunRight;
import org.usfirst.frc.team5026.robot.subsystems.Climb;
import org.usfirst.frc.team5026.robot.commands.autonomous.PathFollower;
import org.usfirst.frc.team5026.robot.subsystems.ConveyorBelt;
import org.usfirst.frc.team5026.robot.subsystems.Drive;
import org.usfirst.frc.team5026.robot.subsystems.Elevator;
import org.usfirst.frc.team5026.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team5026.robot.util.AutoPaths;
import org.usfirst.frc.team5026.robot.util.Constants;
import org.usfirst.frc.team5026.robot.util.StartPosition;

import com.ctre.phoenix.motorcontrol.ControlMode;

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
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static Hardware hardware;
	public static Drive drive;
	public static Climb climb;
	public static ConveyorBelt conveyor;
	public static IntakeSubsystem intake;
	public static Elevator elevator;
	public static UsbCamera cam1;
	public static UsbCamera cam2;
	Command autoCommand;
	SendableChooser<Command> autoChooser = new SendableChooser<>();
	SendableChooser<ChooseStartPosition> startPositionSelector = new SendableChooser<>(); 
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		hardware = new Hardware();
		hardware.rightM1.configOpenloopRamp(0, Constants.kTimeoutMs);
		hardware.leftM1.configOpenloopRamp(0, Constants.kTimeoutMs);
		drive = new Drive(hardware.left, hardware.right, hardware.gearShift);
//		drive = new Drive(hardware.leftTalonSR, hardware.rightTalonSR, hardware.gearShift);
		climb = new Climb();
		intake = new IntakeSubsystem();
		elevator = new Elevator();
		conveyor = new ConveyorBelt();
		oi = new OI();
		//Camera Stuff
		CameraServer camera = CameraServer.getInstance();
	    cam1 = camera.startAutomaticCapture("cam0", RobotMap.CAMERA_PORT);
	    cam1.setResolution(Constants.CAMERA_PIXEL_HEIGHT, Constants.CAMERA_PIXEL_WIDTH);
	    CameraServer camera2 = CameraServer.getInstance();
	    cam2 = camera2.startAutomaticCapture("cam1", RobotMap.CAMERA_PORT_2);
	    cam2.setResolution(Constants.CAMERA_PIXEL_HEIGHT, Constants.CAMERA_PIXEL_WIDTH);
//		right.setInverted(Constants.IS_RIGHT_INVERTED);
		// autoChooser.addObject("My Auto", new MyAutoCommand());
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
		autoChooser.addObject("Center to Switch", new SequenceCenterToSwitch1Cube());
		autoChooser.addObject("Center to Switch 2 Cube", new SequenceCenterToSwitch2Cube());
		autoChooser.addObject("Center to Switch 3 Cube", new SequenceCenterToSwitch3Cube());
//		autoChooser.addObject("Center to Switch 3 Cube 2 Left", new CenterToLeftSwitch3Cube2());
		autoChooser.addObject("Center to Switch 3 Cube 3 Left", new CenterToLeftSwitch3Cube3());
		autoChooser.addObject("Center to Switch 3 Cube 3 Right", new CenterToRightSwitch3Cube3());
		autoChooser.addObject("Center to Switch 3 Cube 3", new SequenceCenterToSwitch3Cube3());
		autoChooser.addObject("Left to Scale 1/1", new SequenceLeftToScaleSwitchSide());
		autoChooser.addObject("Left to Switch No Elevator", new SequenceLeftToSwitchNoElevator());
		autoChooser.addObject("Right to Switch No Elevator", new SequenceRightToSwitchNoElevator());
		autoChooser.addObject("Left to Scale", new SequenceLeftToScale());
		autoChooser.addObject("Right to Scale", new SequenceRightToScale());
		autoChooser.addObject("Left to Scale 2 Cube", new SequenceLeftToScale2Cube());
		autoChooser.addObject("Drive Turn for Left", new DriveRunLeft(-0.7, 0.5));
		autoChooser.addObject("Drive Turn for Right", new DriveRunRight(-0.7, 0.5));
//		autoChooser.addObject("Left to Scale (Prioritizes Switch)", new SequenceLeftToScaleSwitchSide());
//		autoChooser.addObject("Right to Switch", new SequenceRightToScaleSwitchSide());
//		autoChooser.addObject("Left to Switch 2 Cube", new SequenceLeftToSwitch2Cube());
//		autoChooser.addObject("Left to Scale SwitchSide", new SequenceLeftToScaleSwitchSide());
//		autoChooser.addObject("Right to Scale SwitchSide", new SequenceRightToScaleSwitchSide());
		startPositionSelector.addDefault("Center", new ChooseStartPosition(StartPosition.CENTER));
		startPositionSelector.addObject("Left", new ChooseStartPosition(StartPosition.LEFT));
		startPositionSelector.addObject("Right", new ChooseStartPosition(StartPosition.RIGHT));
		SmartDashboard.putNumber("target", 100);
		SmartDashboard.putNumber("max count", 50);
		SmartDashboard.putNumber("tolerance", 69);
		SmartDashboard.putNumber("Path Planning F", Constants.PATHING_F);
		SmartDashboard.putNumber("Path Planning P", Constants.PATHING_P);
		SmartDashboard.putNumber("Path Planning I", Constants.PATHING_I);
		SmartDashboard.putNumber("Path Planning D", Constants.PATHING_D);
		SmartDashboard.putData("Auto mode", autoChooser);
		SmartDashboard.putData("Starting Position", startPositionSelector);
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
		if (autoCommand != null) {
			autoCommand.cancel();
		}
		drive.setupCoastMode();
	}

	@Override
	public void disabledPeriodic() {
//		startPositionSelector.getSelected().setRunWhenDisabled(true);
//		startPositionSelector.getSelected().start();
//		Scheduler.getInstance().run();
//		try {
//			if (startPositionSelector.getSelected().chooser.getSelected().choice != null) {
//				SmartDashboard.putString("Selected autonomous mode", startPositionSelector.getSelected().chooser.getSelected().choice.toString());
//			}
//		} catch (NullPointerException e) {
//			// Just continue on with life
//		}
		SmartDashboard.putBoolean("Elevator Closed?", !hardware.elevatorLimit.get());
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
		Robot.elevator.motors.motor1.setSelectedSensorPosition(Robot.elevator.motors.motor1.getSelectedSensorPosition(Constants.kPIDLoopIdx), Constants.kPIDLoopIdx, Constants.kTimeoutMs);
		Robot.elevator.motors.motor1.set(ControlMode.Disabled, 1);
		hardware.rightM1.configOpenloopRamp(Constants.AUTO_RAMP_RATE, Constants.kTimeoutMs);
		hardware.leftM1.configOpenloopRamp(Constants.AUTO_RAMP_RATE, Constants.kTimeoutMs);
		drive.setupBrakeMode();
		
		autoCommand = autoChooser.getSelected();
//		autoCommand = startPositionSelector.getSelected().chooser.getSelected().choice;

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
		Robot.elevator.motors.motor1.set(ControlMode.Disabled, 1);
//		hardware.rightM1.configOpenloopRamp(Constants.DRIVE_RAMP_RATE, Constants.kTimeoutMs);
//		hardware.leftM1.configOpenloopRamp(Constants.DRIVE_RAMP_RATE, Constants.kTimeoutMs);
		hardware.rightM1.configOpenloopRamp(0, Constants.kTimeoutMs);
		hardware.leftM1.configOpenloopRamp(0, Constants.kTimeoutMs);
		drive.setupBrakeMode();

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
    	SmartDashboard.putString("Elevator Direction", Robot.elevator.getElevatorDirection().name());
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
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		SmartDashboard.putNumber("Drive Left Encoder Reading", Robot.drive.getLeftEncoderPosition());
		SmartDashboard.putNumber("Drive Right Encoder Reading", Robot.drive.getRightEncoderPosition());
	}
	
	public static void dispNum(String key, double value) {
		SmartDashboard.putNumber(key, value);
	}
}
