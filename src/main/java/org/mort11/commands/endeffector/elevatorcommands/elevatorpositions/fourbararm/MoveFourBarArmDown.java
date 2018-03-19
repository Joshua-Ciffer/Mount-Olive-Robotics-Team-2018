package org.mort11.commands.endeffector.elevatorcommands.elevatorpositions.fourbararm;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.hardware.IO;
import org.mort11.util.Constants;

public class MoveFourBarArmDown extends Command {
    private double speed;

    public MoveFourBarArmDown(double speed) {
        super("MoveFourBarArmDown");
        requires(Robot.fourBarArm);
        setInterruptible(true);
        this.speed = speed;
    }

    @Override
    protected void execute() {
        if (speed > Constants.MOTOR_DEADZONE) {
            Robot.fourBarArm.set(speed);
        } else {
            end();
        }
    }

    @Override
    protected boolean isFinished() {
        return !IO.getActuatorLimitSwitchBottom().get() || speed < Constants.MOTOR_DEADZONE;
    }

    @Override
    protected void end() {
        Robot.fourBarArm.set(0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}