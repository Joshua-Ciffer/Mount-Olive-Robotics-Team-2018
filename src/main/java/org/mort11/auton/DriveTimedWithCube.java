package org.mort11.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.mort11.intake.RollIntake;
import org.mort11.util.HardwareStates.IntakeRollersState;;

/**
 * An auton command to drive the robot for a specified time while holding a cube.
 *
 * @author Joshua Ciffer
 * @version 06/12/2018
 */
public final class DriveTimedWithCube extends CommandGroup {

	/**
	 * Constructs a new <code>DriveTimedWithCube</code>.
	 *
	 * @param speed
	 *        The speed for the robot to drive at.
	 * @param timeout
	 *        The time (in seconds) for the robot to drive.
	 */
	public DriveTimedWithCube(double speed, double timeout) {
		super("DriveTimedWithCube");
		addParallel(new DriveDistanceTimed(speed, timeout));
		addParallel(new RollIntake(IntakeRollersState.IN));
	}

}