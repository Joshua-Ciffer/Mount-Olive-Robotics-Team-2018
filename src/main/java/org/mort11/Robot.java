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
 * @author Benny Mirisola
 * @author Seven Kurt
 * @author Frank Alfano
 */
public class Robot extends IterativeRobot {

	public static Elevator firstStageElevator;
	public static IntakePistons intakePistons;
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

	@Override
	public void robotInit() {

		IO.init();

		firstStageElevator = new Elevator();
		intakePistons = new IntakePistons();
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
		IO.getFirstStageElevatorTalonMaster().setNeutralMode(NeutralMode.Brake);
		IO.getFirstStageElevatorTalonFollower().setNeutralMode(NeutralMode.Brake);
		SmartDashboardLogger.initEncoders();
	}

	@Override
	public void disabledPeriodic() {
		autoChooser = new SendableChooser<>();
		SmartDashboardLogger.initEncoders();
		AutoChooser.addAutons(sideChooser.getSelected());
		SmartDashboard.putData("autons", autoChooser);
		// System.out.println("Elevator Position:" + IO.getFirstStageElevatorTalonMaster().getSelectedSensorPosition(0));
	}

	@Override
	public void autonomousInit() {
		gameData = DriverStation.getInstance().getGameSpecificMessage(); // Get the game data from the driver station
		autoCommand = AutoChooser.setAutoCommand(autoChooser.getSelected(), gameData);
		IO.getRightMaster().setSelectedSensorPosition(0, 0, 0);
		// autoCommand = new SwitchTurnLeft();
		// autoCommand = new TurnDegrees(-90);
		if (autoCommand != null) {
			autoCommand.start();
		}
		IO.getFirstStageElevatorTalonMaster().setNeutralMode(NeutralMode.Coast);
		IO.getFirstStageElevatorTalonFollower().setNeutralMode(NeutralMode.Coast);
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		// ((LEDCommand)led.getCurrentCommand()).setCommandMode(CHANGE_ALLIANCE_COLOR);
		// SmartDashboard.updateValues();
		// SmartDashboardLogger.initEncoders();
	}

	@Override
	public void teleopInit() {
		if (autoCommand != null) {
			autoCommand.cancel();
		}
		IO.getRightMaster().setSelectedSensorPosition(0, 0, 0);
		IO.getFirstStageElevatorTalonMaster().setSelectedSensorPosition(0, 0, 0);
		IO.getFirstStageElevatorTalonMaster().setNeutralMode(NeutralMode.Coast);
		IO.getFirstStageElevatorTalonFollower().setNeutralMode(NeutralMode.Coast);
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboardLogger.initEncoders();
		SmartDashboard.updateValues();
		System.out.println("Error: " + IO.getFirstStageElevatorTalonMaster().getClosedLoopError(0));
		// ((LEDCommand)led.getCurrentCommand()).setCommandMode(INTAKE_COLOR_CHANGER);
		// System.out.println("left Drive Error: " + IO.getLeftMaster().getClosedLoopError(0));
		// System.out.println("Left Drive position" + IO.getLeftMaster().getSelectedSensorPosition(0));
		// System.out.println("Velocity of Elevator: " + IO.getFirstStageElevatorTalonMaster().getSelectedSensorVelocity(0));
		// System.out.println("Error of Elevator " + IO.getFirstStageElevatorTalonMaster().getClosedLoopError(0));
		// SmartDashboard.putNumber("Velocity:", IO.getRightMaster().getSelectedSensorVelocity(0));
		// SmartDashboard.putNumber("Error", IO.getRightMaster().getClosedLoopError(0));
		// SmartDashboard.putNumber("Position", IO.getRightMaster().getSelectedSensorPosition(0));
		// SmartDashboard.updateValues();
		// System.out.println(IO.getFirstStageElevatorTalonMaster().getSelectedSensorVelocity(Constants.PID_LOOP_ID));
		System.out.println(IO.getRightMaster().getSelectedSensorPosition(0));
		System.out.println(IO.getLeftMaster().getSelectedSensorPosition(0));
	}

	@Override
	public void testInit() {}

	@Override
	public void testPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.updateValues();
	}

}