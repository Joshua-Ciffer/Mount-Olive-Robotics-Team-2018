package org.mort11.Commands.auton.Driving;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.mort11.Robot;

public class DriveDistanceTimed extends TimedCommand {
    private double speed;

    public DriveDistanceTimed(double speed, double timeout){
        super(timeout);
        this.speed = speed;
    }

    protected void execute(){
        Robot.driveTrain.setBothSides(speed);
    }

    protected void end(){
        Robot.driveTrain.setBothSides(0);
    }

    protected void interrupted(){
        end();
    }
}
