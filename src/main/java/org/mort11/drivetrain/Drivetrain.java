package org.mort11.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.mort11.hardware.IO;
import org.mort11.util.Constants;
import org.mort11.util.HardwareStates.DrivetrainGear;

/**
 * This class represents the drivetrain subsystem.
 * 
 * @author Joshua Ciffer
 * @version 06/12/2018
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
		IO.getLeftDriveTalonMaster().set(ControlMode.PercentOutput, -speed);
		IO.getLeftDriveTalonMiddle().set(ControlMode.Follower, Constants.LEFT_DRIVE_TALON_MASTER);
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
		IO.getRightDriveTalonMiddle().set(ControlMode.Follower, Constants.RIGHT_DRIVE_TALON_MASTER);
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
	 * Sets the left drive speed based on encoder ticks per 100ms.
	 *
	 * @param velocity
	 *        The velocity to set.
	 */
	public void setLeftVelocity(double velocity) {
		IO.getLeftDriveTalonMaster().set(ControlMode.Velocity, velocity);
		IO.getLeftDriveTalonMiddle().set(ControlMode.Follower, Constants.LEFT_DRIVE_TALON_MASTER);
		IO.getLeftDriveTalonRear().set(ControlMode.Follower, Constants.LEFT_DRIVE_TALON_MASTER);
	}

	/**
	 * Sets the right drive speed based on encoder ticks per 100ms.
	 *
	 * @param velocity
	 *        The velocity to set.
	 */
	public void setRightVelocity(double velocity) {
		IO.getRightDriveTalonMaster().set(ControlMode.Velocity, -velocity);
		IO.getRightDriveTalonMiddle().set(ControlMode.Follower, Constants.RIGHT_DRIVE_TALON_MASTER);
		IO.getRightDriveTalonRear().set(ControlMode.Follower, Constants.RIGHT_DRIVE_TALON_MASTER);
	}

	/**
	 * Sets both sides of the drivetrain to the same velocity.
	 *
	 * @param velocity
	 *        The velocity to set.
	 */
	public void setBothVelocity(double velocity) {
		setLeftVelocity(velocity);
		setRightVelocity(velocity);
	}

	/**
	 * Stops the drivetrain.
	 */
	public void halt() {
		setBothSpeed(0);
		IO.getDrivetrainTransmission().set(Value.kOff);
	}

	/**
	 * Shifts the gear of the drivetrain.
	 *
	 * @param gear
	 *        The gear to shift to.
	 */
	public void shift(DrivetrainGear gear) {
		switch (gear) {
			case HIGH: {
				IO.getDrivetrainTransmission().set(Value.kForward);
				break;
			}
			case LOW: {
				IO.getDrivetrainTransmission().set(Value.kReverse);
				break;
			}
		}
	}

}