package org.mort11.util;

import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * Constants contains port numbers, and other values that are used in other areas of the project.
 * This is declared as an interface since all field variables in interfaces are implicitly declared as public static final, so now you don't have to
 * write public static final for every variable.
 * 
 * @author Benny Mirisola
 * @version 03/08/2018
 */
public interface Constants {

    /*
     * Motors
     */
    int ARM_TALON = 11;
    int FIRST_STAGE_ELEVATOR_TALON_MASTER = 8;
    int FIRST_STAGE_ELEVATOR_TALON_FOLLOWER = 9;
    int SECOND_STAGE_ELEVATOR_TALON = 10;
    int INTAKE_ROLLER_VICTOR_RIGHT = 7;
    int INTAKE_ROLLER_VICTOR_LEFT = 6;
    int DRIVETRAIN_LEFT_MASTER = 0;
    int DRIVETRAIN_LEFT_SLAVE_MIDDLE = 1;
    int DRIVETRAIN_LEFT_SLAVE_BACK = 2;
    int DRIVETRAIN_RIGHT_MASTER = 3;
    int DRIVETRAIN_RIGHT_SLAVE_MIDDLE = 4;
    int DRIVETRAIN_RIGHT_SLAVE_BACK = 5;

    /*
     * PID Constants
     */
    double LEFT_kP = 0;
    double LEFT_Ki = 0;
    double LEFT_Kd = 0;
    double LEFT_Ktimeout = 0;
    double RIGHT_Kp = 0;
    double RIGHT_Ki = 0;
    double RIGHT_Kd = 0;
    double RIGHT_Ktimeout = 0;
    double FIRST_STAGE_ELEVATOR_Kp = 0;
    double FIRST_STAGE_ELEVATOR_Ki = 0;
    double FIRST_STAGE_ELEVATOR_Kd = 0;
    double FIRST_STAGE_ELEVATOR_Ktimeout = 0;

    // DIO [Limit switches]
    // NOTE: Fill in actual values for limit switches.
    int INTAKE_LIMIT_SWITCH_LEFT = 0;
    int INTAKE_LIMIT_SWITCH_RIGHT = 4;
    int FIRST_STAGE_ELEVATOR_LIMIT_SWITCH_BOTTOM = 6;
    int FIRST_STAGE_ELEVATOR_LIMIT_SWITCH_TOP = 5;
    int SECOND_STAGE_ELEVATOR_LIMIT_SWITCH_BOTTOM = 7;
    int SECOND_STAGE_ELEVATOR_LIMIT_SWITCH_TOP = 3;

    int ARM_LIMIT_SWITCH_TOP = 8;
    int ARM_LIMIT_SWITCH_BOTTOM = 9;

    /*
     * Talon speeds
     */
    double ELEVATOR_SPEED = .2;
    double INTAKE_SPEED = 1;
    double INTAKE_OUTAKE_SPEED = 1;
    double INTAKE_COAST = 0.25;
    double FOURBARARM_SPEED = 1;
    double FIRSTSTAGE_ELEVATOR_VELOCITY = 600;


    // Joysticks
    int LEFT_DRIVER_JOYSTICK = 0;
    int RIGHT_DRIVER_JOYSTICK = 1;
    int LEFT_OPERATOR_JOYSTICK = 2;
    int RIGHT_OPERATOR_JOYSTICK = 3;

    // Joystick buttons
    int ACTUATE_BUTTON = 1;
    int OUTTAKE_BUTTON = 5;
    int INTAKE_BUTTON = 3;
    int CLIMB_BUTTON = 6;
    int INTAKE_POS_BUTTON = 10;
    int PLACE_ON_SCALE_BUTTON = 8;
    int PLACE_ON_SWITCH_BUTTON = 9;
    int HIGH_GEAR_BUTTON = 11;
    int LOW_GEAR_BUTTON = 12;

    // Potentiometer
    int POTENTIOMETER_INPUT = 2;
    int ARM_ANGLE_LATENCY = 5;

    /**
     * PCM Channels (Solenoids)
     */
    int PCM_ID = 20;
    int TRANSMISSION_SHIFT_LOW = 4;
    int TRANSMISSION_SHIFT_HIGH = 5;
    int INTAKE_PISTON_IN = 2;
    int INTAKE_PISTON_OUT = 3;

    int VERTICAL_SHIFTER_PISTON_UP = 1;
    int VERTICAL_SHIFTER_PISTON_DOWN = 0;

    /**
     * Control Modes
     */
    ControlMode FOLLOWER = ControlMode.Follower;
    ControlMode CONTROL_MODE = ControlMode.PercentOutput;

    /*
     * Motor Names
     */
    String leftDriveMasterName = "LeftDrive Master";
    String leftDriveFollowerMiddleName = "LeftDrive Follower Middle";
    String leftDriveFollowerBackName = "LeftDrive Follower Back";
    String rightDriveMasterName = "RightDrive Master";
    String rightDriveFollowerMiddleName = "RightDrive Follower Middle";
    String rightDriveFollowerBackName = "RightDrive Follower Back";
    String firstStageElevatorLeftName = "Elevator Talon Left";
    String firstStageElevatorRightName = "Elevator Talon Right";
    String secondStageElevatorName = "Second Stage Elevator";
    String fourbarName = "Fourbar";
    String intakeMotorLeftName = "Left Intake";
    String intakeMotorRightName = "Right Drive";

    String potentiometerName = "Potentiometer";

    double MOTOR_DEADZONE = 0.2;
    double ANGLE_DEADZONE = 5;

    double ROLLER_TIMEOUT = .75;
    int INTAKE_TIMEOUT = 4;

    int ARM_MAX = 180;
    int ARM_MIN = 0;

    double CIRCUMFERENCE_IN_INCHES = 6 * Math.PI;
    double CIRCUMFERENCE_IN_FEET = 0.5 * Math.PI;

    // NavX Constants
    int ANGLE_LENIENCY_CLOSE = 5;
    int ANGLE_LENIENCY_FAR = 45;
    int ANGLE_FINISH = 5;
    int DISTANCE_LENIENCY = 10;
    int SWITCH_DEGREES = 95;

    /*
     * Encoder constants
     */
    double ENCODER_TICKS = 4096;
    double ONE_TICK = CIRCUMFERENCE_IN_FEET / ENCODER_TICKS;
    double VELOCITY_SAMPLING_SIZE = 100;

    // Drivetrain speeds
    double SPEED_FAR = .3;
    double SPEED_CLOSE = .22;
    double DRIVETRAIN_SPEED = -.3;

    // LED channels
    // Depending on the wiring of the robot, you need to figure out which colors correspond to which DIO ports.
    int DIO_RED_LED = 10;
    int DIO_GREEN_LED = 11;
    int DIO_BLUE_LED = 12;

    // LED values. DEPENDING ON THE WIRING OF THE ROBOT, THE BOOLEAN VALUES WILL NEED TO CHANGE SO THE LEDs ACTUALLY DO WHAT YOU WANT THEM TO.
    boolean LED_RED_OFF = false;
    boolean LED_RED_ON = true;
    boolean LED_GREEN_OFF = false;
    boolean LED_GREEN_ON = true;
    boolean LED_BLUE_OFF = true;
    boolean LED_BLUE_ON = false;

    /*
     * Rotations
     */
    double FIRST_STAGE_ELEVATOR_ROTATIONS_TELEOP = 10;


    int PID_LOOP_ID = 0;
    int ZERO_ENCODER_POSITION = 0;
}