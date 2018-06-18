package org.mort11.elevator;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.mort11.hardware.IO;
import org.mort11.util.Constants;

/**
 * This class contains a subsystem for the elevator.
 *
 * @author Joshua Ciffer
 * @author Seven Kurt
 * @version 06/13/2018
 */
public final class Elevator extends Subsystem {

	/**
	 * Constructs a new <code>Elevator</code> subsystem.
	 */
	public Elevator() {
		super("Elevator");
	}

	/**
	 * Sets the default command to joystick drive.
	 */
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());
	}

	/**
	 * @param speed
	 *        The speed to set (position mode).
	 * @param rotations
	 *        The number of rotation.
	 */
	public void setSpeedPositionMode(double speed, double rotations) {
		IO.getElevatorTalonMaster().set(ControlMode.Position, speed * rotations * Constants.ENCODER_TICKS);
		IO.getElevatorTalonFollower().set(ControlMode.Follower, Constants.ELEVATOR_TALON_MASTER);
	}

	/**
	 * @param speed
	 *        The speed to set (velocity mode).
	 */
	public void setSpeedVelocityMode(double speed) {
		IO.getElevatorTalonMaster().set(ControlMode.Velocity, speed * Constants.ELEVATOR_VELOCITY);
		IO.getElevatorTalonFollower().set(ControlMode.Follower, Constants.ELEVATOR_TALON_MASTER);
	}

	/**
	 * @param speed
	 *        The speed to set (percent output mode).
	 */
	public void setSpeedPercentMode(double speed) {
		IO.getElevatorTalonMaster().set(ControlMode.PercentOutput, speed);
		IO.getElevatorTalonFollower().set(ControlMode.Follower, Constants.ELEVATOR_TALON_MASTER);
	}

	/**
	 * Stops the elevator motors.
	 */
	public void halt() {
		setSpeedPercentMode(0);
	}

}