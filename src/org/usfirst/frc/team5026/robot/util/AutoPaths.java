package org.usfirst.frc.team5026.robot.util;

import scadlib.paths.FastPathPlanner;
import scadlib.paths.Point;

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
	
	Point[] frcPath = new Point[]{
			new Point(-23.6, -6.6, 3.5, 1.2, 3, -8.2),
			new Point(-8.65, 5.5, 23.4, 12.8, 2.1, 4.72),
			new Point(28.24, 4.3, -6.9, -3.3, 12.5, 13)
	};
	double vMax = 25;
	Point[] frcPath2 = new Point[]{
			new Point(0, 0, 0, 10, 0),
			new Point(0, 50, vMax, 0, 20),
			new Point(25, 90, vMax, 0, 100),
			new Point(50, 80, vMax, -10, 140),
			new Point(60, 50, 0, 0, 150)
	};
	Point[] frcPath3 = new Point[]{
			new Point(0,0,vMax,0,0),
			new Point(6.25, 12.5, vMax, 0, 90),
			new Point(12.5, 0, vMax, 0, 180),
			new Point(6.25, -12.5, vMax, 0, 270),
			new Point(0,0, vMax, 0, 360)
	};
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
	

	double[][] leftPath = new double[][]{
		{robotLength/2, height / 2},
		{(distanceToSwitchFromAlliance-robotLength)/2-delta-xDelta, height/2},
		{(distanceToSwitchFromAlliance-robotLength)/2+delta-xDelta, height/2+delta},
		{(distanceToSwitchFromAlliance+robotLength)/2+delta-xDelta, height-distanceToSwitchFromWall-switchLength/2+yDelta},
		{distanceToSwitchFromAlliance-robotLength/2, height-distanceToSwitchFromWall-switchLength/2+yDelta}
	};
	
	double stage2x1 = 5;
	double stage2y1 = 2;
	double stage2x2 = 10;
	double stage2y2 = 10;
	double stage2y3 = 15;
	
	double[][] leftTurnBack = new double[][]{
		{distanceToSwitchFromAlliance-robotLength/2, height-distanceToSwitchFromWall-switchLength/2+yDelta},
		{distanceToSwitchFromAlliance-robotLength/2-stage2x1, height-distanceToSwitchFromWall-switchLength/2+yDelta+stage2y1},
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, height-distanceToSwitchFromWall-switchLength/2+yDelta+stage2y2},
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, height-distanceToSwitchFromWall-switchLength/2+yDelta+stage2y3},
	};
	
	double[][] leftGrabCube = new double[][]{
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, height-distanceToSwitchFromWall-switchLength/2+yDelta+stage2y3},
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, height-distanceToSwitchFromWall-switchLength/2+yDelta-stage2y3}
	};
	
	double[][] leftReverseCube = new double[][]{
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, height-distanceToSwitchFromWall-switchLength/2+yDelta-stage2y3},
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, height-distanceToSwitchFromWall-switchLength/2+yDelta+stage2y3}
	};
	
	double[][] leftTurnToSwitch = new double[][]{
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, height-distanceToSwitchFromWall-switchLength/2+yDelta+stage2y3},
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, height-distanceToSwitchFromWall-switchLength/2+yDelta+stage2y2},
		{distanceToSwitchFromAlliance-robotLength/2-stage2x1, height-distanceToSwitchFromWall-switchLength/2+yDelta+stage2y1},
		{distanceToSwitchFromAlliance-robotLength/2, height-distanceToSwitchFromWall-switchLength/2+yDelta},
	};
	
	double[][] rightPath = new double[][]{
		{robotLength/2, height/2},
		{(distanceToSwitchFromAlliance-robotLength)/2-delta-xDelta, height/2},
		{(distanceToSwitchFromAlliance-robotLength)/2+delta-xDelta, height/2-delta},
		{(distanceToSwitchFromAlliance+robotLength)/2+delta-xDelta, distanceToSwitchFromWall+switchLength/2-yDelta},
		{distanceToSwitchFromAlliance-robotLength/2, distanceToSwitchFromWall+switchLength/2-yDelta}
	};
	
	FastPathPlanner fpp = new FastPathPlanner(leftPath);
	FastPathPlanner stage2 = new FastPathPlanner(leftTurnBack); // This path should have left and right inverted and negative!
	FastPathPlanner grabCube = new FastPathPlanner(leftGrabCube);
	FastPathPlanner goBackFromCube = new FastPathPlanner(leftReverseCube);
	FastPathPlanner goBack = new FastPathPlanner(leftTurnToSwitch);
	
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
	
	public static void reversePath(FastPathPlanner path) {
		double[][] tempArr = path.rightPath;
		path.rightPath = path.leftPath;
		path.leftPath = tempArr;
		
		for (int i=0; i < path.smoothLeftVelocity.length; i++) {
			double temp = -path.smoothRightVelocity[i][1];
			path.smoothRightVelocity[i][1] = -path.smoothLeftVelocity[i][1];
			path.smoothLeftVelocity[i][1] = temp;
			path.smoothCenterVelocity[i][1] = -path.smoothCenterVelocity[i][1];
		}
	}

}
