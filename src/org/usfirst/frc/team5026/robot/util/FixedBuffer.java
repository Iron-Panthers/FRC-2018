package org.usfirst.frc.team5026.robot.util;

public class FixedBuffer {
	
	public double sum = 0;
	private double[] values;
	private int headIndex = 0;
	
	public FixedBuffer(int size) {
		values = new double[size];
	}
	
	public void addValue(double value) {
		sum -= values[headIndex];
		sum += value;
		values[headIndex] = value;
		headIndex++;
		
		if (headIndex >= values.length) {
			headIndex = 0;
		}
	}

}
