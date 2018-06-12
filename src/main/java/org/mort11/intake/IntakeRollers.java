package org.mort11.intake;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.mort11.hardware.IO;
import org.mort11.util.HardwareStates.IntakeRollersState;
import org.mort11.util.Constants;

/**
 * 
 *
 * @author Joshua Ciffer
 * @version 06/12/2018
 */
public final class IntakeRollers extends Subsystem {

	/**
	 * 
	 */
	private IntakeRollersState rollerState;

	public IntakeRollers() {
		super("IntakeRollers");
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new CoastIntake());
	}

	public void setRollerSpeed(double speed) {
		IO.getIntakeRollerVictorLeft().set(Constants.CONTROL_MODE, speed);
		IO.getIntakeRollerVictorRight().set(Constants.CONTROL_MODE, speed);
	}

	public void halt() {
		setRollerSpeed(0);
	}

	public void setRollerState(IntakeRollersState rollerState) {
		this.rollerState = rollerState;
	}

	public IntakeRollersState getRollerState() {
		return rollerState;
	}

}