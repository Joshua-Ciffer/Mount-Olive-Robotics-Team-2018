package test;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.command.TimedCommand;
import org.mort11.Robot;
import org.mort11.hardware.IO;
import org.mort11.util.Convertor;

/*
 * @author Benny Mirisola
 * For testing purposes only
 */

public class TimedDriveDistance extends TimedCommand {

    public TimedDriveDistance(double timeout) {
        super(timeout);
        requires(Robot.driveTrain);
        setInterruptible(false);
    }

    protected void execute() {
        Robot.driveTrain.setRightDriveVelocity(Convertor.convertFPSToEncoderTicksPer100Milliseconds(1));
        Robot.driveTrain.setLeftDriveVelocity(Convertor.convertFPSToEncoderTicksPer100Milliseconds(1));
    }

    protected void end() {
        IO.getLeftMaster().setNeutralMode(NeutralMode.Brake);
        IO.getRightMaster().setNeutralMode(NeutralMode.Brake);
        Robot.driveTrain.setLeftDriveVelocity(0);
        Robot.driveTrain.setRightDriveVelocity(0);
    }

}
