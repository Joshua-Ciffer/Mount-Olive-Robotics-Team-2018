package org.mort11.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.mort11.hardware.IO;
import org.mort11.util.HardwareStates.IntakeShiftState;

/**
 * The intake shifter subsystem represents the piston that moves the intake into an up or down position.
 * 
 * @author Joshua Ciffer
 * @version 06/12/2018
 */
public final class IntakeShifter extends Subsystem {

	/**
	 * Constructs a new <code>IntakeShifter</code> subsystem.
	 */
	public IntakeShifter() {
		super("IntakeShifter");
	}

	/**
	 * By default, subsystem is shifted into the down position.
	 */
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ShiftIntake(IntakeShiftState.DOWN));
	}

	/**
	 * Shifts the intake into the desired position.
	 *
	 * @param pistonState
	 *        The state to shift the intake pistons to.
	 */
	public void shift(IntakeShiftState pistonState) {
		switch (pistonState) {
			case UP: {
				IO.getIntakeShifterPiston().set(Value.kReverse);
				break;
			}
			case DOWN: {
				IO.getIntakeShifterPiston().set(Value.kForward);
				break;
			}
		}
	}

	/**
	 * Disables the intake shifter piston.
	 */
	public void halt() {
		IO.getIntakeShifterPiston().set(Value.kOff);
	}

}