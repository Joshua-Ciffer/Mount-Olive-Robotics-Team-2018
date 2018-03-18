package test;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.util.Convertor;

public class MoveDT extends Command {

    public MoveDT() {
        requires(Robot.driveTrain);
        setInterruptible(false);
    }

    protected void execute() {
        //Robot.driveTrain.setLeftDriveVelocity(Convertor.convertFPSToEncoderTicksPer100Milliseconds(3));
        //System.out.println(Convertor.convertFPSToEncoderTicksPer100Milliseconds(7));
        Robot.driveTrain.setRightDriveVelocity(-Convertor.convertFPSToEncoderTicksPer100Milliseconds(4));
        //Convertor.convertFPSToEncoderTicksPer100Milliseconds(2);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
