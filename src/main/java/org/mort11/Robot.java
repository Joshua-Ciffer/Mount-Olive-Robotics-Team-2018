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
import org.mort11.led.LED;
import org.mort11.util.AutoChooser;
import org.mort11.util.SmartDashboardLogger;

/**
 * 
 * @author Joshua Ciffer
 * @author Benny Mirisola
 * @author Seven Kurt
 * @author Frank Alfano
 * @version 06/12/2018
 */
public final class Robot extends IterativeRobot {

	public static Elevator elevator;
	public static IntakePistons intakePiston;
	public static IntakeShifter intakeShifter;
	public static IntakeRollers intakeRollers;
	public static Drivetrain drivetrain;
	public static LED led;
	public static SendableChooser<Command> autoChooser;
	SendableChooser<String> sideChooser;
	private Command autoCommand; // Autonomous command to run
	private String gameData; // Game data from the driver station
	@SuppressWarnings("unused")
	private String robotPos; // The position of the robot on the field

	/**
	 * Don't let anyone instantiate this class.
	 */
	private Robot() {}

	@Override
	public void robotInit() {

		IO.init();

		elevator = new Elevator();
		intakePiston = new IntakePistons();
		intakeShifter = new IntakeShifter();
		intakeRollers = new IntakeRollers();
		drivetrain = new Drivetrain(); // Create the drive train subsystem object
		led = new LED();
		Operator.init();

		sideChooser = new SendableChooser<>();
		sideChooser.addDefault("Middle", "Middle");
		sideChooser.addObject("Left", "Left");
		sideChooser.addObject("Right", "Right");
		SmartDashboard.putData("Sides", sideChooser);

		// SmartDashboardLogger.init();

	}

	@Override
	public void disabledInit() {
		Scheduler.getInstance().removeAll();
		IO.getElevatorTalonMaster().setNeutralMode(NeutralMode.Brake);
		IO.getElevatorTalonFollower().setNeutralMode(NeutralMode.Brake);
		SmartDashboardLogger.initEncoders();
	}

	@Override
	public void disabledPeriodic() {
		autoChooser = new SendableChooser<>();
		SmartDashboardLogger.initEncoders();
		AutoChooser.addAutons(sideChooser.getSelected());
		SmartDashboard.putData("autons", autoChooser);
	}

	@Override
	public void autonomousInit() {
		gameData = DriverStation.getInstance().getGameSpecificMessage(); // Get the game data from the driver station
		autoCommand = AutoChooser.setAutoCommand(autoChooser.getSelected(), gameData);
		IO.getRightDriveTalonMaster().setSelectedSensorPosition(0, 0, 0);
		if (autoCommand != null) {
			autoCommand.start();
		}
		IO.getElevatorTalonMaster().setNeutralMode(NeutralMode.Coast);
		IO.getElevatorTalonFollower().setNeutralMode(NeutralMode.Coast);
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		// SmartDashboard.updateValues();
		// SmartDashboardLogger.initEncoders();
	}

	@Override
	public void teleopInit() {
		if (autoCommand != null) {
			autoCommand.cancel();
		}
		IO.getRightDriveTalonMaster().setSelectedSensorPosition(0, 0, 0);
		IO.getElevatorTalonMaster().setSelectedSensorPosition(0, 0, 0);
		IO.getElevatorTalonMaster().setNeutralMode(NeutralMode.Coast);
		IO.getElevatorTalonFollower().setNeutralMode(NeutralMode.Coast);
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboardLogger.initEncoders();
		SmartDashboard.updateValues();
		System.out.println("Error: " + IO.getElevatorTalonMaster().getClosedLoopError(0));
		System.out.println(IO.getRightDriveTalonMaster().getSelectedSensorPosition(0));
		System.out.println(IO.getLeftDriveTalonMaster().getSelectedSensorPosition(0));
	}

	@Override
	public void testInit() {}

	@Override
	public void testPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.updateValues();
	}

}