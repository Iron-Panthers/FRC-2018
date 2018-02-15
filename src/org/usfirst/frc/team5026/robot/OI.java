package org.usfirst.frc.team5026.robot;

import org.usfirst.frc.team5026.robot.commands.IntakeCommandGroup;
import org.usfirst.frc.team5026.robot.commands.OuttakeCommand;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorFindF;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorSetPIDF;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorSliding;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorTarget;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToGround;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToScale;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToSwitch;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorZero;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick driveStick;
	public Joystick elevatorStick;
	public Button stickBtnOne;
	public Button stickBtnTwo;
	public Button stickBtnThree;
	public Button stickBtnFour;
	public Button stickBtnFive;
	public Button boardBtnOne;
	public Button boardBtnTwo;
	public Button boardBtnThree;
	public Button boardBtnFour;
	public Button boardBtnFive;
	public Button boardBtnSix;
	public OI () {
		driveStick = new Joystick(RobotMap.DRIVE_JOYSTICK);
		elevatorStick = new Joystick(RobotMap.ELEVATOR_JOYSTICK);
		stickBtnOne = new JoystickButton(driveStick, 1);
		stickBtnTwo = new JoystickButton(driveStick, 2);
		stickBtnThree = new JoystickButton(driveStick, 3);
		stickBtnFour = new JoystickButton(driveStick, 4);
		stickBtnFive = new JoystickButton(driveStick, 5);
		boardBtnOne = new JoystickButton(elevatorStick, 1);
		boardBtnTwo = new JoystickButton(elevatorStick, 2);
		boardBtnThree = new JoystickButton(elevatorStick, 3);
		boardBtnFour = new JoystickButton(elevatorStick, 4);
		boardBtnFive = new JoystickButton(elevatorStick, 5);
		boardBtnSix = new JoystickButton(elevatorStick, 6);
	}
	public void mapButtons() {
		stickBtnOne.whileHeld(new IntakeCommandGroup());
		stickBtnTwo.whileHeld(new OuttakeCommand());
		stickBtnThree.whileHeld(new ElevatorToScale());
		stickBtnFour.whileHeld(new ElevatorToGround());
		
		boardBtnOne.whileHeld(new ElevatorFindF());
		boardBtnTwo.whileHeld(new ElevatorSliding());
		boardBtnThree.whileHeld(new ElevatorTarget());
		boardBtnFour.whenPressed(new ElevatorSetPIDF());
		boardBtnFive.whenPressed(new ElevatorZero());
		boardBtnSix.whenPressed(new IntakeCommandGroup());
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
