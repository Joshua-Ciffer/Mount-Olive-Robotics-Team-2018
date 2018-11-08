package org.mort11.auton;

import edu.wpi.first.wpilibj.command.TimedCommand;

import org.mort11.Robot;

/**
 * An auton command to run the drivetrain for a specified amount of time at a specific speed. This command only drives the robot
 * in a straight line.
 * 
 * @author Joshua Ciffer
 * @version 06/08/2018
 */
public final class DriveDistanceTimed extends TimedCommand {

	/**
	 * The speed the robot will drive.
	 */
	private double speed;

	/**
	 * Constructs a new <code>DriveDistanceTimed</code> command.
	 *
	 * @param speed
	 *        The speed the robot will drive.
	 * @param timeout
	 *        The time the robot will drive for, in seconds.
	 */
	public DriveDistanceTimed(double speed, double timeout) {
		super(timeout);
		this.speed = speed;
		requires(Robot.getDrivetrain());
		setInterruptible(false);
	}

	/**
	 * Sets both sides of the drivetrain to drive at the specified speed.
	 */
	@Override
	protected void execute() {
		Robot.getDrivetrain().setBothSpeed(speed);
	}

	/**
	 * Halts the drivetrain at the completion of the command.
	 */
	@Override
	protected void end() {
		Robot.getDrivetrain().halt();
	}

}