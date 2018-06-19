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
	 * Hardware states for the drivetrain transmission.
	 */
	public enum DrivetrainGear {

		/**
		 * State when the drivetrain is in high gear.
		 */
		HIGH,

		/**
		 * State when the drivetrain is in low gear.
		 */
		LOW

	}

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
	 * Hardware states for the intake piston.
	 */
	public enum IntakePistonState {

		/**
		 * State when the intake is closed (holding on to a cube).
		 */
		IN,

		/**
		 * State when the intake is open (releasing a cube).
		 */
		OUT

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

	/**
	 * Hardware states for the climber.
	 */
	public enum ClimberState {

		/**
		 * State when the climber piston is fully extended (climbing).
		 */
		EXTENDED,

		/**
		 * State when the climber piston is fully retracted (not climbing).
		 */
		RETRACTED

	}

}