package org.mort11.Commands.endeffector.ElevatorCommands.ElevatorCommandGroups.JoystickDrives;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.MoveSecondStageElevatorDown;
import org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.MoveSecondStageElevatorUp;

public class MoveSecondStageElevator extends CommandGroup{
    public MoveSecondStageElevator(double speed){
        addSequential(new MoveSecondStageElevatorUp(speed));
        addSequential(new MoveSecondStageElevatorDown(speed));
    }
}
