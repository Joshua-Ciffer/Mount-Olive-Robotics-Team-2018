package org.mort11.Hardware;

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
    public enum ElevatorFirstStageState {
        BOTTOM, TOP
    }

    /**
     * States for the second stage elevator.
     */
    public enum ElevatorSecondStageState {
        BOTTOM, MIDDLE, TOP
    }

    /**
     * States for the four bar arm state.
     */
    public enum FourBarArmState {
        BOTTOM, TOP
    }

    /**
     * States for the intake piston.
     */
    public enum IntakePistonState {
        IN, OUT
    }

    public enum RollerState {
        IN, OUT, STOP,COAST
    }

    public enum Gear {
        HIGH, LOW
    }

    public enum ElevatorDirection {
        UP, DOWN

    }
}