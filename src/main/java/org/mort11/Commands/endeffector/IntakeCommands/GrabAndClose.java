package org.mort11.Commands.endeffector.IntakeCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.Hardware.HardwareStates;

public class GrabAndClose extends CommandGroup{
    public GrabAndClose(){
        addParallel(new ActuatePiston(HardwareStates.IntakePistonState.IN));
        addParallel(new RollIntakeIn());
    }
}
