package org.mort11.elevator;

import edu.wpi.first.wpilibj.command.Command;

import org.mort11.Robot;
import org.mort11.control.Operator;
import org.mort11.hardware.IO;
import org.mort11.util.Constants;

/**
 * 
 * 
 *
 * @author Joshua Ciffer
 * @version 06/08/2018
 */
public final class MoveElevatorDown extends Command {
    private double speed;

    public MoveElevatorDown() {
        super("JoystickDriveFirstStageElevatorDown");
        requires(Robot.firstStageElevator);
        setInterruptible(true);
        this.speed = speed;
    }

    @Override
    protected void execute() {
        speed = Operator.getLeftOperatorJoystick().getY();
        if (speed > Constants.MOTOR_DEADZONE) {
            Robot.firstStageElevator.setVelocity(-speed);
        }
    }

    @Override
    protected boolean isFinished() {
        return !IO.getFirstStageElevatorLimitSwitchBottom().get() || speed < Constants.MOTOR_DEADZONE;
    }

    @Override
    protected void end() {
        Robot.firstStageElevator.setVelocity(0);
    }

    @Override
    protected void initialize() {
        //IO.getFirstStageElevatorTalonMaster().setSelectedSensorPosition(Constants.ZERO_ENCODER_POSITION,Constants.PID_LOOP_ID, 0);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
