package org.mort11.elevator;

import edu.wpi.first.wpilibj.command.Command;

import org.mort11.Robot;
import org.mort11.hardware.IO;
import org.mort11.util.Constants;

/**
 * A command to move the elevator to its lowest point.
 *
 * @author Joshua Ciffer
 * @version 06/13/2018
 */
public final class MoveElevatorDown extends Command {

	/**
	 * Constructs a new <code>MoveElevatorDown</code> command.
	 */
	public MoveElevatorDown() {
		super("MoveElevatorDown");
		requires(Robot.elevator);
		setInterruptible(true);
	}

	/**
	 * Moves the elevator down until command finishes.
	 */
	@Override
	protected void execute() {
		Robot.elevator.setSpeedPercentMode(-Constants.ELEVATOR_SPEED);
	}

	/**
	 * Command finishes if the bottom elevator limit switch is pressed.
	 */
	@Override
	protected boolean isFinished() {
		return !IO.getBottomElevatorLimitSwitch().get();
	}

	/**
	 * Elevator is halted upon completion of this command.
	 */
	@Override
	protected void end() {
		Robot.elevator.halt();
	}

}