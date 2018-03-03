package org.mort11.Subsystems.endeffector.Intake;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.mort11.Hardware.IO;
import org.mort11.Util.Constants;

public class IntakeRollers extends Subsystem {
    public IntakeRollers(){
        super("IntakeRollers");
    }
    @Override
    protected void initDefaultCommand() {

    }
    public void setRollerSpeed(double speed) {
        IO.getIntakeRollerVictorLeft().set(Constants.CONTROL_MODE, speed);
        IO.getIntakeRollerVictorRight().set(Constants.CONTROL_MODE, speed);
    }
}
