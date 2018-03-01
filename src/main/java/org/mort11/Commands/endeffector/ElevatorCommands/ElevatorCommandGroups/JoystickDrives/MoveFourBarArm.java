package org.mort11.Commands.endeffector.ElevatorCommands.ElevatorCommandGroups.JoystickDrives;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.MoveFourBarArmDown;
import org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.MoveFourBarArmUp;
import org.mort11.Robot;

public class MoveFourBarArm extends CommandGroup {
    public MoveFourBarArm(){

    }

    public MoveFourBarArm(double speed) {
        requires(Robot.fourBarArm);
        addSequential(new MoveFourBarArmUp(speed));
        addSequential(new MoveFourBarArmDown(speed));
    }
}
