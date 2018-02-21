package org.usfirst.frc.team5026.robot.util;

import scadlib.paths.FastPathPlanner;

public class AutoPaths {
	private static double width = 648;
	private static double height = 324.5;
	private static double robotWidth = Constants.ROBOT_WIDTH;
	private static double robotLength = Constants.ROBOT_LENGTH;
	private static double switchLength = 38.719;
	private static double distanceToSwitchFromWall = 85.25;
	private static double distanceToSwitchFromAlliance = 140;
	private static double delta = 10;
	private static double widthOfSwitch = 56;
	private static double xDelta = 10;
	private static double yDelta = 0;
	
	private static double[][] CENTER_LEFT_PATH = new double[][]{
		{robotLength/2, height / 2},
		{(distanceToSwitchFromAlliance-robotLength)/2-delta-xDelta, height/2},
		{(distanceToSwitchFromAlliance-robotLength)/2+delta-xDelta, height/2+delta},
		{(distanceToSwitchFromAlliance+robotLength)/2+delta-xDelta, height-distanceToSwitchFromWall-switchLength/2+yDelta},
		{distanceToSwitchFromAlliance-robotLength/2, height-distanceToSwitchFromWall-switchLength/2+yDelta}
	};
	private static double[][] CENTER_RIGHT_PATH = new double[][]{
		{robotLength/2, height/2},
		{robotLength/2+delta, height/2},
		{(distanceToSwitchFromAlliance-robotLength)/2+delta, height/2-2*delta},
		{(distanceToSwitchFromAlliance+robotLength)/2-delta, distanceToSwitchFromWall+switchLength/2+delta},
		{(distanceToSwitchFromAlliance+robotLength)/2+delta, distanceToSwitchFromWall+switchLength/2},
		{distanceToSwitchFromAlliance-robotLength/2, distanceToSwitchFromWall+switchLength/2}
	};
	
	private static FastPathPlanner CENTER_LEFT;
	private static FastPathPlanner CENTER_RIGHT;
	
	public static PlatformState ALLY_SWITCH_STATE = PlatformState.UNKNOWN;
	public static PlatformState SCALE_STATE = PlatformState.UNKNOWN;
	public static PlatformState ENEMY_SWITCH_STATE = PlatformState.UNKNOWN;
	
	public static FastPathPlanner getLeftPath() {
		if (CENTER_LEFT != null) {
			return CENTER_LEFT;
		}
		CENTER_LEFT = new FastPathPlanner(CENTER_LEFT_PATH);
		CENTER_LEFT.calculate(5, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
		CENTER_LEFT.getLeftArclength();
		CENTER_LEFT.getRightArclength();
		return CENTER_LEFT;
	}
	public static FastPathPlanner getRightPath() {
		if (CENTER_RIGHT != null) {
			return CENTER_RIGHT;
		}
		CENTER_RIGHT = new FastPathPlanner(CENTER_RIGHT_PATH);
		CENTER_RIGHT.calculate(5, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
		CENTER_RIGHT.getLeftArclength();
		CENTER_RIGHT.getRightArclength();
		return CENTER_RIGHT;
	}
	public static final void updateData(String gameMessage) {
		if (gameMessage.length() <= 2) {
			// This should never happen!
			System.out.println("Game message not found!");
			return;
		}
		ALLY_SWITCH_STATE = gameMessage.charAt(0) == 'L' || gameMessage.charAt(0) == 'l' ? PlatformState.LEFT : PlatformState.RIGHT;
		SCALE_STATE = gameMessage.charAt(1) == 'L' || gameMessage.charAt(1) == 'l' ? PlatformState.LEFT : PlatformState.RIGHT;
		ENEMY_SWITCH_STATE = gameMessage.charAt(2) == 'L' || gameMessage.charAt(2) == 'l' ? PlatformState.LEFT : PlatformState.RIGHT;
	}
}
