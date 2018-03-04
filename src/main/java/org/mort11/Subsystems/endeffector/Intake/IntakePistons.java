package org.mort11.Subsystems.endeffector.Intake;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.mort11.Hardware.HardwareStates;
import org.mort11.Hardware.IO;

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
                System.out.println("Going in");
                break;
            }
            case OUT: {
                IO.getIntakePiston().set(DoubleSolenoid.Value.kForward);
                System.out.println("Going out");
                break;
            }
        }
    }
}
