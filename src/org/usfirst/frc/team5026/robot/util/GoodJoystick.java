package org.usfirst.frc.team5026.robot.util;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GoodJoystick {
	public Joystick driveStick;
	public JoystickButton driveStickTrigger; 
	public GoodJoystick(int port){
		driveStick = new Joystick(port);
		driveStickTrigger = new JoystickButton(driveStick, 1);
	}
	public void seeAxis() {
		SmartDashboard.putNumber("Raw X", driveStick.getX());
		SmartDashboard.putNumber("Raw Y", driveStick.getY());
	}
	//Robot.drive.useArcadeDrive(Robot.oi.driveStick.getX()*Constants.X_AXIS_MODIFIER, Robot.oi.driveStick.getY());

	public Vector findXY() {
		// Reverses drive when triggered
		Vector v = driveStickTrigger.get() ? new Vector(driveStick.getX(), driveStick.getY()) : new Vector(driveStick.getX(), -driveStick.getY());
		double magnitude = v.getMagnitude();
		double scaledMagnitude = (magnitude-Constants.CIRCLE_DEADZONE)/(1-Constants.CIRCLE_DEADZONE);
		v.norm();
		v.mult(scaledMagnitude);
		
		//TODO
		v.mult(1.05);
					
		//if(Math.abs(y) < Constants.YDEADZONE_SIZE*Math.abs(driveStick.getX()) || magnitude < Constants.CIRCLE_DEADZONE) {
		if ( magnitude < Constants.CIRCLE_DEADZONE ) {
			v.zero();
		}
		
		SmartDashboard.putNumber("deadzone corrected X", v.getX());
		SmartDashboard.putNumber("deadzone corrected Y", v.getY());
		return v;
	}

	//k = Robot.oi.driveStick.getY()/Robot.oi.driveStick.getX();
	public double findRightPower(double x,double y) {
		boolean isBabyProofed = SmartDashboard.getBoolean("Is Baby Proofed", Constants.IS_BABY_PROOFED);
		if (isBabyProofed) {
			return (y-x)*Constants.BABY_PROOFING_MODIFIER;
		}
			return y-x;
	}
	public double findLeftPower(double x,double y) {
		boolean isBabyProofed = SmartDashboard.getBoolean("Is Baby Proofed", Constants.IS_BABY_PROOFED);
		if (isBabyProofed) {
			return (y+x)*Constants.BABY_PROOFING_MODIFIER;
		}
	        return y+x;
	}
	//Robot.drive.setLeftMotor(Robot.oi.driveStick.getY() + Robot.oi.driveStick.getX());
	//Robot.drive.setRightMotor(Robot.oi.driveStick.getY() - Robot.oi.driveStick.getX());
}


