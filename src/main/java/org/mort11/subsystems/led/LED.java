package org.mort11.subsystems.led;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.mort11.hardware.IO;

import static org.mort11.util.Constants.*;

/**
 * This class contains a subsystem for the LEDs. Several different commands can be run on the LED subsystem.
 * Values for the LEDs are inverted. True turns an LED off, false turns it on.
 *
 * @author Joshua Ciffer
 * @version 03/08/2018
 */
public class LED extends Subsystem {

    /**
     * Constructs a new LED Subsystem.
     */
    public LED() {
        super("LED");
    }

    /**
     * Sets the LEDs to be disabled by default.
     */
    @Override
    protected void initDefaultCommand() {
        //setDefaultCommand(new LEDCommand(LEDMode.DISABLED));
    }

    /**
     * Turns on red LEDs.
     */
    public void turnOnRed() {
        IO.getRedLED().set(LED_RED_ON);            // On
        IO.getGreenLED().set(LED_GREEN_OFF);    // Off
        IO.getBlueLED().set(LED_BLUE_OFF);        // Off
    }

    /**
     * Turns on green LEDs.
     */
    public void turnOnGreen() {
        IO.getRedLED().set(LED_RED_OFF);        // Off
        IO.getGreenLED().set(LED_GREEN_ON);        // On
        IO.getBlueLED().set(LED_BLUE_OFF);        // Off
    }

    /**
     * Turns on blue LEDs.
     */
    public void turnOnBlue() {
        IO.getRedLED().set(LED_RED_OFF);        // Off
        IO.getGreenLED().set(LED_GREEN_OFF);    // Off
        IO.getBlueLED().set(LED_BLUE_ON);        // On
    }

    /**
     * If teleop mode is enabled, then the LEDs stay red by default. If the switch in the intake is pressed (cube is in the intake),
     * then the LEDs change to green.
     */
    public void changeIntakeColor() {
        if (!IO.getIntakeLimitSwitchLeft().get() && !IO.getIntakeLimitSwitchRight().get()) {        // Switch is pressed,
            IO.getRedLED().set(LED_RED_OFF);        // Off
            IO.getGreenLED().set(LED_GREEN_ON);        // On
            IO.getBlueLED().set(LED_BLUE_OFF);        // Off
        } else {                                            // Switch is not pressed,
            IO.getRedLED().set(LED_RED_ON);            // On
            IO.getGreenLED().set(LED_GREEN_OFF);    // Off
            IO.getBlueLED().set(LED_BLUE_OFF);        // Off
        }
    }

    /**
     * Changes the color from red to blue based on the robot's alliance.
     */
    public void changeAllianceColor() {
        switch (DriverStation.getInstance().getAlliance()) {
            case Blue: {
                IO.getRedLED().set(LED_RED_OFF);        // Off
                IO.getGreenLED().set(LED_GREEN_OFF);    // Off
                IO.getBlueLED().set(LED_BLUE_ON);        // On
                break;
            }
            case Red: {
                IO.getRedLED().set(LED_RED_ON);            // On
                IO.getGreenLED().set(LED_GREEN_OFF);    // Off
                IO.getBlueLED().set(LED_BLUE_OFF);        // Off
                break;
            }
            case Invalid: {
                IO.getRedLED().set(LED_RED_OFF);        // Off
                IO.getGreenLED().set(LED_GREEN_ON);        // On
                IO.getBlueLED().set(LED_BLUE_OFF);        // Off
                break;
            }
        }
    }

    /**
     * Randomly cycles through a bunch of different colors.
     */
    public void endGameColors() {
        switch ((int) (Math.random() * 7)) {        // Randomly determines which color to set it to.
            case 0: {    // Red.
                IO.getRedLED().set(LED_RED_ON);            // On
                IO.getGreenLED().set(LED_GREEN_OFF);    // Off
                IO.getBlueLED().set(LED_BLUE_OFF);        // Off
                break;
            }
            case 1: {    // Green.
                IO.getRedLED().set(LED_RED_OFF);        // Off
                IO.getGreenLED().set(LED_GREEN_ON);        // On
                IO.getBlueLED().set(LED_BLUE_OFF);        // Off
                break;
            }
            case 2: {    // Blue.
                IO.getRedLED().set(LED_RED_OFF);        // Off
                IO.getGreenLED().set(LED_GREEN_OFF);    // Off
                IO.getBlueLED().set(LED_BLUE_ON);        // On
                break;
            }
            case 3: {    // Purple.
                IO.getRedLED().set(LED_RED_ON);            // On
                IO.getGreenLED().set(LED_GREEN_OFF);    // Off
                IO.getBlueLED().set(LED_BLUE_ON);        // On
                break;
            }
            case 4: {    // Yellow.
                IO.getRedLED().set(LED_RED_ON);            // On
                IO.getGreenLED().set(LED_GREEN_ON);        // On
                IO.getBlueLED().set(LED_BLUE_OFF);        // Off
                break;
            }
            case 5: {    // Light blue.
                IO.getRedLED().set(LED_RED_OFF);        // Off
                IO.getGreenLED().set(LED_GREEN_ON);        // On
                IO.getBlueLED().set(LED_BLUE_ON);        // On
                break;
            }
            case 6: {    // White.
                IO.getRedLED().set(LED_RED_ON);            // On
                IO.getGreenLED().set(LED_GREEN_ON);        // On
                IO.getBlueLED().set(LED_BLUE_ON);        // On
                break;
            }
        }
    }

    /**
     * Turns off all LEDs.
     */
    public void disableLEDs() {
        IO.getRedLED().set(LED_RED_OFF);        // Off
        IO.getGreenLED().set(LED_GREEN_OFF);    // Off
        IO.getBlueLED().set(LED_BLUE_OFF);        // Off
    }

    public enum LEDMode {
        CHANGE_ALLIANCE_COLOR,
        INTAKE_COLOR_CHANGER,
        CYCLE_END_GAME_COLORS,
        DISABLED
    }

}