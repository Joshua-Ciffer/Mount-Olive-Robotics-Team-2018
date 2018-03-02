package org.mort11.Commands.endeffector.IntakeCommands;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Hardware.HardwareStates;
import org.mort11.Hardware.IO;
import org.mort11.Robot;
import org.mort11.Util.Constants;

public class CoastIntake extends Command {

    public CoastIntake(){
        super("CoastIntake");
        requires(Robot.intake);
        setInterruptible(true);
    }

    protected void execute(){
        if(IO.getIntakeLimitSwitchLeft().get() == false && IO.getIntakeLimitSwitchRight().get() == false){
            Robot.intake.setRollerSpeed(Constants.INTAKE_COAST, HardwareStates.RollerState.IN);
        }
    }

    protected void end (){
        Robot.intake.setRollerSpeed(Constants.INTAKE_STOP, HardwareStates.RollerState.STOP);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    protected void interrupted(){
        end();
    }
}
