package org.usfirst.frc.team5026.robot.commands;
 
import org.usfirst.frc.team5026.robot.Robot;
import org.usfirst.frc.team5026.robot.util.Constants;
 
import edu.wpi.first.wpilibj.command.TimedCommand;
 
/**
 *
 */
public class OuttakeForTime extends TimedCommand {
 
    public OuttakeForTime(double timeout) {
        super(timeout);
        requires(Robot.intake);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
 
    // Called just before this Command runs the first time
    protected void initialize() {
    }
 
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
      Robot.intake.outtake(Constants.OUTTAKE_POWER);
    }
 
    // Called once after timeout
    protected void end() {
    }
 
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}