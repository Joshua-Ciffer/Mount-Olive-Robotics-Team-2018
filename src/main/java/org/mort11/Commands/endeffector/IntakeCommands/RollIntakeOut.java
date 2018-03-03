package org.mort11.Commands.endeffector.IntakeCommands;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Control.Operator;
import org.mort11.Robot;
import org.mort11.Util.Constants;

/**
 * @author Joshua Ciffer
 * @version 02/14/2018
 */
public class RollIntakeOut extends Command {

    public RollIntakeOut() {
        super("RollIntakeOut");
        requires(Robot.intakeRollers);
        setInterruptible(true);
    }

    @Override
    protected void execute() {
        Robot.intakeRollers.setRollerSpeed(Constants.INTAKE_SPEED);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

        Robot.intakeRollers.setRollerSpeed(0);

    }

    @Override
    protected void interrupted() {
        end();
    }

}