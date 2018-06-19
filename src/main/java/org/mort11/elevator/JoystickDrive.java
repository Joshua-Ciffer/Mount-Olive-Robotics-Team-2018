package org.mort11.elevator;

import edu.wpi.first.wpilibj.command.Command;

import org.mort11.control.Operator;
import org.mort11.hardware.IO;
import org.mort11.Robot;

/**
 * Command to move the elevator up or down based on input from the operator joystick.
 *
 * @author Joshua Ciffer
 * @version 06/13/2018
 */
public final class JoystickDrive extends Command {

	/**
	 * The speed to move the elevator.
	 */
	private double speed;

	/**
	 * Constructs a new <code>MoveElevator</code> command.
	 */
	public JoystickDrive() {
		super("JoystickDrive");
		requires(Robot.elevator);
		setInterruptible(false);
	}

	/**
	 * Moves the elevator up or down based on y-axis input from the operator joystick.
	 */
	@Override
	protected void execute() {
		speed = Operator.getLeftDriverJoystick().getY();
		if (!IO.getTopElevatorLimitSwitch().get()) {	// If the elevator is at the top,
			if (speed < 0) {	// Only move it as long as it is going down.
				Robot.elevator.setSpeedPercentMode(speed);
			}
		} else if (!IO.getBottomElevatorLimitSwitch().get()) {	// If the elevator is at the bottom,
			if (speed > 0) {	// Only move it as long as it is going up.
				Robot.elevator.setSpeedPercentMode(speed);
			}
		} else {	// Otherwise, move it in whatever direction.
			Robot.elevator.setSpeedPercentMode(Operator.getLeftOperatorJoystick().getY());
		}
	}

	/**
	 * Command always returns false.
	 */
	@Override
	protected boolean isFinished() {
		return false;
	}

	/**
	 * Sets the elevator speed to zero at the completion of this command.
	 */
	@Override
	protected void end() {
		Robot.elevator.halt();
	}

}