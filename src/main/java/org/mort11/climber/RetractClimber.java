package org.mort11.climber;

import edu.wpi.first.wpilibj.command.Command;

import org.mort11.Robot;
import org.mort11.util.HardwareStates.ClimberState;

/**
 * Command to retract the climber piston.
 *
 * @author Joshua Ciffer
 * @version 06/13/2018
 */
public final class RetractClimber extends Command {

	/**
	 * Constructs a new <code>RetractClimber</code> command.
	 */
	public RetractClimber() {
		super("RetractClimber");
		requires(Robot.climber);
		setInterruptible(false);
	}

	/**
	 * Retracts the climber piston.
	 */
	@Override
	protected void execute() {
		Robot.climber.actuateClimber(ClimberState.RETRACTED);
	}

	/**
	 * Command returns true as soon as it completes.
	 */
	@Override
	protected boolean isFinished() {
		return true;
	}

}