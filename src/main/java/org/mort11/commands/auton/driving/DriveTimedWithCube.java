package org.mort11.commands.auton.driving;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.commands.endeffector.intakecommands.RollIntake;
import org.mort11.util.HardwareStates;

public class DriveTimedWithCube extends CommandGroup {

    public DriveTimedWithCube(double speed, double timeout, double intakeSpeed) {
        addParallel(new DriveDistanceTimed(speed, timeout));
        addParallel(new RollIntake(intakeSpeed, HardwareStates.RollerState.IN));
    }
}
