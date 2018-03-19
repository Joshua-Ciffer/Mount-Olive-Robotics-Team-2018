package org.mort11.commands.endeffector.intakecommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.util.Constants;
import org.mort11.util.HardwareStates;

public class InAndCoast extends CommandGroup {
    public InAndCoast(double speed) {
        setInterruptible(true);
        addSequential(new RollIntake(Constants.INTAKE_SPEED, HardwareStates.RollerState.IN));
        addSequential(new RollIntake(Constants.INTAKE_COAST, HardwareStates.RollerState.COAST));
    }
}
