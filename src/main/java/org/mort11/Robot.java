package org.mort11;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.mort11.auton.DriveDistanceTimed;
import org.mort11.auton.DriveTimedWithCube;
import org.mort11.hardware.IO;
import org.mort11.control.Operator;
import org.mort11.drivetrain.Drivetrain;
import org.mort11.elevator.Elevator;
import org.mort11.intake.IntakeRollers;
import org.mort11.intake.IntakeShifter;
import org.mort11.util.Constants;

/**
 * The main robot class. All subsystems are initialized here and commands are scheduled.
 * 
 * @author Joshua Ciffer
 * @author Benny Mirisola
 * @author Timmy Vu
 * @version 11/08/2018
 */
public class Robot extends IterativeRobot {

	/**
	 * The drivetrain subsystem.
	 */
	private static Drivetrain drivetrain;

	/**
	 * The elevator subsystem.
	 */
	private static Elevator elevator;

	/**
	 * The intake roller wheels.
	 */
	private static IntakeRollers intakeRollers;

	/**
	 * The intake shifter piston.
	 */
	private static IntakeShifter intakeShifter;

	private Command autoCommand;

	/**
	 * Initializes all of the robots subsystems and the smart dash board.
	 */
	@Override
	public void robotInit() {
		IO.init();
		drivetrain = new Drivetrain();
		elevator = new Elevator();
		intakeRollers = new IntakeRollers();
		intakeShifter = new IntakeShifter();
		Operator.init();
	}

	/**
	 * Runs periodically no matter what mode is enabled or disabled.
	 */
	@Override
	public void robotPeriodic() {}

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
	public void autonomousInit() {
		autoCommand = new DriveTimedWithCube(Constants.DRIVETRAIN_SPEED, Constants.DRIVETRAIN_AUTON_TIMEOUT);

		if(autoCommand != null){
			autoCommand.start();
		}
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
	public void teleopInit() {}

	/**
	 * Periodic code for teleop mode.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
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
	}

	/**
	 * @return The drivetrain subsystem.
	 */
	public static Drivetrain getDrivetrain() {
		return drivetrain;
	}

	/**
	 * @return The elevator subsystem.
	 */
	public static Elevator getElevator() {
		return elevator;
	}

	/**
	 * @return The intake rollers subsystem.
	 */
	public static IntakeRollers getIntakeRollers() {
		return intakeRollers;
	}

	/**
	 * @return The intake shifter subsystem.
	 */
	public static IntakeShifter getIntakeShifter() {
		return intakeShifter;
	}

}