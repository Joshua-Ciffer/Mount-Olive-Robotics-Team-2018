package org.mort11.Commands.endeffector.ElevatorCommands.ElevatorCommandGroups.JoystickDrives;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.SecondStage.MoveSecondStageElevatorDown;
import org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.SecondStage.MoveSecondStageElevatorUp;

public class MoveSecondStageElevator extends CommandGroup {
    public MoveSecondStageElevator() {
        addSequential(new MoveSecondStageElevatorUp());
        addSequential(new MoveSecondStageElevatorDown());
    }
}
