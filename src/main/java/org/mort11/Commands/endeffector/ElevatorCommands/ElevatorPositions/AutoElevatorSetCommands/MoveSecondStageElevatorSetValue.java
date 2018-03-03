package org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.AutoElevatorSetCommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;
import org.mort11.Control.Operator;
import org.mort11.Hardware.IO;
import org.mort11.Robot;
import org.mort11.Util.Constants;

public class MoveSecondStageElevatorSetValue extends TimedCommand {
    private double speed;
    public MoveSecondStageElevatorSetValue(double speed, double timeout){
        super(timeout);
        requires(Robot.secondStageElevator);
        setInterruptible(false);
        this.speed = speed;
    }

    @Override
    protected void execute() {
        Robot.secondStageElevator.set(speed);
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
