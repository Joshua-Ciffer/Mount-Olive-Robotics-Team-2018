package org.mort11.led;

import edu.wpi.first.wpilibj.command.Command;

import org.mort11.Robot;

/**
 * This command turns off all of the LEDs while the robot is disabled.
 * 
 * @author Joshua Ciffer
 * @version 06/12/2018
 */
public final class DisableLEDs extends Command {

	/**
	 * Constructs a new <code>DisableLEDs</code> Command.
	 */
	public DisableLEDs() {
		super("DisableLEDs");
		requires(Robot.led);
		setInterruptible(true);
	}

	/**
	 * Sets all LEDs to off.
	 */
	@Override
	protected void initialize() {
		Robot.led.turnOffAll();
	}

	/**
	 * Calls the command method in the subsystem class.
	 */
	@Override
	protected void execute() {
		Robot.led.turnOffAll();
	}

	/**
	 * Command runs continuously.
	 */
	@Override
	protected boolean isFinished() {
		return false;
	}

}