package org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.FourBarArm;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Control.Operator;
import org.mort11.Hardware.IO;
import org.mort11.Robot;
import org.mort11.Util.Constants;

public class MoveFourBarArmDown extends Command {
    private double speed;
    public MoveFourBarArmDown() {
        super("MoveFourBarArmDown");
        requires(Robot.fourBarArm);
        setInterruptible(true);
    }
    @Override
    protected void execute() {
        speed = Operator.getRightOperatorJoystick().getZ();
        if(speed > Constants.MOTOR_DEADZONE) {
            System.out.println("MoveFourBarArmDown has executed");
            Robot.fourBarArm.set(-speed);
        }
    }
    @Override
    protected boolean isFinished() {
        return !IO.getActuatorLimitSwitchBottom().get() || speed < Constants.MOTOR_DEADZONE;
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
