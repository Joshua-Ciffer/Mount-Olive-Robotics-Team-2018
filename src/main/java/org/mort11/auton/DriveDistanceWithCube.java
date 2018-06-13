package org.mort11.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.mort11.intake.CoastIntake;

/**
 * An auton command that drives the robot for a specified distance while holding a cube.
 *
 * @author Joshua Ciffer
 * @version 06/12/2018
 */
public final class DriveDistanceWithCube extends CommandGroup {

	/**
	 * Constructs a new <code>DriveDistanceWithCube</code>.
	 *
	 * @param distance
	 *        The distance to drive.
	 */
	public DriveDistanceWithCube(double distance) {
		super("DriveDistanceWithCube");
		addParallel(new DriveDistance(distance));
		addParallel(new CoastIntake());
	}

}