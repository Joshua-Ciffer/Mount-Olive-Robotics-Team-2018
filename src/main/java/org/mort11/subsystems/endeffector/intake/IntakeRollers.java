package org.mort11.subsystems.endeffector.intake;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.mort11.commands.endeffector.intakecommands.CoastIntake;
import org.mort11.hardware.IO;
import org.mort11.util.Constants;

public class IntakeRollers extends Subsystem {
    public IntakeRollers() {
        super("IntakeRollers");
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new CoastIntake());
    }

    public void setRollerSpeed(double speed) {
        IO.getIntakeRollerVictorLeft().set(Constants.CONTROL_MODE, speed);
        IO.getIntakeRollerVictorRight().set(Constants.CONTROL_MODE, speed);
    }
}
