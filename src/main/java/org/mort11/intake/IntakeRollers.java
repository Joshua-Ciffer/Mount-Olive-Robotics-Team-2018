package org.mort11.intake;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.mort11.hardware.IO;
import org.mort11.util.HardwareStates.IntakeRollersState;
import org.mort11.util.Constants;

/**
 * The subsystem representing the intake roller wheels that intake or outtake a cube.
 *
 * @author Joshua Ciffer
 * @version 06/12/2018
 */
public final class IntakeRollers extends Subsystem {

	/**
	 * The state the intake rollers are currently in.
	 */
	private IntakeRollersState rollerState;

	/**
	 * Constructs a new <code>IntakeRollers</code> subsystem.
	 */
	public IntakeRollers() {
		super("IntakeRollers");
	}

	/**
	 * Sets the default command to coast the intake.
	 */
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new CoastIntake());
	}

	/**
	 * @param speed
	 *        The speed to set the intake rollers.
	 */
	public void setRollerSpeed(double speed) {
		IO.getIntakeRollerVictorLeft().set(Constants.CONTROL_MODE, speed);
		IO.getIntakeRollerVictorRight().set(Constants.CONTROL_MODE, speed);
	}

	/**
	 * Sets the intake rollers' speed to zero.
	 */
	public void halt() {
		setRollerSpeed(0);
	}

	/**
	 * @return The state the intake rollers are currently in.
	 */
	public IntakeRollersState getRollerState() {
		return rollerState;
	}

	/**
	 * @param rollerState
	 *        The state to set the intake rollers to.
	 */
	public void setRollerState(IntakeRollersState rollerState) {
		this.rollerState = rollerState;
	}

}