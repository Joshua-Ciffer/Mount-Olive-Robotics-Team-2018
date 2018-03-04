package org.mort11.Commands.auton.Driving;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.Commands.endeffector.IntakeCommands.RollIntake;
import org.mort11.Hardware.HardwareStates;

public class DriveTimedWithCube extends CommandGroup {

    public DriveTimedWithCube(double speed, double timeout, double intakeSpeed) {
        addParallel(new DriveDistanceTimed(speed, timeout));
        addParallel(new RollIntake(intakeSpeed, HardwareStates.RollerState.IN));
    }
}
