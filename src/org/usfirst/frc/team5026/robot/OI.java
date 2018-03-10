package org.usfirst.frc.team5026.robot;

import org.usfirst.frc.team5026.robot.commands.conveyorbelt.ConveyorBeltBackward;
import org.usfirst.frc.team5026.robot.commands.conveyorbelt.ConveyorBeltForward;
import org.usfirst.frc.team5026.robot.commands.drive.DriveShift;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorPistonToggle;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorSliding;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToExchange;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToScale;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToShortCube;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToSwitch;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorToTallCube;
import org.usfirst.frc.team5026.robot.commands.elevator.ElevatorZero;
import org.usfirst.frc.team5026.robot.commands.intake.IntakeCommandGroup;
import org.usfirst.frc.team5026.robot.commands.intake.IntakeOuttakeCommand;
import org.usfirst.frc.team5026.robot.util.GoodJoystick;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public GoodJoystick driveStick;
	public Joystick elevatorStick;
	public Button stickBtnOne; //reserved for GoodJoystick
	public Button stickBtnTwo;
	public Button stickBtnThree;
	public Button stickBtnFour;
	public Button stickBtnFive;

	public Button boardBtnZero;
	public Button boardBtnOne;
	public Button boardBtnTwo;
	public Button boardBtnThree;
	public Button boardBtnFour;
	public Button boardBtnFive;
	public Button boardBtnSix;
	public Button boardBtnSeven;
	public Button boardBtnEight;
	public Button boardBtnNine;
	public Button boardBtnTen;
	public Button boardBtnEleven;
	public OI(){
		driveStick = new GoodJoystick(RobotMap.DRIVE_JOYSTICK);
		elevatorStick = new Joystick(RobotMap.ELEVATOR_JOYSTICK);
		stickBtnOne = new JoystickButton(driveStick.driveStick,1);
		stickBtnTwo = new JoystickButton(driveStick.driveStick,2);
		stickBtnThree = new JoystickButton(driveStick.driveStick,3);
		stickBtnFour = new JoystickButton(driveStick.driveStick, 4);
		stickBtnFive = new JoystickButton(driveStick.driveStick, 5);
		
		boardBtnZero = new JoystickButton(elevatorStick, 12);
		boardBtnOne = new JoystickButton(elevatorStick, 1);
		boardBtnTwo = new JoystickButton(elevatorStick, 2);
		boardBtnThree = new JoystickButton(elevatorStick, 3);
		boardBtnFour = new JoystickButton(elevatorStick, 4);
		boardBtnFive = new JoystickButton(elevatorStick, 5);
		boardBtnSix = new JoystickButton(elevatorStick, 6);
		boardBtnSeven = new JoystickButton(elevatorStick, 7);
		boardBtnEight = new JoystickButton(elevatorStick, 8);
		boardBtnNine = new JoystickButton(elevatorStick, 9);
		boardBtnTen = new JoystickButton(elevatorStick, 10);
		boardBtnEleven = new JoystickButton(elevatorStick, 11);

	}
	public void mapButtons(){
//		stickBtnOne.whenPressed(new ReverseDrive());
//		stickBtnOne.whenReleased(new ReverseDrive());
//		stickBtnTwo.whileHeld(new OuttakeCommand());
		stickBtnTwo.toggleWhenPressed(new DriveShift());
		stickBtnThree.whileHeld(new IntakeOuttakeCommand());
		stickBtnFive.whenPressed(new ElevatorZero());
//		stickBtnThree.whileHeld(new ElevatorToScale());
//		stickBtnFour.whileHeld(new ElevatorToGround());

		boardBtnZero.whenPressed(new ElevatorToExchange());
		boardBtnOne.whenPressed(new ElevatorToSwitch());
		boardBtnTwo.whenPressed(new ElevatorToScale());
		boardBtnThree.whenPressed(new ElevatorToShortCube());
		boardBtnFour.whenPressed(new ElevatorToTallCube());
		boardBtnFive.whenPressed(new ElevatorPistonToggle());
		boardBtnSix.whenPressed(new ElevatorSliding());
		boardBtnSeven.whileHeld(new ConveyorBeltForward());
		boardBtnEight.whileHeld(new ConveyorBeltBackward());
		boardBtnNine.whenPressed(new ElevatorZero());
		boardBtnTen.whileHeld(new IntakeCommandGroup());
		boardBtnEleven.whileHeld(new IntakeOuttakeCommand());
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
