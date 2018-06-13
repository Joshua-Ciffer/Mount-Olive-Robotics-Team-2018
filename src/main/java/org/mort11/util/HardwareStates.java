package org.mort11.util;

/**
 * Contains enum type states for different hardware conditions.
 *
 * @author Joshua Ciffer
 * @author Zach "Merge Errors" Rich
 * @version 06/13/2018
 */
public final class HardwareStates {

	/**
	 * Don't let anyone instantiate this class.
	 */
	private HardwareStates() {}

	/**
	 * Hardware states for the elevator.
	 */
	public enum ElevatorState {

		/**
		 * State when the elevator cannot go any lower (bottom elevator limit switch is pressed).
		 */
		BOTTOM,

		/**
		 * State when the elevator cannot go any higher (top elevator limit switch is pressed).
		 */
		TOP

	}

}