package org.mort11.Commands.endeffector.IntakeCommands;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Hardware.HardwareStates;
import org.mort11.Robot;

/**
 *
 * @author Joshua Ciffer
 * @author Benny Mirisola
 * @author Seven Kurt
 * @version 02/14/2018
 */
public class ActuatePiston extends Command {

	private HardwareStates.IntakePistonState pistonState;

	public ActuatePiston(HardwareStates.IntakePistonState pistonState) {
		super("ActuatePiston");
		requires(Robot.intakePistons);
		setInterruptible(true);
		this.pistonState = pistonState;
	}

	@Override
	protected void execute() {
		Robot.intakePistons.actuatePiston(pistonState);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

}