package org.mort11.Commands.auton.Driving;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.Commands.endeffector.IntakeCommands.RollIntake;
import org.mort11.Hardware.HardwareStates;
import org.mort11.Util.Constants;

public class DriveDistanceWithCube extends CommandGroup {
    public DriveDistanceWithCube (double distance){
        addParallel(new DriveDistance(distance));
        addParallel(new RollIntake(Constants.INTAKE_COAST, HardwareStates.RollerState.IN));
    }
}
