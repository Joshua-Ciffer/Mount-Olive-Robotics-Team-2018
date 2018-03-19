package org.mort11.commands.endeffector.elevatorcommands.elevatorcommandgroups.joystickdrives;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.commands.endeffector.elevatorcommands.elevatorpositions.firststage.MoveFirstStageElevatorDown;
import org.mort11.commands.endeffector.elevatorcommands.elevatorpositions.firststage.MoveFirstStageElevatorUp;

//JoystickDrive for firstage
public class MoveFirstStageElevator extends CommandGroup {
    public MoveFirstStageElevator() {
        addSequential(new MoveFirstStageElevatorUp());
        addSequential(new MoveFirstStageElevatorDown());
    }
}
