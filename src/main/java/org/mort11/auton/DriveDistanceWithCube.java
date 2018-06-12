package org.mort11.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.mort11.intake.CoastIntake;

public class DriveDistanceWithCube extends CommandGroup {
    public DriveDistanceWithCube(double distance) {
        addParallel(new DriveDistance(distance));
        addParallel(new CoastIntake());
    }
}
