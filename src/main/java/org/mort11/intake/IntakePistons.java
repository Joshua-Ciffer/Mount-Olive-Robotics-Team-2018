package org.mort11.intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.mort11.hardware.IO;
import org.mort11.util.HardwareStates;

public class IntakePistons extends Subsystem {
    public IntakePistons() {
        super("IntakePistons");
    }

    @Override
    protected void initDefaultCommand() {
        //setDefaultCommand(new ActuatePiston(HardwareStates.IntakePistonState.OUT));
    }

    public void actuatePiston(HardwareStates.IntakePistonState pistonState) {
        switch (pistonState) {
            case IN: {
                IO.getIntakePiston().set(DoubleSolenoid.Value.kReverse);
                break;
            }
            case OUT: {
                IO.getIntakePiston().set(DoubleSolenoid.Value.kForward);
                break;
            }
        }
    }
}
