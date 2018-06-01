package org.mort11.led;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.hardware.IO;
import static org.mort11.util.Constants.*;

/**
 * This command checks for input from a switch and if the switch is pressed, the LEDs are lit up green.
 * The LEDs stay red while the switch is not pressed.
 *
 * @author Joshua Ciffer
 * @version 02/16/2018
 */
public class IntakeColorChanger extends Command {

	/**
	 * Constructs a new IntakeColorChanger command that requires the intake subsystem declared in the Robot class.
	 */
	public IntakeColorChanger() {
		super("IntakeColorChanger");
		requires(Robot.led);
		setInterruptible(true);
	}

	/**
	 * Initializes the LEDs.
	 */
	@Override
	protected void initialize() {
		IO.getRedLED().set(LED_RED_ON);			// On
		IO.getGreenLED().set(LED_GREEN_OFF);	// Off
		IO.getBlueLED().set(LED_BLUE_OFF);		// Off
	}

	/**
	 * Repeatedly calls the subsystem to change the LED color based off of input from a switch.
	 */
	@Override
	protected void execute() {
		if (DriverStation.getInstance().getMatchTime() >= 30) {		// If there is more than 30 seconds left in the match, run the intake colors.
			Robot.led.changeIntakeColor();
		} else {													// Else, run the end game colors.
			Robot.led.setLEDCommand(new CycleEndGameColors());
		}
	}

	/**
	 * Always returns false so the command is never interrupted.
	 *
	 * @return False
	 */
	@Override
	protected boolean isFinished() {
		return false;
	}

}