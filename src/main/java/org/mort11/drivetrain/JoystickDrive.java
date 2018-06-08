package org.mort11.drivetrain;

import edu.wpi.first.wpilibj.command.Command;

import org.mort11.Robot;
import org.mort11.control.Operator;

/**
 * The main command that operates the drivetrain based on joystick input from the driver.
 * 
 * @author Zach "Bad Push" Rich
 * @author Joshua Ciffer
 * @version 06/08/2018
 */
public final class JoystickDrive extends Command {

	/**
	 * Constructs a new <code>JoystickDrive</code> command.
	 */
	public JoystickDrive() {
		super("JoystickDrive");
		requires(Robot.drivetrain);
		setInterruptible(false);
	}

	/**
	 * Set drivetrain sides to operator joystick input.
	 */
	@Override
	protected void execute() {
		Robot.drivetrain.setLeftDriveSpeed(Operator.getLeftDriverJoystick().getX());
		Robot.drivetrain.setRightDriveSpeed(Operator.getRightDriverJoystick().getY());
	}

	/**
	 * The limit switch is false when it is pressed. The switch returns true when it is not pressed.
	 * If the limit switch is pressed (false) then isFinished() returns true because the switch would
	 * then stop robot movement.
	 *
	 * @return Returns whether or not the command has been interrupted.
	 */
	@Override
	protected boolean isFinished() {
		return false;
	}

}