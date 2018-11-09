package org.mort11.elevator;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.mort11.hardware.IO;
import org.mort11.util.Constants;

/**
 * This class contains a subsystem for the elevator.
 *
 * @author Joshua Ciffer
 * @version 11/08/2018
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
	 *        The speed to set (percent output mode).
	 */
	public void setSpeed(double speed) {
		IO.getElevatorTalonRight().set(ControlMode.PercentOutput, speed);
		IO.getElevatorTalonLeft().set(ControlMode.Follower, Constants.ELEVATOR_TALON_RIGHT);
	}

	/**
	 * Stops the elevator motors.
	 */
	public void halt() {
		setSpeed(0);
	}

}