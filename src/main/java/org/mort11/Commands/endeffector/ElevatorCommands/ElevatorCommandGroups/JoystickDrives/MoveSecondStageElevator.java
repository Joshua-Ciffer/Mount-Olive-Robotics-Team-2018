package org.mort11.Commands.endeffector.ElevatorCommands.ElevatorCommandGroups.JoystickDrives;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.MoveSecondStageElevatorDown;
import org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.MoveSecondStageElevatorUp;
import org.mort11.Robot;

public class MoveSecondStageElevator extends CommandGroup{
    public MoveSecondStageElevator(){
    }
    public MoveSecondStageElevator(double speed){
        requires(Robot.secondStageElevator);
        addSequential(new MoveSecondStageElevatorUp(speed));
        addSequential(new MoveSecondStageElevatorDown(speed));
    }
}
