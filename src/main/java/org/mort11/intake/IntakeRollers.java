package org.mort11.intake;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.mort11.hardware.IO;
import org.mort11.util.HardwareStates.RollerState;
import org.mort11.util.Constants;

public class IntakeRollers extends Subsystem {
	
	private RollerState rollerState;
	
    public IntakeRollers() {
        super("IntakeRollers");
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new CoastIntake());
    }

    public void setRollerSpeed(double speed) {
        IO.getIntakeRollerVictorLeft().set(Constants.CONTROL_MODE, speed);
        IO.getIntakeRollerVictorRight().set(Constants.CONTROL_MODE, speed);
    }
    
    public void halt() {
    	setRollerSpeed(0);
    }
    
    public void setRollerState(RollerState rollerState) {
    	this.rollerState = rollerState;
    }
    
    public RollerState getRollerState() {
    	return rollerState;
    }
    
}