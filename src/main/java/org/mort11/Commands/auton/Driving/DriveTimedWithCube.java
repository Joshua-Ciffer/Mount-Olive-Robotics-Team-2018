package org.mort11.Commands.auton.Driving;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.Commands.endeffector.IntakeCommands.RollIntakeIn;
import org.mort11.Util.Constants;

public class DriveTimedWithCube extends CommandGroup {

    public DriveTimedWithCube(double speed, double timeout){
      addParallel(new DriveDistanceTimed(speed, timeout));
      addParallel(new RollIntakeIn());
    }
}
