package org.mort11.commands.auton.driving;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.commands.endeffector.intakeCommands.RollIntake;
import org.mort11.util.Constants;
import org.mort11.util.HardwareStates;

public class DriveDistanceWithCube extends CommandGroup {
    public DriveDistanceWithCube(double distance) {
        addParallel(new DriveDistance(distance));
        addParallel(new RollIntake(Constants.INTAKE_COAST, HardwareStates.RollerState.IN));
    }
}
