package org.mort11.Commands.endeffector.ElevatorCommands.ElevatorCommandGroups.Positions;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.FourBarArm.MoveFourBarArmDegrees;
import org.mort11.Robot;

public class PlaceOnSwitch extends CommandGroup {

    public PlaceOnSwitch() {

        setInterruptible(true);

        //addParallel(new MoveFirstStageElevatorDown(-Constants.ELEVATOR_SPEED));
        //addParallel(new MoveSecondStageElevatorUp(Constants.ELEVATOR_SPEED));
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
