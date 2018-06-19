package org.mort11.drivetrain;

import edu.wpi.first.wpilibj.command.Command;

import org.mort11.Robot;
import org.mort11.control.Operator;

/**
 * The main command that operates the drivetrain based on joystick input from the driver.
 * 
 * @author Zach "Bad Push" Rich
 * @author Joshua Ciffer
 * @version 06/12/2018
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
	 * Set drivetrain speed to operator joystick input.
	 */
	@Override
	protected void execute() {
		Robot.drivetrain.setLeftSpeed(Operator.getLeftDriverJoystick().getY());
		Robot.drivetrain.setRightSpeed(Operator.getRightDriverJoystick().getY());
	}

	/**
	 * Command always returns false.
	 */
	@Override
	protected boolean isFinished() {
		return false;
	}

}