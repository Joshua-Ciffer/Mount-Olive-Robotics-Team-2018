package org.mort11.Commands.endeffector.ElevatorCommands.ElevatorCommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.*;
import org.mort11.Hardware.HardwareStates;
import org.mort11.Hardware.IO;
import org.mort11.Robot;
import org.mort11.Util.Constants;

public class Climb extends CommandGroup {

    public Climb() {

        setInterruptible(true);

        addParallel(new MoveFirstStageElevatorUp(Constants.ELEVATOR_SPEED));
        addParallel(new MoveSecondStageElevatorUp(Constants.ELEVATOR_SPEED));
        addParallel(new MoveFourBarArmDegrees(180));

    }

    @Override
    protected void interrupted() {

        end();

    }

    @Override
    protected void end() {

        Robot.firstStageElevator.set(0);
        Robot.secondStageElevator.set(0);
        Robot.fourBarArm.setPot(0);

    }

}
