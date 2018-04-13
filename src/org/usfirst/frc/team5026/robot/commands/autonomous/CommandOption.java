package org.usfirst.frc.team5026.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This Command allows a user to input the data nescessary for any of the four different sequences in auto.
 * This class can then be used as a parameter for a {@link FindGameDataAndAddCommand}.
 */
public class CommandOption {
	public Command leftSwitchLeftScale;
	public Command leftSwitchRightScale;
	public Command rightSwitchLeftScale;
	public Command rightSwitchRightScale;
	
	/**
	 * Construct this with LL, LR, RL, and RR Commands in that order.
	 * If the length of cmds is 2, then it will be assumed that the first command is the same for LL and LR, and the second command is the same for RL and RR.
	 * 
	 * @param cmds the commands to be associated with the data.
	 */
	public CommandOption(Command... cmds) {
		if (cmds.length > 2) {
			leftSwitchLeftScale = cmds[0];
			leftSwitchRightScale = cmds[1];
			rightSwitchLeftScale = cmds[2];
			rightSwitchRightScale = cmds[3];
		} else if (cmds.length == 2) {
			leftSwitchLeftScale = cmds[0];
			leftSwitchRightScale = cmds[1];
			rightSwitchLeftScale = cmds[0];
			rightSwitchRightScale = cmds[1];
		} else {
			throw new IllegalArgumentException("You put in too few commands in the CommandOption constructor!");
		}
	}
}
