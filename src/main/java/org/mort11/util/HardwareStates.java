package org.mort11.util;

/**
 * Contains enum type states for different hardware conditions.
 *
 * @author Zach "Merge Errors" Rich
 * @author Joshua Ciffer
 * @version 02/14/2018
 */
public class HardwareStates {

    /**
     * States for the first stage elevator.
     */
    public enum ElevatorState {
        BOTTOM, TOP
    }

    /**
     * States for the intake piston.
     */
    public enum IntakePistonState {
        IN, OUT
    }

    public enum IntakeShiftState {
        UP, DOWN
    }

    public enum IntakeRollersState {
        IN, OUT, STOP, COAST
    }

    public enum DrivetrainGear {
        HIGH, LOW
    }

    public enum ElevatorDirection {
        UP, DOWN

    }
}