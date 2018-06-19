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
	 * Left drivetrain master motor port value.
	 */
	int LEFT_DRIVE_TALON_MASTER = 0;

	/**
	 * Left drivetrain middle follower motor port value.
	 */
	int LEFT_DRIVE_TALON_MIDDLE = 1;

	/**
	 * Left drivetrain rear follower motor port value.
	 */
	int LEFT_DRIVE_TALON_REAR = 2;

	/**
	 * Right drivetrain master motor port value.
	 */
	int RIGHT_DRIVE_TALON_MASTER = 3;

	/**
	 * Right drivetrain middle follower motor port value.
	 */
	int RIGHT_DRIVE_TALON_MIDDLE = 4;

	/**
	 * Right drivetrain rear follower motor port value.
	 */
	int RIGHT_DRIVE_TALON_REAR = 5;

	/**
	 * Drivetrain transmission low state port value.
	 */
	int DRIVETRAIN_TRANSMISSION_LOW = 4;

	/**
	 * Drivetrain transmission high state port value.
	 */
	int DRIVETRAIN_TRANSMISSION_HIGH = 5;

	/**
	 * The drivetrain speed (percent output mode) used in autons.
	 */
	double DRIVETRAIN_SPEED = -.3;

	/**
	 * The drivetrain speed (percent output mode) used in autons when far away from its target.
	 */
	double DRIVETRAIN_SPEED_FAR = .3;

	/**
	 * The drivetrain speed (percent output mode) used in autons when close to its target.
	 */
	double DRIVETRAIN_SPEED_CLOSE = .22;

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
	 * Right intake roller motor port value.
	 */
	int RIGHT_INTAKE_ROLLER_VICTOR = 7;

	/**
	 * Left intake roller motor port value.
	 */
	int LEFT_INTAKE_ROLLER_VICTOR = 6;

	/**
	 * Right intake limit switch port value.
	 */
	int RIGHT_INTAKE_LIMIT_SWITCH = 4;

	/**
	 * Left intake limit switch port value.
	 */
	int LEFT_INTAKE_LIMIT_SWITCH = 0;

	/**
	 * The intake roller speed when intaking a cube.
	 */
	double INTAKE_SPEED = 1;

	/**
	 * The intake roller speed when outtaking a cube.
	 */
	double OUTTAKE_SPEED = 1;

	/**
	 * The intake roller speed when coasting.
	 */
	double COAST_SPEED = 0.25;

	/**
	 * Intake piston extended state port value.
	 */
	int INTAKE_PISTON_IN = 2;

	/**
	 * Intake piston retracted state port value.
	 */
	int INTAKE_PISTON_OUT = 3;

	/**
	 * Intake shifter piston retracted state port value.
	 */
	int INTAKE_SHIFTER_PISTON_UP = 1;

	/**
	 * Intake shifter piston extended state port value.
	 */
	int INTAKE_SHIFTER_PISTON_DOWN = 0;

	/**
	 * The timeout for the intake rollers when intaking a cube.
	 */
	double ROLLER_TIMEOUT = .75;

	/**
	 * The climber piston extended state port value.
	 */
	int CLIMBER_PISTON_EXTENDED = 0;

	/**
	 * The climber piston retracted state port value.
	 */
	int CLIMBER_PISTON_RETRACTED = 0;

	/**
	 * PCM ID value.
	 */
	int PCM_ID = 20;

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
	 * Actuate intake piston button value.
	 */
	int ACTUATE_INTAKE_PISTON_BUTTON = 1;

	/**
	 * Intake shifter button value.
	 */
	int INTAKE_SHIFTER_BUTTON = 12;

	/**
	 * Outtake button value.
	 */
	int OUTTAKE_BUTTON = 5;

	/**
	 * Intake button value.
	 */
	int INTAKE_BUTTON = 3;

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