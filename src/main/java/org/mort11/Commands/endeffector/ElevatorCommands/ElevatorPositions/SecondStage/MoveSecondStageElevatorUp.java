package org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.SecondStage;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Control.Operator;
import org.mort11.Hardware.IO;
import org.mort11.Robot;
import org.mort11.Util.Constants;

public class MoveSecondStageElevatorUp extends Command {
    private double speed;
    public MoveSecondStageElevatorUp(){
        super("MoveSecondStageElevatorUp");
        requires(Robot.secondStageElevator);
        setInterruptible(true);
    }

    @Override
    protected void execute() {
        speed = Operator.getRightOperatorJoystick().getY();

        if(speed < -Constants.MOTOR_DEADZONE)
            Robot.secondStageElevator.set(-speed);
    }

    @Override
    protected boolean isFinished() {
        return !IO.getSecondStageElevatorLimitSwitchTop().get() || speed > -Constants.MOTOR_DEADZONE ;
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
