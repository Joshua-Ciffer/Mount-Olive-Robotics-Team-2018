package org.mort11.intake;

import edu.wpi.first.wpilibj.command.Command;

import org.mort11.Robot;
import org.mort11.hardware.IO;
import org.mort11.util.Constants;

/**
 * Command that coasts the intake rollers when triggered by a button press from the operator joystick.
 *
 * @author Joshua Ciffer
 * @version 06/12/2018
 */
public final class CoastIntake extends Command {

	/**
	 * Constructs a new <code>CoastIntake</code> command.
	 */
	public CoastIntake() {
		super("CoastIntake");
		requires(Robot.intakeRollers);
		setInterruptible(true);
	}

	/**
	 * If both intake limit switches are pressed, coast the intake rollers.
	 */
	@Override
	protected void execute() {
		if (!IO.getIntakeLimitSwitchLeft().get() && !IO.getIntakeLimitSwitchRight().get()) {
			Robot.intakeRollers.setRollerSpeed(-Constants.INTAKE_COAST);
		}
	}

	/**
	 * Command always returns false.
	 */
	@Override
	protected boolean isFinished() {
		return false;
	}

	/**
	 * Intake rollers are halted upon completion of this command.
	 */
	@Override
	protected void end() {
		Robot.intakeRollers.halt();
	}

}