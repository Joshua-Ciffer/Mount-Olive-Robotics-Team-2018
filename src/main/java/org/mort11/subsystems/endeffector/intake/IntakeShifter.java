package org.mort11.subsystems.endeffector.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.mort11.commands.endeffector.intakecommands.ShiftIntake;
import org.mort11.hardware.IO;
import org.mort11.util.HardwareStates;

/**
 * @author Joshua Ciffer
 * @version 03/08/2018
 */
public class IntakeShifter extends Subsystem {

    public IntakeShifter() {
        super("IntakePistons");
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ShiftIntake(HardwareStates.IntakeShiftState.DOWN));
    }

    public void shiftPiston(HardwareStates.IntakeShiftState pistonState) {
        switch (pistonState) {
            case UP: {
                IO.getVerticalShifterPiston().set(DoubleSolenoid.Value.kReverse);
                break;
            }
            case DOWN: {
                IO.getVerticalShifterPiston().set(DoubleSolenoid.Value.kForward);
                break;
            }
        }
    }

}