package org.mort11.util;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.auton.DoNothing;
import org.mort11.auton.DriveDistanceTimed;
import org.mort11.auton.DriveTimedWithCube;

/**
 * Created by q24xboss's PC on 1/22/2018.
 */

public class AutoChooser {

	static Command autoCommand;

	// TODO: This class needs to be dealt with.
	public static Command setAutoCommand(Command selected, String gameData) {
		autoCommand = selected;
		// if(selected.equals(new SwitchTurnLeft()) && gameData.charAt(0) == 'R') {
		// autoCommand = new SwitchTurnLeft();
		// }
		// else if(selected.equals(new SwitchTurnRight()) && gameData.charAt(0) == 'L') {
		// autoCommand = new SwitchTurnRight();
		// }
		// else if(selected.equals(new ScaleTurnLeft()) && gameData.charAt(0) == 'R') {
		// autoCommand = new ScaleTurnLeft();
		// }
		// else if(selected.equals(new ScaleTurnRight()) && gameData.charAt(0) == 'L') {
		// autoCommand = new ScaleTurnRight();
		// }
		// else if(selected.equals(new DriveStraight())) {
		// autoCommand = new DriveStraight();
		// }
		// else {
		// autoCommand = new DriveStraight();
		// }
		//
		return autoCommand; // Return the autonomous command to run
		//
	}

	/*
	 * Adds autons to side according to auton chooser
	 */
	public static void addAutons(String side) {
		switch (side.toLowerCase()) {
			case "middle": {
				Robot.getAutonChooser().addObject("Do Nothing", new DoNothing());
				Robot.getAutonChooser().addDefault("Drive Forwards With Cube", new DriveTimedWithCube(Constants.DRIVETRAIN_SPEED, 4));
				Robot.getAutonChooser().addObject("DriveForwardsTimed", new DriveDistanceTimed(Constants.DRIVETRAIN_SPEED, 2));
				break;
			}
			case "left": {
				Robot.getAutonChooser().addObject("Do Nothing", new DoNothing());
				Robot.getAutonChooser().addDefault("Drive Forwards With Cube", new DriveTimedWithCube(Constants.DRIVETRAIN_SPEED, 5));
				Robot.getAutonChooser().addObject("DriveForwardsTimed", new DriveDistanceTimed(Constants.DRIVETRAIN_SPEED, 3));
				break;
			}
			case "right": {
				Robot.getAutonChooser().addObject("Do Nothing", new DoNothing());
				Robot.getAutonChooser().addDefault("Drive Forwards With Cube", new DriveTimedWithCube(Constants.DRIVETRAIN_SPEED, 5));
				Robot.getAutonChooser().addObject("DriveForwardsTimed", new DriveDistanceTimed(Constants.DRIVETRAIN_SPEED, 3));
				break;
			}
		}
	}

}