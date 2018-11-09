package org.mort11.intake;

import edu.wpi.first.wpilibj.command.Command;

import org.mort11.util.HardwareStates.IntakeRollersState;
import org.mort11.util.Constants;
import org.mort11.Robot;

/**
 * The roll intake command runs the intake rollers depending on the state they are currently in.
 *
 * @author Joshua Ciffer
 * @version 11/08/2018
 */
public final class RollIntake extends Command {

	/**
	 * The state the intake rollers are currently operating in.
	 */
	private IntakeRollersState rollerState;

	/**
	 * Constructs a new <code>RollIntake</code> command.
	 *
	 * @param rollerState
	 *        The state to set the intake rollers to.
	 */
	public RollIntake(IntakeRollersState rollerState) {
		super("Roll intake");
		this.rollerState = rollerState;
		requires(Robot.getIntakeRollers());
		setInterruptible(true);
	}

	/**
	 * When the intake rollers are intaking a cube, they are set to the intake speed. When the intake rollers are outtaking a cube, they are set
	 * to the outtake speed. When they are set to the stop state, they are halted.
	 */
	@Override
	protected void execute() {
		switch (rollerState) {
			case IN: {
				Robot.getIntakeRollers().setRollerSpeed(Constants.INTAKE_SPEED);
				break;
			}
			case OUT: {
				Robot.getIntakeRollers().setRollerSpeed(Constants.OUTTAKE_SPEED);
				break;
			}
			case STOP: {
				Robot.getIntakeRollers().halt();
				break;
			}
		}
	}

	/**
	 * @return False, because command never completes until button is released.
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
		Robot.getIntakeRollers().halt();
	}

}