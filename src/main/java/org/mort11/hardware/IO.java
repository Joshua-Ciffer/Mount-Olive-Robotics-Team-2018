package org.mort11.hardware;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.SPI;

import org.mort11.util.Constants;

/**
 * Contains objects that correlate to hardware on the robot.
 *
 * @author Benny Mirisola
 * @author Seven Kurt
 * @author Joshua Ciffer
 * @author Frankie Alfano
 * @version 06/12/2018
 */
public final class IO {

	private static Compressor compressor;
	private static TalonSRX elevatorTalonMaster, elevatorTalonFollower;
	private static VictorSPX intakeRollerVictorRight, intakeRollerVictorLeft;
	private static TalonSRX leftDriveMaster;
	private static TalonSRX leftDriveSlaveMiddle;
	private static TalonSRX leftDriveSlaveBack;
	private static TalonSRX rightDriveMaster;
	private static TalonSRX rightDriveSlaveMiddle;
	private static TalonSRX rightDriveSlaveBack;
	private static DigitalInput intakeLimitSwitchLeft, intakeLimitSwitchRight;
	private static DigitalInput elevatorLimitSwitchBottom, elevatorLimitSwitchTop;
	private static AnalogInput potentiometerInput;
	// LEDs input and output.
	private static DigitalOutput redLED;
	private static DigitalOutput greenLED;
	private static DigitalOutput blueLED;
	private static Potentiometer potentiometer;
	private static AHRS ahrs;
	/**
	 * Double Solenoids.
	 */
	private static DoubleSolenoid transmission;
	private static DoubleSolenoid intakePiston;
	private static DoubleSolenoid intakeShifterPiston;

	/**
	 * Don't let anyone instantiate this class.
	 */
	private IO() {}

	/**
	 * Initializes all hardware objects.
	 */
	public static void init() {

		elevatorTalonMaster = new TalonSRX(Constants.ELEVATOR_TALON_MASTER);
		elevatorTalonFollower = new TalonSRX(Constants.ELEVATOR_TALON_FOLLOWER);
		elevatorTalonFollower.setInverted(true);

		leftDriveMaster = new TalonSRX(Constants.LEFT_DRIVE_TALON_MASTER);
		leftDriveSlaveMiddle = new TalonSRX(Constants.LEFT_DRIVE_TALON_MIDDLE);
		leftDriveSlaveBack = new TalonSRX((Constants.LEFT_DRIVE_TALON_REAR));

		rightDriveMaster = new TalonSRX(Constants.RIGHT_DRIVE_TALON_MASTER);
		rightDriveSlaveMiddle = new TalonSRX(Constants.RIGHT_DRIVE_TALON_MIDDLE);
		rightDriveSlaveBack = new TalonSRX(Constants.RIGHT_DRIVE_TALON_REAR);

		leftDriveMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		leftDriveMaster.selectProfileSlot(0, 0);
		rightDriveMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		rightDriveMaster.selectProfileSlot(0, 0);
		rightDriveMaster.setSensorPhase(true);

		elevatorTalonMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 100);
		elevatorTalonMaster.selectProfileSlot(0, 0);
		elevatorTalonMaster.setSensorPhase(false);
		// firstStageElevatorTalonFollower.setInverted(true);
		// rightMaster.config_kP(0, 0, 0);

		transmission = new DoubleSolenoid(Constants.PCM_ID, Constants.TRANSMISSION_SHIFT_LOW, Constants.TRANSMISSION_SHIFT_HIGH);

		intakeRollerVictorRight = new VictorSPX(Constants.RIGHT_INTAKE_ROLLER_VICTOR);
		intakeRollerVictorLeft = new VictorSPX(Constants.LEFT_INTAKE_ROLLER_VICTOR);

		intakeLimitSwitchLeft = new DigitalInput(Constants.LEFT_INTAKE_LIMIT_SWITCH);
		intakeLimitSwitchRight = new DigitalInput(Constants.RIGHT_INTAKE_LIMIT_SWITCH);

		elevatorLimitSwitchBottom = new DigitalInput(Constants.BOTTOM_ELEVATOR_LIMIT_SWITCH);
		elevatorLimitSwitchTop = new DigitalInput(Constants.TOP_ELEVATOR_LIMIT_SWITCH);

		redLED = new DigitalOutput(Constants.DIO_RED_LED);
		greenLED = new DigitalOutput(Constants.DIO_GREEN_LED);
		blueLED = new DigitalOutput(Constants.DIO_BLUE_LED);

		initLimitSwitchNames();

