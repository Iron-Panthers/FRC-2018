package org.usfirst.frc.team5026.robot.util;

import paths.FastPathPlanner;

public class AutoPaths {
	private static double width = 648, height = 324.5, robotWidth = Constants.ROBOT_WIDTH, robotLength = Constants.ROBOT_LENGTH, switchLength = 38.719, distanceToSwitchFromWall = 85.25, distanceToSwitchFromAlliance = 140, delta = 10, widthOfSwitch = 56;
	private static double[][] CENTER_LEFT_PATH = new double[][]{
		{robotLength/2, height / 2},
		{(distanceToSwitchFromAlliance-robotLength)/2-delta, height/2},
		{(distanceToSwitchFromAlliance-robotLength)/2+delta, height/2+delta},
		{(distanceToSwitchFromAlliance+robotLength)/2+delta, height-distanceToSwitchFromWall-switchLength/2},
		{distanceToSwitchFromAlliance-robotLength/2, height-distanceToSwitchFromWall-switchLength/2}
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
	
	public static FastPathPlanner getLeftPath() {
		if (CENTER_LEFT != null) {
			return CENTER_LEFT;
		}
		CENTER_LEFT = new FastPathPlanner(CENTER_LEFT_PATH);
		CENTER_LEFT.calculate(3, 0.02, Constants.ROBOT_WIDTH);
		return CENTER_LEFT;
	}
	public static FastPathPlanner getRightPath() {
		if (CENTER_RIGHT != null) {
			return CENTER_RIGHT;
		}
		CENTER_RIGHT = new FastPathPlanner(CENTER_RIGHT_PATH);
		CENTER_RIGHT.calculate(3, 0.02, Constants.ROBOT_WIDTH);
		return CENTER_RIGHT;
	}
}
