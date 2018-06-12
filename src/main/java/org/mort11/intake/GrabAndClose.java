package org.mort11.intake;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.mort11.hardware.IO;
import org.mort11.util.Constants;
import org.mort11.util.HardwareStates.IntakePistonState;
import org.mort11.util.HardwareStates.RollerState;

/**
 * 
 * 
 *
 * @author Joshua Ciffer
 * @version 06/12/2018
 */
public final class GrabAndClose extends CommandGroup {

	/**
	 * Constructs a new <code>GrabAndClose</code> command.
	 *
	 *
	 */
	public GrabAndClose() {
		setInterruptible(true);
		addParallel(new ActuateIntakePiston(IntakePistonState.OUT));
		addParallel(new RollIntake(Constants.INTAKE_SPEED, RollerState.IN), Constants.ROLLER_TIMEOUT);
	}

	/**
	 * Command finishes if the intake limit switches are both pressed.
	 */
	@Override
	protected boolean isFinished() {
		return !IO.getIntakeLimitSwitchLeft().get() && !IO.getIntakeLimitSwitchRight().get();
	}

}