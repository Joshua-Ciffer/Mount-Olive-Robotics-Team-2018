package org.mort11.commands.endeffector.intakecommands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.util.HardwareStates;

/**
 * @author Joshua Ciffer
 * @version 03/08/2018
 */
public class InUpAndCoast extends CommandGroup {

    public InUpAndCoast() {
        super("InUpAndCoast");
        setInterruptible(true);
        addSequential(new GrabAndClose());
        addSequential(new ShiftIntake(HardwareStates.IntakeShiftState.UP));
        addSequential(new CoastIntake());
    }

}