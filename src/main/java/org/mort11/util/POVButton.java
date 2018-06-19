package org.mort11.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Makes a button out of the POV hat.
 *
 * @author Matt Turi
 */
public class POVButton extends Trigger {

	private POV button;
	private Joystick joystick;

	public POVButton(Joystick joystick, POV button) {
		this.button = button;
		this.joystick = joystick;
	}

	/**
	 * Starts the given command whenever the button is newly pressed.
	 *
	 * @param command
	 *        the command to start
	 */
	public void whenPressed(final Command command) {
		whenActive(command);
	}

	/**
	 * Constantly starts the given command while the button is held.
	 * <p>
	 * {@link Command#start()} will be called repeatedly while the button is held,
	 * and will be canceled when the button is released.
	 *
	 * @param command
	 *        the command to start
	 */
	public void whileHeld(final Command command) {
		whileActive(command);
	}

	/**
	 * Starts the command when the button is released
	 *
	 * @param command
	 *        the command to start
	 */
	public void whenReleased(final Command command) {
		whenInactive(command);
	}

	/**
	 * Toggles the command whenever the button is pressed (on then off then on)
	 *
	 * @param command
	 *        the command to start
	 */
	public void toggleWhenPressed(final Command command) {
		toggleWhenActive(command);
	}

	/**
	 * Cancel the command when the button is pressed
	 *
	 * @param command
	 *        the command to start
	 */
	public void cancelWhenPressed(final Command command) {
		cancelWhenActive(command);
	}

	@Override
	public boolean get() {
		return joystick.getPOV() == button.direction;
	}
	
}