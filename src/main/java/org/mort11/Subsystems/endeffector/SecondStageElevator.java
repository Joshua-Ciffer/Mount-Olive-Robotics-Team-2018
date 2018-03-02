package org.mort11.Subsystems.endeffector;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.mort11.Commands.endeffector.ElevatorCommands.ElevatorCommandGroups.JoystickDrives.MoveSecondStageElevator;
import org.mort11.Control.Operator;
import org.mort11.Hardware.IO;
import org.mort11.Util.Constants;

/**
 * This class contains a subsystem for the second stage elevator.
 *
 * @author Seven Kurt
 * @version 02/14/2018
 */
public class SecondStageElevator extends Subsystem {

	/**
	 * Constructs a new SecondStageElevator Subsystem.
	 */
	public SecondStageElevator() {
		super("SecondStageElevator");
	}

	/**
	 * Sets no default command.
	 */
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new MoveSecondStageElevator());
	}

	/**
	 * Sets the speed and control mode of the second stage elevator talon.
	 * 
	 * @param speed - The talon speed.
	 */
	public void set(double speed) {

		IO.getSecondStageElevatorTalon().set(Constants.CONTROL_MODE, speed);

	}

}