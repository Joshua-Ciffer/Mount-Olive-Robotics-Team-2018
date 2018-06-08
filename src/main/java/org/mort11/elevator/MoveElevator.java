package org.mort11.elevator;

import edu.wpi.first.wpilibj.command.Command;

import org.mort11.control.Operator;
import org.mort11.hardware.IO;
import org.mort11.util.Constants;
import org.mort11.Robot;

/**
 * Command to move the elevator up or down based on input from the operator joystick.
 *
 * @author Joshua Ciffer
 * @version 06/08/2018
 */
public final class MoveElevator extends Command {

	/**
	 * The speed to move the elevator.
	 */
	private double speed;

	/**
	 * Constructs a new <code>MoveElevator</code> command.
	 */
	public MoveElevator() {
		super("MoveElevator");
		requires(Robot.elevator);
	}

	protected void execute() {
		speed = Operator.getLeftOperatorJoystick().getY();
		if (speed > Constants.MOTOR_DEADZONE) {
			Robot.elevator.setVelocity(-speed);
		}
	}

	/**
	 * 
	 */
	@Override
	protected boolean isFinished() {
		if (!IO.getFirstStageElevatorLimitSwitchBottom().get() || (speed < Constants.MOTOR_DEADZONE)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Sets the elevator speed to zero at the completion of this command.
	 */
	protected void end() {
		Robot.elevator.setVelocity(0);
	}

}