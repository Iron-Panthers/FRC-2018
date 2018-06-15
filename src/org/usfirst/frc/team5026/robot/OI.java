package org.usfirst.frc.team5026.robot;

import org.usfirst.frc.team5026.robot.commands.climb.ClimbDown;
import org.usfirst.frc.team5026.robot.commands.climb.ClimbForTime;
import org.usfirst.frc.team5026.robot.commands.climb.ClimbUp;
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
	public Button stickBtnSix;
	public Button stickBtnSeven;
	public Button stickBtnEight;
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
		driveStick = new GoodJoystick(RobotMap.DRIVE_JOYSTICK);
		elevatorStick = new Joystick(RobotMap.ELEVATOR_JOYSTICK);
		stickBtnOne = new JoystickButton(driveStick.driveStick,1);
		stickBtnTwo = new JoystickButton(driveStick.driveStick,2);
		stickBtnThree = new JoystickButton(driveStick.driveStick,3);
		stickBtnFour = new JoystickButton(driveStick.driveStick, 4);
		stickBtnFive = new JoystickButton(driveStick.driveStick, 5);
		stickBtnSix = new JoystickButton(driveStick.driveStick, 6);
		stickBtnSeven = new JoystickButton(driveStick.driveStick, 7);
		stickBtnEight = new JoystickButton(driveStick.driveStick, 8);
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
//		stickBtnOne.whenPressed(new ReverseDrive());
//		stickBtnOne.whenReleased(new ReverseDrive());
//		stickBtnTwo.whileHeld(new OuttakeCommand());
		stickBtnTwo.toggleWhenPressed(new DriveShift());
		stickBtnThree.whileHeld(new IntakeOuttakeCommand());
		stickBtnFive.whenPressed(new ClimbForTime(3.));
//		stickBtnThree.whileHeld(new ElevatorToScale());
//		stickBtnFour.whileHeld(new ElevatorToGround());
		stickBtnSix.whileHeld(new ClimbUp());
		stickBtnFour.whileHeld(new ClimbDown());
//		stickBtnEight.whenPressed(new ClimbCommandGroup());
		
		boardBtnOne.whileHeld(new ElevatorSliding());
		boardBtnTwo.whenPressed(new IntakeCommandGroup());
		boardBtnThree.whileHeld(new IntakeOuttakeCommand());
//		boardBtnFour.whenPressed(new ConveyorBeltForwardToBanner());
		boardBtnFour.whenPressed(new ElevatorZero());
		boardBtnFive.whileHeld(new ConveyorBeltForward());
		boardBtnSix.whileHeld(new ConveyorBeltBackward());
		
		boardBtnSeven.whenPressed(new ElevatorToShortCube());
		boardBtnEight.whenPressed(new ElevatorToTallCube());
		boardBtnNine.whenPressed(new ElevatorToSwitch());
		boardBtnTen.whenPressed(new ElevatorToScale());
		boardBtnEleven.whenPressed(new ElevatorToExchange());
//		boardBtnThree.whileHeld(new ElevatorTarget());
//		boardBtnFour.whenPressed(new ElevatorSetPIDF());
		
//		boardBtnSeven.whileHeld(new OuttakeCommand());
		boardBtnTwelve.whenPressed(new ElevatorPistonToggle());
	}
}
