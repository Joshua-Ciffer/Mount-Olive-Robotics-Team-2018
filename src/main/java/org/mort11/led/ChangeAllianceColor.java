package org.mort11.led;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.hardware.IO;
import static org.mort11.util.Constants.*;

/**
 * This command will change the LEDs color from red to blue depending on the robot's alliance.
 * 
 * @author Joshua Ciffer
 * @version 02/16/2018
 */
public class ChangeAllianceColor extends Command {

	/**
	 * Constructs a new ChangeAllianceColor Command.
	 */
	public ChangeAllianceColor() {
		super("ChangeAllianceColor");
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
	 * Calls the command method in the LED subsystem class.
	 */
	@Override
	protected void execute() {
		// Robot.led.changeAllianceColor();
		IO.getRedLED().set(true);
		IO.getGreenLED().set(false);
		IO.getBlueLED().set(true);
	}

	/**
	 * Command runs continuously.
	 */
	@Override
	protected boolean isFinished() {
		return false;
	}

}