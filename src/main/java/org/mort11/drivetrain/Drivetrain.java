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
		super("drivetrain");
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
		IO.getLeftMaster().set(ControlMode.PercentOutput, -speed);
		IO.getLeftSlaveMiddle().set(ControlMode.Follower, Constants.DRIVETRAIN_LEFT_MASTER);
		IO.getLeftSlaveBack().set(ControlMode.Follower, Constants.DRIVETRAIN_LEFT_MASTER);
	}

	/**
	 * Sets the right drive speed based on percent output.
	 *
	 * @param speed
	 *        The speed to set.
	 */
	public void setRightSpeed(double speed) {
		IO.getRightMaster().set(ControlMode.PercentOutput, speed);
		IO.getRightSlaveMiddle().set(ControlMode.Follower, Constants.DRIVETRAIN_RIGHT_MASTER);
		IO.getRightSlaveBack().set(ControlMode.Follower, Constants.DRIVETRAIN_RIGHT_MASTER);
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
		IO.getLeftMaster().set(ControlMode.Velocity, velocity);
		IO.getLeftSlaveMiddle().set(ControlMode.Follower, Constants.DRIVETRAIN_LEFT_MASTER);
		IO.getLeftSlaveBack().set(ControlMode.Follower, Constants.DRIVETRAIN_LEFT_MASTER);
	}

	/**
	 * Sets the right drive speed based on encoder ticks per 100ms.
	 *
	 * @param velocity
	 *        The velocity to set.
	 */
	public void setRightVelocity(double velocity) {
		IO.getRightMaster().set(ControlMode.Velocity, -velocity);
		IO.getRightSlaveMiddle().set(ControlMode.Follower, Constants.DRIVETRAIN_RIGHT_MASTER);
		IO.getRightSlaveBack().set(ControlMode.Follower, Constants.DRIVETRAIN_RIGHT_MASTER);
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
				IO.getTransmission().set(Value.kForward);
				break;
			}
			case LOW: {
				IO.getTransmission().set(Value.kReverse);
				break;
			}
		}
	}

}