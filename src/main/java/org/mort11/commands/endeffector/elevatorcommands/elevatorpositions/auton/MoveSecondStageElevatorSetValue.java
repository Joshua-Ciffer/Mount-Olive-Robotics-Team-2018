package org.mort11.commands.endeffector.elevatorcommands.elevatorpositions.auton;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.mort11.Robot;
import org.mort11.hardware.IO;
import org.mort11.util.HardwareStates;

public class MoveSecondStageElevatorSetValue extends TimedCommand {
    private double speed;
    private HardwareStates.ElevatorDirection elevatorDirection;

    public MoveSecondStageElevatorSetValue(double speed, HardwareStates.ElevatorDirection elevatorDirection, double timeout) {
        super(timeout);
        requires(Robot.secondStageElevator);
        setInterruptible(true);
        this.speed = speed;
        this.elevatorDirection = elevatorDirection;
    }

    @Override
    protected void execute() {
        switch (elevatorDirection) {

            case UP:

                if (IO.getSecondStageElevatorLimitSwitchTop().get()) {

                    Robot.secondStageElevator.set(speed);

                }

                break;
            case DOWN:

                if (IO.getSecondStageElevatorLimitSwitchBottom().get()) {

                    Robot.secondStageElevator.set(-speed);

                }

                break;

        }

    }

    @Override
    protected boolean isFinished() {

        super.isFinished();

        switch (elevatorDirection) {
            case UP:
                if (IO.getSecondStageElevatorLimitSwitchTop().get()) {

                    return true;

                }

                break;
            case DOWN:

                if (IO.getSecondStageElevatorLimitSwitchBottom().get()) {

                    return true;

                }

                break;
        }

        return false;

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
