package org.mort11.Commands.endeffector.ElevatorCommands.ElevatorCommandGroups.JoystickDrives;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.FirstStage.MoveFirstStageElevatorDown;
import org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.FirstStage.MoveFirstStageElevatorUp;

public class MoveFirstStageElevator extends CommandGroup {
    public MoveFirstStageElevator() {
        addSequential(new MoveFirstStageElevatorUp());
        addSequential(new MoveFirstStageElevatorDown());
    }
}
