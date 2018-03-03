package org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.auton;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.mort11.Robot;

public class MoveFirstStageElevatorSetValue extends TimedCommand{
    private double speed;
    public MoveFirstStageElevatorSetValue(double speed, double timeout){
        super(timeout);
        requires(Robot.firstStageElevator);
        setInterruptible(false);
        this.speed = speed;
    }

    @Override
    protected void execute() {
        Robot.firstStageElevator.set(speed);
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
