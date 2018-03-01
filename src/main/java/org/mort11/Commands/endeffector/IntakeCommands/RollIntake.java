package org.mort11.Commands.endeffector.IntakeCommands;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Hardware.HardwareStates;
import org.mort11.Hardware.IO;
import org.mort11.Robot;
import org.mort11.Util.Constants;

/**
 * @author Joshua Ciffer
 * @version 02/14/2018
 */
public class RollIntake extends Command {

    private HardwareStates.RollerState rollerState;

    public RollIntake(HardwareStates.RollerState rollerState) {
        super("IntakeRollers");
        requires(Robot.intake);
        setInterruptible(true);
        this.rollerState = rollerState;
    }

    @Override
    protected void execute() {
        Robot.intake.setRollerSpeed(Constants.INTAKE_SPEED, rollerState);

    }


    @Override
    protected void interrupted() {
        Robot.intake.setRollerSpeed(0, rollerState);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

}