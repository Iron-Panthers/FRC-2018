package org.usfirst.frc.team5026.robot.util;

public class Vector {
	
	private double x;
	private double y;
	private double magnitude; // The magnitude of the vector
	
	/**
	 * Constructs a 2D vector
	 * 
	 * @param x coordinate of the vector
	 * @param y coordinate of the vector
	 */
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
		calcMagnitude();
	}
	
	/**
	 * Calculates the magnitude of the vector
	 */
	public void calcMagnitude() {
		this.magnitude = Math.sqrt(x*x + y*y);
	}
	
	/**
	 * Returns the magnitude of the vector
	 * 
	 * @return {@link Vector#magnitude}
	 */
	public double getMagnitude() {
		return this.magnitude;
	}
	
	/**
	 * Normalizes the vector
	 * 
	 * @return the normal vector
	 */
	public Vector norm() {
		return new Vector(x/magnitude, y/magnitude);
	}

}
