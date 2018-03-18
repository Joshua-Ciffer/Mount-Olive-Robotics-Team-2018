package org.mort11.commands.endeffector.elevatorcommands.elevatorpositions.secondstage;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.control.Operator;
import org.mort11.hardware.IO;
import org.mort11.util.Constants;

public class MoveSecondStageElevatorUp extends Command {
    private double speed;

    public MoveSecondStageElevatorUp() {
        super("MoveSecondStageElevatorUp");
        requires(Robot.secondStageElevator);
        setInterruptible(true);
    }

    @Override
    protected void execute() {
        speed = Operator.getRightOperatorJoystick().getY();

        if (speed < -Constants.MOTOR_DEADZONE)
            Robot.secondStageElevator.set(-speed);
    }

    @Override
    protected boolean isFinished() {
        return !IO.getSecondStageElevatorLimitSwitchTop().get() || speed > -Constants.MOTOR_DEADZONE;
    }

    @Override
    protected void end() {
        Robot.secondStageElevator.set(0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
