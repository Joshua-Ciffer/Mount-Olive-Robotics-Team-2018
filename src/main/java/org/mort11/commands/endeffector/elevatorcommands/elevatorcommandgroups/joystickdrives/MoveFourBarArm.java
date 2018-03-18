package org.mort11.commands.endeffector.elevatorcommands.elevatorcommandgroups.joystickdrives;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.commands.endeffector.elevatorcommands.elevatorpositions.fourbararm.MoveFourBarArmDown;
import org.mort11.commands.endeffector.elevatorcommands.elevatorpositions.fourbararm.MoveFourBarArmUp;

public class MoveFourBarArm extends CommandGroup {
    public MoveFourBarArm(double speed) {
        addSequential(new MoveFourBarArmUp(speed));
        addSequential(new MoveFourBarArmDown(speed));
    }
}
