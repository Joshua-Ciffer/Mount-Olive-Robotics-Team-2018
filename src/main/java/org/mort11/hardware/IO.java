package org.mort11.hardware;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;

import org.mort11.util.Constants;

/**
 * Contains objects that correlate to hardware on the robot.
 *
 * @author Benny Mirisola
 * @author Seven Kurt
 * @author Joshua Ciffer
 * @author Frankie Alfano
 * @version 06/13/2018
 */
public final class IO {

	/**
	 * The left intake limit switch.
	 */
	private static DigitalInput leftIntakeLimitSwitch;

	/**
	 * The right intake limit switch.
	 */
	private static DigitalInput rightIntakeLimitSwitch;

	/**
	 * Red LED channel.
	 */
	private static DigitalOutput redLED;

	/**
	 * Green LED channel.
	 */
	private static DigitalOutput greenLED;

	/**
	 * Blue LED channel.
	 */
	private static DigitalOutput blueLED;

	/**
	 * Don't let anyone instantiate this class.
	 */
	private IO() {}

	/**
	 * Initializes all hardware objects.
	 */
	public static void init() {
		leftIntakeLimitSwitch = new DigitalInput(Constants.RIGHT_INTAKE_LIMIT_SWITCH);
		rightIntakeLimitSwitch = new DigitalInput(Constants.LEFT_INTAKE_LIMIT_SWITCH);

		redLED = new DigitalOutput(Constants.RED_LED_CHANNEL);
		greenLED = new DigitalOutput(Constants.GREEN_LED_CHANNEL);
		blueLED = new DigitalOutput(Constants.BLUE_LED_CHANNEL);
	}

	/**
	 * @return The left intake limit switch.
	 */
	public static DigitalInput getLeftIntakeLimitSwitch() {
		return leftIntakeLimitSwitch;
	}

	/**
	 * @return The right intake limit switch.
	 */
	public static DigitalInput getRightIntakeLimitSwitch() {
		return rightIntakeLimitSwitch;
	}

	/**
	 * @return The red LED channel.
	 */
	public static DigitalOutput getRedLED() {
		return redLED;
	}

	/**
	 * @return The green LED channel.
	 */
	public static DigitalOutput getGreenLED() {
		return greenLED;
	}

	/**
	 * @return The blue LED channel.
	 */
	public static DigitalOutput getBlueLED() {
		return blueLED;
	}

}