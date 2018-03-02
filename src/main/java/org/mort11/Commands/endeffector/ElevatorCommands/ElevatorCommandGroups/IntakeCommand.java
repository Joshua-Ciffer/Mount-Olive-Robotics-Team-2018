package org.mort11.Commands.endeffector.ElevatorCommands.ElevatorCommandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.*;
import org.mort11.Robot;
import org.mort11.Util.Constants;

public class IntakeCommand extends CommandGroup {

    public IntakeCommand() {

        setInterruptible(true);

        //addParallel(new MoveFirstStageElevatorDown(-Constants.ELEVATOR_SPEED));
        //addParallel(new MoveSecondStageElevatorDown(-Constants.ELEVATOR_SPEED));
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
