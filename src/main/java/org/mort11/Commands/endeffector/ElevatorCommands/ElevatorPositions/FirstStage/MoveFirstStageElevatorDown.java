package org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.FirstStage;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Control.Operator;
import org.mort11.Hardware.IO;
import org.mort11.Robot;
import org.mort11.Util.Constants;

public class MoveFirstStageElevatorDown extends Command {
    private double speed;

    public MoveFirstStageElevatorDown() {
        super("JoystickDriveFirstStageElevatorDown");
        requires(Robot.firstStageElevator);
        setInterruptible(true);
    }

    @Override
    protected void execute() {
        speed = Operator.getLeftOperatorJoystick().getY();

        if (speed > Constants.MOTOR_DEADZONE) {
            Robot.firstStageElevator.set(-speed);
        }
    }

    @Override
    protected boolean isFinished() {
        return !IO.getFirstStageElevatorLimitSwitchBottom().get() || speed < Constants.MOTOR_DEADZONE;
    }

    @Override
    protected void end() {
        Robot.firstStageElevator.set(0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
