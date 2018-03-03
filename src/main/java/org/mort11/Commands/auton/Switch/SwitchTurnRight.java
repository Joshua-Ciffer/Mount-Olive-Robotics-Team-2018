package org.mort11.Commands.auton.Switch;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.Commands.auton.Driving.DriveDistance;
import org.mort11.Commands.auton.Driving.DriveDistanceWithCube;
import org.mort11.Commands.auton.Turning.TurnDegrees;
import org.mort11.Commands.endeffector.IntakeCommands.RollIntake;
import org.mort11.Hardware.HardwareStates;
import org.mort11.Util.Constants;

public class SwitchTurnRight extends CommandGroup {
    public SwitchTurnRight(){
       addSequential(new DriveDistanceWithCube(60));
       addSequential(new TurnDegrees(90));
       //addSequential();
    }
}
