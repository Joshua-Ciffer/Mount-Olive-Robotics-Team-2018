package org.mort11.Commands.endeffector.IntakeCommands;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Hardware.HardwareStates;
import org.mort11.Robot;

public class RollIntake extends Command {
    private double speed;
    private HardwareStates.RollerState rollerState;

    public RollIntake(double speed, HardwareStates.RollerState request) {
        super("Roll Intake");
        requires(Robot.intakeRollers);
        setInterruptible(true);
        this.speed = speed;
        this.rollerState = request;
    }

    @Override
    protected void execute() {
        switch (rollerState) {
            case IN:
                Robot.intakeRollers.setRollerSpeed(-speed);
                break;

            case OUT:
                Robot.intakeRollers.setRollerSpeed(speed);
                break;

            case STOP:
                Robot.intakeRollers.setRollerSpeed(0);
                break;

        }
    }

    @Override
    protected void end() {
        Robot.intakeRollers.setRollerSpeed(0);

    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
