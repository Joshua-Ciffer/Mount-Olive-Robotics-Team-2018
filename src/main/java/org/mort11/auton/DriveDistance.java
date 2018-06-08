package org.mort11.auton;

import edu.wpi.first.wpilibj.command.Command;

import org.mort11.Robot;
import org.mort11.hardware.IO;
import org.mort11.util.Convertor;

import static org.mort11.util.Constants.*;

/**
 * This auton command drives the robot for a specified distance.
 * 
 * @author Seven Kurt
 * @author Joshua Ciffer
 * @version 06/08/2018
 */
public final class DriveDistance extends Command {

	/**
	 * The distance intended for the robot to drive.
	 */
	private double targetDistance;

	/**
	 * The distance the robot has traveled so far.
	 */
	private double distanceTraveled;

	/**
	 * Constructs a new <code>DriveDistance</code> command.
	 *
	 * @param targetDistance
	 *        The distance intended for the robot to drive.
	 */
	public DriveDistance(double targetDistance) {
		super("DriveDistance");
		this.targetDistance = targetDistance;
	}

	protected void initialize() {
		IO.getRightMaster().setSelectedSensorPosition(0, 0, 0);
		IO.getLeftMaster().setSelectedSensorPosition(0, 0, 0);
	}

	protected void execute() {
		// distance = ahrs.getDisplacementY();
		if (Math.abs(targetDistance - distanceTraveled) > DISTANCE_LENIENCY) {
			Robot.drivetrain.setLeftDriveVelocity(Convertor.convertFPSToEncoderTicksPer100Milliseconds(2));
			Robot.drivetrain.setRightDriveVelocity(Convertor.convertFPSToEncoderTicksPer100Milliseconds(2));
		} else if (Math.abs(targetDistance - distanceTraveled) < DISTANCE_LENIENCY) {
			Robot.drivetrain.setLeftDriveVelocity(Convertor.convertFPSToEncoderTicksPer100Milliseconds(1));
			Robot.drivetrain.setRightDriveVelocity(Convertor.convertFPSToEncoderTicksPer100Milliseconds(2));
		}

		Robot.drivetrain.setLeftDriveSpeed(0.5);
		Robot.drivetrain.setRightDriveSpeed(0.5);
		distanceTraveled = CIRCUMFERENCE_IN_INCHES * (IO.getRightMaster().getSensorCollection().getPulseWidthPosition() / 4096);

	}

	protected boolean isFinished() {
		return distanceTraveled <= targetDistance + 10 || distanceTraveled >= targetDistance - 10;
	}

	protected void end() {
		Robot.drivetrain.setRightDriveSpeed(0);
		Robot.drivetrain.setLeftDriveSpeed(0);
	}
}
