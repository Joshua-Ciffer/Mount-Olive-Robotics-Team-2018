package org.mort11.util;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.commands.auton.DoNothing;
import org.mort11.commands.auton.driving.DriveDistanceTimed;
import org.mort11.commands.auton.driving.DriveTimedWithCube;
//import org.mort11.Commands.Autonomous.*;

/**
 * Created by q24xboss's PC on 1/22/2018.
 */

public class AutoChooser {
    static Command autoCommand;

    public static Command setAutoCommand(Command selected, String gameData) {
        autoCommand = selected;
//        if(selected.equals(new SwitchTurnLeft()) && gameData.charAt(0) == 'R') {
//            autoCommand = new SwitchTurnLeft();
//        }
//        else if(selected.equals(new SwitchTurnRight()) && gameData.charAt(0) == 'L') {
//            autoCommand = new SwitchTurnRight();
//        }
//        else if(selected.equals(new ScaleTurnLeft()) && gameData.charAt(0) == 'R') {
//            autoCommand = new ScaleTurnLeft();
//        }
//        else if(selected.equals(new ScaleTurnRight()) && gameData.charAt(0) == 'L') {
//            autoCommand = new ScaleTurnRight();
//        }
//        else if(selected.equals(new DriveStraight())) {
//            autoCommand = new DriveStraight();
//        }
//        else {
//            autoCommand = new DriveStraight();
//        }
//
        return autoCommand; // Return the autonomous command to run
//
    }

    /*
     * Adds autons to side according to auton chooser
     */
    public static void addAutons(String side) {
        if (side.equals("Middle")) {
            Robot.autoChooser.addObject("Do Nothing", new DoNothing());
            Robot.autoChooser.addDefault("Drive Forwards With Cube", new DriveTimedWithCube(Constants.DRIVETRAIN_SPEED, 4, Constants.INTAKE_COAST));
            Robot.autoChooser.addObject("DriveForwardsTimed", new DriveDistanceTimed(Constants.DRIVETRAIN_SPEED, 2));
        } else if (side.equals("Left")) {
            Robot.autoChooser.addObject("Do Nothing", new DoNothing());
            Robot.autoChooser.addDefault("Drive Forwards With Cube", new DriveTimedWithCube(Constants.DRIVETRAIN_SPEED, 5, Constants.INTAKE_COAST));
            Robot.autoChooser.addObject("DriveForwardsTimed", new DriveDistanceTimed(Constants.DRIVETRAIN_SPEED, 3));
        } else if (side.equals("Right")) {
            Robot.autoChooser.addObject("Do Nothing", new DoNothing());
            Robot.autoChooser.addDefault("Drive Forwards With Cube", new DriveTimedWithCube(Constants.DRIVETRAIN_SPEED, 5, Constants.INTAKE_COAST));
            Robot.autoChooser.addObject("DriveForwardsTimed", new DriveDistanceTimed(Constants.DRIVETRAIN_SPEED, 3));
        }
    }

}