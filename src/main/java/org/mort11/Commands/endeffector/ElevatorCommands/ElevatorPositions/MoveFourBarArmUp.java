package org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Control.Operator;
import org.mort11.Hardware.IO;
import org.mort11.Robot;
import org.mort11.Util.Constants;

public class MoveFourBarArmUp extends Command {
    private double speed;

    public MoveFourBarArmUp() {
        super("MoveFourBarArm");
        requires(Robot.fourBarArm);
    }
    @Override
    protected void execute() {
        speed = Operator.getRightOperatorJoystick().getZ();
        if(speed < -Constants.MOTOR_DEADZONE){
            System.out.println("MoveFourBarArmUp has executed");
            Robot.fourBarArm.set(speed);
        }
    }
    @Override
    protected boolean isFinished() {

        return !IO.getActuatorLimitSwitchTop().get() || speed > Constants.MOTOR_DEADZONE;
    }
    @Override
    protected void end() {
        System.out.println("MoveFourBarArmUp has finished");
        Robot.fourBarArm.set(0);
    }
    @Override
    protected void interrupted() {
        end();
    }
}
