package org.mort11.hardware;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SPI;

import org.mort11.Robot;
import org.mort11.util.Constants;

/**
 * Contains objects that correlate to hardware on the robot.
 *
 * @author Benny Mirisola
 * @author Seven Kurt
 * @author Joshua Ciffer
 * @author Frankie Alfano
 * @version 06/20/2018
 */
public final class IO {

	/**
	 * The left drivetrain master motor.
	 */
	private static TalonSRX leftDriveTalonMaster;

	/**
	 * The left drivetrain middle follower motor.
	 */
	private static TalonSRX leftDriveTalonMiddle;

	/**
	 * The left drivetrain rear follower motor.
	 */
	private static TalonSRX leftDriveTalonRear;

	/**
	 * The right drivetrain master motor.
	 */
	private static TalonSRX rightDriveTalonMaster;

	/**
	 * The right drivetrain middle follower motor.
	 */
	private static TalonSRX rightDriveTalonMiddle;

	/**
	 * The right drivetrain rear follower motor.
	 */
	private static TalonSRX rightDriveTalonRear;

	/**
	 * The master elevator motor.
	 */
	private static TalonSRX elevatorTalonMaster;

	/**
	 * The follower elevator motor.
	 */
	private static TalonSRX elevatorTalonFollower;

	/**
	 * The bottom elevator limit switch.
	 */
	private static DigitalInput bottomElevatorLimitSwitch;

	/**
	 * The top elevator limit switch.
	 */
	private static DigitalInput topElevatorLimitSwitch;

	/**
	 * The right intake roller motor.
	 */
	private static VictorSPX rightIntakeRollerVictor;

	/**
	 * The left intake roller motor.
	 */
	private static VictorSPX leftIntakeRollerVictor;

	/**
	 * The intake grabber piston.
	 */
	private static DoubleSolenoid intakePiston;

	/**
	 * The piston that shifts the intake into position.
	 */
	private static DoubleSolenoid intakeShifterPiston;

	/**
	 * The left intake limit switch.
	 */
	private static DigitalInput leftIntakeLimitSwitch;

	/**
	 * The right intake limit switch.
	 */
	private static DigitalInput rightIntakeLimitSwitch;

	/**
	 * The main compressor.
	 */
	private static Compressor compressor;

	/**
	 * Don't let anyone instantiate this class.
	 */
	private IO() {}

	/**
	 * Initializes all hardware objects.
	 */
	public static void init() {
		leftDriveTalonMaster = new TalonSRX(Constants.LEFT_DRIVE_TALON_MASTER);
		leftDriveTalonMiddle = new TalonSRX(Constants.LEFT_DRIVE_TALON_FRONT);
		leftDriveTalonRear = new TalonSRX(Constants.LEFT_DRIVE_TALON_REAR);
		rightDriveTalonMaster = new TalonSRX(Constants.RIGHT_DRIVE_TALON_MASTER);
		rightDriveTalonMiddle = new TalonSRX(Constants.RIGHT_DRIVE_TALON_FRONT);
		rightDriveTalonRear = new TalonSRX(Constants.RIGHT_DRIVE_TALON_REAR);

		elevatorTalonMaster = new TalonSRX(Constants.ELEVATOR_TALON_RIGHT);
		elevatorTalonFollower = new TalonSRX(Constants.ELEVATOR_TALON_LEFT);
		elevatorTalonFollower.setInverted(true);
		bottomElevatorLimitSwitch = new DigitalInput(Constants.BOTTOM_ELEVATOR_LIMIT_SWITCH);
		topElevatorLimitSwitch = new DigitalInput(Constants.TOP_ELEVATOR_LIMIT_SWITCH);

		rightIntakeRollerVictor = new VictorSPX(Constants.RIGHT_INTAKE_ROLLER_VICTOR);
		leftIntakeRollerVictor = new VictorSPX(Constants.LEFT_INTAKE_ROLLER_VICTOR);
		intakePiston = new DoubleSolenoid(Constants.PCM_ID, Constants.INTAKE_PISTON_IN, Constants.INTAKE_PISTON_OUT);
		intakeShifterPiston = new DoubleSolenoid(Constants.PCM_ID, Constants.INTAKE_SHIFTER_PISTON_UP, Constants.INTAKE_SHIFTER_PISTON_DOWN);
		leftIntakeLimitSwitch = new DigitalInput(Constants.LEFT_INTAKE_LIMIT_SWITCH);
		rightIntakeLimitSwitch = new DigitalInput(Constants.RIGHT_INTAKE_LIMIT_SWITCH);

		compressor = new Compressor();
	}

	/**
	 * Stops all motors and disables all pistons and the compressor.
	 */
	public static void seize() {
		Robot.drivetrain.halt();
		Robot.elevator.halt();
		Robot.intakeRollers.halt();
		Robot.intakePistons.halt();
		Robot.intakeShifter.halt();
		compressor.stop();
	}

	/**
	 * @return The left drivetrain master motor.
	 */
	public static TalonSRX getLeftDriveTalonMaster() {
		return leftDriveTalonMaster;
	}

	/**
	 * @return The left drivetrain middle follower motor.
	 */
	public static TalonSRX getLeftDriveTalonMiddle() {
		return leftDriveTalonMiddle;
	}

	/**
	 * @return The left drivetrain rear follower motor.
	 */
	public static TalonSRX getLeftDriveTalonRear() {
		return leftDriveTalonRear;
	}

	/**
	 * @return The right drivetrain master motor.
	 */
	public static TalonSRX getRightDriveTalonMaster() {
		return rightDriveTalonMaster;
	}

	/**
	 * @return The right drivetrain middle follower motor.
	 */
	public static TalonSRX getRightDriveTalonMiddle() {
		return rightDriveTalonMiddle;
	}

	/**
	 * @return The right drivetrain rear follower motor.
	 */
	public static TalonSRX getRightDriveTalonRear() {
		return rightDriveTalonRear;
	}

	/**
	 * @return The master elevator motor.
	 */
	public static TalonSRX getElevatorTalonMaster() {
		return elevatorTalonMaster;
	}

	/**
	 * @return The follower elevator motor.
	 */
	public static TalonSRX getElevatorTalonFollower() {
		return elevatorTalonFollower;
	}

	/**
	 * @return The bottom elevator limit switch.
	 */
	public static DigitalInput getBottomElevatorLimitSwitch() {
		return bottomElevatorLimitSwitch;
	}

	/**
	 * @return The top elevator limit switch.
	 */
	public static DigitalInput getTopElevatorLimitSwitch() {
		return topElevatorLimitSwitch;
	}

	/**
	 * @return The right intake roller motor.
	 */
	public static VictorSPX getRightIntakeRollerVictor() {
		return rightIntakeRollerVictor;
	}

	/**
	 * @return The left intake roller motor.
	 */
	public static VictorSPX getLeftIntakeRollerVictor() {
		return leftIntakeRollerVictor;
	}

	/**
	 * @return The intake grabber piston.
	 */
	public static DoubleSolenoid getIntakePiston() {
		return intakePiston;
	}

	/**
	 * @return The piston that shifts the intake into position.
	 */
	public static DoubleSolenoid getIntakeShifterPiston() {
		return intakeShifterPiston;
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
	 * @return The main compressor.
	 */
	public static Compressor getCompressor() {
		return compressor;
	}

}