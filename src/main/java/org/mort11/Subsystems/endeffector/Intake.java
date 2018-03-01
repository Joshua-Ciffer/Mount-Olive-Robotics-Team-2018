package org.mort11.Subsystems.endeffector;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.mort11.Commands.endeffector.IntakeCommands.RollIntake;
import org.mort11.Hardware.HardwareStates;
import org.mort11.Hardware.IO;
import org.mort11.Util.Constants;

/**
 * This class contains a subsystem for the intake.
 *
 * @author Joshua Ciffer
 * @version 02/14/2018
 */
public class Intake extends Subsystem {

    /**
     * Constructs a new Intake Subsystem.
     */
    public Intake() {
        super("IntakeRollers");
    }

    /**
     * Sets the default command for the subsystem to the command group that controls intake pistons and rollers.
     */
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new RollIntake(HardwareStates.RollerState.COAST));
    }

    /**
     * Sets the speed of the intake rollers.
     *
     * @param speed - Roller talon speed.
     */
    public void setRollerSpeed(double speed, HardwareStates.RollerState rollerState) {
        switch (rollerState) {
            case IN: {

                if (IO.getIntakeLimitSwitchLeft().get() == false && IO.getIntakeLimitSwitchRight().get() == false) {
                    break;
                } else {
                    IO.getIntakeRollerVictorLeft().set(Constants.CONTROL_MODE, speed);
                    IO.getIntakeRollerVictorRight().set(Constants.CONTROL_MODE, -speed);
                    break;
                }
            }
            case OUT: {
                IO.getIntakeRollerVictorLeft().set(Constants.CONTROL_MODE, -speed);
                IO.getIntakeRollerVictorRight().set(Constants.CONTROL_MODE, speed);
                break;
            }
            case STOP: {
                IO.getIntakeRollerVictorLeft().set(Constants.CONTROL_MODE, Constants.INTAKE_STOP);
                IO.getIntakeRollerVictorRight().set(Constants.CONTROL_MODE, Constants.INTAKE_STOP);
            }
        }
    }


    /**
     * Actuates the intake piston.
     *
     * @param pistonState - The state the piston will be setPot to.
     */
    public void actuatePiston(HardwareStates.IntakePistonState pistonState) {
        switch (pistonState) {
            case IN: {
                IO.getIntakePiston().set(DoubleSolenoid.Value.kForward);
                break;
            }
            case OUT: {
                IO.getIntakePiston().set(DoubleSolenoid.Value.kReverse);
                break;
            }
        }
    }

}