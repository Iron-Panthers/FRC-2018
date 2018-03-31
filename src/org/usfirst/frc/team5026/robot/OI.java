package org.usfirst.frc.team5026.robot;

import org.usfirst.frc.team5026.robot.commands.ReplayPowers;
import org.usfirst.frc.team5026.robot.commands.WritePowers;
import org.usfirst.frc.team5026.robot.util.BetterJoystick;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public BetterJoystick driveStick;
	public Joystick elevatorStick;
	public Button stickBtnOne; //reserved for GoodJoystick
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
	public Button boardBtnSeven;
	public Button boardBtnEight;
	public Button boardBtnNine;
	public Button boardBtnTen;
	public Button boardBtnEleven;
	public Button boardBtnTwelve;
	public OI(){
		driveStick = new BetterJoystick(RobotMap.DRIVE_JOYSTICK);
		elevatorStick = new Joystick(RobotMap.ELEVATOR_JOYSTICK);
		stickBtnOne = new JoystickButton(driveStick.driveStick,1);
		stickBtnTwo = new JoystickButton(driveStick.driveStick,2);
		stickBtnThree = new JoystickButton(driveStick.driveStick,3);
		stickBtnFour = new JoystickButton(driveStick.driveStick, 4);
		stickBtnFive = new JoystickButton(driveStick.driveStick, 5);
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
		boardBtnTwelve = new JoystickButton(elevatorStick, 12);

	}
	public void mapButtons(){
		stickBtnFour.whileHeld(new WritePowers());
		stickBtnFive.whenPressed(new ReplayPowers(false));
		stickBtnThree.whenPressed(new ReplayPowers(true));
		
////		stickBtnTwo.whileHeld(new OuttakeCommand());
//		stickBtnTwo.toggleWhenPressed(new DriveShift());
//		stickBtnThree.whileHeld(new IntakeOuttakeCommand());
//		stickBtnFive.whenPressed(new ElevatorZero());
////		stickBtnThree.whileHeld(new ElevatorToScale());
////		stickBtnFour.whileHeld(new ElevatorToGround());
//		
//		boardBtnOne.whileHeld(new ElevatorSliding());
//		boardBtnTwo.whenPressed(new IntakeCommandGroup());
//		boardBtnThree.whileHeld(new IntakeOuttakeCommand());
////		boardBtnFour.whenPressed(new ConveyorBeltForwardToBanner());
//		boardBtnFour.whenPressed(new ElevatorZero());
//		boardBtnFive.whileHeld(new ConveyorBeltForward());
//		boardBtnSix.whileHeld(new ConveyorBeltBackward());
//		
//		boardBtnSeven.whenPressed(new ElevatorToShortCube());
//		boardBtnEight.whenPressed(new ElevatorToTallCube());
//		boardBtnNine.whenPressed(new ElevatorToSwitch());
//		boardBtnTen.whenPressed(new ElevatorToScale());
//		boardBtnEleven.whenPressed(new ElevatorToExchange());
////		boardBtnThree.whileHeld(new ElevatorTarget());
////		boardBtnFour.whenPressed(new ElevatorSetPIDF());
//		
////		boardBtnSeven.whileHeld(new OuttakeCommand());
//		boardBtnTwelve.whenPressed(new ElevatorPistonToggle());
//	}
//	//// CREATING BUTTONS
//	// One type of button is a joystick button which is any button on a
//	//// joystick.
//	// You create one by telling it which joystick it's on and which button
//	// number it is.
//	// Joystick stick = new Joystick(port);
//	// Button button = new JoystickButton(stick, buttonNumber);
//// There are a few additional built in buttons you can use. Additionally,
//	// by subclassing Button you can create custom triggers and bind those to
//	// commands the same as any other Button.
//
//	//// TRIGGERING COMMANDS WITH BUTTONS
//	// Once you have a button, it's trivial to bind it to a button in one of
//	// three ways:
//
//	// Start the command when the button is pressed and let it run the command
//	// until it is finished as determined by it's isFinished method.
//	// button.whenPressed(new ExampleCommand());
//
//	// Run the command while the button is being held down and interrupt it once
//	// the button is released.
//	// button.whileHeld(new ExampleCommand());
//
//	// Start the command when the button is released and let it run the command
//	// until it is finished as determined by it's isFinished method.
//	// button.whenReleased(new ExampleCommand());
	}
}
