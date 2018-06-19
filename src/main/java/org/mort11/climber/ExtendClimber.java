package org.mort11.climber;

import edu.wpi.first.wpilibj.command.Command;

import org.mort11.Robot;
import org.mort11.util.HardwareStates.ClimberState;

/**
 * Command to extend the climber piston.
 *
 * @author Joshua Ciffer
 * @version 06/13/2018
 */
public final class ExtendClimber extends Command {

	/**
	 * Constructs a new <code>ExtendClimber</code> command.
	 */
	public ExtendClimber() {
		super("ExtendClimber");
		requires(Robot.climber);
		setInterruptible(false);
	}

	/**
	 * Extends the climber piston.
	 */
	@Override
	protected void execute() {
		Robot.climber.actuateClimber(ClimberState.EXTENDED);
	}

	/**
	 * Command returns true as soon as it completes.
	 */
	@Override
	protected boolean isFinished() {
		return true;
	}

}