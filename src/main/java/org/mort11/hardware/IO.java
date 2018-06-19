package org.mort11.hardware;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;

import org.mort11.Robot;
import org.mort11.util.Constants;

/**
 * Contains objects that correlate to hardware on the robot.
 *
 * @author Benny Mirisola
 * @author Seven Kurt
 * @author Joshua Ciffer
 * @author Frankie Alfano
 * @version 06/13/2018
 */
public final class IO {

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
	 * Don't let anyone instantiate this class.
	 */
	private IO() {}

	/**
	 * Initializes all hardware objects.
	 */
	public static void init() {
		elevatorTalonMaster = new TalonSRX(Constants.ELEVATOR_TALON_MASTER);
		elevatorTalonMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 180);
		elevatorTalonMaster.selectProfileSlot(0, 0);
		elevatorTalonMaster.setSensorPhase(false);
		elevatorTalonFollower = new TalonSRX(Constants.ELEVATOR_TALON_FOLLOWER);
		elevatorTalonFollower.setInverted(true);
		bottomElevatorLimitSwitch = new DigitalInput(Constants.BOTTOM_ELEVATOR_LIMIT_SWITCH);
		topElevatorLimitSwitch = new DigitalInput(Constants.TOP_ELEVATOR_LIMIT_SWITCH);
	}

	/**
	 * Stops all motors and disables all pistons and the compressor.
	 */
	public static void seize() {
		Robot.elevator.halt();
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

}