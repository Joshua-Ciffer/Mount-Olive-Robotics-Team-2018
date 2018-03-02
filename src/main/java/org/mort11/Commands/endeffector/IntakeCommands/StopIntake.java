package org.mort11.Commands.endeffector.IntakeCommands;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Hardware.IO;
import org.mort11.Robot;
import org.mort11.Util.Constants;

/**
 * @author Joshua Ciffer
 * @version 02/14/2018
 */
public class StopIntake extends Command {

    public StopIntake() {
        super("StopIntake");
        requires(Robot.intake);
        setInterruptible(true);
    }

    @Override
    protected void execute() {
        Robot.intake.setRollerSpeed(0);
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
        end();
    }

}