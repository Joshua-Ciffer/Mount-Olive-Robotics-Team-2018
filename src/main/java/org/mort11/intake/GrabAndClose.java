package org.mort11.intake;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.mort11.util.Constants;
import org.mort11.util.HardwareStates.IntakeRollersState;

/**
 * Command to grab a cube and close the intake. Command is triggered by a button on the operator joystick.
 *
 * @author Joshua Ciffer
 * @version 06/12/2018
 */
public final class GrabAndClose extends CommandGroup {

	/**
	 * Constructs a new <code>GrabAndClose</code> command.
	 */
	public GrabAndClose() {
		super("GrabAndClose");
		setInterruptible(true);
		addParallel(new RollIntake(IntakeRollersState.IN), Constants.ROLLER_TIMEOUT);
	}

	/**
	 * Command finishes if the intake limit switches are both pressed (a cube is in the intake).
	 */
	@Override
	protected boolean isFinished() {
		return false;
	}

}