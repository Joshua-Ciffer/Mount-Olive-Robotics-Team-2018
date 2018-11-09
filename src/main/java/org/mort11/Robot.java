package org.mort11;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.mort11.hardware.IO;
import org.mort11.control.Operator;
import org.mort11.drivetrain.Drivetrain;
import org.mort11.elevator.Elevator;
import org.mort11.intake.IntakeRollers;
import org.mort11.intake.IntakeShifter;
import org.mort11.util.AutoChooser;

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

	/**
	 * Tells the robot which auton command to run.
	 */
	private static SendableChooser<Command> autonChooser;

	/**
	 * Tells the robot which side?
	 */
	private static SendableChooser<String> sideChooser;

	/**
	 * The auton command to run for this round.
	 */
	private static Command autonCommand;

	/**
	 * Game data from the drive station.
	 */
	private static String gameData;

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
		IO.getCompressor().start();
		sideChooser = new SendableChooser<>();
		sideChooser.addDefault("Middle", "Middle");
		sideChooser.addObject("Left", "Left");
		sideChooser.addObject("Right", "Right");
		SmartDashboard.putData("Sides", sideChooser);
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
	public void disabledPeriodic() {
		autonChooser = new SendableChooser<>();
		AutoChooser.addAutons(sideChooser.getSelected());
		SmartDashboard.putData("autons", autonChooser);
	}

	/**
	 * Initializes the robot for auton mode.
	 */
	@Override
	public void autonomousInit() {
		gameData = DriverStation.getInstance().getGameSpecificMessage(); // Get the game data from the driver station
		autonCommand = AutoChooser.setAutoCommand(autonChooser.getSelected(), gameData);
		if (autonCommand != null) {
			autonCommand.start();
		}
	}

	/**
	 * Periodic code for auton mode.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.updateValues();
	}

	/**
	 * Initializes the robot for teleop mode.
	 */
	@Override
	public void teleopInit() {
		if (autonCommand != null) {
			autonCommand.cancel();
		}
	}

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

	/**
	 * @return The auton sendable chooser.
	 */
	public static SendableChooser<Command> getAutonChooser() {
		return autonChooser;
	}

	/**
	 * @return The side sendable chooser
	 */
	public static SendableChooser<String> getSideChooser() {
		return sideChooser;
	}

	/**
	 * @return The current auton command.
	 */
	public static Command getAutonCommand() {
		return autonCommand;
	}

}