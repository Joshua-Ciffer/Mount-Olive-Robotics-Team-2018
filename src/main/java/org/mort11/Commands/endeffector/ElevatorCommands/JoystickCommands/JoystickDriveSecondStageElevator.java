package org.mort11.Commands.endeffector.ElevatorCommands.JoystickCommands;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Control.Operator;
import org.mort11.Hardware.IO;
import org.mort11.Robot;

public class JoystickDriveSecondStageElevator extends Command {

    public JoystickDriveSecondStageElevator() {

        super("JoystickDriveSecondStageElevator");
        requires(Robot.secondStageElevator);
        setInterruptible(true);

    }

    @Override
    protected void execute() {

        Robot.secondStageElevator.set(Operator.getRightOperatorJoystick().getY());

    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
