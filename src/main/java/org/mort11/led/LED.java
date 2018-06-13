package org.mort11.led;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.mort11.hardware.IO;
import org.mort11.util.Constants;

/**
 * This class contains a subsystem for the LEDs. Several different commands can be run on the LED subsystem.
 * Values for the LEDs are inverted. True turns an LED off, false turns it on.
 * 
 * @author Joshua Ciffer
 * @version 05/31/2018
 */
public final class LED extends Subsystem {

	/**
	 * Constructs a new <code>LED</code> Subsystem.
	 */
	public LED() {
		super("LED");
	}

	/**
	 * Sets the LEDs to be disabled by default.
	 */
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DisableLEDs());
	}

	/**
	 * Turns on red LEDs.
	 */
	public void turnOnRed() {
		IO.getRedLED().set(Constants.LED_RED_ON);			// On
		IO.getGreenLED().set(Constants.LED_GREEN_OFF);		// Off
		IO.getBlueLED().set(Constants.LED_BLUE_OFF);		// Off
	}

	/**
	 * Turns on green LEDs.
	 */
	public void turnOnGreen() {
		IO.getRedLED().set(Constants.LED_RED_OFF);			// Off
		IO.getGreenLED().set(Constants.LED_GREEN_ON);		// On
		IO.getBlueLED().set(Constants.LED_BLUE_OFF);		// Off
	}

	/**
	 * Turns on blue LEDs.
	 */
	public void turnOnBlue() {
		IO.getRedLED().set(Constants.LED_RED_OFF);		// Off
		IO.getGreenLED().set(Constants.LED_GREEN_OFF);	// Off
		IO.getBlueLED().set(Constants.LED_BLUE_ON);		// On
	}

	/**
	 * Turns off all LEDs.
	 */
	public void turnOffAll() {
		IO.getRedLED().set(Constants.LED_RED_OFF);		// Off
		IO.getGreenLED().set(Constants.LED_GREEN_OFF);	// Off
		IO.getBlueLED().set(Constants.LED_BLUE_OFF);	// Off
	}

	/**
	 * If teleop mode is enabled, then the LEDs stay red by default. If the switch in the intake is pressed (cube is in the intake),
	 * then the LEDs change to green.
	 */
	public void changeIntakeColor() {
		if (!IO.getLeftIntakeLimitSwitch().get() && !IO.getRightIntakeLimitSwitch().get()) {		// Switch is pressed,
			IO.getRedLED().set(Constants.LED_RED_OFF);			// Off
			IO.getGreenLED().set(Constants.LED_GREEN_ON);		// On
			IO.getBlueLED().set(Constants.LED_BLUE_OFF);		// Off
		} else {											// Switch is not pressed,
			IO.getRedLED().set(Constants.LED_RED_ON);			// On
			IO.getGreenLED().set(Constants.LED_GREEN_OFF);		// Off
			IO.getBlueLED().set(Constants.LED_BLUE_OFF);		// Off
		}
	}

	/**
	 * Changes the color from red to blue based on the robot's alliance.
	 */
	public void changeAllianceColor() {
		switch (DriverStation.getInstance().getAlliance()) {
			case Blue: {
				IO.getRedLED().set(Constants.LED_RED_OFF);		// Off
				IO.getGreenLED().set(Constants.LED_GREEN_OFF);	// Off
				IO.getBlueLED().set(Constants.LED_BLUE_ON);		// On
				break;
			}
			case Red: {
				IO.getRedLED().set(Constants.LED_RED_ON);		// On
				IO.getGreenLED().set(Constants.LED_GREEN_OFF);	// Off
				IO.getBlueLED().set(Constants.LED_BLUE_OFF);	// Off
				break;
			}
			case Invalid: {
				IO.getRedLED().set(Constants.LED_RED_OFF);		// Off
				IO.getGreenLED().set(Constants.LED_GREEN_ON);	// On
				IO.getBlueLED().set(Constants.LED_BLUE_OFF);	// Off
				break;
			}
		}
	}

	/**
	 * Randomly cycles through a bunch of different colors.
	 */
	public void endGameColors() {
		switch ((int)(Math.random() * 7)) {		// Randomly determines which color to set it to.
			case 0: {	// Red.
				IO.getRedLED().set(Constants.LED_RED_ON);		// On
				IO.getGreenLED().set(Constants.LED_GREEN_OFF);	// Off
				IO.getBlueLED().set(Constants.LED_BLUE_OFF);	// Off
				break;
			}
			case 1: {	// Green.
				IO.getRedLED().set(Constants.LED_RED_OFF);		// Off
				IO.getGreenLED().set(Constants.LED_GREEN_ON);	// On
				IO.getBlueLED().set(Constants.LED_BLUE_OFF);	// Off
				break;
			}
			case 2: {	// Blue.
				IO.getRedLED().set(Constants.LED_RED_OFF);		// Off
				IO.getGreenLED().set(Constants.LED_GREEN_OFF);	// Off
				IO.getBlueLED().set(Constants.LED_BLUE_ON);		// On
				break;
			}
			case 3: {	// Purple.
				IO.getRedLED().set(Constants.LED_RED_ON);		// On
				IO.getGreenLED().set(Constants.LED_GREEN_OFF);	// Off
				IO.getBlueLED().set(Constants.LED_BLUE_ON);		// On
				break;
			}
			case 4: {	// Yellow.
				IO.getRedLED().set(Constants.LED_RED_ON);		// On
				IO.getGreenLED().set(Constants.LED_GREEN_ON);	// On
				IO.getBlueLED().set(Constants.LED_BLUE_OFF);	// Off
				break;
			}
			case 5: {	// Light blue.
				IO.getRedLED().set(Constants.LED_RED_OFF);		// Off
				IO.getGreenLED().set(Constants.LED_GREEN_ON);	// On
				IO.getBlueLED().set(Constants.LED_BLUE_ON);		// On
				break;
			}
			case 6: {	// White.
				IO.getRedLED().set(Constants.LED_RED_ON);		// On
				IO.getGreenLED().set(Constants.LED_GREEN_ON);	// On
				IO.getBlueLED().set(Constants.LED_BLUE_ON);		// On
				break;
			}
		}
	}

	/**
	 * Changes the command that the LEDs run when the robot is changed from teleop, to auton, to disabled.
	 * -Teleop mode: IntakeColorChanger()
	 * -Auton mode: ChangeAllianceColor()
	 * -Disabled mode: DisableLEDs()
	 * -End game: CycleEndGameColors()
	 * 
	 * getCurrentCommand().cancel() could throw a NullPointerException if there is no current command assigned to the subsystem,
	 * so a try and catch statement is necessary. If there is no current command assigned to the subsystem, then no other action
	 * required.
	 * 
	 * @param ledCommand
	 *        The command to run on the LEDs.
	 */
	public void setLEDCommand(Command ledCommand) {
		switch (ledCommand.getName()) {
			case "IntakeColorChanger": {
				try {
					getCurrentCommand().cancel();
				} catch (Exception e) {}
				setDefaultCommand(new IntakeColorChanger());
				break;
			}
			case "ChangeAllianceColor": {
				try {
					getCurrentCommand().cancel();
				} catch (Exception e) {}
				setDefaultCommand(new ChangeAllianceColor());
				break;
			}
			case "CycleEndGameColors": {
				try {
					getCurrentCommand().cancel();
				} catch (Exception e) {}
				setDefaultCommand(null);	// Default command is set to null because the cycle end game colors command only needs to run once.
				new CycleEndGameColors().start();	// Command is declared anonymously since it only needs to run once.
				break;
			}
			case "DisableLEDs": {
				try {
					getCurrentCommand().cancel();
				} catch (Exception e) {}
				setDefaultCommand(new DisableLEDs());
				break;
			}
			default: {
				throw new IllegalArgumentException("Invalid LED command.");
			}
		}
	}

}