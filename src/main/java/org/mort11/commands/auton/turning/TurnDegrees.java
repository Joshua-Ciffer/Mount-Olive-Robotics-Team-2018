package org.mort11.commands.auton.turning;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.drivetrain.Drivetrain;
import org.mort11.hardware.IO;
import org.mort11.util.Constants;

/**
 * @author Daddy Seven Kurt
 */
public class TurnDegrees extends Command {

    private double desiredAngle;
    private Drivetrain drivetrain = Robot.driveTrain;
    private AHRS ahrs = IO.getAHRS();
    private double yaw;

    public TurnDegrees(double angle) {
        if (angle > 180) {
            angle = 180;
            System.out.println("TurnDegrees angle can't be more than 180 degrees! Setting to 180...");
        } else if (angle < -180) {
            angle = -180;
            System.out.println("TurnDegrees angle can't be less than -180 degrees! Setting to -180...");
        }

        this.desiredAngle = angle;

        requires(Robot.driveTrain);
    }

    protected void initialize() {
        ahrs.zeroYaw();
    }

    protected void execute() {
        yaw = ahrs.getYaw();
        System.out.println(yaw);
        /**
         * finds the difference in angle between desired angle and the current yaw
         * if difference is greater than 30, set the motors to .3
         * if the difference is less than 30 but more than 3, set the motors to .15
         */
        if (Math.abs(yaw - desiredAngle) >= Constants.ANGLE_LENIENCY_FAR) {
            if (desiredAngle < 0) {
                drivetrain.setLeftDriveSpeed(Constants.SPEED_FAR);
                drivetrain.setRightDriveSpeed(-Constants.SPEED_FAR);
            } else {
                drivetrain.setLeftDriveSpeed(-Constants.SPEED_FAR);
                drivetrain.setRightDriveSpeed(Constants.SPEED_FAR);
            }
        } else if (Math.abs(yaw - desiredAngle) >= Constants.ANGLE_LENIENCY_CLOSE) {
            if (desiredAngle < 0) {
                drivetrain.setLeftDriveSpeed(Constants.SPEED_CLOSE);
                drivetrain.setRightDriveSpeed(-Constants.SPEED_CLOSE);
            } else {
                drivetrain.setLeftDriveSpeed(-Constants.SPEED_CLOSE);
                drivetrain.setRightDriveSpeed(Constants.SPEED_CLOSE);
            }
        }
        System.out.println(isFinished());
    }

    protected boolean isFinished() {
        return Math.abs(this.ahrs.getYaw() - desiredAngle) <= Constants.ANGLE_FINISH;
    }

    protected void end() {
        drivetrain.halt();
        ahrs.zeroYaw();
        System.out.println("Turn Degrees has finished");
    }

}
