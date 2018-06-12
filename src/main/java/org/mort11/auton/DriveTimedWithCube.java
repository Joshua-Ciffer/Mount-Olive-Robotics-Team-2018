package org.mort11.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.intake.RollIntake;
import org.mort11.util.HardwareStates;

public class DriveTimedWithCube extends CommandGroup {

    public DriveTimedWithCube(double speed, double timeout) {
        addParallel(new DriveDistanceTimed(speed, timeout));
        addParallel(new RollIntake(HardwareStates.IntakeRollersState.IN));
    }
}
