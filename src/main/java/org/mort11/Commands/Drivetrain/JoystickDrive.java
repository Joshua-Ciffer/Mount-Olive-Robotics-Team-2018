package org.mort11.Commands.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Hardware.IO;
import org.mort11.Robot;
import org.mort11.Control.Operator;

/**
 * @author Zach "Bad Push" Rich
 * @version 01/30/2018
 */
public class JoystickDrive extends Command {

    /**
     * Constructs a new JoystickDrive command.
     */
    public JoystickDrive() {
        super("JoystickDrive");
        requires(Robot.driveTrain);
        setInterruptible(false);
    }

    /**
     * Set drivetrain sides to operator joystick input.
     */
    @Override
    protected void execute() {
        Robot.driveTrain.setLeftDriveSpeed(Operator.getLeftDriverJoystick().getY());
        Robot.driveTrain.setRightDriveSpeed(Operator.getRightDriverJoystick().getY());
    }

    /**
     * The limit switch is false when it is pressed.  The switch returns true when it is not pressed.
     * If the limit switch is pressed (false) then isFinished() returns true because the switch would
     * then stop robot movement.
     *
     * @return Returns whether or not the command has been interrupted.
     */
    @Override
    protected boolean isFinished() {
        return false;
    }

    /**
     * Stop the drivetrain if command is interrupted.
     */
}