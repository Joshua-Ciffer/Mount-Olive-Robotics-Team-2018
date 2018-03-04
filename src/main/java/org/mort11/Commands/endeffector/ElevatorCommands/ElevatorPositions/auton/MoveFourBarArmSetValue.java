package org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.auton;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.mort11.Hardware.HardwareStates;
import org.mort11.Hardware.IO;
import org.mort11.Robot;

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

                if(IO.getActuatorLimitSwitchBottom().get()) {

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
        System.out.println("MoveFourBarArmDown has executed");
        Robot.fourBarArm.set(0);
    }
    @Override
    protected void interrupted() {
        end();
    }
}
