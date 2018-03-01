package org.mort11.Commands.endeffector.ElevatorCommands.ElevatorCommandGroups.JoystickDrives;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.MoveFirstStageElevatorDown;
import org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.MoveFirstStageElevatorUp;
import org.mort11.Robot;

public class MoveFirstStageElevator extends CommandGroup {
    public MoveFirstStageElevator(){

    }
    public MoveFirstStageElevator(double speed){
        requires(Robot.firstStageElevator);
        addSequential(new MoveFirstStageElevatorUp(speed));
        addSequential(new MoveFirstStageElevatorDown(speed));
    }
}
