package org.mort11.auton;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.mort11.Robot;

public class DriveDistanceTimed extends TimedCommand {
    private double speed;

    public DriveDistanceTimed(double speed, double timeout) {
        super(timeout);
        this.speed = speed;
        requires(Robot.driveTrain);
        setInterruptible(false);
    }

    protected void execute() {
        Robot.driveTrain.setLeftDriveSpeed(speed);
        Robot.driveTrain.setRightDriveSpeed(speed);
        System.out.println("This is working");
    }

    protected void end() {
        Robot.driveTrain.setBothSides(0);
    }

    protected void interrupted() {
        end();
    }
}