		// potentiometerInput = new AnalogInput(Constants.POTENTIOMETER_INPUT);
		// potentiometer = new AnalogPotentiometer(potentiometerInput, 180, 0);

		intakePiston = new DoubleSolenoid(Constants.PCM_ID, Constants.INTAKE_PISTON_IN, Constants.INTAKE_PISTON_OUT);
		intakePiston.setName("intake");

		intakeShifterPiston = new DoubleSolenoid(Constants.PCM_ID, Constants.INTAKE_SHIFTER_PISTON_UP, Constants.VERTICAL_SHIFTER_PISTON_DOWN);
		intakeShifterPiston.setName("VerticalShifterPiston");

		compressor = new Compressor();
		compressor.start();

		ahrs = new AHRS(SPI.Port.kMXP);

		// Keeps LEDs turned off at the beginning.
		redLED.set(Constants.LED_RED_OFF);        // Off
		greenLED.set(Constants.LED_GREEN_OFF);    // Off
		blueLED.set(Constants.LED_BLUE_OFF);        // Off

	}

	public static void initLimitSwitchNames() {

		intakeLimitSwitchLeft.setName("Left intake Limit Switch");
		intakeLimitSwitchRight.setName("Right intake Limit Switch");

		elevatorLimitSwitchBottom.setName("Bottom First Stage Elevator Limit Switch");
		elevatorLimitSwitchTop.setName("Top First Stage Elevator Limit Switch");

		redLED.setName("Red");
		greenLED.setName("Green");
		blueLED.setName("Blue");

	}

	/**
	 * Stops all motors and disables all solenoids.
	 */
	public static void seize() {
		leftDriveMaster.set(ControlMode.PercentOutput, 0);
		leftDriveSlaveMiddle.set(ControlMode.Follower, 0);
		leftDriveSlaveBack.set(ControlMode.Follower, 0);
		rightDriveMaster.set(ControlMode.PercentOutput, 0);
		rightDriveSlaveMiddle.set(ControlMode.Follower, 0);
		rightDriveSlaveBack.set(ControlMode.Follower, 0);
	}

	public static TalonSRX getElevatorTalonMaster() {
		return elevatorTalonMaster;
	}

	public static TalonSRX getElevatorTalonFollower() {
		return elevatorTalonFollower;
	}

	public static VictorSPX getIntakeRollerVictorRight() {
		return intakeRollerVictorRight;
	}

	public static VictorSPX getIntakeRollerVictorLeft() {
		return intakeRollerVictorLeft;
	}

	public static DigitalInput getIntakeLimitSwitchLeft() {
		return intakeLimitSwitchLeft;
	}

	public static DigitalInput getIntakeLimitSwitchRight() {
		return intakeLimitSwitchRight;
	}

	public static DigitalInput getFirstStageElevatorLimitSwitchBottom() {
		return elevatorLimitSwitchBottom;
	}

	public static DigitalInput getFirstStageElevatorLimitSwitchTop() {
		return elevatorLimitSwitchTop;
	}

	public static AnalogInput getPotentiometerInput() {
		return potentiometerInput;
	}

	public static Potentiometer getPotentiometer() {
		return potentiometer;
	}

	public static DoubleSolenoid getIntakePiston() {
		return intakePiston;
	}

	public static TalonSRX getLeftMaster() {
		return leftDriveMaster;
	}

	public static TalonSRX getLeftSlaveMiddle() {
		return leftDriveSlaveMiddle;
	}

	public static TalonSRX getLeftSlaveBack() {
		return leftDriveSlaveBack;
	}

	public static TalonSRX getRightMaster() {
		return rightDriveMaster;
	}

	public static TalonSRX getRightSlaveMiddle() {
		return rightDriveSlaveMiddle;
	}

	public static TalonSRX getRightSlaveBack() {
		return rightDriveSlaveBack;
	}

	public static DoubleSolenoid getTransmission() {
		return transmission;
	}

	public static DoubleSolenoid getIntakeShifterPiston() {
		return intakeShifterPiston;
	}

	/**
	 * @return NavX
	 */
	public static AHRS getAHRS() {
		return ahrs;
	}

	/**
	 * @return redLED digital output object.
	 */
	public static DigitalOutput getRedLED() {
		return redLED;
	}

	/**
	 * @return greenLED digital output object.
	 */
	public static DigitalOutput getGreenLED() {
		return greenLED;
	}

	/**
	 * @return blueLED digital output object.
	 */
	public static DigitalOutput getBlueLED() {
		return blueLED;
	}

	public static Compressor getCompressor() {
		return compressor;
	}

}