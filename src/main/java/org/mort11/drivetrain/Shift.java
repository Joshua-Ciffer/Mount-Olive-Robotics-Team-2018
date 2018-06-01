package org.mort11.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.util.HardwareStates;

/**
 * Code for shifting transmission
 *
 * @author Zach Rich
 */
public class Shift extends Command {
	
    private HardwareStates.Gear gear;

    /**
     * Default constructor
     *
     * @param gear
     */
    public Shift(HardwareStates.Gear gear) {
        this.gear = gear;
    }

    /**
     * Calls shifting method in drivetrain class.
     */
    protected void execute() {
        Robot.driveTrain.shift(gear);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
    
}