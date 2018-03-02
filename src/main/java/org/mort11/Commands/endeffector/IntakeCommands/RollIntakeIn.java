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
public class RollIntakeIn extends Command {

    public RollIntakeIn() {
        super("RollIntakeIn");
        requires(Robot.intake);
        setInterruptible(true);
    }

    @Override
    protected void execute() {
        Robot.intake.setRollerSpeed(-Constants.INTAKE_SPEED);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

        Robot.intake.setRollerSpeed(0);

    }

    @Override
    protected void interrupted() {
        Robot.intake.setRollerSpeed(0);
    }

}