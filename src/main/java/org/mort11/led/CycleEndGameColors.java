package org.mort11.led;

import edu.wpi.first.wpilibj.command.InstantCommand;
import org.mort11.Robot;
import org.mort11.hardware.IO;
import static org.mort11.util.Constants.*;

/**
 * This command cycles through every color on the LEDs at the end of the game.
 * This command is an instant command, because it only needs to run once at the end of the game.
 * 
 * @author Joshua Ciffer
 * @version 02/17/2018
 */
public class CycleEndGameColors extends InstantCommand {

	/**
	 * Constructs a new CycleEndGameColors Command.
	 */
	public CycleEndGameColors() {
		super("CycleEndGameColors");
		requires(Robot.led);
		setInterruptible(true);
	}

	/**
	 * Starts with LEDs turned off.
	 */
	@Override
	protected void initialize() {
		IO.getRedLED().set(LED_RED_OFF);			// Off
		IO.getGreenLED().set(LED_GREEN_OFF);		// Off
		IO.getBlueLED().set(LED_BLUE_OFF);			// Off
	}

	/**
	 * Changes through every color.
	 */
	@Override
	protected void execute() {
		Robot.led.endGameColors();
	}

	/**
	 * Command only runs for 30 seconds.
	 */
	@Override
	protected boolean isFinished() {
		if (timeSinceInitialized() >= 30) {		// Command only runs for 30 seconds.
			IO.getRedLED().set(LED_RED_OFF);			// Off
			IO.getGreenLED().set(LED_GREEN_OFF);		// Off
			IO.getBlueLED().set(LED_BLUE_OFF);			// Off
			return true;
		} else {
			return false;
		}
	}

}