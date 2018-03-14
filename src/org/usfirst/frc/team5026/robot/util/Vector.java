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
	
	/**
	 * Normalizes the vector
	 * 
	 * @return the normal vector
	 */
	public Vector norm() {
		return new Vector(x/magnitude, y/magnitude);
	}
	
	/**
	 * Returns the angle of the vector in radians
	 * 
	 * @return angle of the vector in radians
	 */
	public double getAngleRad() {
		if (x == 0) return Math.PI/2;
		double alpha = Math.atan(Math.abs(y)/Math.abs(x));
		if (x > 0 && y > 0) return alpha;
		if (x < 0 && y > 0) return alpha + Math.PI/2;
		if (x < 0 && y < 0) return alpha + Math.PI;
		return alpha + 1.5*Math.PI;
	}
	
	/**
	 * Returns the angle of the vector in degrees
	 * 
	 * @return angle of the vector in degrees
	 */
	public double getAngleDeg() {
		return getAngleRad()*180/Math.PI;
	}

}
