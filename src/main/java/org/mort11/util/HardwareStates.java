package org.mort11.util;

/**
 * Contains enum type states for different hardware conditions.
 *
 * @author Joshua Ciffer
 * @version 11/08/2018
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

	/**
	 * Hardware states for the intake rollers.
	 */
	public enum IntakeRollersState {

		/**
		 * State when the intake is intaking a cube.
		 */
		IN,

		/**
		 * State when the intake is outtaking a cube.
		 */
		OUT,

		/**
		 * State when the intake rollers are stopped.
		 */
		STOP,

		/**
		 * State when the intake rollers are coasting.
		 */
		COAST

	}

	/**
	 * Hardware states for the intake shifter.
	 */
	public enum IntakeShiftState {

		/**
		 * State when the intake is shifted in the up position.
		 */
		UP,

		/**
		 * State when the intake is shifted in the down position.
		 */
		DOWN

	}

}