package org.mort11.intake;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.hardware.IO;
import org.mort11.util.Constants;
import org.mort11.util.HardwareStates;

public class GrabAndClose extends CommandGroup {
    public GrabAndClose() {
        setInterruptible(true);
        addParallel(new ActuatePiston(HardwareStates.IntakePistonState.OUT));
        addParallel(new RollIntake(Constants.INTAKE_SPEED, HardwareStates.RollerState.IN), Constants.ROLLER_TIMEOUT);
    }

    @Override
    protected boolean isFinished() {
        return !IO.getIntakeLimitSwitchLeft().get() && !IO.getIntakeLimitSwitchRight().get();
    }
}
