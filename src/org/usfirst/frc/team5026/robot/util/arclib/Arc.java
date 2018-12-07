package org.usfirst.frc.team5026.robot.util.arclib;

public class Arc {
	public double widthBetweenWheels = 1;
	public double a;
	public double b;
	public double c;
	public double d;
	public double m;
	double centerX;
	double centerY;
	double radius;
	double k;
	double v;
	double h;
	double q;
	double angle;
	double arcLength;
	double leftWheelDistance;
	double rightWheelDistance;
	double endSlope;
	double startAngle;
	double firstPointAngle = 0;
	double secondPointAngle = 0;
	double priorTestX;
	double priorTestY;
	double nextTestX;
	double nextTestY;
	double testXCoord;
	double testYCoord;
	double secondTestAngle;
	boolean isBackwards;
	public boolean robotIsReversed = false;
	
	public Arc(double x1,double y1,double x2,double y2,double m,double px, double py, boolean isBackwards) {
		a = x1;
		b = y1;
		c = x2;
		d = y2;
		this.m = m;
		priorTestX = px;
		priorTestY = py;
		this.isBackwards = isBackwards;

		//finds the center and radius of the arc's circle based on above parameters
		//for further info see https://www.desmos.com/calculator/ejj8ezty67
		centerX = (a + (b * m) -( m * ( (c * c) + (d * d)-( (a * a) + (b * b) ) )/
				( (2 * d)-(2 * b) ) ) )/(1 + ( (m * ( (2 * a)-(2 * c) ) ) / ( (2 * d)-(2 * b) ) ) );
		
		centerY = -(1/m)*(centerX-(a+(b*m)));
		radius = Math.sqrt(((a-centerX)*(a-centerX)) + ((b-centerY)*(b-centerY)));
		
		
		
		//the below values are used to find a point forming a right triangle with the (c,d) and the circle center
		//used for calculating angle based on atan of ratio of distances to these points
		//for more info see the above desoms link
		k = (a + b*m - d*m + m*m*c)/(m*m+1);
		v = (m*k)+d-m*c;
		h = radius-Math.sqrt(((a-k)*(a-k)) + ((b-v)*(b-v)));
		q = Math.sqrt(((c-k)*(c-k)) + ((d-v)*(d-v)));
		
		//calculates end slope to feed into the next arc as a new m
		endSlope = (-1)/((d-centerY)/(c-centerX));
		
		//finds angle based on difference between the absolute angles of a,b and c,d on the circle
		firstPointAngle = calcAngle(a,b);
		secondPointAngle = calcAngle(c,d);
		angle = firstPointAngle - secondPointAngle;
		
		//this part finds the angle of a coordinate on the other side of (a,b) from the test point found in the last arc
		testXCoord = a + (a - priorTestX);
		testYCoord = b + (b - priorTestY);
		double testAngle = calcAngle(testXCoord, testYCoord) - secondPointAngle;
		
		//now make the angle the long part instead of the short part if this new test coordinate angle is bigger than the current angle. Remember, it should be smaller,
		//because the test coordinate is essentially "after" (a,b) on the path, so the arc to (c,d) should be smaller
		System.out.println("intitial angle: " + angle);
		if(!isBackwards) {
			if(angle > 0) {
				if(testAngle > angle) 
					angle = angle - 2*Math.PI;
			}
			else if(angle < 0) {
				if(testAngle < angle)
					angle = angle + 2*Math.PI;
			}
		}
		else {
			if(angle > 0) {
				if(testAngle < angle) 
					angle = angle - 2*Math.PI;
			}
			else if(angle < 0) {
				if(testAngle > angle)
					angle = angle + 2*Math.PI;
			}
		}
		System.out.println("angle: " + angle);
		
		//finds distances for the inside and outside wheels to travel
		arcLength = angle*radius;
		double insideWheelDistance = arcLength*(radius/(radius-widthBetweenWheels/2));
		double outsideWheelDistance = arcLength*(radius/(radius+widthBetweenWheels/2));
		if(d < c*m+(b-a*m)) {
			if(angle < 0) {
				rightWheelDistance = -insideWheelDistance;
				leftWheelDistance = -outsideWheelDistance;
			}
			else {
				rightWheelDistance = outsideWheelDistance;
				leftWheelDistance = insideWheelDistance;
			}
		}
		else if(d > c*m+(b-a*m)) {
			if(angle < 0) {
				rightWheelDistance = -insideWheelDistance;
				leftWheelDistance = -outsideWheelDistance;
			}
			else {
				rightWheelDistance = outsideWheelDistance;
				leftWheelDistance = insideWheelDistance;
			}
		}
		else {
			System.out.println("man you messed up. Stop ruining my code. Adjust some of your arcs by like .1. That should fix it." );
		}
		//System.out.println("right distance" + rightWheelDistance + "left distance" + leftWheelDistance);
		
		//now we calculate a new test point based on the angle we found in this arc. We are making a point that comes right "before" (c,d) on the path
		//so that we can find a point that comes right "after" when we feed this into the next arc
		//testTestX1 is a point we are testing as a potential test point :). We need to find whether the test point should be on one side or the other of (c,d)
		//this is accomplished using the angle we already know and the angles that these test test points form
		double testTestX1;
		double testTestY1;
		testTestX1 = c - 0.01;
		testTestY1 = centerY + Math.sqrt(radius*radius - (testTestX1 - centerX)*(testTestX1 - centerX));
		//.5 is an arbitrary value. I don't think this should ever be an issue cuz 1/Math.max_value is really heckin' small, and we're never making circles smaller than
		//like 50 units anyway
		if(Math.abs(d-testTestY1) > .5) {
			testTestY1 = centerY - Math.sqrt(radius*radius - (testTestX1 - centerX)*(testTestX1 - centerX));
		}
		
		double testTestX2;
		double testTestY2;
		testTestX2 = c + 0.01;
		testTestY2 = centerY + Math.sqrt(radius*radius - (testTestX2 - centerX)*(testTestX2 - centerX));
		if(Math.abs(d-testTestY2) > .5) {
			testTestY2 = centerY - Math.sqrt(radius*radius - (testTestX2 - centerX)*(testTestX2 - centerX));
		}
		
		if(angle < 0) {
			if(calcAngle(testTestX1, testTestY1) < secondPointAngle) {
				nextTestX = testTestX1;
				nextTestY = testTestY1;
				secondTestAngle = firstPointAngle - calcAngle(testTestX1, testTestY1);
			}
			else {
				nextTestX = testTestX2;
				nextTestY = testTestY2;
				secondTestAngle = firstPointAngle - calcAngle(testTestX2, testTestY2);
			}
		}
		if(angle > 0) {
			if(calcAngle(testTestX1, testTestY1) > secondPointAngle) {
				nextTestX = testTestX1;
				nextTestY = testTestY1;
				secondTestAngle = firstPointAngle - calcAngle(testTestX1, testTestY1);
			}
			else {
				nextTestX = testTestX2;
				nextTestY = testTestY2;
				secondTestAngle = firstPointAngle - calcAngle(testTestX2, testTestY2);
			}
		}
		
		startAngle = firstPointAngle;
		
	}
	
