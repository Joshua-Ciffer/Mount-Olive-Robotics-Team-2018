package org.mort11.util;

/**
 * Constants contains port numbers, and other values that are used in other areas of the project.
 * This is declared as an interface since all field variables in interfaces are implicitly declared as public static final, so now you don't have to
 * write public static final for every variable.
 *
 * @author Joshua Ciffer
 * @version 06/13/2018
 */
public interface Constants {

	/**
	 * Right intake limit switch port value.
	 */
	int RIGHT_INTAKE_LIMIT_SWITCH = 4;

	/**
	 * Left intake limit switch port value.
	 */
	int LEFT_INTAKE_LIMIT_SWITCH = 0;

	/**
	 * Red LED channel port value.
	 */
	int RED_LED_CHANNEL = 10;

	/**
	 * Green LED channel port value.
	 */
	int GREEN_LED_CHANNEL = 11;

	/**
	 * Blue LED channel port value.
	 */
	int BLUE_LED_CHANNEL = 12;

	/**
	 * Red LED channel off value.
	 */
	boolean LED_RED_OFF = false;

	/**
	 * Red LED channel on value.
	 */
	boolean LED_RED_ON = true;

	/**
	 * Green LED channel off value.
	 */
	boolean LED_GREEN_OFF = false;

	/**
	 * Green LED channel on value.
	 */
	boolean LED_GREEN_ON = true;

	/**
	 * Blue LED channel off value.
	 */
	boolean LED_BLUE_OFF = true;

	/**
	 * Blue LED channel on value.
	 */
	boolean LED_BLUE_ON = false;

}