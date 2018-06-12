package org.mort11.hardware;

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
	private static TalonSRX leftMaster;
	private static TalonSRX leftSlaveMiddle;
	private static TalonSRX leftSlaveBack;
	private static TalonSRX rightMaster;
	private static TalonSRX rightSlaveMiddle;
	private static TalonSRX rightSlaveBack;
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

		leftMaster = new TalonSRX(Constants.DRIVETRAIN_LEFT_MASTER);
		leftSlaveMiddle = new TalonSRX(Constants.DRIVETRAIN_LEFT_SLAVE_MIDDLE);
		leftSlaveBack = new TalonSRX((Constants.DRIVETRAIN_LEFT_SLAVE_BACK));

		rightMaster = new TalonSRX(Constants.DRIVETRAIN_RIGHT_MASTER);
		rightSlaveMiddle = new TalonSRX(Constants.DRIVETRAIN_RIGHT_SLAVE_MIDDLE);
		rightSlaveBack = new TalonSRX(Constants.DRIVETRAIN_RIGHT_SLAVE_BACK);

		leftMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		leftMaster.selectProfileSlot(0, 0);
		rightMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		rightMaster.selectProfileSlot(0, 0);
		rightMaster.setSensorPhase(true);

		elevatorTalonMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 100);
		elevatorTalonMaster.selectProfileSlot(0, 0);
		elevatorTalonMaster.setSensorPhase(false);
		// firstStageElevatorTalonFollower.setInverted(true);
		// rightMaster.config_kP(0, 0, 0);

		// transmission = new DoubleSolenoid(Constants.PCM_ID, Constants.TRANSMISSION_SHIFT_LOW, Constants.TRANSMISSION_SHIFT_HIGH);

		intakeRollerVictorRight = new VictorSPX(Constants.INTAKE_ROLLER_VICTOR_RIGHT);
		intakeRollerVictorLeft = new VictorSPX(Constants.INTAKE_ROLLER_VICTOR_LEFT);

		intakeLimitSwitchLeft = new DigitalInput(Constants.INTAKE_LIMIT_SWITCH_LEFT);
		intakeLimitSwitchRight = new DigitalInput(Constants.INTAKE_LIMIT_SWITCH_RIGHT);

		elevatorLimitSwitchBottom = new DigitalInput(Constants.ELEVATOR_LIMIT_SWITCH_BOTTOM);
		elevatorLimitSwitchTop = new DigitalInput(Constants.ELEVATOR_LIMIT_SWITCH_TOP);

		redLED = new DigitalOutput(Constants.DIO_RED_LED);
		greenLED = new DigitalOutput(Constants.DIO_GREEN_LED);
		blueLED = new DigitalOutput(Constants.DIO_BLUE_LED);

		initLimitSwitchNames();

		// potentiometerInput = new AnalogInput(Constants.POTENTIOMETER_INPUT);
		// potentiometer = new AnalogPotentiometer(potentiometerInput, 180, 0);

		intakePiston = new DoubleSolenoid(Constants.PCM_ID, Constants.INTAKE_PISTON_IN, Constants.INTAKE_PISTON_OUT);
		intakePiston.setName("intake");

		intakeShifterPiston = new DoubleSolenoid(Constants.PCM_ID, Constants.VERTICAL_SHIFTER_PISTON_UP, Constants.VERTICAL_SHIFTER_PISTON_DOWN);
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
		leftMaster.set(Constants.CONTROL_MODE, 0);
		leftSlaveMiddle.set(Constants.FOLLOWER, 0);
		leftSlaveBack.set(Constants.FOLLOWER, 0);
		rightMaster.set(Constants.CONTROL_MODE, 0);
		rightSlaveMiddle.set(Constants.FOLLOWER, 0);
		rightSlaveBack.set(Constants.FOLLOWER, 0);
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
		return leftMaster;
	}

	public static TalonSRX getLeftSlaveMiddle() {
		return leftSlaveMiddle;
	}

	public static TalonSRX getLeftSlaveBack() {
		return leftSlaveBack;
	}

	public static TalonSRX getRightMaster() {
		return rightMaster;
	}

	public static TalonSRX getRightSlaveMiddle() {
		return rightSlaveMiddle;
	}

	public static TalonSRX getRightSlaveBack() {
		return rightSlaveBack;
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