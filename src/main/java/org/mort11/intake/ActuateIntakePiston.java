package org.mort11.intake;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.util.HardwareStates;

/**
 * @author Joshua Ciffer
 * @author Benny Mirisola
 * @author Seven Kurt
 * @version 02/14/2018
 */
public class ActuateIntakePiston extends Command {

    private HardwareStates.IntakePistonState pistonState;

    public ActuateIntakePiston(HardwareStates.IntakePistonState pistonState) {
        super("ActuatePiston");
        requires(Robot.intakePistons);
        setInterruptible(true);
        this.pistonState = pistonState;
    }

    @Override
    protected void execute() {
        Robot.intakePistons.actuatePiston(pistonState);
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

}