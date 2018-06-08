package org.mort11.auton;

import edu.wpi.first.wpilibj.command.TimedCommand;

import org.mort11.Robot;
import org.mort11.util.HardwareStates.RollerState;

/**
 * 
 * 
 *
 * @author Joshua Ciffer
 * @version 06/08/2018
 */
public final class RollIntakeTimed extends TimedCommand {

	/**
	 * The speed to set the intake rollers to.
	 */
	private double speed;

	/**
	 * The state to set the intake rollers to.
	 */
	private RollerState rollerState;

	/**
	 * Constructs a new <code>RollIntakeTimed</code> command.
	 *
	 * @param speed
	 *        The speed to set the intake rollers to.
	 * @param request
	 *        The state to set the intake rollers to.
	 * @param timeout
	 *        The duration to run the command, in seconds.
	 */
	public RollIntakeTimed(double speed, RollerState request, double timeout) {
		super(timeout);
		requires(Robot.intakeRollers);
		setInterruptible(true);
		this.speed = speed;
		this.rollerState = request;
	}

	@Override
	protected void execute() {
		switch (rollerState) {
			case IN: {
				Robot.intakeRollers.setRollerSpeed(-speed);
				break;
			}
			case OUT: {
				Robot.intakeRollers.setRollerSpeed(speed);
				break;
			}
			case STOP: {
				Robot.intakeRollers.setRollerSpeed(0);
				break;
			}
			case COAST: {
				break;
			}
		}
	}

	/**
	 * Sets the roller speed to 0 at the completion of this command.
	 */
	@Override
	protected void end() {
		Robot.intakeRollers.setRollerSpeed(0);
	}

}