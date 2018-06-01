package org.mort11.led;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.hardware.IO;
import static org.mort11.util.Constants.*;

/**
 * This command turns off all of the LEDs while the robot is disabled.
 * 
 * @author Joshua Ciffer
 * @version 02/16/2018
 */
public class DisableLEDs extends Command {

	/**
	 * Constructs a new DisableLEDs Command.
	 */
	public DisableLEDs() {
		super("DisableLEDs");
		requires(Robot.led);
		setInterruptible(true);
	}

	/**
	 * Sets all LEDs to off.
	 */
	@Override
	protected void initialize() {
		IO.getRedLED().set(LED_RED_OFF);		// Off
		IO.getGreenLED().set(LED_GREEN_OFF);	// Off
		IO.getBlueLED().set(LED_BLUE_OFF);		// Off
	}

	/**
	 * Calls the command method in the subsystem class.
	 */
	@Override
	protected void execute() {
		Robot.led.disableLEDs();
	}

	/**
	 * Command runs continuously.
	 */
	@Override
	protected boolean isFinished() {
		return false;
	}

}