package org.mort11.Subsystems.endeffector;


import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.mort11.Commands.endeffector.ElevatorCommands.ElevatorCommandGroups.JoystickDrives.MoveFirstStageElevator;
import org.mort11.Hardware.IO;
import org.mort11.Util.Constants;

/**
 * This class contains a subsystem for the first stage elevator.
 *
 * @author Seven Kurt
 * @version 02/14/2018
 */
public class FirstStageElevator extends Subsystem {

    /**
     * Constructs a new FirstStageElevator Subsystem.
     */
    public FirstStageElevator() {
        super("FirstStageElevator");
    }

    /**
     * Sets no default command for the subsystem.
     */
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new MoveFirstStageElevator());
    }

    /**
     * Sets the speed of the elevator talons.
     *
     * @param speed - Talon speed.
     */
    public void set(double speed) {

        IO.getFirstStageElevatorTalonMaster().set(Constants.CONTROL_MODE, speed);
        IO.getFirstStageElevatorTalonFollower().set(ControlMode.Follower, Constants.FIRST_STAGE_ELEVATOR_TALON_MASTER);

    }

}