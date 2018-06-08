package org.mort11.auton;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.mort11.Robot;

public class DriveDistanceTimed extends TimedCommand {
    private double speed;

    public DriveDistanceTimed(double speed, double timeout) {
        super(timeout);
        this.speed = speed;
        requires(Robot.drivetrain);
        setInterruptible(false);
    }

    protected void execute() {
        Robot.drivetrain.setLeftDriveSpeed(speed);
        Robot.drivetrain.setRightDriveSpeed(speed);
        System.out.println("This is working");
    }

    protected void end() {
        Robot.drivetrain.setBothSides(0);
    }

    protected void interrupted() {
        end();
    }
}
