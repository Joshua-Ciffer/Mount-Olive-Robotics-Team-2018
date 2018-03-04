package org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.FourBarArm;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Hardware.IO;
import org.mort11.Robot;
import org.mort11.Util.Constants;

public class MoveFourBarArmDegrees extends Command {

    private int degrees;

    public MoveFourBarArmDegrees() {
    }

    public MoveFourBarArmDegrees(int degrees) {

        super("MoveFourBarArmDegrees");
        requires(Robot.fourBarArm);
        setInterruptible(true);

        this.degrees = degrees;

    }

    protected void execute() {
        if (degrees < IO.getPotentiometer().get()) {
            Robot.fourBarArm.setPot(-Constants.FOURBARARM_SPEED);
        } else if (degrees > IO.getPotentiometer().get()) {
            Robot.fourBarArm.setPot(Constants.FOURBARARM_SPEED);
        }

    }

    @Override
    protected boolean isFinished() {

        return Math.abs(IO.getPotentiometer().get() - degrees) <= Constants.ARM_ANGLE_LATENCY;

    }

    @Override
    protected void interrupted() {

        end();

    }

    @Override
    protected void end() {

        Robot.fourBarArm.setPot(0);

    }

}
