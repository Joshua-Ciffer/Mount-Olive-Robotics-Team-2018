package org.mort11.climber;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.mort11.hardware.IO;
import org.mort11.util.HardwareStates.ClimberState;

/**
 * The climber subsystem consists of a piston that extends up or down to climb.
 *
 * @author Joshua Ciffer
 * @version 06/13/2018
 */
public final class Climber extends Subsystem {

	/**
	 * Constructs a new <code>Climber</code> subsystem.
	 */
	public Climber() {
		super("Climber");
	}

	/**
	 * Sets no default command.
	 */
	@Override
	protected void initDefaultCommand() {}

	/**
	 * Actuates the climber piston to the desired state.
	 *
	 * @param state
	 *        The state to actuate the piston.
	 */
	public void actuateClimber(ClimberState state) {
		switch (state) {
			case EXTENDED: {
				IO.getClimberPiston().set(Value.kForward);
				break;
			}
			case RETRACTED: {
				IO.getClimberPiston().set(Value.kReverse);
				break;
			}
		}
	}

	/**
	 * Disables the climber piston.
	 */
	public void halt() {
		IO.getClimberPiston().set(Value.kOff);
	}

}