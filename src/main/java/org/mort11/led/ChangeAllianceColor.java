package org.mort11.led;

import edu.wpi.first.wpilibj.command.Command;

import org.mort11.Robot;

/**
 * This command will change the LEDs color from red to blue depending on the robot's alliance.
 * 
 * @author Joshua Ciffer
 * @version 06/12/2018
 */
public final class ChangeAllianceColor extends Command {

	/**
	 * Constructs a new <code>ChangeAllianceColor</code> Command.
	 */
	public ChangeAllianceColor() {
		super("ChangeAllianceColor");
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
	 * Calls the command method in the LED subsystem class.
	 */
	@Override
	protected void execute() {
		Robot.led.changeAllianceColor();
	}

	/**
	 * Command runs continuously.
	 */
	@Override
	protected boolean isFinished() {
		return false;
	}

}