	/**
	 * calculates an angle based on input coordinates (x and y) and the arc's center x and y
	 **/
	public double calcAngle(double x, double y) {
		double heading = 0;
		if(x > centerX && y > centerY) {
			heading = Math.atan(Math.abs((y-centerY)/(x-centerX)));
		}
		else if(x < centerX && y > centerY) {
			heading = Math.PI - Math.atan(Math.abs((y-centerY)/(x-centerX)));
		}
		else if(x < centerX && y < centerY) {
			heading = Math.PI + Math.atan(Math.abs((y-centerY)/(x-centerX)));
		}
		else if(x > centerX && y < centerY) {
			heading = 2*Math.PI - Math.atan(Math.abs((y-centerY)/(x-centerX)));
		}
		else {
			System.out.println("Yep that'll break the boi. Adjust your points a tiny bit. That should fix");
		}
		return heading;
	}
	
	public void displayValues() {
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);

		System.out.println("circle center x: " + centerX);
		System.out.println("circle center y: " + centerY);
//		System.out.println(k);
//		System.out.println(v);
//		System.out.println(h);
//		System.out.println(q);
		System.out.println("angle: " + angle);
		System.out.println("path length: " + arcLength);
		System.out.println("endslope: " + endSlope);
		System.out.println("start angle:" + (startAngle*180)/Math.PI);
	}
	public void recalibrateDistances() {
		if(robotIsReversed) {
			System.out.println("marker");
			double tempRightWheelDistance = rightWheelDistance;
			rightWheelDistance = -leftWheelDistance;
			leftWheelDistance = -tempRightWheelDistance;
		}
	}
}
