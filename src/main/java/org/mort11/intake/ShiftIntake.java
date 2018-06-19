package org.mort11.intake;

import edu.wpi.first.wpilibj.command.Command;

import org.mort11.Robot;
import org.mort11.util.HardwareStates.IntakeShiftState;;

/**
 * Command to shift the intake into the up or down position.
 * 
 * @author Joshua Ciffer
 * @version 06/12/2018
 */
public final class ShiftIntake extends Command {

	/**
	 * The state to shift the intake piston to.
	 */
	private IntakeShiftState pistonState;

	/**
	 * Constructs a new <code>ShiftIntake</code> command.
	 *
	 * @param pistonState
	 *        The state to shift the intake piston to.
	 */
	public ShiftIntake(IntakeShiftState pistonState) {
		super("ShiftIntake");
		this.pistonState = pistonState;
		requires(Robot.intakeShifter);
		setInterruptible(false);
	}

	/**
	 * Shifts the intake to the desired state.
	 */
	@Override
	protected void execute() {
		Robot.intakeShifter.shift(pistonState);
	}

	/**
	 * Command completes after shifting the intake.
	 */
	@Override
	protected boolean isFinished() {
		return true;
	}

}