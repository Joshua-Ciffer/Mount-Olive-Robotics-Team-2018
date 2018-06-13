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
	 * 
	 */
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new MoveElevator());
	}

	/**
	 * Sets the speed of the elevator talons.
	 *
	 * @param speed
	 *        - Talon speed.
	 */
	public void set(double speed, double rotations) {

		IO.getElevatorTalonMaster().set(ControlMode.Position, speed * rotations * Constants.ENCODER_TICKS);
		IO.getElevatorTalonFollower().set(ControlMode.Follower, Constants.ELEVATOR_TALON_MASTER);

	}

	public void setVelocity(double speed) {
		IO.getElevatorTalonMaster().set(ControlMode.Velocity, speed * Constants.ELEVATOR_VELOCITY);
		IO.getElevatorTalonFollower().set(ControlMode.Follower, Constants.ELEVATOR_TALON_MASTER);
	}

	public void setPercent(double percent) {
		IO.getElevatorTalonMaster().set(ControlMode.PercentOutput, percent);
		IO.getElevatorTalonFollower().set(ControlMode.Follower, Constants.ELEVATOR_TALON_MASTER);
	}

}