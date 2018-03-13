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
		{121.375, 219.8905},
		{119.0, 219.8905},
		{105.20898876404493, 217.2905604719764},
		{88.4629213483146, 206.1229105211406},
		{75.72134831460673, 199.1032448377581},
		{67.71235955056179, 198.78416912487708},
	};
	
	private static double[][] CENTER_LEFT_GRAB = new double[][]{
		{113.58202247191011, 178.36332350049165},
		{106.66516853932583, 185.70206489675516},
		{96.10786516853932, 191.76450344149458},
		{85.18651685393257, 196.2315634218289},
		{75.72134831460673, 199.1032448377581},
		{67.71235955056179, 198.78416912487708},
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
		{121.375, 104.6095},
		{119.0, 104.6095},
		{105.20898876404493, 107.20943952802361},
		{88.4629213483146, 118.3770894788594},
		{75.72134831460673, 125.3967551622419},
		{67.71235955056179, 125.71583087512292},
	};
	
	private static double[][] CENTER_RIGHT_GRAB = new double[][]{
		{103.41369863013699, 139.07142857142858},
		{96.10786516853932, 132.73549655850542},
		{85.18651685393257, 128.2684365781711},
		{75.72134831460673, 125.3967551622419},
		{67.71235955056179, 125.71583087512292},
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
		{72.78904109589041, 282.154532967033},
		{112.29041095890412, 281.26304945054943},
		{168.65753424657535, 285.72046703296706},
		{194.4, 281.26304945054943},
		{213.041095890411, 268.7822802197802},
		{223.69315068493154, 253.62706043956044},
		{229.01917808219181, 225.99107142857144},
		{232.56986301369867, 174.28502747252747},
		{229.01917808219181, 134.16826923076923},
		{228.1315068493151, 100.2918956043956},
		{232.56986301369867, 85.13667582417582},
		{245.88493150684934, 72.6559065934066},
		{261.86301369863014, 66.41552197802199},
		{289.38082191780825, 70.87293956043956},
	};
	
	private static double[][] LEFT_SCALE_RIGHT_START = new double[][]{
		{18.625, 42.565},
		{34.0, 42.565},
		{72.78904109589041, 42.34546703296701},
		{112.29041095890412, 43.23695054945057},
		{168.65753424657535, 38.779532967032935},
		{194.4, 43.23695054945057},
		{213.041095890411, 55.717719780219795},
		{223.69315068493154, 70.87293956043956},
		{229.01917808219181, 98.50892857142856},
		{232.56986301369867, 150.21497252747253},
		{229.01917808219181, 190.33173076923077},
		{228.1315068493151, 224.20810439560438},
		{232.56986301369867, 239.36332417582418},
		{245.88493150684934, 251.8440934065934},
		{261.86301369863014, 258.08447802197804},
		{289.38082191780825, 253.62706043956044},
	};
	
	private static FastPathPlanner BACKUP;
	
	// Switch Auto Modes
	private static FastPathPlanner CENTER_LEFT;
	private static FastPathPlanner CENTER_RIGHT;
	private static FastPathPlanner LEFT_LEFT;
	private static FastPathPlanner RIGHT_RIGHT;
	
	private static FastPathPlanner[] CENTER_LEFT_SWITCH_2_CUBE;
	private static FastPathPlanner[] CENTER_RIGHT_SWITCH_2_CUBE;
	private static FastPathPlanner[] LEFT_LEFT_2;
	private static FastPathPlanner[] RIGHT_RIGHT_2;
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
	
	public static FastPathPlanner getReverseOffScale() {
		if (BACKUP == null) {
			BACKUP = new FastPathPlanner(new double[][]{{0,0},{-10,0}});
			BACKUP.calculate(1, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			BACKUP.getLeftArclength();
			BACKUP.getRightArclength();
			reverseAndFlipPath(BACKUP);
		}
		return BACKUP;
	}
	
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
			FastPathPlanner goBackFromCube = new FastPathPlanner(CENTER_LEFT_GRAB);
			FastPathPlanner goBack = new FastPathPlanner(CENTER_LEFT_TURNBACK);
			
			fpp.calculate(3.2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			stage2.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			grabCube.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			goBackFromCube.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			goBack.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			
			reverseAndFlipPath(stage2);
			flipPath(grabCube);
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
			FastPathPlanner goBackFromCube = new FastPathPlanner(CENTER_RIGHT_GRAB);
			FastPathPlanner goBack = new FastPathPlanner(CENTER_RIGHT_TURNBACK);
			
			fpp.calculate(3.2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			stage2.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			grabCube.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			goBackFromCube.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			goBack.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			
			reverseAndFlipPath(stage2);
			flipPath(grabCube);
			reverseAndFlipPath(goBackFromCube);
//			flipPath(goBack);
			
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
		LEFT_SCALE_LEFT_START_PATH_SWITCH.calculate(8, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
		LEFT_SCALE_LEFT_START_PATH_SWITCH.getLeftArclength();
		LEFT_SCALE_LEFT_START_PATH_SWITCH.getRightArclength();
		return LEFT_SCALE_LEFT_START_PATH_SWITCH;
	}
	
	public static FastPathPlanner getRightStartingRightScaleSwitchPath() {
		if (RIGHT_SCALE_RIGHT_START_PATH_SWITCH != null) {
			return RIGHT_SCALE_RIGHT_START_PATH_SWITCH;
		}
		RIGHT_SCALE_RIGHT_START_PATH_SWITCH = new FastPathPlanner(RIGHT_SCALE_RIGHT_START_SWITCH);
		RIGHT_SCALE_RIGHT_START_PATH_SWITCH.calculate(8, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
		RIGHT_SCALE_RIGHT_START_PATH_SWITCH.getLeftArclength();
		RIGHT_SCALE_RIGHT_START_PATH_SWITCH.getRightArclength();
		return RIGHT_SCALE_RIGHT_START_PATH_SWITCH;
	}
	
	public static FastPathPlanner getLeftStartingRightScalePath() {
		if (RIGHT_SCALE_LEFT_START_PATH != null) {
			return RIGHT_SCALE_LEFT_START_PATH;
		}
		RIGHT_SCALE_LEFT_START_PATH = new FastPathPlanner(RIGHT_SCALE_LEFT_START);
		RIGHT_SCALE_LEFT_START_PATH.calculate(11, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
		RIGHT_SCALE_LEFT_START_PATH.getLeftArclength();
		RIGHT_SCALE_LEFT_START_PATH.getRightArclength();
		return RIGHT_SCALE_LEFT_START_PATH;
	}
	
	public static FastPathPlanner getRightStartingLeftScalePath() {
		if (LEFT_SCALE_RIGHT_START_PATH != null) {
			return LEFT_SCALE_RIGHT_START_PATH;
		}
		LEFT_SCALE_RIGHT_START_PATH = new FastPathPlanner(LEFT_SCALE_RIGHT_START);
		LEFT_SCALE_RIGHT_START_PATH.calculate(11, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
		LEFT_SCALE_RIGHT_START_PATH.getLeftArclength();
		LEFT_SCALE_RIGHT_START_PATH.getRightArclength();
		return LEFT_SCALE_RIGHT_START_PATH;
	}
	
	public static FastPathPlanner[] getLeftStartingLeftScale2Cube() {
		if (LEFT_START_LEFT_SCALE_2 == null) {
			double[][] leftScaleStartNew = new double[][]{
				{18.625, 281.935},
				{34.0, 281.935},
				{103.41369863013699, 287.5034340659341},
				{160.2246575342466, 289.2864010989011},
				{222.36164383561646, 286.61195054945057},
				{255.20547945205482, 279.03434065934067},
				{272.0712328767124, 272.79395604395603},
				{289.8246575342466, 260.3131868131868},
			};
			
			double[][] leftScaleBackup = new double[][]{
				{289.8246575342466, 260.3131868131868},
				{272.0712328767124, 272.79395604395603},
				{259.64383561643837, 273.2396978021978},
				{242.77808219178084, 275.91414835164835},
				{229.46301369863016, 283.0460164835165},
				{226.8, 294.6353021978022},
			};
			
			double[][] leftScaleGrabCube = new double[][]{
				{226.8, 294.6353021978022},
				{229.46301369863016, 283.9375},
				{225.0246575342466, 264.3248626373626},
				{210.8219178082192, 242.92925824175825},
			};
			
			FastPathPlanner first = new FastPathPlanner(leftScaleStartNew);
			FastPathPlanner second = new FastPathPlanner(leftScaleBackup);
			FastPathPlanner third = new FastPathPlanner(leftScaleGrabCube);
			FastPathPlanner fourth = new FastPathPlanner(leftScaleGrabCube);
			FastPathPlanner fifth = new FastPathPlanner(leftScaleBackup);
			
			first.calculate(8, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			second.calculate(3, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			third.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			fourth.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			fifth.calculate(3, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);

			reverseAndFlipPath(second);
			reversePath(fourth);
			flipPath(fifth);
			
			LEFT_START_LEFT_SCALE_2 = new FastPathPlanner[]{
				first, second, third, fourth, fifth
			};
		}
		return LEFT_START_LEFT_SCALE_2;
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
	
	public static FastPathPlanner[] getLeftStartingLeftSwitch2Cube() {
		if (LEFT_LEFT_2 == null) {
			double[][] leftSwitchStart = new double[][]{
				{18.625, 281.935},
				{28.625, 281.935},
				{75.0082191780822, 294.6353021978022},
				{105.18904109589042, 296.4182692307692},
				{141.58356164383562, 290.17788461538464},
				{159.33698630136988, 275.91414835164835},
				{168.0, 260.875},
				{168.0, 257.875},
			};
			
			double[][] leftSwitchStartBackup = new double[][]{
				{168.0, 257.875},
				{168.0, 260.875},
				{169.98904109589043, 274.5769230769231},
				{176.2027397260274, 284.38324175824175},
				{198.39452054794523, 292.4065934065934},
				{203.7205479452055, 296.864010989011},
				{207.27123287671236, 305.77884615384613},
			};
			
			double[][] leftSwitchStartGrabCube = new double[][]{
				{207.27123287671236, 305.77884615384613},
				{203.7205479452055, 296.864010989011},
				{206.38356164383563, 289.7321428571429},
				{206.38356164383563, 285.27472527472526},
				{209.93424657534248, 275.4684065934066},
				{217.0356164383562, 266.55357142857144},
				{209.0465753424658, 244.26648351648353},
			};
			
			double[][] leftSwitchStartInvert = new double[][]{
				{207.27123287671236, 305.77884615384613},
				{203.7205479452055, 296.864010989011},
				{198.39452054794523, 292.4065934065934},
				{176.2027397260274, 284.38324175824175},
				{169.98904109589043, 274.5769230769231},
				{168.0, 260.875},
				{168.0, 257.875},
			};
			FastPathPlanner fpp = new FastPathPlanner(leftSwitchStart);
			FastPathPlanner stage2 = new FastPathPlanner(leftSwitchStartBackup); // This path should have left and right inverted and negative!
			FastPathPlanner grabCube = new FastPathPlanner(leftSwitchStartGrabCube);
			FastPathPlanner goBackFromCube = new FastPathPlanner(leftSwitchStartGrabCube);
			FastPathPlanner goBack = new FastPathPlanner(leftSwitchStartInvert);
			
			fpp.calculate(5, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			stage2.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			grabCube.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			goBackFromCube.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			goBack.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			
			reverseAndFlipPath(stage2);
			flipPath(goBackFromCube);
//			flipPath(goBack);
			
			LEFT_LEFT_2 = new FastPathPlanner[]{
					fpp, stage2, grabCube, goBackFromCube, goBack
			};
			
			for (FastPathPlanner p: LEFT_LEFT_2) {
				p.getLeftArclength();
				p.getRightArclength();
			}
		}
		return LEFT_LEFT_2;
	}
	
	public static FastPathPlanner[] getRightStartingRightSwitch2Cube() {
		if (RIGHT_RIGHT_2 == null) {
			double[][] rightSwitchStart = new double[][]{
				{18.625, 42.565},
				{28.625, 42.565},
				{75.0082191780822, 29.86469780219778},
				{105.18904109589042, 28.081730769230774},
				{141.58356164383562, 34.32211538461536},
				{159.33698630136988, 48.58585164835165},
				{168.0, 63.625},
				{168.0, 66.625},
			};
			
			double[][] rightSwitchStartBackup = new double[][]{
				{168.0, 66.625},
				{168.0, 63.625},
				{169.98904109589043, 49.923076923076906},
				{176.2027397260274, 40.11675824175825},
				{198.39452054794523, 32.0934065934066},
				{203.7205479452055, 27.63598901098902},
				{207.27123287671236, 18.721153846153868},
			};
			
			double[][] rightSwitchStartGrabCube = new double[][]{
				{207.27123287671236, 18.721153846153868},
				{203.7205479452055, 27.63598901098902},
				{206.38356164383563, 34.76785714285711},
				{206.38356164383563, 39.225274725274744},
				{209.93424657534248, 49.0315934065934},
				{217.0356164383562, 57.946428571428555},
				{209.0465753424658, 80.23351648351647},
			};
			
			double[][] rightSwitchStartInvert = new double[][]{
				{207.27123287671236, 18.721153846153868},
				{203.7205479452055, 27.63598901098902},
				{198.39452054794523, 32.0934065934066},
				{176.2027397260274, 40.11675824175825},
				{169.98904109589043, 49.923076923076906},
				{168.0, 63.625},
				{168.0, 66.625},
			};
			
			FastPathPlanner fpp = new FastPathPlanner(rightSwitchStart);
			FastPathPlanner stage2 = new FastPathPlanner(rightSwitchStartBackup); // This path should have left and right inverted and negative!
			FastPathPlanner grabCube = new FastPathPlanner(rightSwitchStartGrabCube);
			FastPathPlanner goBackFromCube = new FastPathPlanner(rightSwitchStartGrabCube);
			FastPathPlanner goBack = new FastPathPlanner(rightSwitchStartInvert);
			
			fpp.calculate(5, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			stage2.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			grabCube.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			goBackFromCube.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			goBack.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			
			reverseAndFlipPath(stage2);
			flipPath(goBackFromCube);
//			flipPath(goBack);
			
			RIGHT_RIGHT_2 = new FastPathPlanner[]{
					fpp, stage2, grabCube, goBackFromCube, goBack
			};
			
			for (FastPathPlanner p: RIGHT_RIGHT_2) {
				p.getLeftArclength();
				p.getRightArclength();
			}
		}
		return RIGHT_RIGHT_2;
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
		flipPath(path);
		reversePath(path);
	}
	public static void reversePath(FastPathPlanner path) {
		for (int i=0; i < path.smoothLeftVelocity.length; i++) {
			path.smoothRightVelocity[i][1] = -path.smoothRightVelocity[i][1];
			path.smoothLeftVelocity[i][1] = -path.smoothLeftVelocity[i][1];
			path.smoothCenterVelocity[i][1] = -path.smoothCenterVelocity[i][1];
		}
//		for (int i=0; i < path.smoothLeftVelocity.length; i++) {
//			double temp = -path.smoothRightVelocity[i][1];
//			path.smoothRightVelocity[i][1] = -path.smoothLeftVelocity[i][1];
//			path.smoothLeftVelocity[i][1] = temp;
//			path.smoothCenterVelocity[i][1] = -path.smoothCenterVelocity[i][1];
//		}
	}
	public static void flipPath(FastPathPlanner path) {
		double[][] tempArr = path.rightPath;
		path.rightPath = path.leftPath;
		path.leftPath = tempArr;
		double[][] temp = path.smoothLeftVelocity;
		path.smoothLeftVelocity = path.smoothRightVelocity;
		path.smoothRightVelocity = temp;
		
//		 THIS IS A HACK! TODO REMOVE ME REMOVE ME
//		for (int i = 0; i < path.nodeOnlyPath.length; i++) {
//			path.nodeOnlyPath[i][0] = -path.nodeOnlyPath[i][0];
//		}
	}
}
