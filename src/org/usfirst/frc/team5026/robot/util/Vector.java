package org.usfirst.frc.team5026.robot.util;

public class Vector {
	
	private double x;
	private double y;
	
	/**
	 * Constructs a 2D vector
	 * 
	 * @param x coordinate of the vector
	 * @param y coordinate of the vector
	 */
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Returns the magnitude of the vector
	 * 
	 * @return {@link Vector#magnitude}
	 */
	public double getMagnitude() {
		return Math.sqrt(x*x + y*y);
	}
	
	/**
	 * Returns the x component of the vector 
	 * 
	 * @return {@link Vector#x}
	 */
	public double getX() {
		return x;
	}

	/**
	 * Returns the y component of the vector 
	 * 
	 * @return {@link Vector#y}
	 */
	public double getY() {
		return y;
	}
	
	public void set(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Normalizes the vector
	 */
	public void norm() {
		double magnitude = getMagnitude();
		if (magnitude < 0.0001) {
			return;
		}
		x /= magnitude;
		y /= magnitude;
	}
	
	/**
	 * Multiplies the vector components by some number m
	 */
	public void mult(double m) {
		x *= m;
		y *= m;
	}
	
	/**
	 * Add a scalar to both components
	 * 
	 * @param scalar
	 */
	public void add(double scalar) {
		this.x += scalar;
		this.y += scalar;
	}
	
	/**
	 * Zero's this vector
	 */
	public void zero() {
		this.x = 0;
		this.y = 0;
	}
}
