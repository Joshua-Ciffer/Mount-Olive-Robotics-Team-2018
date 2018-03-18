package test;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.control.Operator;

public class VelocityJoystickDrive extends Command {

    protected void execute() {
        Robot.driveTrain.setRightDriveVelocity(Operator.getRightDriverJoystick().getY());
        Robot.driveTrain.setLeftDriveVelocity(Operator.getLeftDriverJoystick().getY());
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
