package org.mort11.commands.auton._switch;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.commands.auton.driving.DriveDistanceWithCube;
import org.mort11.commands.auton.turning.TurnDegrees;
import org.mort11.commands.endeffector.intakeCommands.auton.RollIntakeTimed;
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
