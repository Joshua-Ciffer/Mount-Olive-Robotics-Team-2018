package org.mort11.commands.endeffector.intakecommands;
//

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.hardware.IO;
import org.mort11.util.Constants;

//import org.mort11.Hardware.HardwareStates;
//import org.mort11.Hardware.IO;
//import org.mort11.Robot;
//import org.mort11.Util.Constants;
//
public class CoastIntake extends Command {

    public CoastIntake() {
        super("CoastIntake");
        requires(Robot.intakeRollers);
        setInterruptible(true);
    }

    protected void execute() {
        if (IO.getIntakeLimitSwitchLeft().get() == false && IO.getIntakeLimitSwitchRight().get() == false) {
            Robot.intakeRollers.setRollerSpeed(-Constants.INTAKE_COAST);
        } else {
            //Robot.intakeRollers.setRollerSpeed(0);
        }
    }

    protected void end() {
        Robot.intakeRollers.setRollerSpeed(0);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    protected void interrupted() {
        end();
    }

}