package org.mort11.intake;

import edu.wpi.first.wpilibj.command.Command;

import org.mort11.hardware.IO;
import org.mort11.util.HardwareStates.IntakeRollersState;
import org.mort11.util.Constants;
import org.mort11.Robot;

/**
 * The roll intake command runs the intake rollers depending on the state they are currently in.
 *
 * @author Joshua Ciffer
 * @version 06/12/2018
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
		requires(Robot.intakeRollers);
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
				Robot.intakeRollers.setRollerSpeed(Constants.INTAKE_SPEED);
				break;
			}
			case OUT: {
				Robot.intakeRollers.setRollerSpeed(Constants.INTAKE_OUTAKE_SPEED);
				break;
			}
			case STOP: {
				Robot.intakeRollers.halt();
				break;
			}
			case COAST: {
				break;
			}
		}
	}

	/**
	 * The intake rollers will roll continuously if they are coasting, outtaking, or stopped. In any of those situations, this command is canceled
	 * by a button press or button release from the operator joystick. If intaking, the command completes if a cube hits both the intake limit switches.
	 * 
	 * @return Whether or not the intake rollers are finished running.
	 */
	@Override
	protected boolean isFinished() {
		switch (rollerState) {
			case COAST: {
				break;
			}
			case OUT: {
				break;
			}
			case STOP: {
				break;
			}
			case IN: {
				if (!IO.getIntakeLimitSwitchLeft().get() || !IO.getIntakeLimitSwitchRight().get()) {
					return true;
				}
				break;
			}
		}
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