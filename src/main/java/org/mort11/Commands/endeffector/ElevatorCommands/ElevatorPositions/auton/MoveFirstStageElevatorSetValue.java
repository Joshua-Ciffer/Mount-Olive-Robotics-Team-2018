package org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.auton;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.mort11.Hardware.HardwareStates;
import org.mort11.Hardware.IO;
import org.mort11.Robot;

public class MoveFirstStageElevatorSetValue extends TimedCommand{
    private double speed;
    private HardwareStates.ElevatorDirection elevatorDirection;
    public MoveFirstStageElevatorSetValue(double speed, HardwareStates.ElevatorDirection elevatorDirection, double timeout){
        super(timeout);
        requires(Robot.firstStageElevator);
        setInterruptible(true);
        this.speed = speed;
        this.elevatorDirection = elevatorDirection;
    }

    @Override
    protected void execute() {
        switch (elevatorDirection) {
            case UP:
                if (IO.getFirstStageElevatorLimitSwitchTop().get()) {

                    Robot.firstStageElevator.set(speed);

                }

                break;
            case DOWN:

                if (IO.getFirstStageElevatorLimitSwitchBottom().get()) {

                    Robot.firstStageElevator.set(-speed);

                }

                break;
        }
    }

    @Override
    protected boolean isFinished() {

        super.isFinished();

        switch (elevatorDirection) {
            case UP:
                if (IO.getFirstStageElevatorLimitSwitchTop().get()) {

                    return true;

                }

                break;
            case DOWN:

                if (IO.getFirstStageElevatorLimitSwitchBottom().get()) {

                    return true;

                }

                break;
        }

        return false;

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
