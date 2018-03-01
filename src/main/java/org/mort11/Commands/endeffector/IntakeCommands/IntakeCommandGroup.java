package org.mort11.Commands.endeffector.IntakeCommands;

import org.mort11.Hardware.HardwareStates;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class IntakeCommandGroup extends CommandGroup {

	public IntakeCommandGroup(HardwareStates.IntakePistonState pistonState, HardwareStates.RollerState rollerState) {
		super("IntakeCommandGroup");
		addParallel(new ActuatePiston(pistonState));
		addParallel(new RollIntake(rollerState));
	}
	
}