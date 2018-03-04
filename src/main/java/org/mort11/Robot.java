package org.mort11;

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
import org.mort11.Subsystems.endeffector.Intake.IntakePistons;
import org.mort11.Subsystems.endeffector.Intake.IntakeRollers;
import org.mort11.Subsystems.endeffector.SecondStageElevator;
import org.mort11.Util.AutoChooser;

/**
 * @author Benny Mirisola
 * @author Seven Kurt
 * @author Frank Alfano
 */
public class Robot extends IterativeRobot {

    public static FirstStageElevator firstStageElevator;
    public static SecondStageElevator secondStageElevator;
    public static FourBarArm fourBarArm;
    public static IntakePistons intakePistons;
    public static IntakeRollers intakeRollers;
    public static Drivetrain driveTrain; // Creates a drivetrain object

    private Command autoCommand; // Autonomous command to run

    private String gameData; // Game data from the driver station
    private String robotPos; // The position of the robot on the field

    public static SendableChooser<Command> autoChooser;
    SendableChooser<String> sideChooser;

    @Override
    public void robotInit() {

        IO.init();

        firstStageElevator = new FirstStageElevator();
        secondStageElevator = new SecondStageElevator();
        fourBarArm = new FourBarArm();
        intakePistons = new IntakePistons();
        intakeRollers = new IntakeRollers();
        driveTrain = new Drivetrain(); // Create the drive train subsystem object

        Operator.init();

        sideChooser = new SendableChooser<>();
        sideChooser.addDefault("Middle", "Middle");
        sideChooser.addObject("Left", "Left");
        sideChooser.addObject("Right", "Right");
        SmartDashboard.putData("Sides", sideChooser);

        //SmartDashboardLogger.init();

    }

    @Override
    public void disabledInit() {
        Scheduler.getInstance().removeAll();
    }

    @Override
    public void disabledPeriodic() {
        autoChooser = new SendableChooser<>();

        AutoChooser.addAutons(sideChooser.getSelected());
        SmartDashboard.putData("autons", autoChooser);
    }

    @Override
    public void autonomousInit() {

        gameData = DriverStation.getInstance().getGameSpecificMessage(); // Get the game data from the driver station
        autoCommand = AutoChooser.setAutoCommand(autoChooser.getSelected(), gameData);
        if (autoCommand != null) {
            autoCommand.start();
        }
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        if (autoCommand != null) {
            autoCommand.cancel();
        }
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.updateValues();
    }

    @Override
    public void testInit() {
    }

    @Override
    public void testPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.updateValues();
    }

}