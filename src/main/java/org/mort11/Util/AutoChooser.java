package org.mort11.Util;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.mort11.Commands.auton.DoNothing;
import org.mort11.Commands.auton.Driving.DriveDistanceTimed;
import org.mort11.Commands.auton.Driving.DriveTimedWithCube;
import org.mort11.Robot;
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
    public static void addAutons(String side){
        if (side.equals("Middle")){
            Robot.autoChooser.addDefault("Do Nothing", new DoNothing());
            Robot.autoChooser.addObject("Drive Forwards With Cube", new DriveTimedWithCube(Constants.DRIVETRAIN_SPEED, 2, Constants.INTAKE_COAST));
            Robot.autoChooser.addObject("DriveForwardsTimed", new DriveDistanceTimed(Constants.DRIVETRAIN_SPEED, 2));
        }

        else if (side.equals("Left")){
            Robot.autoChooser.addDefault("Do Nothing", new DoNothing());
            Robot.autoChooser.addObject("Drive Forwards With Cube", new DriveTimedWithCube(Constants.DRIVETRAIN_SPEED, 2,Constants.INTAKE_COAST));
            Robot.autoChooser.addObject("DriveForwardsTimed", new DriveDistanceTimed(Constants.DRIVETRAIN_SPEED, 3));
        }

        else if (side.equals("Right")){
            Robot.autoChooser.addDefault("Do Nothing", new DoNothing());
            Robot.autoChooser.addObject("Drive Forwards With Cube", new DriveTimedWithCube(Constants.DRIVETRAIN_SPEED, 3, Constants.INTAKE_COAST));
            Robot.autoChooser.addObject("DriveForwardsTimed", new DriveDistanceTimed(Constants.DRIVETRAIN_SPEED, 3));
        }
    }

}