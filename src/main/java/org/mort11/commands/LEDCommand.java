package org.mort11.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.hardware.IO;
import org.mort11.subsystems.led.LED;

import static org.mort11.subsystems.led.LED.LEDMode;
import static org.mort11.subsystems.led.LED.LEDMode.CYCLE_END_GAME_COLORS;
import static org.mort11.util.Constants.*;

/**
 * @author Joshua Ciffer
 * @version 03/08/2018
 */
public class LEDCommand extends Command {

    /**
     * Determines which LED command is run.
     */
    private LED.LEDMode commandMode;

    /**
     * Constructs a new LEDCommand.
     */
    public LEDCommand(LED.LEDMode commandMode) {
        super("LEDCommand");
        requires(Robot.led);
        setInterruptible(true);
        this.commandMode = commandMode;
    }

    /**
     * Starts with all LEDs turned off.
     */
    @Override
    protected void initialize() {
        IO.getRedLED().set(LED_RED_OFF);
        IO.getGreenLED().set(LED_GREEN_OFF);
        IO.getBlueLED().set(LED_BLUE_OFF);
    }

    /**
     * Runs the LED command for the current command mode.
     */
    @Override
    protected void execute() {
        switch (commandMode) {
            case CHANGE_ALLIANCE_COLOR: {
                Robot.led.changeAllianceColor();
                break;
            }
            case INTAKE_COLOR_CHANGER: {
                if (DriverStation.getInstance().getMatchTime() >= 30) {
                    Robot.led.changeIntakeColor();
                } else {
                    setCommandMode(CYCLE_END_GAME_COLORS);
                }
                break;
            }
            case CYCLE_END_GAME_COLORS: {
                Robot.led.endGameColors();
                break;
            }
            case DISABLED: {
                Robot.led.disableLEDs();
                break;
            }
        }
    }

    /**
     * Command runs continuously.
     */
    @Override
    protected boolean isFinished() {
        return false;
    }

    /**
     * @return The current LED command mode.
     */
    public LEDMode getCommandMode() {
        return commandMode;
    }

    /**
     * Sets a new LED mode.
     *
     * @param commandMode - The new LED mode to set.
     */
    public void setCommandMode(LEDMode commandMode) {
        this.commandMode = commandMode;
    }

}