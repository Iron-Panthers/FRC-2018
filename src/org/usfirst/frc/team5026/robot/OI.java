package org.usfirst.frc.team5026.robot;

import org.usfirst.frc.team5026.robot.commands.ConditionalINOUT;
import org.usfirst.frc.team5026.robot.commands.InCommand;
import org.usfirst.frc.team5026.robot.commands.InOutAtSetLength;
import org.usfirst.frc.team5026.robot.commands.InOutCommand;
import org.usfirst.frc.team5026.robot.commands.OutAtSetLengthOscillate;
import org.usfirst.frc.team5026.robot.commands.OutCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick driveStick;
	public JoystickButton buttonOne;
	public JoystickButton buttonTwo;
	public JoystickButton buttonThree;
	public JoystickButton buttonFour;
	public JoystickButton buttonFive;
	public JoystickButton special;
	public OI(){
		driveStick = new Joystick(RobotMap.DRIVE_JOYSTICK);
		buttonOne = new JoystickButton(driveStick, 1);
		buttonTwo = new JoystickButton(driveStick, 2);
		buttonThree = new JoystickButton(driveStick, 3);
		buttonFour = new JoystickButton(driveStick, 4);
		buttonFive = new JoystickButton(driveStick, 5);
		special = new JoystickButton(driveStick, 6);
	}
	public void mapButtons(){
		buttonOne.whenPressed(new InCommand());
		buttonTwo.whenPressed(new OutCommand());
		buttonThree.whileHeld(new InOutCommand());
		buttonFour.whileHeld(new InOutAtSetLength());
		buttonFive.whileHeld(new OutAtSetLengthOscillate());
		special.whileHeld(new ConditionalINOUT());
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
