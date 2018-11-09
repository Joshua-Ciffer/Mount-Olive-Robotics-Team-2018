package org.mort11.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.mort11.hardware.IO;
import org.mort11.util.Constants;

/**
 * This class represents the drivetrain subsystem.
 * 
 * @author Joshua Ciffer
 * @version 11/08/2018
 */
public final class Drivetrain extends Subsystem {

	/**
	 * Constructs a new <code>Drivetrain</code> subsystem.
	 */
	public Drivetrain() {
		super("Drivetrain");
	}

	/**
	 * Sets default command to be operated off of the joystick.
	 */
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive());
	}

	/**
	 * Sets the left drive speed based on percent output.
	 *
	 * @param speed
	 *        The speed to set.
	 */
	public void setLeftSpeed(double speed) {
		IO.getLeftDriveTalonMaster().set(ControlMode.PercentOutput, speed);
		IO.getLeftDriveTalonFront().set(ControlMode.Follower, Constants.LEFT_DRIVE_TALON_MASTER);
		IO.getLeftDriveTalonRear().set(ControlMode.Follower, Constants.LEFT_DRIVE_TALON_MASTER);
	}

	/**
	 * Sets the right drive speed based on percent output.
	 *
	 * @param speed
	 *        The speed to set.
	 */
	public void setRightSpeed(double speed) {
		IO.getRightDriveTalonMaster().set(ControlMode.PercentOutput, speed);
		IO.getRightDriveTalonFront().set(ControlMode.Follower, Constants.RIGHT_DRIVE_TALON_MASTER);
		IO.getRightDriveTalonRear().set(ControlMode.Follower, Constants.RIGHT_DRIVE_TALON_MASTER);
	}

	/**
	 * Sets both sides of the drivetrain to the same speed.
	 *
	 * @param speed
	 *        The speed to set.
	 */
	public void setBothSpeed(double speed) {
		setLeftSpeed(speed);
		setRightSpeed(speed);
	}

	/**
	 * Stops the drivetrain.
	 */
	public void halt() {
		setBothSpeed(0);
	}

}