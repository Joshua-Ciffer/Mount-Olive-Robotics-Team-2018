package org.mort11.commands.auton._switch;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.mort11.commands.auton.turning.TurnDegrees;
import org.mort11.commands.endeffector.intakeCommands.RollIntake;
import org.mort11.util.Constants;
import org.mort11.util.HardwareStates;
import test.TimedDriveDistance;

public class SwitchTurnLeft extends CommandGroup {
    public SwitchTurnLeft() {
        addSequential(new TimedDriveDistance(4.4));
        addSequential(new WaitCommand(0.5));
        //addsequential(new MoveFirstStageElevatorUp(1), 2);
        addSequential(new TurnDegrees(-Constants.SWITCH_DEGREES));
        addSequential(new RollIntake(Constants.INTAKE_SPEED, HardwareStates.RollerState.OUT), 3);
    }
}
