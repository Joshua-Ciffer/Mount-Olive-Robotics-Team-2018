package org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Hardware.IO;
import org.mort11.Robot;
import org.mort11.Util.Constants;

public class MoveSecondStageElevatorUp extends Command {
    private double speed;
    public MoveSecondStageElevatorUp(double speed){
        super("MoveSecondStageElevatorUp");
        requires(Robot.secondStageElevator);
        setInterruptible(true);
        this.speed = speed;
    }

    @Override
    protected void execute() {
        if(speed < -Constants.MOTOR_DEADZONE)
            Robot.secondStageElevator.set(speed);
    }

    @Override
    protected boolean isFinished() {
        return !IO.getSecondStageElevatorLimitSwitchTop().get() || speed > Constants.MOTOR_DEADZONE ;
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
