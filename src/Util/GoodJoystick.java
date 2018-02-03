package Util;
import org.usfirst.frc.team5026.robot.Constants;
import org.usfirst.frc.team5026.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GoodJoystick {
	public double x;
	public double y;
	public GoodJoystick(){
	}
	double right;
	double left;
	public void seeAxis() {
		SmartDashboard.putNumber("Joystick X Axis", Robot.oi.driveStick.getX());
		SmartDashboard.putNumber("Joystick Y Axis", Robot.oi.driveStick.getY());
	}
	//Robot.drive.useArcadeDrive(Robot.oi.driveStick.getX()*Constants.X_AXIS_MODIFIER, Robot.oi.driveStick.getY());

	public void findXY() {
		y = -Robot.oi.driveStick.getY();
		x = Robot.oi.driveStick.getX();
		if(Math.abs(y) < Constants.DEADZONE_SIZE) {
			y=0;
		}
		if(Math.abs(x) < Constants.DEADZONE_SIZE) {
			x=0;
		}
		x = (x - Constants.DEADZONE_SIZE);
		if(Robot.drive.isReversed) {
			y = -y;
			x = -x;
		}
	}
	//k = Robot.oi.driveStick.getY()/Robot.oi.driveStick.getX();
	public double findRightPower() {
			right = y - x;
			return right;
	}
	public double findLeftPower() {
	        left = y + x;
	        return left;
	}
//	Robot.drive.setLeftMotor(Robot.oi.driveStick.getY() + Robot.oi.driveStick.getX());
//	Robot.drive.setRightMotor(Robot.oi.driveStick.getY() - Robot.oi.driveStick.getX());
}


