package org.mort11;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.mort11.Control.Operator;
import org.mort11.Hardware.IO;
import org.mort11.Subsystems.Drivetrain.Drivetrain;
import org.mort11.Subsystems.endeffector.FirstStageElevator;
import org.mort11.Subsystems.endeffector.FourBarArm;
import org.mort11.Subsystems.endeffector.Intake;
import org.mort11.Subsystems.endeffector.SecondStageElevator;
import org.mort11.Util.AutoChooser;
import org.mort11.Util.SmartDashboardLogger;

/**
 *
 * @author Benny Mirisola
 * @author Seven Kurt
 * @version 02/14/2018
 */
public class Robot extends IterativeRobot {

	public static FirstStageElevator firstStageElevator;
	public static SecondStageElevator secondStageElevator;
	public static FourBarArm fourBarArm;
	public static Intake intake;
	public static Drivetrain driveTrain; // Creates a drivetrain object

	private Command autoCommand; // Autonomous command to run

	private NetworkTable autonomous; // ShuffleBoard autonomous table
	public static NetworkTable debug; // ShuffleBoard debug table
	private NetworkTable limelight; // ShuffleBoard camera table

	private String gameData; // Game data from the driver station
	private String robotPos; // The position of the robot on the field

	UsbCamera camera; // The camera connected to the robot
	public static SendableChooser<Command> autoChooser;
	SendableChooser<String> sideChooser;

	@Override
	public void robotInit() {

		IO.init();

		firstStageElevator = new FirstStageElevator();
		secondStageElevator = new SecondStageElevator();
		fourBarArm = new FourBarArm();
		intake = new Intake();

		new Compressor().start();

		Operator.init();

		autonomous = NetworkTableInstance.getDefault().getTable("Autonomous"); // Create tables
		debug = NetworkTableInstance.getDefault().getTable("Debug");
		limelight = NetworkTableInstance.getDefault().getTable("Limelight");

		driveTrain = new Drivetrain(); // Create the drive train subsystem object
		SmartDashboardLogger.init();
		autoChooser = new SendableChooser<Command>();
		sideChooser = new SendableChooser<>();
		sideChooser.addDefault("Middle", "Middle");
		sideChooser.addObject("Left", "Left");
		sideChooser.addObject("Right", "Right");

	}

	@Override
	public void teleopInit() {
		super.teleopInit();

		NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
		NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(1);

	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {

		super.autonomousInit();

		gameData = DriverStation.getInstance().getGameSpecificMessage(); // Get the game data from the driver station

		// if(!autoChooser.getSelected().equals(new DoNothing())){
		// autoCommand = AutoChooser.setAutoCommand((Command)autoChooser.getSelected(), gameData);
		// }

	}

	@Override
	public void autonomousPeriodic() {
		super.autonomousPeriodic();
	}

	@Override
	public void testInit() {
		super.teleopInit();
	}

	@Override
	public void testPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.updateValues();
	}

	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		AutoChooser.addAutons(sideChooser.getSelected());

	}

}