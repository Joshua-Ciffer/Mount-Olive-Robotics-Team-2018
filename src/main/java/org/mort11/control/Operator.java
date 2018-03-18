package org.mort11.control;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.mort11.commands.endeffector.elevatorcommands.elevatorpositions.fourbararm.MoveFourBarArmDown;
import org.mort11.commands.endeffector.elevatorcommands.elevatorpositions.fourbararm.MoveFourBarArmUp;
import org.mort11.commands.endeffector.intakeCommands.*;
import org.mort11.util.Constants;
import org.mort11.util.HardwareStates;
import org.mort11.util.POV;
import org.mort11.util.POVButton;

/**
 * Contains means of getting user input from joysticks and buttons.
 *
 * @author Joshua Ciffer
 * @author Frankie Alfano
 * @author Benny Mirisola
 * @author Tim Vu
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

        JoystickButton actuateButton = new JoystickButton(leftOperatorJoystick, Constants.ACTUATE_BUTTON);
        actuateButton.whileHeld(new ActuatePiston(HardwareStates.IntakePistonState.IN));
        actuateButton.whenReleased(new GrabAndClose());

        JoystickButton outtakeButton = new JoystickButton(rightOperatorJoystick, Constants.OUTTAKE_BUTTON);
        outtakeButton.whileHeld(new RollIntake(Constants.INTAKE_OUTAKE_SPEED, HardwareStates.RollerState.OUT));
        outtakeButton.whenReleased(new RollIntake(0, HardwareStates.RollerState.STOP));

        JoystickButton intakeButton = new JoystickButton(rightOperatorJoystick, Constants.INTAKE_BUTTON);
        intakeButton.whileHeld(new RollIntake(Constants.INTAKE_SPEED, HardwareStates.RollerState.IN));
        intakeButton.whenReleased(new CoastIntake());

        //JoystickButton outActuateButton = new JoystickButton(leftOperatorJoystick, Constants.OUT_ACTUATE_BUTTON);
        //outActuateButton.whenPressed(new ActuatePiston(HardwareStates.IntakePistonState.IN));

        //JoystickButton inActuateButton = new JoystickButton(rightOperatorJoystick, Constants.IN_ACTUATE_BUTTON);
        //inActuateButton.whenPressed(new ActuatePiston(HardwareStates.IntakePistonState.OUT));

        POVButton fourbarButtonUp = new POVButton(rightOperatorJoystick, POV.UP);
        fourbarButtonUp.whileHeld(new MoveFourBarArmUp(-Constants.FOURBARARM_SPEED));
        fourbarButtonUp.whenReleased(new MoveFourBarArmUp(0));

        POVButton fourButtonDown = new POVButton(rightOperatorJoystick, POV.DOWN);
        fourButtonDown.whileHeld(new MoveFourBarArmDown(Constants.FOURBARARM_SPEED));
        fourButtonDown.whenReleased(new MoveFourBarArmDown(0));


//        JoystickButton firstStageUpButton = new JoystickButton(leftDriverJoystick, 1);
//        firstStageUpButton.whenPressed(new MoveFirstStageElevatorSetValue(0.2, HardwareStates.ElevatorDirection.UP,4));
//
//        JoystickButton firstStageDownButton = new JoystickButton(leftDriverJoystick, 2);
//        firstStageDownButton.whenPressed(new MoveFirstStageElevatorSetValue(0.2, HardwareStates.ElevatorDirection.DOWN, 4));
//
//        JoystickButton secondStageUpButton = new JoystickButton(leftDriverJoystick, 3);
//        secondStageUpButton.whenPressed(new MoveSecondStageElevatorSetValue(0.2,HardwareStates.ElevatorDirection.UP,4));
//
//        JoystickButton secondStageDownButton = new JoystickButton(leftDriverJoystick, 4);
//        secondStageDownButton.whenPressed(new MoveSecondStageElevatorSetValue(0.2,HardwareStates.ElevatorDirection.DOWN,4));
//
//        JoystickButton fourBarArmUpButton = new JoystickButton(leftDriverJoystick, 5);
//        fourBarArmUpButton.whenPressed(new MoveFourBarArmSetValue(0.2,HardwareStates.ElevatorDirection.UP,4));
//
//        JoystickButton fourBarArmDownButton = new JoystickButton(leftDriverJoystick, 6);
//        fourBarArmDownButton.whenPressed(new MoveFourBarArmSetValue(0.2, HardwareStates.ElevatorDirection.DOWN,4));

        JoystickButton shifterButton = new JoystickButton(rightOperatorJoystick, 12);
        shifterButton.whileHeld(new ShiftIntake(HardwareStates.IntakeShiftState.UP));
        shifterButton.whenReleased(new ShiftIntake(HardwareStates.IntakeShiftState.DOWN));

        //JoystickButton intakeCommandGroupButton = new JoystickButton(leftOperatorJoystick, 7);
        //intakeCommandGroupButton.whenPressed(new Intake());
//        JoystickButton shiftIntakeButton = new JoystickButton(leftDriverJoystick, 1);
//        shiftIntakeButton.whileHeld(new ShiftIntake(HardwareStates.IntakeShiftState.UP));
//        shiftIntakeButton.whenReleased(new ShiftIntake(HardwareStates.IntakeShiftState.DOWN));

        //JoystickButton climbButton = new JoystickButton(leftOperatorJoystick, Constants.CLIMB_BUTTON);
        //JoystickButton intakePosButton = new JoystickButton(leftOperatorJoystick, Constants.INTAKE_POS_BUTTON);
        //JoystickButton placeOnScaleButton = new JoystickButton(leftOperatorJoystick, Constants.PLACE_ON_SCALE_BUTTON);
        //JoystickButton placeOnSwitchButton = new JoystickButton(leftOperatorJoystick, Constants.PLACE_ON_SWITCH_BUTTON);
        //JoystickButton shiftButton = new JoystickButton(rightOperatorJoystick, Constants.SHIFT_BUTTON);
        //JoystickButton lowButton = new JoystickButton(rightOperatorJoystick, Constants.LOW_BUTTON);

        //climbButton.whenPressed(new Climb());
        //intakePosButton.whenPressed(new Intake());
        //placeOnScaleButton.whenPressed(new PlaceOnScale());
        //placeOnSwitchButton.whenPressed(new PlaceOnSwitch());

        //shiftButton.whenPressed(new Shift(HardwareStates.Gear.HIGH));
        //lowButton.whenPressed(new Shift(HardwareStates.Gear.LOW));

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