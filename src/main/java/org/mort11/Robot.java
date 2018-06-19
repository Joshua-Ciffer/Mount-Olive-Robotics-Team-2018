package org.mort11;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.mort11.control.Operator;
import org.mort11.elevator.Elevator;
import org.mort11.hardware.IO;
import org.mort11.util.SmartDashboardLogger;

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
	 * The elevator subsystem.
	 */
	public static Elevator elevator;

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
		elevator = new Elevator();
		Operator.init();
	}

	/**
	 * Initializes the robot for disabled mode.
	 */
	@Override
	public void disabledInit() {
		Scheduler.getInstance().removeAll();
		IO.getElevatorTalonMaster().setNeutralMode(NeutralMode.Brake);
		IO.getElevatorTalonFollower().setNeutralMode(NeutralMode.Brake);
		SmartDashboardLogger.initEncoders();
	}

	/**
	 * Periodic code for disabled mode.
	 */
	@Override
	public void disabledPeriodic() {
		SmartDashboardLogger.initEncoders();
	}

	/**
	 * Initializes the robot for auton mode.
	 */
	@Override
	public void autonomousInit() {
		IO.getElevatorTalonMaster().setNeutralMode(NeutralMode.Coast);
		IO.getElevatorTalonFollower().setNeutralMode(NeutralMode.Coast);
	}

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
	public void teleopInit() {
		IO.getElevatorTalonMaster().setSelectedSensorPosition(0, 0, 0);
		IO.getElevatorTalonMaster().setNeutralMode(NeutralMode.Coast);
		IO.getElevatorTalonFollower().setNeutralMode(NeutralMode.Coast);
	}

	/**
	 * Periodic code for teleop mode.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboardLogger.initEncoders();
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