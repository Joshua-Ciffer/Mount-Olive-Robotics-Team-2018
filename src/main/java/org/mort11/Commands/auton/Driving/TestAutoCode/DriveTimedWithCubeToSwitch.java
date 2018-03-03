package org.mort11.Commands.auton.Driving.TestAutoCode;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.mort11.Commands.auton.Driving.DriveDistanceTimed;
import org.mort11.Commands.endeffector.ElevatorCommands.ElevatorPositions.AutoElevatorSetCommands.MoveFourBarArmSetValue;
import org.mort11.Commands.endeffector.IntakeCommands.AutoIntakeSetCommands.RollIntakeTimed;
import org.mort11.Commands.endeffector.IntakeCommands.RollIntake;
import org.mort11.Hardware.HardwareStates;
import org.mort11.Util.Constants;

public class DriveTimedWithCubeToSwitch extends CommandGroup {

    public DriveTimedWithCubeToSwitch(double drivetrainSpeed, double armSpeed, double timeout){
      addParallel(new DriveDistanceTimed(drivetrainSpeed, timeout));
      addParallel(new MoveFourBarArmSetValue(armSpeed, timeout));
      addSequential(new RollIntakeTimed(Constants.INTAKE_COAST, HardwareStates.RollerState.IN, timeout));
      addSequential(new RollIntake(Constants.INTAKE_SPEED, HardwareStates.RollerState.OUT));
    }
}
