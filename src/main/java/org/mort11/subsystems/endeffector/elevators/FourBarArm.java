package org.mort11.subsystems.endeffector.elevators;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.mort11.hardware.IO;
import org.mort11.util.Constants;

/**
 * This class contains a subsystem for the four bar arm.
 *
 * @author Benny Mirisola
 * @author Frank Alfano
 * @version 02/14/2018
 */
public class FourBarArm extends Subsystem {

    /**
     * Constructs a new FourBarArm Subsystem.
     */
    public FourBarArm() {
        super("FourBarArm");
    }

    /**
     * Sets no default command for the subsystem.
     */
    @Override
    protected void initDefaultCommand() {
        //setDefaultCommand(new MoveFourBarArm());
    }

    /**
     * Sets the speed of the arm talon.
     *
     * @param speed - Talon speed.
     */
    public void setPot(double speed) {

        if (IO.getPotentiometer().get() <= Constants.ARM_MIN + Constants.ANGLE_DEADZONE) {

            if (speed < -Constants.MOTOR_DEADZONE) {

                IO.getFourbarTalon().set(Constants.CONTROL_MODE, speed);

            }

        } else if (IO.getPotentiometer().get() >= Constants.ARM_MAX - Constants.ANGLE_DEADZONE) { // If the arm wants to go to the top, and it is not already at the top ...

            if (speed > Constants.MOTOR_DEADZONE) {

                IO.getFourbarTalon().set(Constants.CONTROL_MODE, speed);

            }

        } else {

            if (speed > Constants.MOTOR_DEADZONE - Constants.ANGLE_DEADZONE && speed < Constants.MOTOR_DEADZONE + Constants.ANGLE_DEADZONE) {

                IO.getFourbarTalon().set(Constants.CONTROL_MODE, speed);

            }

        }

    }

    public void set(double speed) {
        IO.getFourbarTalon().set(Constants.CONTROL_MODE, speed);

    }

}