package org.mort11.led;

import edu.wpi.first.wpilibj.command.InstantCommand;

import org.mort11.Robot;

/**
 * This command cycles through every color on the LEDs at the end of the game.This command is an instant command, because it only needs
 * to run once at the end of the game.
 * 
 * @author Joshua Ciffer
 * @version 06/12/2018
 */
public final class CycleEndGameColors extends InstantCommand {

	/**
	 * Constructs a new <code>CycleEndGameColors</code> Command.
	 */
	public CycleEndGameColors() {
		super("CycleEndGameColors");
		requires(Robot.led);
		setInterruptible(true);
	}

	/**
	 * Starts with LEDs turned off.
	 */
	@Override
	protected void initialize() {
		Robot.led.turnOffAll();
	}

	/**
	 * Changes through every color.
	 */
	@Override
	protected void execute() {
		Robot.led.endGameColors();
	}

	/**
	 * Command only runs for 30 seconds.
	 */
	@Override
	protected boolean isFinished() {
		if (timeSinceInitialized() >= 30) {		// Command only runs for 30 seconds.
			Robot.led.turnOffAll();
			return true;
		} else {
			return false;
		}
	}

}