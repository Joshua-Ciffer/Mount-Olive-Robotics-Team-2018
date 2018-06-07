package org.mort11.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.mort11.util.Constants;
import org.mort11.util.HardwareStates;

public class SwitchTurnRight extends CommandGroup {
    public SwitchTurnRight() {
        addSequential(new DriveDistanceWithCube(166));
        addSequential(new TurnDegrees(90));
        addParallel(new DriveDistanceWithCube(24));
        addSequential(new RollIntakeTimed(Constants.INTAKE_SPEED, HardwareStates.RollerState.OUT, 2));
    }
}
