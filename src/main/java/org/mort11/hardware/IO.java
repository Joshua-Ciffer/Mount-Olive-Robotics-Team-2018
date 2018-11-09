package org.mort11.hardware;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import org.mort11.Robot;
import org.mort11.util.Constants;

/**
 * Contains objects that correlate to hardware on the robot.
 *
 * @author Joshua Ciffer
 * @version 11/08/2018
 */
public final class IO {

	/**
	 * The front right drivetrain talon.
	 */
	private static TalonSRX rightDriveTalonFront;

	/**
	 * The master right drivetrain talon.
	 */
	private static TalonSRX rightDriveTalonMaster;

	/**
	 * The rear right drivetrain talon.
	 */
	private static TalonSRX rightDriveTalonRear;

	/**
	 * The front left drivetrain talon.
	 */
	private static TalonSRX leftDriveTalonFront;

	/**
	 * The master left drivetrain talon.
	 */
	private static TalonSRX leftDriveTalonMaster;

	/**
	 * The rear left drivetrain talon.
	 */
	private static TalonSRX leftDriveTalonRear;

	/**
	 * The right elevator talon.
	 */
	private static TalonSRX elevatorTalonRight;

	/**
	 * The left elevator talon.
	 */
	private static TalonSRX elevatorTalonLeft;

	/**
	 * The top elevator limit switch.
	 */
	private static DigitalInput topElevatorLimitSwitch;

	/**
	 * The bottom elevator limit switch.
	 */
	private static DigitalInput bottomElevatorLimitSwitch;

	/**
	 * The right intake roller motor.
	 */
	private static VictorSPX rightIntakeRollerVictor;

	/**
	 * The left intake roller motor.
	 */
	private static VictorSPX leftIntakeRollerVictor;

	/**
	 * The piston that shifts the intake into position.
	 */
	private static DoubleSolenoid intakeShifterPiston;

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
		rightDriveTalonFront = new TalonSRX(Constants.RIGHT_DRIVE_TALON_FRONT);
		rightDriveTalonMaster = new TalonSRX(Constants.RIGHT_DRIVE_TALON_MASTER);
		rightDriveTalonRear = new TalonSRX(Constants.RIGHT_DRIVE_TALON_REAR);
		leftDriveTalonFront = new TalonSRX(Constants.LEFT_DRIVE_TALON_FRONT);
		leftDriveTalonMaster = new TalonSRX(Constants.LEFT_DRIVE_TALON_MASTER);
		leftDriveTalonRear = new TalonSRX(Constants.LEFT_DRIVE_TALON_REAR);

		elevatorTalonRight = new TalonSRX(Constants.ELEVATOR_TALON_RIGHT);
		elevatorTalonLeft = new TalonSRX(Constants.ELEVATOR_TALON_LEFT);
		topElevatorLimitSwitch = new DigitalInput(Constants.TOP_ELEVATOR_LIMIT_SWITCH);
		bottomElevatorLimitSwitch = new DigitalInput(Constants.BOTTOM_ELEVATOR_LIMIT_SWITCH);

		rightIntakeRollerVictor = new VictorSPX(Constants.RIGHT_INTAKE_ROLLER_VICTOR);
		leftIntakeRollerVictor = new VictorSPX(Constants.LEFT_INTAKE_ROLLER_VICTOR);
		intakeShifterPiston = new DoubleSolenoid(Constants.PCM_ID, Constants.INTAKE_SHIFTER_PISTON_DOWN, Constants.INTAKE_SHIFTER_PISTON_UP);

		compressor = new Compressor();
	}

	/**
	 * Stops all motors and disables all pistons and the compressor.
	 */
	public static void seize() {
		Robot.getDrivetrain().halt();
		Robot.getElevator().halt();
		Robot.getIntakeRollers().halt();
		Robot.getIntakeShifter().halt();
		compressor.stop();
	}

	/**
	 * @return The front right drivetrain talon.
	 */
	public static TalonSRX getRightDriveTalonFront() {
		return rightDriveTalonFront;
	}

	/**
	 * @return The master right drivetrain talon.
	 */
	public static TalonSRX getRightDriveTalonMaster() {
		return rightDriveTalonMaster;
	}

	/**
	 * @return The rear right drivetrain talon.
	 */
	public static TalonSRX getRightDriveTalonRear() {
		return rightDriveTalonRear;
	}

	/**
	 * @return The front left drivetrain talon.
	 */
	public static TalonSRX getLeftDriveTalonFront() {
		return leftDriveTalonFront;
	}

	/**
	 * @return The master left drivetrain talon.
	 */
	public static TalonSRX getLeftDriveTalonMaster() {
		return leftDriveTalonMaster;
	}

	/**
	 * @return The rear left drivetrain talon.
	 */
	public static TalonSRX getLeftDriveTalonRear() {
		return leftDriveTalonRear;
	}

	/**
	 * @return The right elevator talon.
	 */
	public static TalonSRX getElevatorTalonRight() {
		return elevatorTalonRight;
	}

	/**
	 * @return The left elevator talon.
	 */
	public static TalonSRX getElevatorTalonLeft() {
		return elevatorTalonLeft;
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
	 * @return The piston that shifts the intake into position.
	 */
	public static DoubleSolenoid getIntakeShifterPiston() {
		return intakeShifterPiston;
	}

	/**
	 * @return The main compressor.
	 */
	public static Compressor getCompressor() {
		return compressor;
	}

}