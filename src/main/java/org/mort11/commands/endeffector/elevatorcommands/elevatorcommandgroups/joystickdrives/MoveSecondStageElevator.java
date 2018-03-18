package org.mort11.commands.endeffector.elevatorcommands.elevatorcommandgroups.joystickdrives;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.commands.endeffector.elevatorcommands.elevatorpositions.secondstage.MoveSecondStageElevatorDown;
import org.mort11.commands.endeffector.elevatorcommands.elevatorpositions.secondstage.MoveSecondStageElevatorUp;

public class MoveSecondStageElevator extends CommandGroup {
    public MoveSecondStageElevator() {
        addSequential(new MoveSecondStageElevatorUp());
        addSequential(new MoveSecondStageElevatorDown());
    }
}
