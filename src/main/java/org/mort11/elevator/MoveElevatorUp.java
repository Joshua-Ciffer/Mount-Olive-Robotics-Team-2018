package org.mort11.elevator;

import edu.wpi.first.wpilibj.command.Command;

import org.mort11.Robot;
import org.mort11.hardware.IO;
import org.mort11.util.Constants;

/**
 * Command to move the elevator into its highest position.
 *
 * @author Joshua Ciffer
 * @version 06/13/2018
 */
public final class MoveElevatorUp extends Command {

	/**
	 * Constructs a new <code>MoveElevatorUp</code> command.
	 */
	public MoveElevatorUp() {
		super("MoveElevatorUp");
		requires(Robot.getElevator());
		setInterruptible(true);
	}

	/**
	 * Elevator is moved up until the command finishes.
	 */
	@Override
	protected void execute() {
		Robot.getElevator().setSpeedPercentMode(Constants.ELEVATOR_SPEED);
	}

	/**
	 * Command finishes if the top elevator limit switch is pressed.
	 */
	@Override
	protected boolean isFinished() {
		return !IO.getTopElevatorLimitSwitch().get();
	}

	/**
	 * Elevator is halted upon completion of this command.
	 */
	@Override
	protected void end() {
		Robot.getElevator().halt();
	}

}