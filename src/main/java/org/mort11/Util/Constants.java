package org.mort11.Util;

import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * @author Benny Mirisola
 */
public class Constants {

    /*
     * Motors
     */
    public static final int ARM_TALON = 11;
    public static final int FIRST_STAGE_ELEVATOR_TALON_MASTER = 8;
    public static final int FIRST_STAGE_ELEVATOR_TALON_FOLLOWER = 9;
    public static final int SECOND_STAGE_ELEVATOR_TALON = 10;
    public static final int INTAKE_ROLLER_VICTOR_RIGHT = 7;
    public static final int INTAKE_ROLLER_VICTOR_LEFT = 6;
    public static final int DRIVETRAIN_LEFT_MASTER = 0;
    public static final int DRIVETRAIN_LEFT_SLAVE_MIDDLE = 1;
    public static final int DRIVETRAIN_LEFT_SLAVE_BACK = 2;
    public static final int DRIVETRAIN_RIGHT_MASTER = 3;
    public static final int DRIVETRAIN_RIGHT_SLAVE_MIDDLE = 4;
    public static final int DRIVETRAIN_RIGHT_SLAVE_BACK = 5;

    // DIO [Encoders, Limit switches]
    // NOTE: Fill in actual values for limit switches.
    public static final int INTAKE_LIMIT_SWITCH_LEFT = 0;
    public static final int INTAKE_LIMIT_SWITCH_RIGHT = 4;
    public static final int FIRST_STAGE_ELEVATOR_LIMIT_SWITCH_BOTTOM = 6;
    public static final int FIRST_STAGE_ELEVATOR_LIMIT_SWITCH_TOP = 5;
    public static final int SECOND_STAGE_ELEVATOR_LIMIT_SWITCH_BOTTOM = 7;
    public static final int SECOND_STAGE_ELEVATOR_LIMIT_SWITCH_TOP = 3;

    public static final int ARM_LIMIT_SWITCH_TOP = 1;
    public static final int ARM_LIMIT_SWITCH_BOTTOM = 2;

    /*
     *Talon speeds
     */
    public static final double ELEVATOR_SPEED = .2;
    public static final double INTAKE_SPEED = 0.5;
    public static final double INTAKE_COAST = 0.25;
    public static final double FOURBARARM_SPEED = 0.5;

    // Joysticks
    public static final int LEFT_DRIVER_JOYSTICK = 0;
    public static final int RIGHT_DRIVER_JOYSTICK = 1;
    public static final int LEFT_OPERATOR_JOYSTICK = 2;
    public static final int RIGHT_OPERATOR_JOYSTICK = 3;

    // Joystick buttons
    public static final int INTAKE_BUTTON = 3;
    public static final int OUTTAKE_BUTTON = 5;
    public static final int IN_ACTUATE_BUTTON = 1;
    public static final int OUT_ACTUATE_BUTTON = 2;
    public static final int CLIMB_BUTTON = 6;
    public static final int INTAKE_POS_BUTTON = 10;
    public static final int PLACE_ON_SCALE_BUTTON = 8;
    public static final int PLACE_ON_SWITCH_BUTTON = 9;
    public static final int HIGH_GEAR_BUTTON = 11;
    public static final int LOW_GEAR_BUTTON = 12;

    // Potentiometer
    public static final int POTENTIOMETER_INPUT = 2;
    public static final int ARM_ANGLE_LATENCY = 5;

    /**
     * PCM Channels (Solenoids)
     */
    public static final int PCM_ID = 20;
    public static final int TRANSMISSION_SHIFT_LOW = 0;
    public static final int TRANSMISSION_SHIFT_HIGH = 1;
    public static final int INTAKE_PISTON_IN = 2;
    public static final int INTAKE_PISTON_OUT = 3;

    /**
     * Control Modes
     */
    public static ControlMode FOLLOWER = ControlMode.Follower;
    public static final ControlMode CONTROL_MODE = ControlMode.PercentOutput;

    /*
     * Motor Names
     */
    public static final String leftDriveMasterName = "LeftDrive Master";
    public static final String leftDriveFollowerMiddleName = "LeftDrive Follower Middle";
    public static final String leftDriveFollowerBackName = "LeftDrive Follower Back";
    public static final String rightDriveMasterName = "RightDrive Master";
    public static final String rightDriveFollowerMiddleName = "RightDrive Follower Middle";
    public static final String rightDriveFollowerBackName = "RightDrive Follower Back";
    public static final String firstStageElevatorLeftName = "Elevator Talon Left";
    public static final String firstStageElevatorRightName = "Elevator Talon Right";
    public static final String secondStageElevatorName = "Second Stage Elevator";
    public static final String fourbarName = "Fourbar";
    public static final String intakeMotorLeftName = "Left Intake";
    public static final String intakeMotorRightName = "Right Drive";

    public static final String potentiometerName = "Potentiometer";

    public static final double MOTOR_DEADZONE = 0.2;
    public static final double ANGLE_DEADZONE = 5;

    public static final double ROLLER_TIMEOUT = .75;

    public static final int ARM_MAX = 180;
    public static final int ARM_MIN = 0;

    public static final double CIRCUMFERENCE = 6 * Math.PI;

    // NavX Constants
    public static final int ANGLE_LENIENCY_CLOSE = 5;
    public static final int ANGLE_LENIENCY_FAR = 45;
    public static final int ANGLE_FINISH = 5;
    public static final int DISTANCE_LENIENCY = 10;

    // Drivetrain speeds
    public static final double SPEED_FAR = .3;
    public static final double SPEED_CLOSE = .15;
    public static final double DRIVETRAIN_SPEED = -.3;

}