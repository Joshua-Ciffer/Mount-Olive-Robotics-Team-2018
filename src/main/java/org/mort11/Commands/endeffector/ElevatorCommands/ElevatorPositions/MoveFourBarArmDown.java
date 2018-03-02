package org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Hardware.IO;
import org.mort11.Robot;
import org.mort11.Util.Constants;

public class MoveFourBarArmDown extends Command {
    private double speed;
    public MoveFourBarArmDown(double speed) {
        super("MoveFourBarArmDown");
        requires(Robot.fourBarArm);
        this.speed = speed;
    }
    @Override
    protected void execute() {
        if(speed > Constants.MOTOR_DEADZONE){
            System.out.println("MoveFourBarArmDown has executed");
            Robot.fourBarArm.set(speed);
        }
    }
    @Override
    protected boolean isFinished() {
        return !IO.getActuatorLimitSwitchBottom().get() || speed < -Constants.MOTOR_DEADZONE;
    }
    @Override
    protected void end() {
        System.out.println("MoveFourBarArmDown has executed");
        Robot.fourBarArm.set(0);
    }
    @Override
    protected void interrupted() {
        end();
    }
}
