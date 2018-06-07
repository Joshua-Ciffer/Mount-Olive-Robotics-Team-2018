package org.mort11.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

//JoystickDrive for firstage
public class MoveFirstStageElevator extends CommandGroup {
    public MoveFirstStageElevator() {
        addSequential(new MoveFirstStageElevatorUp());
        addSequential(new MoveFirstStageElevatorDown());
    }
}
