package org.mort11.auton;

import edu.wpi.first.wpilibj.command.Command;

import org.mort11.Robot;

/**
 * A simple auton command to have the robot do nothing.
 *
 * @author Joshua Ciffer
 * @version 06/08/2018
 */
public final class DoNothing extends Command {

	/**
	 * Constructs a new <code>DoNothing</code> command.
	 */
	public DoNothing() {
		super("DoNothing");
	}

	/**
	 * Command does nothing while executing.
	 */
	@Override
	protected void execute() {}

	/**
	 * Command returns true instantly and terminates.
	 */
	@Override
	protected boolean isFinished() {
		return true;
	}

	/**
	 * Drivetrain is halted upon termination of this command.
	 */
	@Override
	protected void end() {
		Robot.drivetrain.halt();
	}

}