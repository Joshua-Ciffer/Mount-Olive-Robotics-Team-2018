package org.mort11.elevator;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.mort11.Robot;
import org.mort11.hardware.IO;
import org.mort11.util.Constants;
import org.mort11.util.HardwareStates;

public class MoveFirstStageElevatorSetValue extends TimedCommand {

    private double speed;
    private HardwareStates.ElevatorDirection elevatorDirection;

    public MoveFirstStageElevatorSetValue(double speed, HardwareStates.ElevatorDirection elevatorDirection, double timeout) {
        super(timeout);
        requires(Robot.elevator);
        setInterruptible(true);
        this.speed = speed;
        this.elevatorDirection = elevatorDirection;
    }

    @Override
    protected void execute() {
        switch (elevatorDirection) {
            case UP:
                if (IO.getFirstStageElevatorLimitSwitchTop().get()) {

                    Robot.elevator.set(speed, Constants.ELEVATOR_ROTATIONS_TELEOP);

                }

                break;
            case DOWN:

                if (IO.getFirstStageElevatorLimitSwitchBottom().get()) {

                    Robot.elevator.set(-speed, Constants.ELEVATOR_ROTATIONS_TELEOP);

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
        Robot.elevator.set(0, Constants.ELEVATOR_ROTATIONS_TELEOP);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
