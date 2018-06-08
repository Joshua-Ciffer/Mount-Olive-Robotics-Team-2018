package org.mort11.drivetrain;

import edu.wpi.first.wpilibj.command.Command;

import org.mort11.Robot;
import org.mort11.util.HardwareStates.Gear;

/**
 * Command that runs upon a button press to change the gear of the drivetrain.
 *
 * @author Zach Rich
 * @author Joshua Ciffer
 * @version 06/08/2018
 */
public final class ShiftDrivetrain extends Command {

	/**
	 * The gear the drivetrain is put in to.
	 */
	private Gear gear;

	/**
	 * Constructs a new <code>ShiftDrivetrain</code> command.
	 * 
	 * @param gear
	 *        The gear to shift the drivetrain to.
	 */
	public ShiftDrivetrain(Gear gear) {
		super("ShiftDrivetrain");
		this.gear = gear;
		setInterruptible(false);
	}

	/**
	 * Calls shifting method in drivetrain subsystem class.
	 */
	protected void execute() {
		Robot.drivetrain.shift(gear);
	}

	/**
	 * Always returns true because command never finishes.
	 */
	@Override
	protected boolean isFinished() {
		return true;
	}

}