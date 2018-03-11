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
	private static double distanceToScaleFromAlliance = 299.65;
	private static double distanceToScaleFromWall = 71.57;
	private static double scalePlatformLength = 36;
	private static double portalY = 29.69;
	private static double delta = 10;
	private static double widthOfSwitch = 56;
	private static double xDelta = 10;
	private static double yDelta = 0;
	private static double scaleYDelta = 8;
	
	private static double stage2x1 = 5;
	private static double stage2y1 = 2;
	private static double stage2x2 = 10;
	private static double stage2y2 = 10;
	private static double stage2y3 = 15;
	private static double stage2y4 = 40;
	
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
	
	private static double[][] CENTER_LEFT_TURNBACK = new double[][]{
		{distanceToSwitchFromAlliance-robotLength/2, height-distanceToSwitchFromWall-switchLength/2+yDelta},
		{distanceToSwitchFromAlliance-robotLength/2-stage2x1, height-distanceToSwitchFromWall-switchLength/2+yDelta+stage2y1},
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, height-distanceToSwitchFromWall-switchLength/2+yDelta+stage2y2},
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, height-distanceToSwitchFromWall-switchLength/2+yDelta+stage2y3},
	};
	
	private static double[][] CENTER_LEFT_GRAB = new double[][]{
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, height-distanceToSwitchFromWall-switchLength/2+yDelta+stage2y3},
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, height-distanceToSwitchFromWall-switchLength/2+yDelta-stage2y3}
	};
	
	private static double[][] CENTER_LEFT_REVERSE = new double[][]{
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, height-distanceToSwitchFromWall-switchLength/2+yDelta-stage2y3},
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, height-distanceToSwitchFromWall-switchLength/2+yDelta+stage2y3}
	};
	
	private static double[][] CENTER_LEFT_TURNTO = new double[][]{
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, height-distanceToSwitchFromWall-switchLength/2+yDelta+stage2y3},
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, height-distanceToSwitchFromWall-switchLength/2+yDelta+stage2y2},
		{distanceToSwitchFromAlliance-robotLength/2-stage2x1, height-distanceToSwitchFromWall-switchLength/2+yDelta+stage2y1},
		{distanceToSwitchFromAlliance-robotLength/2, height-distanceToSwitchFromWall-switchLength/2+yDelta},
	};
	
	private static double[][] LEFT_LEFT_SWITCH = new double[][]{
		{robotLength/2, height-portalY-robotWidth/2},
		{robotLength/2+10, height-portalY-robotWidth/2},
		{robotLength/2+80, height-portalY-robotWidth/2},
		{distanceToSwitchFromAlliance+widthOfSwitch/2-15, height-distanceToSwitchFromWall+robotLength/2+23},
		{distanceToSwitchFromAlliance+widthOfSwitch/2-7, height-distanceToSwitchFromWall+robotLength/2+18},
		{distanceToSwitchFromAlliance+widthOfSwitch/2-2, height-distanceToSwitchFromWall+robotLength/2+10},
		{distanceToSwitchFromAlliance+widthOfSwitch/2, height-distanceToSwitchFromWall+robotLength/2+3},
		{distanceToSwitchFromAlliance+widthOfSwitch/2, height-distanceToSwitchFromWall+robotLength/2},
		{distanceToSwitchFromAlliance+widthOfSwitch/2, height-distanceToSwitchFromWall+robotLength/2-5},
	};

	private static double[][] CENTER_RIGHT_TURNBACK = new double[][]{
		{distanceToSwitchFromAlliance-robotLength/2, distanceToSwitchFromWall+switchLength/2-yDelta},
		{distanceToSwitchFromAlliance-robotLength/2-stage2x1, distanceToSwitchFromWall+switchLength/2-yDelta-stage2y1},
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, distanceToSwitchFromWall+switchLength/2-yDelta-stage2y2},
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, distanceToSwitchFromWall+switchLength/2-yDelta-stage2y3},
	};
	
	private static double[][] CENTER_RIGHT_GRAB = new double[][]{
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, distanceToSwitchFromWall+switchLength/2-yDelta-stage2y3},
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, distanceToSwitchFromWall+switchLength/2-yDelta+stage2y4}
	};
	
	private static double[][] CENTER_RIGHT_REVERSE = new double[][]{
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, distanceToSwitchFromWall+switchLength/2-yDelta+stage2y4},
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, distanceToSwitchFromWall+switchLength/2-yDelta-stage2y3},
	};
	
	private static double[][] CENTER_RIGHT_TURNTO = new double[][]{
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, distanceToSwitchFromWall+switchLength/2-yDelta-stage2y3},
		{distanceToSwitchFromAlliance-robotLength/2-stage2x2, distanceToSwitchFromWall+switchLength/2-yDelta-stage2y2},
		{distanceToSwitchFromAlliance-robotLength/2-stage2x1, distanceToSwitchFromWall+switchLength/2-yDelta-stage2y1},
		{distanceToSwitchFromAlliance-robotLength/2, distanceToSwitchFromWall+switchLength/2-yDelta},
	};
	
	private static double[][] RIGHT_RIGHT_SWITCH = new double[][]{
		{robotLength/2, portalY+robotWidth/2},
		{robotLength/2+10, portalY+robotWidth/2},
		{robotLength/2+80, portalY+robotWidth/2},
		{distanceToSwitchFromAlliance+widthOfSwitch/2-15, distanceToSwitchFromWall-robotLength/2-23},
		{distanceToSwitchFromAlliance+widthOfSwitch/2-7, distanceToSwitchFromWall-robotLength/2-18},
		{distanceToSwitchFromAlliance+widthOfSwitch/2-2, distanceToSwitchFromWall-robotLength/2-10},
		{distanceToSwitchFromAlliance+widthOfSwitch/2, distanceToSwitchFromWall-robotLength/2-3},
		{distanceToSwitchFromAlliance+widthOfSwitch/2, distanceToSwitchFromWall-robotLength/2},
		{distanceToSwitchFromAlliance+widthOfSwitch/2, distanceToSwitchFromWall-robotLength/2+5},

	};

	private static double[][] LEFT_SCALE_LEFT_START = new double[][]{
		{18.625, 281.935},
		{34.0, 281.935},
		{131.8191780821918, 287.5034340659341},
		{225.0246575342466, 290.17788461538464},
		{309.3534246575343, 295.5267857142857},
		{319.11780821917813, 286.61195054945057},
		{324.0, 272.0},
		{324.0, 266.125},
	};
	
	private static double[][] RIGHT_SCALE_RIGHT_START = new double[][]{
		{18.625, 42.565},
		{40.0, 42.565},
		{121.16712328767125, 33.43063186813187},
		{219.6986301369863, 32.09340659340659},
		{266.74520547945207, 41.89972527472528},
		{289.8246575342466, 53.48901098901099},
		{296.0383561643836, 57.94642857142857},
		{298.7013698630137, 61.512362637362635},
	};
	
	private static double[][] LEFT_SCALE_LEFT_START_SWITCH = new double[][]{
		{18.625, 281.935},
		{34.0, 281.935},
		{103.41369863013699, 287.5034340659341},
		{160.2246575342466, 289.2864010989011},
		{222.36164383561646, 286.61195054945057},
		{252.5424657534247, 281.26304945054943},
		{272.95890410958907, 274.13118131868134},
		{292.4876712328767, 261.6504120879121},
	};
	
	private static double[][] RIGHT_SCALE_RIGHT_START_SWITCH = new double[][]{
		{18.625, 42.565},
		{28.849315068493155, 42.791208791208796},
		{113.17808219178083, 39.67101648351648},
		{194.84383561643838, 41.45398351648352},
		{242.77808219178084, 48.58585164835165},
		{264.0821917808219, 54.82623626373626},
		{283.6109589041096, 61.958104395604394},
		{291.6, 68.19848901098901},
	};
	
	private static double[][] RIGHT_SCALE_LEFT_START = new double[][]{
		{18.625, 281.935},
		{34.0, 281.935},
		{112.29041095890412, 281.26304945054943},
		{194.84383561643838, 275.91414835164835},
		{210.8219178082192, 265.21634615384613},
		{221.47397260273974, 230.89423076923077},
		{225.9123287671233, 134.61401098901098},
		{225.0246575342466, 102.96634615384616},
		{231.2383561643836, 85.13667582417582},
		{242.77808219178084, 77.11332417582418},
		{258.75616438356167, 69.98145604395604},
		{289.8246575342466, 72.6559065934066},
	};
	
	private static double[][] LEFT_SCALE_RIGHT_START = new double[][]{
		{18.625, 42.565},
		{34.0, 42.565},
		{112.29041095890412, 43.23695054945057},
		{194.84383561643838, 48.58585164835165},
		{210.8219178082192, 59.28365384615387},
		{221.47397260273974, 93.60576923076923},
		{225.9123287671233, 189.88598901098902},
		{225.0246575342466, 221.53365384615384},
		{231.2383561643836, 239.36332417582418},
		{242.77808219178084, 247.38667582417582},
		{258.75616438356167, 254.51854395604397},
		{289.8246575342466, 251.8440934065934},
	};
	
	// Switch Auto Modes
	private static FastPathPlanner CENTER_LEFT;
	private static FastPathPlanner CENTER_RIGHT;
	private static FastPathPlanner LEFT_LEFT;
	private static FastPathPlanner RIGHT_RIGHT;
	
	private static FastPathPlanner[] CENTER_LEFT_SWITCH_2_CUBE;
	private static FastPathPlanner[] CENTER_RIGHT_SWITCH_2_CUBE;
	
	// Scale Auto Modes
	private static FastPathPlanner LEFT_SCALE_LEFT_START_PATH;
	private static FastPathPlanner RIGHT_SCALE_RIGHT_START_PATH;
	private static FastPathPlanner LEFT_SCALE_LEFT_START_PATH_SWITCH;
	private static FastPathPlanner RIGHT_SCALE_RIGHT_START_PATH_SWITCH;
	private static FastPathPlanner RIGHT_SCALE_LEFT_START_PATH;
	private static FastPathPlanner LEFT_SCALE_RIGHT_START_PATH;
	
	// States
	public static PlatformState ALLY_SWITCH_STATE = PlatformState.UNKNOWN;
	public static PlatformState SCALE_STATE = PlatformState.UNKNOWN;
	public static PlatformState ENEMY_SWITCH_STATE = PlatformState.UNKNOWN;
	public static StartPosition startPosition = StartPosition.UNKNOWN;
	
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
	
	public static FastPathPlanner[] getLeftSwitch2Cube() {
		if (CENTER_LEFT_SWITCH_2_CUBE == null) {
			FastPathPlanner fpp = new FastPathPlanner(CENTER_LEFT_PATH);
			FastPathPlanner stage2 = new FastPathPlanner(CENTER_LEFT_TURNBACK); // This path should have left and right inverted and negative!
			FastPathPlanner grabCube = new FastPathPlanner(CENTER_LEFT_GRAB);
			FastPathPlanner goBackFromCube = new FastPathPlanner(CENTER_LEFT_REVERSE);
			FastPathPlanner goBack = new FastPathPlanner(CENTER_LEFT_TURNTO);
			
			fpp.calculate(3.2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			stage2.calculate(1, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			grabCube.calculate(1, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			goBackFromCube.calculate(1, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			goBack.calculate(1, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			
			reverseAndFlipPath(stage2);
			reverseAndFlipPath(goBackFromCube);

			CENTER_LEFT_SWITCH_2_CUBE = new FastPathPlanner[] {
					fpp, stage2, grabCube, goBackFromCube, goBack
			};
			
			for (FastPathPlanner p: CENTER_LEFT_SWITCH_2_CUBE) {
				p.getLeftArclength();
				p.getRightArclength();
			}
		}
		return CENTER_LEFT_SWITCH_2_CUBE;
	}
	
	public static FastPathPlanner[] getRightSwitch2Cube() {
		if (CENTER_RIGHT_SWITCH_2_CUBE == null) {
			FastPathPlanner fpp = new FastPathPlanner(CENTER_RIGHT_PATH);
			FastPathPlanner stage2 = new FastPathPlanner(CENTER_RIGHT_TURNBACK); // This path should have left and right inverted and negative!
			FastPathPlanner grabCube = new FastPathPlanner(CENTER_RIGHT_GRAB);
			FastPathPlanner goBackFromCube = new FastPathPlanner(CENTER_RIGHT_REVERSE);
			FastPathPlanner goBack = new FastPathPlanner(CENTER_RIGHT_TURNTO);
			
			fpp.calculate(3.2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			stage2.calculate(1, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			grabCube.calculate(1, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			goBackFromCube.calculate(1, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			goBack.calculate(1, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			
			reverseAndFlipPath(stage2);
			reverseAndFlipPath(goBackFromCube);
			
			CENTER_RIGHT_SWITCH_2_CUBE = new FastPathPlanner[]{
					fpp, stage2, grabCube, goBackFromCube, goBack
			};
			
			for (FastPathPlanner p: CENTER_RIGHT_SWITCH_2_CUBE) {
				p.getLeftArclength();
				p.getRightArclength();
			}
		}
		return CENTER_RIGHT_SWITCH_2_CUBE;
	}
	
	public static FastPathPlanner getLeftStartingLeftScalePath() {
		if (LEFT_SCALE_LEFT_START_PATH != null) {
			return LEFT_SCALE_LEFT_START_PATH;
		}
		LEFT_SCALE_LEFT_START_PATH = new FastPathPlanner(LEFT_SCALE_LEFT_START);
		LEFT_SCALE_LEFT_START_PATH.calculate(8, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
		LEFT_SCALE_LEFT_START_PATH.getLeftArclength();
		LEFT_SCALE_LEFT_START_PATH.getRightArclength();
		return LEFT_SCALE_LEFT_START_PATH;
	}
	
	public static FastPathPlanner getRightStartingRightScalePath() {
		if (RIGHT_SCALE_RIGHT_START_PATH != null) {
			return RIGHT_SCALE_RIGHT_START_PATH;
		}
		RIGHT_SCALE_RIGHT_START_PATH = new FastPathPlanner(RIGHT_SCALE_RIGHT_START);
		RIGHT_SCALE_RIGHT_START_PATH.calculate(8, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
		RIGHT_SCALE_RIGHT_START_PATH.getLeftArclength();
		RIGHT_SCALE_RIGHT_START_PATH.getRightArclength();
		return RIGHT_SCALE_RIGHT_START_PATH;
	}
	
	public static FastPathPlanner getLeftStartingLeftScaleSwitchPath() {
		if (LEFT_SCALE_LEFT_START_PATH_SWITCH != null) {
			return LEFT_SCALE_LEFT_START_PATH_SWITCH;
		}
		LEFT_SCALE_LEFT_START_PATH_SWITCH = new FastPathPlanner(LEFT_SCALE_LEFT_START_SWITCH);
		LEFT_SCALE_LEFT_START_PATH_SWITCH.calculate(6, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
		LEFT_SCALE_LEFT_START_PATH_SWITCH.getLeftArclength();
		LEFT_SCALE_LEFT_START_PATH_SWITCH.getRightArclength();
		return LEFT_SCALE_LEFT_START_PATH_SWITCH;
	}
	
	public static FastPathPlanner getRightStartingRightScaleSwitchPath() {
		if (RIGHT_SCALE_RIGHT_START_PATH_SWITCH != null) {
			return RIGHT_SCALE_RIGHT_START_PATH_SWITCH;
		}
		RIGHT_SCALE_RIGHT_START_PATH_SWITCH = new FastPathPlanner(RIGHT_SCALE_RIGHT_START_SWITCH);
		RIGHT_SCALE_RIGHT_START_PATH_SWITCH.calculate(6, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
		RIGHT_SCALE_RIGHT_START_PATH_SWITCH.getLeftArclength();
		RIGHT_SCALE_RIGHT_START_PATH_SWITCH.getRightArclength();
		return RIGHT_SCALE_RIGHT_START_PATH_SWITCH;
	}
	
	public static FastPathPlanner getLeftStartingRightScalePath() {
		if (RIGHT_SCALE_LEFT_START != null) {
			return RIGHT_SCALE_LEFT_START_PATH;
		}
		RIGHT_SCALE_LEFT_START_PATH = new FastPathPlanner(RIGHT_SCALE_LEFT_START);
		RIGHT_SCALE_LEFT_START_PATH.calculate(10, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
		RIGHT_SCALE_LEFT_START_PATH.getLeftArclength();
		RIGHT_SCALE_LEFT_START_PATH.getRightArclength();
		return RIGHT_SCALE_LEFT_START_PATH;
	}
	
	public static FastPathPlanner getRightStartingLeftScalePath() {
		if (LEFT_SCALE_RIGHT_START_PATH != null) {
			return LEFT_SCALE_RIGHT_START_PATH;
		}
		LEFT_SCALE_RIGHT_START_PATH = new FastPathPlanner(LEFT_SCALE_RIGHT_START);
		LEFT_SCALE_RIGHT_START_PATH.calculate(10, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
		LEFT_SCALE_RIGHT_START_PATH.getLeftArclength();
		LEFT_SCALE_RIGHT_START_PATH.getRightArclength();
		return LEFT_SCALE_RIGHT_START_PATH;
	}
	
	public static FastPathPlanner getLeftStartingLeftSwitchPath() {
		if (LEFT_LEFT != null) {
			return LEFT_LEFT;
		}
		LEFT_LEFT = new FastPathPlanner(LEFT_LEFT_SWITCH);
		LEFT_LEFT.calculate(5.8, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
		LEFT_LEFT.getLeftArclength();
		LEFT_LEFT.getRightArclength();
		return LEFT_LEFT;
	}
	
	public static FastPathPlanner getRightStartingRightSwitchPath() {
		if (RIGHT_RIGHT != null) {
			return RIGHT_RIGHT;
		}
		RIGHT_RIGHT = new FastPathPlanner(RIGHT_RIGHT_SWITCH);
		RIGHT_RIGHT.calculate(5.8, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
		RIGHT_RIGHT.getLeftArclength();
		RIGHT_RIGHT.getRightArclength();
		return RIGHT_RIGHT;
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
	
	public static void reverseAndFlipPath(FastPathPlanner path) {
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
	public static void reversePath(FastPathPlanner path) {
		for (int i=0; i < path.smoothLeftVelocity.length; i++) {
			double temp = -path.smoothRightVelocity[i][1];
			path.smoothRightVelocity[i][1] = -path.smoothLeftVelocity[i][1];
			path.smoothLeftVelocity[i][1] = temp;
			path.smoothCenterVelocity[i][1] = -path.smoothCenterVelocity[i][1];
		}
	}
	public static void flipPath(FastPathPlanner path) {
		double[][] tempArr = path.rightPath;
		path.rightPath = path.leftPath;
		path.leftPath = tempArr;
	}
}
