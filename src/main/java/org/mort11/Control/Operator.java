package org.mort11.Control;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.mort11.Commands.Drivetrain.Shifting.Shift;
import org.mort11.Commands.endeffector.ElevatorCommands.ElevatorCommandGroups.Climb;
import org.mort11.Commands.endeffector.ElevatorCommands.ElevatorCommandGroups.IntakeCommand;
import org.mort11.Commands.endeffector.ElevatorCommands.ElevatorCommandGroups.PlaceOnScale;
import org.mort11.Commands.endeffector.ElevatorCommands.ElevatorCommandGroups.PlaceOnSwitch;
import org.mort11.Commands.endeffector.IntakeCommands.ActuatePiston;
import org.mort11.Commands.endeffector.IntakeCommands.RollIntake;
import org.mort11.Hardware.HardwareStates;
import org.mort11.Util.Constants;

/**
 * Contains means of getting user input from joysticks and buttons.
 *
 * @author Joshua Ciffer
 * @author Frankie Alfano
 * @author Benny Mirisola
 * @version 02/14/2018
 */
public class Operator {

    /**
     * Left driver joystick object.
     */
    private static Joystick leftDriverJoystick = new Joystick(Constants.LEFT_DRIVER_JOYSTICK);

    /**
     * Right driver joystick object.
     */
    private static Joystick rightDriverJoystick = new Joystick(Constants.RIGHT_DRIVER_JOYSTICK);

    /**
     * Left operator joystick object.
     */
    private static Joystick leftOperatorJoystick = new Joystick(Constants.LEFT_OPERATOR_JOYSTICK);

    /**
     * Right operator joystick object.
     */
    private static Joystick rightOperatorJoystick = new Joystick(Constants.RIGHT_OPERATOR_JOYSTICK);

    /**
     * Initializes all joystick objects and buttons.
     */
    public static void init() {
        JoystickButton climbButton = new JoystickButton(leftOperatorJoystick, Constants.CLIMB_BUTTON);
        JoystickButton intakePosButton = new JoystickButton(leftOperatorJoystick, Constants.INTAKE_POS_BUTTON);
        JoystickButton placeOnScaleButton = new JoystickButton(leftOperatorJoystick, Constants.PLACE_ON_SCALE_BUTTON);
        JoystickButton placeOnSwitchButton = new JoystickButton(leftOperatorJoystick, Constants.PLACE_ON_SWITCH_BUTTON);

        JoystickButton intakeButton = new JoystickButton(leftOperatorJoystick, Constants.INTAKE_BUTTON);
        JoystickButton outtakeButton = new JoystickButton(leftOperatorJoystick, Constants.OUTTAKE_BUTTON);
        JoystickButton actuateIntakeButton = new JoystickButton(leftOperatorJoystick, Constants.ACTUATE_PISTON_BUTTON);
        JoystickButton shiftButton = new JoystickButton(leftOperatorJoystick, Constants.SHIFT_BUTTON);
        JoystickButton lowButton = new JoystickButton(leftOperatorJoystick, Constants.LOW_BUTTON);

        climbButton.whenPressed(new Climb());
        intakePosButton.whenPressed(new IntakeCommand());
        placeOnScaleButton.whenPressed(new PlaceOnScale());
        placeOnSwitchButton.whenPressed(new PlaceOnSwitch());

        shiftButton.whenPressed(new Shift(HardwareStates.Gear.HIGH));
        lowButton.whenPressed(new Shift(HardwareStates.Gear.LOW));

        intakeButton.whileHeld(new RollIntake(HardwareStates.RollerState.IN));
        intakeButton.whenReleased(new RollIntake(HardwareStates.RollerState.STOP));
        outtakeButton.whileHeld(new RollIntake(HardwareStates.RollerState.OUT));
        outtakeButton.whenReleased(new RollIntake(HardwareStates.RollerState.STOP));
        actuateIntakeButton.whileHeld(new ActuatePiston(HardwareStates.IntakePistonState.IN));
        actuateIntakeButton.whenReleased(new ActuatePiston(HardwareStates.IntakePistonState.OUT));

    }

    /**
     * @return Left drive joystick object.
     */
    public static Joystick getLeftDriverJoystick() {
        return leftDriverJoystick;
    }

    /**
     * @return Right drive joystick object.
     */
    public static Joystick getRightDriverJoystick() {
        return rightDriverJoystick;
    }

    /**
     * @return Left operator joystick object.
     */
    public static Joystick getLeftOperatorJoystick() {
        return leftOperatorJoystick;
    }

    /**
     * @return Right operator joystick.
     */
    public static Joystick getRightOperatorJoystick() {
        return rightOperatorJoystick;
    }

}