package org.mort11.intake;

import edu.wpi.first.wpilibj.command.Command;

import org.mort11.Robot;
import org.mort11.util.HardwareStates.IntakePistonState;

/**
 * Command that actuates the intake piston to the desired state triggered by a button press on the operator joystick.
 * 
 * @author Joshua Ciffer
 * @version 06/12/2018
 */
public final class ActuateIntakePiston extends Command {

	/**
	 * The state to put the piston in.
	 */
	private IntakePistonState pistonState;

	/**
	 * Constructs a new <code>ActuateIntakePiston</code> command.
	 *
	 * @param pistonState
	 *        The state to put the piston in.
	 */
	public ActuateIntakePiston(IntakePistonState pistonState) {
		super("ActuateIntakePiston");
		this.pistonState = pistonState;
		requires(Robot.intakePiston);
		setInterruptible(false);
	}

	/**
	 * Actuates the intake piston to the desired state.
	 */
	@Override
	protected void execute() {
		Robot.intakePiston.actuate(pistonState);
	}

	/**
	 * Command returns true after actuating the piston.
	 */
	@Override
	protected boolean isFinished() {
		return true;
	}

}