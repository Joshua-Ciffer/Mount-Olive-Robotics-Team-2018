package org.mort11.drivetrain;

import edu.wpi.first.wpilibj.command.Command;

import org.mort11.Robot;
import org.mort11.util.HardwareStates.DrivetrainGear;

/**
 * Command that runs upon a button press to change the gear of the drivetrain.
 *
 * @author Zach "Merge Error" Rich
 * @author Joshua Ciffer
 * @version 06/12/2018
 */
public final class ShiftDrivetrain extends Command {

	/**
	 * The gear the drivetrain is put in to.
	 */
	private DrivetrainGear gear;

	/**
	 * Constructs a new <code>ShiftDrivetrain</code> command.
	 * 
	 * @param gear
	 *        The gear to shift the drivetrain to.
	 */
	public ShiftDrivetrain(DrivetrainGear gear) {
		super("ShiftDrivetrain");
		this.gear = gear;
		setInterruptible(false);
	}

	/**
	 * Calls shifting method in drivetrain subsystem class.
	 */
	@Override
	protected void execute() {
		Robot.drivetrain.shift(gear);
	}

	/**
	 * Returns true after the drivetrain is shifted.
	 */
	@Override
	protected boolean isFinished() {
		return true;
	}

}