package org.mort11.commands.endeffector.elevatorcommands.elevatorpositions.auton;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.mort11.Robot;
import org.mort11.hardware.IO;
import org.mort11.util.HardwareStates;

public class MoveFourBarArmSetValue extends TimedCommand {
    private double speed;
    private HardwareStates.ElevatorDirection elevatorDirection;

    public MoveFourBarArmSetValue(double speed, HardwareStates.ElevatorDirection elevatorDirection, double timeout) {
        super(timeout);
        requires(Robot.fourBarArm);
        setInterruptible(true);
        this.speed = speed;
        this.elevatorDirection = elevatorDirection;
    }

    @Override
    protected void execute() {
        switch (elevatorDirection) {
            case UP:

                if (IO.getActuatorLimitSwitchTop().get()) {

                    Robot.fourBarArm.set(speed);

                }

                break;
            case DOWN:

                if (IO.getActuatorLimitSwitchBottom().get()) {

                    Robot.fourBarArm.set(-speed);

                }

                break;
        }

    }

    @Override
    protected boolean isFinished() {

        super.isFinished();

        switch (elevatorDirection) {
            case UP:
                if (IO.getActuatorLimitSwitchTop().get()) {

                    return true;

                }

                break;
            case DOWN:

                if (IO.getActuatorLimitSwitchBottom().get()) {

                    return true;

                }

                break;
        }

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