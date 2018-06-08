package org.mort11.auton;

import edu.wpi.first.wpilibj.command.Command;

import org.mort11.Robot;
import org.mort11.hardware.IO;
import org.mort11.util.Constants;

/**
 * An auton command to turn the robot a specified number of degrees.
 * 
 * @author Seven Kurt
 * @author Joshua Ciffer
 * @version 06/08/2018
 */
public final class TurnDegrees extends Command {

	/**
	 * The angle to turn the robot.
	 */
	private double desiredAngle;

	/**
	 * The current yaw the robot has turned.
	 */
	private double yaw;

	/**
	 * Constructs a new <code>TurnDegrees</code> command.
	 *
	 * @param desiredAngle
	 *        The angle to turn the robot.
	 */
	public TurnDegrees(double desiredAngle) {
		super("TurnDegrees");
		if (desiredAngle > 180) {
			this.desiredAngle = 180;
		} else if (desiredAngle < -180) {
			this.desiredAngle = -180;
		} else {
			this.desiredAngle = desiredAngle;
		}
		requires(Robot.drivetrain);
	}

	/**
	 * Initializes the AHRS to zero degrees.
	 */
	protected void initialize() {
		IO.getAHRS().zeroYaw();
	}

	/**
	 * Turns the robot until the desired angle is reached.
	 */
	protected void execute() {
		yaw = IO.getAHRS().getYaw();
		/*
		 * Finds the difference in angle between desired angle and the current yaw. If difference is greater than 30, set the motors
		 * to .3. If the difference is less than 30 but more than 3, set the motors to .15.
		 * ^^^ Thank you to whoever wrote this documentation, -Josh.
		 */
		if (Math.abs(yaw - desiredAngle) >= Constants.ANGLE_LENIENCY_FAR) {
			if (desiredAngle < 0) {
				Robot.drivetrain.setLeftDriveSpeed(Constants.SPEED_FAR);
				Robot.drivetrain.setRightDriveSpeed(-Constants.SPEED_FAR);
			} else {
				Robot.drivetrain.setLeftDriveSpeed(-Constants.SPEED_FAR);
				Robot.drivetrain.setRightDriveSpeed(Constants.SPEED_FAR);
			}
		} else if (Math.abs(yaw - desiredAngle) >= Constants.ANGLE_LENIENCY_CLOSE) {
			if (desiredAngle < 0) {
				Robot.drivetrain.setLeftDriveSpeed(Constants.SPEED_CLOSE);
				Robot.drivetrain.setRightDriveSpeed(-Constants.SPEED_CLOSE);
			} else {
				Robot.drivetrain.setLeftDriveSpeed(-Constants.SPEED_CLOSE);
				Robot.drivetrain.setRightDriveSpeed(Constants.SPEED_CLOSE);
			}
		}
	}

	/**
	 * Command is finished if
	 */
	protected boolean isFinished() {
		return Math.abs(IO.getAHRS().getYaw() - desiredAngle) <= Constants.ANGLE_FINISH;
	}

	/**
	 * Upon completion of the command, the drivetrain is halted, and the AHRS is set to zero yaw.
	 */
	protected void end() {
		Robot.drivetrain.halt();
		IO.getAHRS().zeroYaw();
	}

}