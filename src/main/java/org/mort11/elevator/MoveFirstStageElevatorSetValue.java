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

                    Robot.firstStageElevator.set(speed, Constants.FIRST_STAGE_ELEVATOR_ROTATIONS_TELEOP);

                }

                break;
            case DOWN:

                if (IO.getFirstStageElevatorLimitSwitchBottom().get()) {

                    Robot.firstStageElevator.set(-speed, Constants.FIRST_STAGE_ELEVATOR_ROTATIONS_TELEOP);

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
        Robot.firstStageElevator.set(0, Constants.FIRST_STAGE_ELEVATOR_ROTATIONS_TELEOP);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
