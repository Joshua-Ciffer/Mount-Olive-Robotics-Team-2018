package org.mort11.Commands.endeffector.IntakeCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.Hardware.HardwareStates;
import org.mort11.Util.Constants;

public class GrabAndClose extends CommandGroup{
    public GrabAndClose(){
        addParallel(new ActuatePiston(HardwareStates.IntakePistonState.IN));
        addParallel(new RollIntake(Constants.INTAKE_SPEED, HardwareStates.RollerState.IN), Constants.ROLLER_TIMEOUT);
    }
}
