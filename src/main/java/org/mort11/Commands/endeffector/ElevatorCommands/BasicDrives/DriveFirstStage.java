package org.mort11.Commands.endeffector.ElevatorCommands.BasicDrives;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Commands.auton.Driving.DriveDistance;
import org.mort11.Robot;

public class DriveFirstStage extends Command {

    public DriveFirstStage(){
        super("DriveFirstStage");
        //requires(Robot.firstStageElevator);

    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
