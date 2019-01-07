package org.usfirst.frc.team5026.robot.util.arclib;

import java.util.ArrayList;

public class ArrayListMaker {
	public static ArrayList<Double> make(Double[] inputList) {
		ArrayList<Double> returnList = new ArrayList<Double>();
		for(int i = 0; i < inputList.length; i++) {
			returnList.add(inputList[i]);
		}
		return returnList;
	}
}
