package org.mort11.Commands.endeffector.IntakeCommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.Hardware.HardwareStates;
import org.mort11.Util.Constants;

public class OutakeAndOpen extends CommandGroup {

    public OutakeAndOpen (){
        addParallel(new ActuatePiston(HardwareStates.IntakePistonState.IN));
        addParallel(new RollIntake(Constants.INTAKE_SPEED,HardwareStates.RollerState.OUT), Constants.ROLLER_TIMEOUT);
    }
}
