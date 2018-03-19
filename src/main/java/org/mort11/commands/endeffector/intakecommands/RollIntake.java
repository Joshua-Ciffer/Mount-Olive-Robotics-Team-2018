package org.mort11.commands.endeffector.intakecommands;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.hardware.IO;
import org.mort11.util.HardwareStates;

public class RollIntake extends Command {

    private double speed;
    private HardwareStates.RollerState rollerState;

    public RollIntake(double speed, HardwareStates.RollerState request) {
        super("Roll intake");
        requires(Robot.intakeRollers);
        setInterruptible(true);
        this.speed = speed;
        this.rollerState = request;
    }

    @SuppressWarnings("incomplete-switch")
    @Override
    protected void execute() {
        switch (rollerState) {
            case IN: {
                Robot.intakeRollers.setRollerSpeed(-speed);
                break;
            }
            case OUT: {
                Robot.intakeRollers.setRollerSpeed(speed);
                break;
            }
            case STOP: {
                Robot.intakeRollers.setRollerSpeed(0);
                break;
            }
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
        switch (rollerState) {
            case COAST: {
                break;
            }
            case OUT: {
                break;
            }
            case STOP: {
                break;
            }
            case IN: {
                if (!IO.getIntakeLimitSwitchLeft().get() || !IO.getIntakeLimitSwitchRight().get()) {
                    return true;
                }
                break;
            }
        }
        return false;
    }
}
