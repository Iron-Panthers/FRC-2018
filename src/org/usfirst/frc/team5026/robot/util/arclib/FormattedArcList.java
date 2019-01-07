package org.usfirst.frc.team5026.robot.util.arclib;

import java.util.ArrayList;

import org.usfirst.frc.team5026.robot.util.Constants;

public class FormattedArcList {
	ArrayList<Double> rightPowers;
	ArrayList<Double> leftPowers;
	ArrayList<Double> rightSideLengths;
	ArrayList<Double> leftSideLengths;
	ArrayList<Double> rEncoderPositions;
//	ArrayList<Double> lEncoderPositions;
	
	public FormattedArcList(ArrayList<Arc> arcs) {
		rightPowers = new ArrayList<Double>();
		leftPowers = new ArrayList<Double>();
		rightSideLengths = new ArrayList<Double>();
		leftSideLengths = new ArrayList<Double>();
		rEncoderPositions = new ArrayList<Double>();
		rEncoderPositions.add(0.0);
//		lEncoderPositions = new ArrayList<Double>();
		double numArcs = arcs.size();
		for(int i = 0; i < numArcs; i ++) {
			rightPowers.add(calcRightPower(arcs.get(i).leftWheelDistance, arcs.get(i).rightWheelDistance)); 
			leftPowers.add(calcLeftPower(arcs.get(i).leftWheelDistance, arcs.get(i).rightWheelDistance));
			rightSideLengths.add(arcs.get(i).rightWheelDistance);
			leftSideLengths.add(arcs.get(i).leftWheelDistance); 
			double thisRightEncoderPosition = 0;
			for (int p = 0; p <= i; p++) {
				thisRightEncoderPosition += rightSideLengths.get(p) * Constants.TICKS_TO_INCHES;
			}
			double currentRightSideLengthInTicks = rightSideLengths.get(i)*Constants.TICKS_TO_INCHES;
			double ticksAtEndOfSlowDown = (600 > (currentRightSideLengthInTicks/2)) ? currentRightSideLengthInTicks/2 : 600;
			double ticksAtStartOfSpeedUp = (600 > (currentRightSideLengthInTicks/2)) ? currentRightSideLengthInTicks/2 : 600;
			System.out.println(thisRightEncoderPosition);
			System.out.println(currentRightSideLengthInTicks);
			System.out.println(ticksAtEndOfSlowDown);
			System.out.println(ticksAtStartOfSpeedUp);
			rEncoderPositions.add((thisRightEncoderPosition - (currentRightSideLengthInTicks)) + ticksAtEndOfSlowDown);
			rEncoderPositions.add(thisRightEncoderPosition - ticksAtStartOfSpeedUp);
			rEncoderPositions.add(thisRightEncoderPosition);
		}
		for(int i = 0; i < numArcs; i ++) {
			double rightDifference;
			double leftDifference;
			double nextStartRightPower;
			double nextStartLeftPower;
			double thisEndRightPower;
			double thisEndLeftPower;
			if(i == 0) {
				if(rightPowers.get(0) > leftPowers.get(0)) {
					rightPowers.add(0, scaleByDifference(rightPowers.get(0), rightPowers.get(0)));
					leftPowers.add(0, scaleByDifference(leftPowers.get(0), rightPowers.get(0)));
				}
				else {
					rightPowers.add(0, scaleByDifference(rightPowers.get(0), leftPowers.get(0)));
					leftPowers.add(0, scaleByDifference(leftPowers.get(0), leftPowers.get(0)));
				}
			}
			double thisRightPower = rightPowers.get((i*3)+1);
			double thisLeftPower = leftPowers.get((i*3)+1);
			double nextRightPower;
			double nextLeftPower;
			if(i == numArcs - 1) {
				nextRightPower = 0;
				nextLeftPower = 0;
			}
			else {
				nextRightPower = rightPowers.get((i*3)+2);
				nextLeftPower = leftPowers.get((i*3)+2);
			}
			rightDifference = Math.abs(thisRightPower - nextRightPower);
			leftDifference = Math.abs(thisLeftPower - nextLeftPower);
			if(rightDifference >= leftDifference) {
				nextStartRightPower = scaleByDifference(nextRightPower, rightDifference);
				nextStartLeftPower = scaleByDifference(nextLeftPower, rightDifference);
				thisEndRightPower = scaleByDifference(thisRightPower, rightDifference);
				thisEndLeftPower = scaleByDifference(thisLeftPower, rightDifference);
			}
			else {
				thisEndRightPower = scaleByDifference(thisRightPower, leftDifference);
				thisEndLeftPower = scaleByDifference(thisLeftPower, leftDifference);
				nextStartRightPower = scaleByDifference(nextRightPower, leftDifference);
				nextStartLeftPower = scaleByDifference(nextLeftPower, leftDifference);
			}
			rightPowers.add((i*3)+2, thisEndRightPower);
			leftPowers.add((i*3)+2, thisEndLeftPower);
			rightPowers.add((i*3)+3, nextStartRightPower);
			leftPowers.add((i*3)+3, nextStartLeftPower);
		}
		System.out.println("right powers: " + rightPowers);
		System.out.println("left powers: " + leftPowers);
		System.out.println("right encoder positions" + rEncoderPositions);
	}
	
	public double calcRightPower(double leftPathLength, double rightPathLength) {
		if (Math.abs(rightPathLength) > Math.abs(leftPathLength)) {
			if(rightPathLength > 0) {
				return 1;
			}
			else {
				return -1;
			}
		} 
		else {
			if(rightPathLength > 0) {
				return rightPathLength / leftPathLength;
			}
			else {
				return -(rightPathLength / leftPathLength);
			}
		}
	}

	public double calcLeftPower(double leftPathLength, double rightPathLength) {
		if (Math.abs(rightPathLength) > Math.abs(leftPathLength)) {
			if(leftPathLength > 0) {
				return leftPathLength / rightPathLength;
			}
			else {
				return -(leftPathLength / rightPathLength);
			}
		} 
		else {
			if(leftPathLength > 0) {
				return 1;
			}
			else {
				return -1;
			}
		}
	}
	public double scaleByDifference(double value, double difference) {
		if(difference < .3) {
			return value;
		}
		else {
			return (value/difference) * .3;
		}
	}
}
