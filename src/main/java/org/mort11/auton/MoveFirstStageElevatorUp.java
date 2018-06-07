package org.mort11.auton;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.control.Operator;
import org.mort11.hardware.IO;
import org.mort11.util.Constants;

public class MoveFirstStageElevatorUp extends Command {
    private double speed;

    public MoveFirstStageElevatorUp() {
        super("JoystickDriveFirstStageElevatorUp");
        requires(Robot.firstStageElevator);
        setInterruptible(true);
    }

    @Override
    protected void execute() {
        speed = Operator.getLeftOperatorJoystick().getY();

        if (speed < -Constants.MOTOR_DEADZONE) {
            Robot.firstStageElevator.setVelocity(-speed);
        }
    }

    @Override
    protected boolean isFinished() {
        return !IO.getFirstStageElevatorLimitSwitchTop().get() || speed > -Constants.MOTOR_DEADZONE;
    }

    @Override
    protected void end() {
        //IO.getFirstStageElevatorTalonMaster().setSelectedSensorPosition(Constants.ZERO_ENCODER_POSITION,Constants.PID_LOOP_ID, 0);
        Robot.firstStageElevator.setVelocity(0);
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected void initialize() {
        //IO.getFirstStageElevatorTalonMaster().setSelectedSensorPosition(Constants.ZERO_ENCODER_POSITION,Constants.PID_LOOP_ID, 0);
    }
}
