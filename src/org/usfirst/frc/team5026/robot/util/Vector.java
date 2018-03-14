package org.usfirst.frc.team5026.robot.util;

public class Vector {
	
	private double[] vector; // The vector as an array
	private double magnitude; // The magnitude of the vector
	private int dimensions; // The dimensions of, or number of components in, the vector
	
	/**
	 * Constructs a vector based on the components
	 * 
	 * @param components in the vector
	 */
	public Vector(double...components) {
		setVector(components);
		calcMagnitude();
		this.dimensions = vector.length;
	}
	
	/**
	 * Returns the vector array
	 * 
	 * @return {@link Vector#vector}
	 */
	public double[] get() {
		return this.vector;
	}
	
	/**
	 * Fills in the vector with components
	 * 
	 * @param components in the vector
	 */
	public void setVector(double...components) {
		this.vector = components; 
	}
	
	/**
	 * Calculates the magnitude of the vector
	 */
	public void calcMagnitude() {
		double temp = 0;
		for (double n : vector) temp += n*n;
		this.magnitude = Math.sqrt(temp);
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
	 * Returns number of components in the vector
	 * 
	 * @return {@link Vector#dimensions}
	 */
	public int getDimensions() {
		return this.dimensions;
	}
	
	/**
	 * Normalizes the vector
	 * 
	 * @return the normal vector
	 */
	public Vector norm() {
		double[] normal = new double[this.dimensions];
		for (int i = 0; i < this.dimensions; ++i)
			normal[i] = vector[i]/magnitude;
		return new Vector(normal);
	}

}
