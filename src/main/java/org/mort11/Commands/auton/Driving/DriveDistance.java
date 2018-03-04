package org.mort11.Commands.auton.Driving;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Hardware.IO;
import org.mort11.Robot;
import org.mort11.Subsystems.Drivetrain.Drivetrain;
import org.mort11.Util.Constants;

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
//        distance = ahrs.getDisplacementY();
//        if(targetDistance - distance > Constants.DISTANCE_LENIENCY){
//            drivetrain.setLeftDriveSpeed(Constants.SPEED_FAR);
//            drivetrain.setRightDriveSpeed(Constants.SPEED_FAR);
//        }else if (targetDistance - distance < Constants.DISTANCE_LENIENCY ) {
//            drivetrain.setLeftDriveSpeed(Constants.SPEED_CLOSE);
//            drivetrain.setRightDriveSpeed(Constants.SPEED_CLOSE);
//        }

        drivetrain.setLeftDriveSpeed(0.5);
        drivetrain.setRightDriveSpeed(0.5);
        distanceTravled = Constants.CIRCUMFERENCE * (IO.getRightMaster().getSensorCollection().getPulseWidthPosition() / 4096);

    }

    protected boolean isFinished() {
        return distanceTravled <= targetDistance + 10 || distanceTravled >= targetDistance - 10;
    }

    protected void end() {
        drivetrain.setRightDriveSpeed(0);
        drivetrain.setLeftDriveSpeed(0);
    }
}
