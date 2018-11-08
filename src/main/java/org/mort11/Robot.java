package org.mort11;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.mort11.control.Operator;
import org.mort11.drivetrain.Drivetrain;
import org.mort11.elevator.Elevator;
import org.mort11.hardware.IO;
import org.mort11.intake.IntakePistons;
import org.mort11.intake.IntakeRollers;
import org.mort11.intake.IntakeShifter;
import org.mort11.climber.Climber;
import org.mort11.util.AutoChooser;

/**
 * The main robot class. All subsystems are initialized here and commands are scheduled.
 * 
 * @author Joshua Ciffer
 * @author Benny Mirisola
 * @author Seven Kurt
 * @author Frank Alfano
 * @version 06/13/2018
 */
public class Robot extends IterativeRobot {

	/**
	 * The drivetrain subsystem.
	 */
	public static Drivetrain drivetrain;

	/**
	 * The elevator subsystem.
	 */
	public static Elevator elevator;

	/**
	 * The intake roller wheels.
	 */
	public static IntakeRollers intakeRollers;

	/**
	 * The intake grabber piston.
	 */
	public static IntakePistons intakePistons;

	/**
	 * The intake shifter piston.
	 */
	public static IntakeShifter intakeShifter;

	/**
	 * The climber piston subsystem.
	 */
	public static Climber climber;

	/**
	 * Tells the robot which auton command to run.
	 */
	public static SendableChooser<Command> autonChooser;

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
		intakePistons = new IntakePistons();
		intakeShifter = new IntakeShifter();
		climber = new Climber();
		Operator.init();

		sideChooser = new SendableChooser<>();
		sideChooser.addDefault("Middle", "Middle");
		sideChooser.addObject("Left", "Left");
		sideChooser.addObject("Right", "Right");
		SmartDashboard.putData("Sides", sideChooser);
	}

	/**
	 * Initializes the robot for disabled mode.
	 */
	@Override
	public void disabledInit() {
		Scheduler.getInstance().removeAll();
		IO.getElevatorTalonMaster().setNeutralMode(NeutralMode.Brake);
		IO.getElevatorTalonFollower().setNeutralMode(NeutralMode.Brake);
		IO.getCompressor().stop();
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
		IO.getElevatorTalonMaster().setNeutralMode(NeutralMode.Coast);
		IO.getElevatorTalonFollower().setNeutralMode(NeutralMode.Coast);
		IO.getCompressor().start();
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
		if (autonCommand != null) {
			autonCommand.cancel();
		}
		IO.getElevatorTalonMaster().setNeutralMode(NeutralMode.Coast);
		IO.getElevatorTalonFollower().setNeutralMode(NeutralMode.Coast);
		IO.getCompressor().start();
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
	public void testInit() {
		IO.getCompressor().start();
	}

	/**
	 * Periodic code for test mode.
	 */
	@Override
	public void testPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.updateValues();
	}

}