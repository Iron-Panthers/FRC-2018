package org.usfirst.frc.team5026.robot.util;

import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;

public class AutoPaths {
	private final Waypoint[] straightPoints = {
			new Waypoint(0,0,0),
			new Waypoint(0,5,0),
			new Waypoint(0,10,0),
	};
	// Units are: Fittype, Samples, dt, vMax, aMax, jMax
	public Trajectory STRAIGHT_PATH;
	public TankModifier straightModifier;
	public EncoderFollower straightLeftFollower;
	public EncoderFollower straightRightFollower;
	
	public AutoPaths() {
		createPaths();
		
	}
	public void createPaths() {
		Trajectory.Config straightConfig = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, 0.02, 10, 20, 5);
		STRAIGHT_PATH = Pathfinder.generate(straightPoints, straightConfig);
	}
	public void constructDrivePaths() {
		straightModifier = new TankModifier(STRAIGHT_PATH).modify(Constants.ROBOT_WIDTH); // Width of robot as parameter
		straightLeftFollower = new EncoderFollower(straightModifier.getLeftTrajectory());
		straightRightFollower = new EncoderFollower(straightModifier.getRightTrajectory());
		straightLeftFollower.configureEncoder(0, Constants.DRIVE_TICKS_PER_REVOLUTION, Constants.WHEEL_DIAMETER);
		straightRightFollower.configureEncoder(0, Constants.DRIVE_TICKS_PER_REVOLUTION, Constants.WHEEL_DIAMETER);
		straightLeftFollower.configurePIDVA(Constants.DRIVE_P, Constants.DRIVE_I, Constants.DRIVE_D, 1 / Constants.DRIVE_VELOCITY, Constants.DRIVE_ACCELERATION);
	}
}
