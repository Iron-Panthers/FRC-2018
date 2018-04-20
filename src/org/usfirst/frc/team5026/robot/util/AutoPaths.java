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
		{distanceToSwitchFromAlliance-robotLength/2+5, height-distanceToSwitchFromWall-switchLength/2+yDelta}
	};
	private static double[][] CENTER_RIGHT_PATH = new double[][]{
		{robotLength/2, height/2},
		{robotLength/2+delta, height/2},
		{(distanceToSwitchFromAlliance-robotLength)/2+delta, height/2-2*delta},
		{(distanceToSwitchFromAlliance+robotLength)/2-delta, distanceToSwitchFromWall+switchLength/2+delta},
		{(distanceToSwitchFromAlliance+robotLength)/2+delta, distanceToSwitchFromWall+switchLength/2},
		{distanceToSwitchFromAlliance-robotLength/2+5, distanceToSwitchFromWall+switchLength/2}
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
		{18.625, 281.935},
		{28.625, 281.935},
		{75.0082191780822, 294.6353021978022},
		{108.73972602739727, 299.9842032967033},
		{146.0219178082192, 291.06936813186815},
		{158.44931506849318, 276.80563186813185},
		{163.77534246575345, 266.1078296703297},
		{163.77534246575345, 254.51854395604397},
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
		{50.15342465753425, 282.154532967033},
		{82.99726027397261, 281.26304945054943},
		{126.49315068493152, 283.0460164835165},
		{161.1123287671233, 286.61195054945057},
		{192.18082191780823, 283.0460164835165},
		{213.041095890411, 268.7822802197802},
		{223.69315068493154, 253.62706043956044},
		{225.0246575342466, 221.53365384615384},
		{223.24931506849316, 193.89766483516485},
		{224.1369863013699, 154.6723901098901},
		{224.1369863013699, 121.6875},
		{225.0246575342466, 99.40041208791209},
		{232.56986301369867, 85.13667582417582},
		{245.88493150684934, 73.99313186813187},
		{265.413698630137, 74.88461538461539},
		{286.7178082191781, 76.66758241758242},
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
	private static FastPathPlanner CENTER_FAST_LEFT;
	private static FastPathPlanner CENTER_FAST_RIGHT;
	private static FastPathPlanner CENTER_RIGHT;
	private static FastPathPlanner LEFT_LEFT;
	private static FastPathPlanner RIGHT_RIGHT;
	// 2 Cube
	private static FastPathPlanner[] CENTER_LEFT_SWITCH_2_CUBE;
	private static FastPathPlanner[] CENTER_RIGHT_SWITCH_2_CUBE;
	private static FastPathPlanner[] LEFT_LEFT_2; // Don't use!
	private static FastPathPlanner[] RIGHT_RIGHT_2; // Don't use!

	private static FastPathPlanner[] CENTER_LEFT_SWITCH_3_CUBE_1;
	private static FastPathPlanner[] CENTER_LEFT_SWITCH_3_CUBE_2;
	private static FastPathPlanner[] CENTER_LEFT_SWITCH_3_CUBE_3;
	private static FastPathPlanner[] CENTER_LEFT_SWITCH_3_CUBE_4;
	
	private static FastPathPlanner[] CENTER_RIGHT_SWITCH_3_CUBE_3;
	
	// Scale Auto Modes
	private static FastPathPlanner LEFT_SCALE_LEFT_START_PATH_SWITCH;
	private static FastPathPlanner RIGHT_SCALE_RIGHT_START_PATH_SWITCH;
	private static FastPathPlanner RIGHT_SCALE_LEFT_START_PATH;
	private static FastPathPlanner LEFT_SCALE_RIGHT_START_PATH;
	// 2 Cube
	private static FastPathPlanner[] LEFT_START_LEFT_SCALE_2;
	
	private static FastPathPlanner[] LEFT_START_LEFT_SCALE_SWITCH;
	private static FastPathPlanner[] RIGHT_START_RIGHT_SCALE_SWITCH;
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
	
	public static FastPathPlanner getLeftFastPath() {
		if (CENTER_FAST_LEFT != null) {
			return CENTER_FAST_LEFT;
		}
		double[][] centerLeft = new double[][]{
			{18.625, 162.25},
			{31.375, 162.25},
			{51.375, 172.25},
			{88.625, 219.8905},
			{116.85842696629213, 219.8938706015891},
		};
		CENTER_FAST_LEFT = new FastPathPlanner(centerLeft);
		CENTER_FAST_LEFT.calculate(3.2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
		CENTER_FAST_LEFT.getLeftArclength();
		CENTER_FAST_LEFT.getRightArclength();
		return CENTER_FAST_LEFT;
	}
	
	public static FastPathPlanner getRightFastPath() {
		if (CENTER_FAST_RIGHT != null) {
			return CENTER_FAST_RIGHT;
		}
		double[][] centerRight = new double[][]{
			{18.625, 162.25},
			{31.375, 162.25},
			{51.375, 152.25},
			{88.625, 104.6095},
			{112.85393258426966, 104.2377979568672},
		};
		CENTER_FAST_RIGHT = new FastPathPlanner(centerRight);
		CENTER_FAST_RIGHT.calculate(3.2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
		CENTER_FAST_RIGHT.getLeftArclength();
		CENTER_FAST_RIGHT.getRightArclength();
		return CENTER_FAST_RIGHT;
	}
	
	public static FastPathPlanner[] getLeftSwitch2Cube() {
		if (CENTER_LEFT_SWITCH_2_CUBE == null) {
			double[][] leftReturnCube = new double[][]{
				{67.34831460674157, 197.7939841089671},
				{77.54157303370786, 198.8989784335982},
				{100.11235955056179, 209.9489216799092},
				{116.4943820224719, 216.9472190692395},
				{127.05168539325842, 217.6838819523269},
			};
			FastPathPlanner fpp = getLeftPath();
			FastPathPlanner stage2 = new FastPathPlanner(CENTER_LEFT_TURNBACK); // This path should have left and right inverted and negative!
			FastPathPlanner grabCube = new FastPathPlanner(CENTER_LEFT_GRAB);
			FastPathPlanner goBackFromCube = new FastPathPlanner(CENTER_LEFT_GRAB);
			FastPathPlanner goBack = new FastPathPlanner(leftReturnCube);
			
			stage2.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			grabCube.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			goBackFromCube.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			goBack.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			
			reverseAndFlipPath(stage2);
			flipPath(grabCube);
			reverseAndFlipPath(goBackFromCube); // Maybe just reverse instead of fipping

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
	
	public static FastPathPlanner[] getLeftSwitch3Cube1() {
		if (CENTER_LEFT_SWITCH_3_CUBE_1 == null) {
			CENTER_LEFT_SWITCH_3_CUBE_1 = new FastPathPlanner[9];
			double[][] leftPath3Cube = new double[][]{
				{18.625, 162.25},
				{31.375, 162.25},
				{39.5013698630137, 165.37019230769232},
				{51.375, 172.25},
				{66.13150684931507, 190.33173076923077},
				{76.78356164383563, 203.70398351648353},
				{86.54794520547946, 217.07623626373626},
				{88.625, 219.8905},
				{99.86301369863014, 219.75068681318683},
				{121.375, 219.8905},
			};
			
			double[][] leftTurnBack = new double[][]{
				{67.71235955056179, 198.78416912487708},
				{75.72134831460673, 199.1032448377581},
				{88.4629213483146, 206.1229105211406},
				{105.20898876404493, 217.2905604719764},
				{119.0, 219.8905},
				{121.375, 219.8905},
			};
			
			double[][] leftGrabCube = new double[][]{
				{113.58202247191011, 178.36332350049165},
				{106.66516853932583, 185.70206489675516},
				{96.10786516853932, 191.76450344149458},
				{85.18651685393257, 196.2315634218289},
				{75.72134831460673, 199.1032448377581},
				{67.71235955056179, 198.78416912487708},
			};
			double[][] leftTurnBack2 = new double[][]{
				{66.57534246575344, 195.68063186813188},
				{71.9013698630137, 196.5721153846154},
				{82.1095890410959, 201.9210164835165},
				{93.64931506849317, 209.94436813186815},
				{105.20898876404493, 217.2905604719764},
				{119.0, 219.8905},
				{121.375, 219.8905},
			};
			
			double[][] leftGrabCube2 = new double[][]{
				{66.57534246575344, 195.68063186813188},
				{71.9013698630137, 196.5721153846154},
				{81.66575342465754, 193.89766483516485},
				{87.43561643835618, 188.54876373626374},
				{96.31232876712329, 181.41689560439562},
				{100.75068493150685, 176.0679945054945},
			};
//			new PathData(leftPath3Cube, 3.2, 0.02, robotWidth),
//			new PathData(leftTurnBack, 2, 0.02, robotWidth, PathData.PathParameter.FLIPREVERSE),
//			new PathData(leftGrabCube, 1.5, 0.02, robotWidth, PathData.PathParameter.FLIP),
//			new PathData(leftGrabCube, 1.5, 0.02, robotWidth, PathData.PathParameter.FLIPREVERSE),
//			new PathData(leftTurnBack, 2, 0.02, robotWidth),
			
			FastPathPlanner first = new FastPathPlanner(leftPath3Cube);
			FastPathPlanner second = new FastPathPlanner(leftTurnBack);
			FastPathPlanner third = new FastPathPlanner(leftGrabCube);
			FastPathPlanner fourth = new FastPathPlanner(leftGrabCube);
			FastPathPlanner fifth = new FastPathPlanner(leftTurnBack);
			
			first.calculate(3.2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			second.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			third.calculate(1.5, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			fourth.calculate(1.5, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			fifth.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			
			reverseAndFlipPath(second);
			flipPath(third);
			reverseAndFlipPath(fourth);
			
			FastPathPlanner s1 = new FastPathPlanner(leftTurnBack2);
			FastPathPlanner s2 = new FastPathPlanner(leftGrabCube2);
			FastPathPlanner s3 = new FastPathPlanner(leftGrabCube2);
			FastPathPlanner s4 = new FastPathPlanner(leftTurnBack2);
			
			s1.calculate(1.5, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			s2.calculate(1.2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			s3.calculate(1.2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			s4.calculate(1.5, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			
			reverseAndFlipPath(s1);
			reversePath(s3);
			
			CENTER_LEFT_SWITCH_3_CUBE_1 = new FastPathPlanner[]{
				first, second, third, fourth, fifth, s1, s2, s3, s4,
			};
			
			for (FastPathPlanner p : CENTER_LEFT_SWITCH_3_CUBE_1) {
				p.getLeftArclength();
				p.getRightArclength();
			}
		}
		return CENTER_LEFT_SWITCH_3_CUBE_1;
	}
	
	public static FastPathPlanner[] getLeftSwitch3Cube2() {
		if (CENTER_LEFT_SWITCH_3_CUBE_2 == null) {
			double[][] leftPath3Cube = new double[][]{
				{18.625, 162.25},
				{31.375, 162.25},
				{39.5013698630137, 165.37019230769232},
				{51.375, 172.25},
				{66.13150684931507, 190.33173076923077},
				{76.78356164383563, 203.70398351648353},
				{86.54794520547946, 217.07623626373626},
				{88.625, 219.8905},
				{99.86301369863014, 219.75068681318683},
				{121.375, 219.8905},
			};
			
			double[][] leftTurnBack = new double[][]{
				{94.53698630136986, 242.92925824175825},
				{100.75068493150685, 227.77403846153845},
				{106.96438356164384, 221.53365384615384},
				{114.95342465753426, 218.8592032967033},
				{121.375, 219.8905},
			};
			
			double[][] leftGrabCube = new double[][]{
				{91.87397260273974, 250.06112637362637},
				{90.09863013698632, 242.03777472527474},
				{90.09863013698632, 227.77403846153845},
				{91.87397260273974, 220.64217032967034},
				{97.2, 207.26991758241758},
				{98.97534246575343, 204.59546703296704},
			};
			
			double[][] leftTurnBackA = new double[][]{
				{95.42465753424658, 242.03777472527474},
				{98.08767123287672, 232.23145604395606},
				{106.96438356164384, 225.0995879120879},
				{113.17808219178083, 222.42513736263737},
				{120.27945205479453, 222.42513736263737},
				{128.26849315068495, 225.99107142857144},
			};
			
			double[][] leftTurnBack2 = new double[][]{
				{102.52602739726028, 241.1462912087912},
				{104.3013698630137, 233.12293956043956},
				{111.4027397260274, 222.42513736263737},
				{119.39178082191782, 218.8592032967033},
				{128.26849315068495, 219.75068681318683},
			};
			
			double[][] leftGrabCube2 = new double[][]{
				{95.42465753424658, 225.99107142857144},
				{96.31232876712329, 221.53365384615384},
				{100.75068493150685, 206.37843406593407},
				{107.85205479452055, 190.33173076923077},
				{112.29041095890412, 182.30837912087912},
			};
			
			double[][] leftAfterGrabCube2 = new double[][]{
				{92.76164383561645, 245.6037087912088},
				{94.53698630136986, 234.0144230769231},
				{101.63835616438357, 209.0528846153846},
				{107.85205479452055, 190.33173076923077},
				{112.29041095890412, 182.30837912087912},
			};
			
			double[][] leftTurnBack2A = new double[][]{
				{102.52602739726028, 241.1462912087912},
				{104.3013698630137, 233.12293956043956},
				{111.4027397260274, 225.99107142857144},
				{118.50410958904111, 221.53365384615384},
				{123.83013698630138, 220.64217032967034},
				{130.93150684931507, 221.53365384615384},
			};
//			new PathData(leftPath3Cube, 3.2, 0.02, robotWidth),
//			new PathData(leftTurnBack, 2, 0.02, robotWidth, PathData.PathParameter.FLIPREVERSE),
//			new PathData(leftGrabCube, 1.5, 0.02, robotWidth, PathData.PathParameter.FLIP),
//			new PathData(leftGrabCube, 1.5, 0.02, robotWidth, PathData.PathParameter.FLIPREVERSE),
//			new PathData(leftTurnBack, 2, 0.02, robotWidth),
			
			FastPathPlanner first = new FastPathPlanner(leftPath3Cube);
			FastPathPlanner second = new FastPathPlanner(leftTurnBack);
			FastPathPlanner third = new FastPathPlanner(leftGrabCube);
			FastPathPlanner fourth = new FastPathPlanner(leftGrabCube);
			FastPathPlanner fifth = new FastPathPlanner(leftTurnBackA);
			
			first.calculate(3.2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			second.calculate(1.5, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			third.calculate(1.5, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			fourth.calculate(1.5, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			fifth.calculate(1.5, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			
			reversePath(second);
//			flipPath(third);
			reversePath(fourth);
			
			FastPathPlanner s1 = new FastPathPlanner(leftTurnBack2);
			FastPathPlanner s2 = new FastPathPlanner(leftGrabCube2);
			FastPathPlanner s3 = new FastPathPlanner(leftAfterGrabCube2);
			FastPathPlanner s4 = new FastPathPlanner(leftTurnBack2A);
			
			s1.calculate(1.5, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			s2.calculate(1.2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			s3.calculate(1.2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			s4.calculate(1.5, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			
			reversePath(s1);
			reversePath(s3);
			
			CENTER_LEFT_SWITCH_3_CUBE_2 = new FastPathPlanner[]{
				first, second, third, fourth, fifth, s1, s2, s3, s4,
			};
			
			for (FastPathPlanner p : CENTER_LEFT_SWITCH_3_CUBE_2) {
				p.getLeftArclength();
				p.getRightArclength();
			}
		}
		return CENTER_LEFT_SWITCH_3_CUBE_2;
	}
	
	public static FastPathPlanner[] getLeftSwitch3Cube3() {
		if (CENTER_LEFT_SWITCH_3_CUBE_3 == null) {
			double[][] leftPath3Cube = new double[][]{
				{18.625, 162.25},
				{31.375, 162.25},
				{39.5013698630137, 165.37019230769232},
				{51.375, 172.25},
				{66.13150684931507, 190.33173076923077},
				{76.78356164383563, 203.70398351648353},
				{86.54794520547946, 217.07623626373626},
				{88.625, 219.8905},
				{99.86301369863014, 219.75068681318683},
				{121.375, 219.8905},
			};
			
			double[][] leftBackup2 = new double[][]{
				{70.56986301369864, 217.9677197802198},
				{74.12054794520549, 219.75068681318683},
				{86.54794520547946, 220.64217032967034},
				{106.07671232876713, 220.64217032967034},
				{118.06027397260274, 219.75068681318683},
				{121.375, 219.8905},
			};
			
			double[][] leftGrabby2 = new double[][]{
				{70.56986301369864, 217.9677197802198},
				{75.89589041095891, 221.53365384615384},
				{77.67123287671234, 226.88255494505495},
				{82.1095890410959, 229.5570054945055},
				{91.87397260273974, 233.12293956043956},
				{101.63835616438357, 234.0144230769231},
				{110.5150684931507, 228.66552197802199},
				{116.72876712328768, 217.07623626373626},
				{117.6164383561644, 204.59546703296704},
				{116.72876712328768, 195.68063186813188},
				{113.17808219178083, 177.85096153846155},
				{114.95342465753426, 173.39354395604397},
			};
			
			double[][] leftBackup2A = new double[][]{
				{93.64931506849317, 248.27815934065936},
				{93.64931506849317, 239.36332417582418},
				{98.08767123287672, 227.77403846153845},
				{106.07671232876713, 220.64217032967034},
				{118.06027397260274, 219.75068681318683},
				{121.375, 219.8905},
			};
			
			double[][] leftGrab2A = new double[][]{
				{93.64931506849317, 248.27815934065936},
				{93.64931506849317, 239.36332417582418},
				{97.2, 218.8592032967033},
				{102.52602739726028, 196.5721153846154},
				{106.96438356164384, 168.93612637362637},
				{106.07671232876713, 160.91277472527472},
			};
//			new PathData(leftPath3Cube, 3.2, 0.02, robotWidth),
//			new PathData(leftTurnBack, 2, 0.02, robotWidth, PathData.PathParameter.FLIPREVERSE),
//			new PathData(leftGrabCube, 1.5, 0.02, robotWidth, PathData.PathParameter.FLIP),
//			new PathData(leftGrabCube, 1.5, 0.02, robotWidth, PathData.PathParameter.FLIPREVERSE),
//			new PathData(leftTurnBack, 2, 0.02, robotWidth),
			
			FastPathPlanner first = new FastPathPlanner(leftPath3Cube);
			FastPathPlanner second = new FastPathPlanner(leftBackup2);
			FastPathPlanner third = new FastPathPlanner(leftGrabby2);
			FastPathPlanner fourth = new FastPathPlanner(leftGrabby2);
			FastPathPlanner fifth = new FastPathPlanner(leftBackup2);
			
			first.calculate(3.2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			second.calculate(1.1, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			third.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			fourth.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			fifth.calculate(1.1, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			
			reversePath(second);
			reversePath(fourth);
			
			FastPathPlanner s1 = new FastPathPlanner(leftBackup2A);
			FastPathPlanner s2 = new FastPathPlanner(leftGrab2A);
			FastPathPlanner s3 = new FastPathPlanner(leftGrab2A);
			FastPathPlanner s4 = new FastPathPlanner(leftBackup2A);
			
			s1.calculate(1.5, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			s2.calculate(1.5, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			s3.calculate(1.5, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			s4.calculate(1.5, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			
			reversePath(s1);
			reversePath(s3);
			
			CENTER_LEFT_SWITCH_3_CUBE_3 = new FastPathPlanner[]{
				first, second, third, fourth, fifth, s1, s2, s3, s4,
			};
			
			for (FastPathPlanner p : CENTER_LEFT_SWITCH_3_CUBE_3) {
				p.getLeftArclength();
				p.getRightArclength();
			}
		}
		return CENTER_LEFT_SWITCH_3_CUBE_3;
	}
	
	public static FastPathPlanner[] getLeftSwitch3Cube4() {
		if (CENTER_LEFT_SWITCH_3_CUBE_4 == null) {
			double[][] leftPath3Cube = new double[][]{
				{18.625, 162.25},
				{31.375, 162.25},
				{39.5013698630137, 165.37019230769232},
				{51.375, 172.25},
				{66.13150684931507, 190.33173076923077},
				{76.78356164383563, 203.70398351648353},
				{86.54794520547946, 217.07623626373626},
				{88.625, 219.8905},
				{99.86301369863014, 219.75068681318683},
				{121.375, 219.8905},
			};
			
			double[][] leftGrabby3 = new double[][]{
				{118.06027397260274, 218.8592032967033},
				{118.94794520547946, 211.72733516483518},
				{117.17260273972605, 188.54876373626374},
				{118.94794520547946, 179.63392857142858},
			};
			
			double[][] leftGrabby3A = new double[][]{
				{118.06027397260274, 218.8592032967033},
				{118.94794520547946, 211.72733516483518},
				{117.17260273972605, 188.54876373626374},
				{118.94794520547946, 176.63392857142858},
			};
			
			FastPathPlanner first = new FastPathPlanner(leftPath3Cube);
			FastPathPlanner second = new FastPathPlanner(leftGrabby3);
			FastPathPlanner third = new FastPathPlanner(leftGrabby3);
			FastPathPlanner fourth = new FastPathPlanner(leftGrabby3A);
			FastPathPlanner fifth = new FastPathPlanner(leftGrabby3A);
			
			first.calculate(3.2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			second.calculate(1.3, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			third.calculate(1.3, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			fourth.calculate(1.3, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			fifth.calculate(1.3, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			
			reversePath(third);
			reversePath(fifth);
			
			CENTER_LEFT_SWITCH_3_CUBE_4 = new FastPathPlanner[]{
				first, second, third, fourth, fifth
			};
			
			for (FastPathPlanner p : CENTER_LEFT_SWITCH_3_CUBE_4) {
				p.getLeftArclength();
				p.getRightArclength();
			}
		}
		return CENTER_LEFT_SWITCH_3_CUBE_4;
	}
	
	public static FastPathPlanner[] getRightSwitch2Cube() {
		if (CENTER_RIGHT_SWITCH_2_CUBE == null) {
			double[][] rightReturnCube = new double[][]{
				{66.2561797752809, 123.75936435868331},
				{72.34520547945206, 124.8076923076923},
				{88.4629213483146, 118.3770894788594},
				{100.11235955056179, 107.1844494892168},
				{115.40224719101123, 102.3961407491487},
				{126.68764044943819, 103.13280363223609},
			};
			FastPathPlanner fpp = getRightPath();
			FastPathPlanner stage2 = new FastPathPlanner(CENTER_RIGHT_TURNBACK); // This path should have left and right inverted and negative!
			FastPathPlanner grabCube = new FastPathPlanner(CENTER_RIGHT_GRAB);
			FastPathPlanner goBackFromCube = new FastPathPlanner(CENTER_RIGHT_GRAB);
			FastPathPlanner goBack = new FastPathPlanner(rightReturnCube);
			
			stage2.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			grabCube.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			goBackFromCube.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			goBack.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			
			reverseAndFlipPath(stage2);
			flipPath(grabCube);
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
	
	public static FastPathPlanner[] getRightSwitch3Cube3() {
		if (CENTER_RIGHT_SWITCH_3_CUBE_3 == null) {
			double[][] rightPath3Cube = new double[][]{
				{18.625, 162.25},
				{31.375, 162.25},
				{39.5013698630137, 159.12980769230768},
				{51.375, 152.25},
				{66.13150684931507, 134.16826923076923},
				{76.78356164383563, 120.79601648351647},
				{86.54794520547946, 107.42376373626374},
				{88.625, 104.6095},
				{99.86301369863014, 104.74931318681317},
				{121.375, 104.6095},
			};
			
			double[][] rightGrabby3 = new double[][]{
				{118.94794520547946, 144.86607142857142},
				{117.17260273972605, 135.95123626373626},
				{118.94794520547946, 112.77266483516482},
				{118.06027397260274, 105.6407967032967},
			};
			
			double[][] rightGrabby3A = new double[][]{
				{118.06027397260274, 105.6407967032967},
				{118.94794520547946, 112.77266483516482},
				{117.17260273972605, 135.95123626373626},
				{118.94794520547946, 147.86607142857142},
			};
			FastPathPlanner first = new FastPathPlanner(rightPath3Cube);
			FastPathPlanner second = new FastPathPlanner(rightGrabby3);
			FastPathPlanner third = new FastPathPlanner(rightGrabby3);
			FastPathPlanner fourth = new FastPathPlanner(rightGrabby3A);
			FastPathPlanner fifth = new FastPathPlanner(rightGrabby3A);
			
			first.calculate(3.2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			second.calculate(1.3, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			third.calculate(1.3, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			fourth.calculate(1.3, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			fifth.calculate(1.3, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			
			reversePath(second);
			reverseAndFlipPath(third);
			reversePath(fifth);
			
			CENTER_RIGHT_SWITCH_3_CUBE_3 = new FastPathPlanner[]{
				first, second, third, fourth, fifth
			};
		}
		return CENTER_RIGHT_SWITCH_3_CUBE_3;
	}
	
	public static FastPathPlanner getLeftStartingLeftScalePath() {
		if (LEFT_SCALE_LEFT_START_PATH_SWITCH != null) {
			return LEFT_SCALE_LEFT_START_PATH_SWITCH;
		}
		LEFT_SCALE_LEFT_START_PATH_SWITCH = new FastPathPlanner(LEFT_SCALE_LEFT_START_SWITCH);
		LEFT_SCALE_LEFT_START_PATH_SWITCH.calculate(8, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
		LEFT_SCALE_LEFT_START_PATH_SWITCH.getLeftArclength();
		LEFT_SCALE_LEFT_START_PATH_SWITCH.getRightArclength();
		return LEFT_SCALE_LEFT_START_PATH_SWITCH;
	}
	
	public static FastPathPlanner getRightStartingRightScalePath() {
		if (RIGHT_SCALE_RIGHT_START_PATH_SWITCH != null) {
			return RIGHT_SCALE_RIGHT_START_PATH_SWITCH;
		}
		RIGHT_SCALE_RIGHT_START_PATH_SWITCH = new FastPathPlanner(RIGHT_SCALE_RIGHT_START_SWITCH);
		RIGHT_SCALE_RIGHT_START_PATH_SWITCH.calculate(8, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
		RIGHT_SCALE_RIGHT_START_PATH_SWITCH.getLeftArclength();
		RIGHT_SCALE_RIGHT_START_PATH_SWITCH.getRightArclength();
		return RIGHT_SCALE_RIGHT_START_PATH_SWITCH;
	}
	
	public static FastPathPlanner[] getLeftStartingLeftScaleSwitchPath() {
		if (LEFT_START_LEFT_SCALE_SWITCH == null) {
			double[][] leftScaleStartNew = new double[][]{
				{18.625, 281.935},
				{34.0, 281.935},
				{103.41369863013699, 287.5034340659341},
				{160.2246575342466, 289.2864010989011},
				{222.36164383561646, 286.61195054945057},
				{255.20547945205482, 279.03434065934067},
				{272.0712328767124, 272.79395604395603},
				{284.9424657534247, 264.3248626373626},
			};
			
			double[][] leftScaleBackup = new double[][]{
				{284.9424657534247, 264.3248626373626},
				{272.0712328767124, 272.3482142857143},
				{258.75616438356167, 275.02266483516485},
				{245.441095890411, 275.91414835164835},
				{231.2383561643836, 285.72046703296706},
				{225.0246575342466, 295.5267857142857},
			};
			
			double[][] leftScaleSwitchBackup = new double[][]{
				{237.45205479452056, 266.1078296703297},
				{228.57534246575344, 259.86744505494505},
				{223.24931506849316, 246.49519230769232},
				{214.37260273972603, 236.68887362637363},
			};
			
			double[][] leftScaleGrabCube = new double[][]{
				{225.0246575342466, 295.5267857142857},
				{231.2383561643836, 285.72046703296706},
				{233.9013698630137, 271.4567307692308},
				{229.46301369863016, 259.86744505494505},
				{224.1369863013699, 249.16964285714286},
				{214.37260273972603, 236.68887362637363},
			};
			
			double[][] leftScaleSwitchPlace = new double[][]{
				{237.45205479452056, 266.1078296703297},
				{228.57534246575344, 259.86744505494505},
				{213.48493150684934, 255.41002747252747},
				{202.83287671232878, 246.49519230769232},
			};
//			leftScaleStartDataNew,
//			new PathData(leftScaleBackup, 2, 0.02, robotWidth, PathData.PathParameter.FLIPREVERSE),
//			new PathData(leftScaleGrabCube, 3, 0.02, robotWidth),
//			new PathData(leftScaleSwitchBackup, 2, 0.02, robotWidth, PathData.PathParameter.REVERSE),
//			new PathData(leftScaleSwitchPlace, 2, 0.02, robotWidth),
			FastPathPlanner first = new FastPathPlanner(leftScaleStartNew);
			FastPathPlanner second = new FastPathPlanner(leftScaleBackup);
			FastPathPlanner third = new FastPathPlanner(leftScaleGrabCube);
			FastPathPlanner fourth = new FastPathPlanner(leftScaleSwitchBackup);
			FastPathPlanner fifth = new FastPathPlanner(leftScaleSwitchPlace);
			
			first.calculate(8, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			second.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			third.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			fourth.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			fifth.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			
			reverseAndFlipPath(second);
			reversePath(fourth);
			
			LEFT_START_LEFT_SCALE_SWITCH = new FastPathPlanner[]{
					first, second, third, fourth, fifth
			};
		}
		return LEFT_START_LEFT_SCALE_SWITCH;
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
	
	public static FastPathPlanner getLeftStartingRightScale2Cube() {
		if (RIGHT_SCALE_LEFT_START_2_CUBE == null) {
			
		}
		return RIGHT_SCALE_LEFT_START_2_CUBE;
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
	
	public static FastPathPlanner[] getRightStartingRightScaleSwitch() {
		if (RIGHT_START_RIGHT_SCALE_SWITCH == null) {
			double[][] rightScaleStartNew = new double[][]{
				{18.625, 42.565},
				{28.849315068493155, 42.791208791208796},
				{113.17808219178083, 39.67101648351648},
				{194.84383561643838, 41.45398351648352},
				{242.77808219178084, 48.58585164835165},
				{264.0821917808219, 54.82623626373626},
				{283.6109589041096, 61.958104395604394},
				{291.6, 68.19848901098901},
			};
			
			double[][] rightScaleBackup = new double[][]{
				{284.9424657534247, 60.17513736263737},
				{272.0712328767124, 52.15178571428572},
				{258.75616438356167, 49.477335164835154},
				{245.441095890411, 48.58585164835165},
				{231.2383561643836, 38.779532967032935},
				{225.0246575342466, 28.973214285714278},
			};
			
			double[][] rightScaleGrabCube = new double[][]{
				{225.0246575342466, 28.973214285714278},
				{231.2383561643836, 38.779532967032935},
				{233.9013698630137, 53.043269230769226},
				{229.46301369863016, 64.63255494505495},
				{224.1369863013699, 75.33035714285714},
				{214.37260273972603, 87.81112637362637},
			};
			
			double[][] rightScaleSwitchBackup = new double[][]{
				{237.45205479452056, 58.39217032967031},
				{228.57534246575344, 64.63255494505495},
				{223.24931506849316, 78.00480769230768},
				{214.37260273972603, 87.81112637362637},
			};
			
			FastPathPlanner first = new FastPathPlanner(rightScaleStartNew);
			FastPathPlanner second = new FastPathPlanner(rightScaleBackup);
			FastPathPlanner third = new FastPathPlanner(rightScaleGrabCube);
			FastPathPlanner fourth = new FastPathPlanner(rightScaleSwitchBackup);
			FastPathPlanner fifth = new FastPathPlanner(rightScaleSwitchBackup);
			
			first.calculate(8, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			second.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			third.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			fourth.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			fifth.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);

			reverseAndFlipPath(second);
			reversePath(fourth);
			
			RIGHT_START_RIGHT_SCALE_SWITCH = new FastPathPlanner[]{
				first, second, third, fourth, fifth
			};
		}
		return RIGHT_START_RIGHT_SCALE_SWITCH;
	}
	
	public static FastPathPlanner[] getLeftStartingLeftScale2Cube() {
		if (LEFT_START_LEFT_SCALE_2 == null) {
			double[][] leftScaleStartNew = new double[][]{
				{18.625, 281.935},
				{33.731506849315075, 282.154532967033},
				{103.41369863013699, 287.5034340659341},
				{166.88219178082193, 287.5034340659341},
				{215.7041095890411, 282.154532967033},
				{271.627397260274, 266.9993131868132},
				{286.7178082191781, 259.86744505494505},
			};
			
			double[][] leftScaleBackup = new double[][]{
				{284.9424657534247, 264.3248626373626},
				{275.17808219178085, 271.010989010989},
				{258.75616438356167, 275.02266483516485},
				{239.227397260274, 281.26304945054943},
				{229.46301369863016, 291.06936813186815},
				{226.07191011235955, 302.40011350737797},
			};
			
			double[][] leftScaleGrabCube = new double[][]{
				{227.52808988764042, 294.2968217934166},
				{229.9068493150685, 290.17788461538464},
				{233.9013698630137, 271.4567307692308},
				{233.45753424657536, 261.6504120879121},
				{229.71235955056179, 248.25539160045403},
				{223.15955056179774, 235.36379114642452},
			};
			
			double[][] leftScaleReturnCube = new double[][]{
				{224.97977528089885, 292.8234960272418},
				{231.1685393258427, 284.35187287173665},
				{244.27415730337077, 272.19693530079456},
				{260.08767123287674, 258.97596153846155},
				{277.841095890411, 250.9526098901099},
				{292.0438356164384, 250.06112637362637},
			};
			
			FastPathPlanner first = new FastPathPlanner(leftScaleStartNew);
			FastPathPlanner second = new FastPathPlanner(leftScaleBackup);
			FastPathPlanner third = new FastPathPlanner(leftScaleGrabCube);
			FastPathPlanner fourth = new FastPathPlanner(leftScaleGrabCube);
			FastPathPlanner fifth = new FastPathPlanner(leftScaleReturnCube);
			
			first.calculate(6, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			second.calculate(3, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			third.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			fourth.calculate(2, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
			fifth.calculate(3, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);

			reverseAndFlipPath(second);
			reversePath(fourth);
//			flipPath(fifth);
			
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
		LEFT_LEFT.calculate(3, Constants.DELTA_TIME, Constants.ROBOT_WIDTH);
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
				{108.73972602739727, 299.9842032967033},
				{146.0219178082192, 291.06936813186815},
				{158.44931506849318, 276.80563186813185},
				{163.77534246575345, 266.1078296703297},
				{163.77534246575345, 248.51854395604397},
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
