package org.mort11.Commands.endeffector.ElevatorCommands.JoystickCommands;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Control.Operator;
import org.mort11.Robot;

public class JoystickDriveFourBarArm extends Command {

    public JoystickDriveFourBarArm() {

        super("JoystickDriveFourBarArm");
        requires(Robot.fourBarArm);
        setInterruptible(true);

    }

    @Override
    protected void execute() {

        Robot.fourBarArm.setPot(Operator.getRightOperatorJoystick().getZ());

    }

    protected void end(){
            Robot.fourBarArm.setPot(0);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
