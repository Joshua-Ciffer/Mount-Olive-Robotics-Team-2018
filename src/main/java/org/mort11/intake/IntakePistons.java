package org.mort11.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.mort11.hardware.IO;
import org.mort11.util.HardwareStates.IntakePistonState;;

/**
 * The intake piston subsystem represents the claw thing that actually grabs the cube. When the piston is in, a cube is being held. When the
 * piston is out, a cube would be released.
 *
 * @author Joshua Ciffer
 * @version 06/12/2018
 */
public final class IntakePistons extends Subsystem {

	/**
	 * Constructs a new <code>IntakePistons</code> subsystem.
	 */
	public IntakePistons() {
		super("IntakePistons");
	}

	/**
	 * Sets no default command.
	 */
	@Override
	protected void initDefaultCommand() {}

	/**
	 * Actuates the intake pistons to the desired state.
	 *
	 * @param pistonState
	 *        The state to actuate the piston.
	 */
	public void actuate(IntakePistonState pistonState) {
		switch (pistonState) {
			case IN: {
				IO.getIntakePiston().set(Value.kReverse);
				break;
			}
			case OUT: {
				IO.getIntakePiston().set(Value.kForward);
				break;
			}
		}
	}

	/**
	 * Disables the intake pistons.
	 */
	public void halt() {
		IO.getIntakePiston().set(Value.kOff);
	}

}