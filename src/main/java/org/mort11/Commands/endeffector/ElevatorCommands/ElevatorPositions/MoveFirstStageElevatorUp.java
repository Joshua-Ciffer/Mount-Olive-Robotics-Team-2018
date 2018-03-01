package org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Hardware.IO;
import org.mort11.Robot;
import org.mort11.Util.Constants;

public class MoveFirstStageElevatorUp extends Command{
    private double speed;
    public MoveFirstStageElevatorUp(double speed){
        super("JoystickDriveFirstStageElevatorUp");
        requires(Robot.firstStageElevator);
        setInterruptible(true);
        this.speed = speed;
    }

    @Override
    protected void execute() {
        if(speed < -Constants.MOTOR_DEADZONE)
            Robot.firstStageElevator.set(speed);
    }

    @Override
    protected boolean isFinished() {
        return !IO.getFirstStageElevatorLimitSwitchTop().get() || speed > Constants.MOTOR_DEADZONE;
    }

    @Override
    protected void end() {
        Robot.firstStageElevator.set(0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
