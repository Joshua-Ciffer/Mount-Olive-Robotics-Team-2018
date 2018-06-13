package org.mort11;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.mort11.hardware.IO;
import org.mort11.led.LED;

/**
 * The main robot class. All subsystems are initialized here and commands are scheduled.
 * 
 * @author Joshua Ciffer
 * @author Benny Mirisola
 * @author Seven Kurt
 * @author Frank Alfano
 * @version 06/13/2018
 */
public final class Robot extends IterativeRobot {

	/**
	 * The LED subsystem.
	 */
	public static LED led;

	/**
	 * Don't let anyone instantiate this class.
	 */
	private Robot() {}

	/**
	 * Initializes all of the robots subsystems and the smart dash board.
	 */
	@Override
	public void robotInit() {
		IO.init();
		led = new LED();
	}

	/**
	 * Initializes the robot for disabled mode.
	 */
	@Override
	public void disabledInit() {
		Scheduler.getInstance().removeAll();
	}

	/**
	 * Periodic code for disabled mode.
	 */
	@Override
	public void disabledPeriodic() {}

	/**
	 * Initializes the robot for auton mode.
	 */
	@Override
	public void autonomousInit() {}

	/**
	 * Periodic code for auton mode.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * Initializes the robot for teleop mode.
	 */
	@Override
	public void teleopInit() {}

	/**
	 * Periodic code for teleop mode.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.updateValues();
	}

	/**
	 * Initializes robot for test mode.
	 */
	@Override
	public void testInit() {}

	/**
	 * Periodic code for test mode.
	 */
	@Override
	public void testPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.updateValues();
	}

}