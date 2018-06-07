package org.mort11.intake;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.util.HardwareStates;

/**
 * @author Joshua Ciffer
 * @version 03/08/2018
 */
public class ShiftIntake extends Command {

    private HardwareStates.IntakeShiftState pistonState;

    public ShiftIntake(HardwareStates.IntakeShiftState pistonState) {
        super("ShiftIntake");
        requires(Robot.intakeShifter);
        setInterruptible(true);
        this.pistonState = pistonState;
    }

    @Override
    protected void execute() {
        Robot.intakeShifter.shiftPiston(pistonState);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}