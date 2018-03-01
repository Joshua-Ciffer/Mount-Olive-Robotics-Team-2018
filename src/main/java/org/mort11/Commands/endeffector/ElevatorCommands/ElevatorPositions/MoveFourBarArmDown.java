package org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;

public class MoveFourBarArmDown extends Command {
    private double speed;
    public MoveFourBarArmDown(double speed) {
        super("MoveFourBarArmDown");
        this.speed = speed;
    }
    @Override
    protected void execute() {
        if(speed < 0)
            Robot.fourBarArm.set(speed);
    }
    @Override
    protected boolean isFinished() {
        return false;
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
