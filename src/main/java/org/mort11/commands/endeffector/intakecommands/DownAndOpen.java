package org.mort11.commands.endeffector.intakecommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.util.HardwareStates;

/**
 * @author Joshua Ciffer
 * @version 03/08/2018
 */
public class DownAndOpen extends CommandGroup {

    public DownAndOpen() {
        super("DownAndOpen");
        setInterruptible(true);
        addParallel(new ShiftIntake(HardwareStates.IntakeShiftState.DOWN));
        addParallel(new ActuatePiston(HardwareStates.IntakePistonState.IN));
    }

}