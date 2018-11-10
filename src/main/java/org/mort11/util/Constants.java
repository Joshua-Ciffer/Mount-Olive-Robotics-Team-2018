package org.mort11.util;

/**
 * Constants contains port numbers, and other values that are used in other areas of the project.
 * This is declared as an interface since all field variables in interfaces are implicitly declared as public static final, so now you don't have to
 * write public static final for every variable.
 *
 * @author Joshua Ciffer
 * @author Benny Mirisola
 * @version 11/08/2018
 */
public interface Constants {

	/**
	 * PCM ID value.
	 */
	int PCM_ID = 61;

	/**
	 * PDP ID value.
	 */
	int PDP_ID = 62;

	/**
	 * Right drivetrain front follower motor port value.
	 */
	int RIGHT_DRIVE_TALON_FRONT = 53;

	/**
	 * Right drivetrain master motor port value.
	 */
	int RIGHT_DRIVE_TALON_MASTER = 54;

	/**
	 * Right drivetrain rear follower motor port value.
	 */
	int RIGHT_DRIVE_TALON_REAR = 55;

	/**
	 * Left drivetrain front follower motor port value.
	 */
	int LEFT_DRIVE_TALON_FRONT = 58;

	/**
	 * Left drivetrain master motor port value.
	 */
	int LEFT_DRIVE_TALON_MASTER = 59;

	/**
	 * Left drivetrain rear follower motor port value.
	 */
	int LEFT_DRIVE_TALON_REAR = 60;

	/**
	 * Elevator right motor port value.
	 */
	int ELEVATOR_TALON_RIGHT = 56;

	/**
	 * Elevator left motor port value.
	 */
	int ELEVATOR_TALON_LEFT = 57;

	/**
	 * Top elevator limit switch port value.
	 */
	int TOP_ELEVATOR_LIMIT_SWITCH = 8;

	/**
	 * Bottom elevator limit switch port value.
	 */
	int BOTTOM_ELEVATOR_LIMIT_SWITCH = 9;

	/**
	 * Right intake roller motor port value.
	 */
	int RIGHT_INTAKE_ROLLER_VICTOR = 51;

	/**
	 * Left intake roller motor port value.
	 */
	int LEFT_INTAKE_ROLLER_VICTOR = 52;

	/**
	 * Intake shifter piston extended state port value.
	 */
	int INTAKE_SHIFTER_PISTON_DOWN = 0;

	/**
	 * Intake shifter piston retracted state port value.
	 */
	int INTAKE_SHIFTER_PISTON_UP = 1;

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
	int OPERATOR_JOYSTICK = 2;

	/**
	 * Intake shifter (down) button assignment.
	 */
	int INTAKE_SHIFTER_DOWN_BUTTON = 12;

	/**
	 * Intake shifter (up) button assignment.
	 */
	int INTAKE_SHIFTER_UP_BUTTON = 11;

	/**
	 * Outtake button value.
	 */
	int OUTTAKE_BUTTON = 5;

	/**
	 * Intake button value.
	 */
	int INTAKE_BUTTON = 3;

	/**
	 * The drivetrain speed (percent output mode) used in autons.
	 */
	double DRIVETRAIN_SPEED = -1;

	/**
	 * The drivetrain speed (percent output mode) used in autons when far away from its target.
	 */
	double DRIVETRAIN_SPEED_FAR = .3;

	/**
	 * The drivetrain speed (percent output mode) used in autons when close to its target.
	 */
	double DRIVETRAIN_SPEED_CLOSE = .22;


	/**
	* Drivetrain timeout used in autons
	 */

	double DRIVETRAIN_AUTON_TIMEOUT = 1.5;

	/**
	 * Drivetrain intake speed used in autonomous
	 */

	double DRIVETRAIN_AUTON_INTAKE_SPEED = .75;

	/**
	 * The elevator speed used in autons.
	 */
	double ELEVATOR_SPEED = .2;

	/**
	 * The elevator velocity used in velocity control mode.
	 */
	double ELEVATOR_VELOCITY = 600;

	/**
	 * The intake roller speed when intaking a cube.
	 */
	double INTAKE_SPEED = -1;

	/**
	 * The intake roller speed when outtaking a cube.
	 */
	double OUTTAKE_SPEED = 1;

	/**
	 * The intake roller speed when coasting.
	 */
	double COAST_SPEED = 0.25;

	/**
	 * The timeout for the intake rollers when intaking a cube.
	 */
	double ROLLER_TIMEOUT = .75;

	/**
	 * Limit for elevator motor speed.
	 */
	double MOTOR_DEADZONE = 0.2;

	/**
	 * The circumference in inches.
	 */
	double CIRCUMFERENCE_IN_INCHES = 6 * Math.PI;

	/**
	 * The circumference in feet.
	 */
	double CIRCUMFERENCE_IN_FEET = 0.5 * Math.PI;

	/**
	 * The total number of encoder ticks.
	 */
	double ENCODER_TICKS = 4096;

	/**
	 * The value representing one encoder tick.
	 */
	double ONE_TICK = CIRCUMFERENCE_IN_FEET / ENCODER_TICKS;

	/**
	 * Value when an angle is determined close enough.
	 */
	int ANGLE_LENIENCY_CLOSE = 5;

	/**
	 * Value when an angle is determined far enough.
	 */
	int ANGLE_LENIENCY_FAR = 45;

	/**
	 * Value when an angle is determiend to be within margin of error.
	 */
	int ANGLE_FINISH = 5;

	/**
	 * Value for margin of error for drive distance.
	 */
	int DISTANCE_LENIENCY = 10;

	/**
	 * Converts feet per second to encoder ticks per 100 milliseconds.
	 *
	 * @param fps
	 *        The feet per second to convert.
	 * @return Encoder ticks per 100 milliseconds.
	 */
	static double convertFPSToEncoderTicksPer100Milliseconds(double fps) {
		double ticksPer100Mil = (fps / (10 * Constants.ONE_TICK));
		return ticksPer100Mil;
	}

}