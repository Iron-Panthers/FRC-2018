package org.usfirst.frc.team5026.robot;

import org.usfirst.frc.team5026.robot.util.Constants;
import org.usfirst.frc.team5026.robot.util.ElevatorMotorGroup;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PowerDistributionPanel;

public class Hardware {
	public TalonSRX elevatorMotor;
	public TalonSRX elevatorSlaveMotor;
	public ElevatorMotorGroup elevatorMotors;
//	public DigitalInput limitSwitchF;
//	public DigitalInput limitSwitchR;
	public DoubleSolenoid leftSolenoid;
	public DoubleSolenoid rightSolenoid;
	public PowerDistributionPanel pdp;
	
	public Hardware() {
		elevatorMotor = new TalonSRX(RobotMap.ELEVATOR_MASTER);
		elevatorSlaveMotor = new TalonSRX(RobotMap.ELEVATOR_SLAVE);
		elevatorMotors = new ElevatorMotorGroup(elevatorMotor, elevatorSlaveMotor);
//		elevatorMotor.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
//		elevatorMotor.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyClosed, 0);
		// TODO Constants/RobotMap
		elevatorMotor.setInverted(Constants.IS_ELEVATOR_INVERTED);
		elevatorSlaveMotor.setInverted(Constants.IS_ELEVATOR_INVERTED);
		elevatorMotor.setSensorPhase(!Constants.IS_ELEVATOR_SENSOR_INVERTED);
//		slaveMotor.setInverted(Constants.IS_ELEVATOR_INVERTED);
		
//		limitSwitchF = new DigitalInput(RobotMap.LIMIT_SWTICH_F);
//		limitSwitchR = new DigitalInput(RobotMap.LIMIT_SWTICH_R);
		leftSolenoid = new DoubleSolenoid(RobotMap.LEFT_SOLENOID_PORT_1, RobotMap.LEFT_SOLENOID_PORT_2);
		rightSolenoid = new DoubleSolenoid(RobotMap.RIGHT_SOLENOID_PORT_1, RobotMap.RIGHT_SOLENOID_PORT_2);

		pdp = new PowerDistributionPanel();
	}
}