package org.mort11.commands.auton.driving;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.drivetrain.Drivetrain;
import org.mort11.hardware.IO;
import org.mort11.util.Constants;
import org.mort11.util.Convertor;

/**
 * @author Seven Kurt
 */
public class DriveDistance extends Command {
    private double targetDistance;
    private Drivetrain drivetrain = Robot.driveTrain;
    private double distanceTravled;

    public DriveDistance(double targetDistance) {
        this.targetDistance = targetDistance;
    }

    protected void initialize() {
        IO.getRightMaster().setSelectedSensorPosition(0, 0, 0);
        IO.getLeftMaster().setSelectedSensorPosition(0, 0, 0);
    }

    protected void execute() {
        //distance = ahrs.getDisplacementY();
        if (Math.abs(targetDistance - distanceTravled) > Constants.DISTANCE_LENIENCY) {
            drivetrain.setLeftDriveVelocity(Convertor.convertFPSToEncoderTicksPer100Milliseconds(2));
            drivetrain.setRightDriveVelocity(Convertor.convertFPSToEncoderTicksPer100Milliseconds(2));
        } else if (Math.abs(targetDistance - distanceTravled) < Constants.DISTANCE_LENIENCY) {
            drivetrain.setLeftDriveVelocity(Convertor.convertFPSToEncoderTicksPer100Milliseconds(1));
            drivetrain.setRightDriveVelocity(Convertor.convertFPSToEncoderTicksPer100Milliseconds(2));
        }

        drivetrain.setLeftDriveSpeed(0.5);
        drivetrain.setRightDriveSpeed(0.5);
        distanceTravled = Constants.CIRCUMFERENCE_IN_INCHES * (IO.getRightMaster().getSensorCollection().getPulseWidthPosition() / 4096);

    }

    protected boolean isFinished() {
        return distanceTravled <= targetDistance + 10 || distanceTravled >= targetDistance - 10;
    }

    protected void end() {
        drivetrain.setRightDriveSpeed(0);
        drivetrain.setLeftDriveSpeed(0);
    }
}
