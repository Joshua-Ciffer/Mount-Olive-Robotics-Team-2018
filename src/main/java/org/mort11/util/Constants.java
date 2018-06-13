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
	 * Elevator master motor port value.
	 */
	int ELEVATOR_TALON_MASTER = 8;

	/**
	 * Elevator follower motor port value.
	 */
	int ELEVATOR_TALON_FOLLOWER = 9;

	/**
	 * Bottom elevator limit switch port value.
	 */
	int BOTTOM_ELEVATOR_LIMIT_SWITCH = 6;

	/**
	 * Top elevator limit switch port value.
	 */
	int TOP_ELEVATOR_LIMIT_SWITCH = 5;

	/**
	 * The elevator speed used in autons.
	 */
	double ELEVATOR_SPEED = .2;

	/**
	 * The elevator velocity used in velocity control mode.
	 */
	double ELEVATOR_VELOCITY = 600;

	/**
	 * Left driver joystick port value.
	 */
	int LEFT_DRIVER_JOYSTICK = 0;

	/**
	 * Right driver joystick port value.
	 */
	int RIGHT_DRIVER_JOYSTICK = 1;

	/**
	 * Left operator joystick port value.
	 */
	int LEFT_OPERATOR_JOYSTICK = 2;

	/**
	 * Right operator joystick port value.
	 */
	int RIGHT_OPERATOR_JOYSTICK = 3;

	/**
	 * Limit for elevator motor speed.
	 */
	double MOTOR_DEADZONE = 0.2;

	/**
	 * The total number of encoder ticks.
	 */
	double ENCODER_TICKS = 4096;

}