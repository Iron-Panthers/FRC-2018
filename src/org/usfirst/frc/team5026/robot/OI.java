package org.usfirst.frc.team5026.robot;

import org.usfirst.frc.team5026.robot.commands.autonomous.CenterToLeftSwitch;
import org.usfirst.frc.team5026.robot.commands.autonomous.CenterToRightSwitch;
import org.usfirst.frc.team5026.robot.commands.autonomous.CrossAutoLine;
import org.usfirst.frc.team5026.robot.commands.autonomous.DriveStraight;
import org.usfirst.frc.team5026.robot.commands.autonomous.DriveTurn;
import org.usfirst.frc.team5026.robot.commands.drive.ReverseDrive;
import org.usfirst.frc.team5026.robot.commands.drive.ShiftHigh;
import org.usfirst.frc.team5026.robot.commands.drive.ShiftLow;
import org.usfirst.frc.team5026.robot.commands.drive.toggleGearshift;
import org.usfirst.frc.team5026.robot.util.GoodJoystick;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Button stickBtnOne;
	public Button stickBtnTwo;
	public Button stickBtnThree;
	public Button stickBtnFour;
	public Button stickBtnFive;
	public Button stickBtnSeven;
	public Button stickBtnEight;
	public Button stickBtnNine;
	public GoodJoystick joystick;
	public Button stickBtnSix;
	public OI(){
		joystick = new GoodJoystick(RobotMap.DRIVE_JOYSTICK);
		stickBtnOne = new JoystickButton(joystick.driveStick,1);
		stickBtnTwo = new JoystickButton(joystick.driveStick,2);
		stickBtnThree = new JoystickButton(joystick.driveStick,3);
		stickBtnFour = new JoystickButton(joystick.driveStick,4);
		stickBtnFive = new JoystickButton(joystick.driveStick,5);
		stickBtnSix = new JoystickButton(joystick.driveStick,6);
		stickBtnSeven = new JoystickButton(joystick.driveStick, 7);
		stickBtnEight = new JoystickButton(joystick.driveStick,8);
		stickBtnNine = new JoystickButton(joystick.driveStick, 9);
	}
	public void mapButtons(){
//		stickBtnOne.whenPressed(new DriveStraight());
		stickBtnOne.whenPressed(new ReverseDrive());
		stickBtnTwo.whenPressed(new toggleGearshift());
		stickBtnNine.whenPressed(new ShiftLow());
		stickBtnFour.whenPressed(new DriveStraight());
		stickBtnFive.whenPressed(new ShiftHigh());
		stickBtnSeven.whenPressed(new CenterToLeftSwitch());
		stickBtnEight.whenPressed(new CenterToRightSwitch());
		stickBtnThree.whenPressed(new DriveTurn(SmartDashboard.getNumber("gyro target", 60)));
		stickBtnSix.whenPressed(new CrossAutoLine());
//		stickBtnThree.whenPressed(new FindF());
	}
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
