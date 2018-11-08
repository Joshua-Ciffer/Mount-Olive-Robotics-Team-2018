package org.mort11.control;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.mort11.intake.CoastIntake;
import org.mort11.intake.GrabAndClose;
import org.mort11.intake.RollIntake;
import org.mort11.intake.ShiftIntake;
import org.mort11.util.Constants;
import org.mort11.util.HardwareStates.IntakeRollersState;
import org.mort11.util.HardwareStates.IntakeShiftState;

/**
 * Contains objects representing driver and operator joysticks and assigns specific commands to buttons.
 *
 * @author Joshua Ciffer
 * @author Frankie Alfano
 * @author Benny Mirisola
 * @author Tim Vu
 * @version 06/08/2018
 */
public final class Operator {

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
	private static Joystick operatorJoystick = new Joystick(Constants.OPERATOR_JOYSTICK);

	/**
	 * Don't let anyone instantiate this class.
	 */
	private Operator() {}

	/**
	 * Initializes all joystick objects and buttons.
	 */
	public static void init() {
		JoystickButton actuateIntakePistonButton = new JoystickButton(operatorJoystick, Constants.ACTUATE_INTAKE_PISTON_BUTTON);
		actuateIntakePistonButton.whenReleased(new GrabAndClose());

		JoystickButton outtakeButton = new JoystickButton(operatorJoystick, Constants.OUTTAKE_BUTTON);
		outtakeButton.whileHeld(new RollIntake(IntakeRollersState.OUT));
		outtakeButton.whenReleased(new RollIntake(IntakeRollersState.STOP));

		JoystickButton intakeButton = new JoystickButton(operatorJoystick, Constants.INTAKE_BUTTON);
		intakeButton.whileHeld(new RollIntake(IntakeRollersState.IN));
		intakeButton.whenReleased(new CoastIntake());

		JoystickButton intakeShifterButton = new JoystickButton(operatorJoystick, Constants.INTAKE_SHIFTER_UP_BUTTON);
		intakeShifterButton.whenPressed(new ShiftIntake(IntakeShiftState.UP));

		JoystickButton intakeShifterDownButton = new JoystickButton(operatorJoystick, Constants.INTAKE_SHIFTER_DOWN_BUTTON);
		intakeShifterDownButton.whenPressed(new ShiftIntake(IntakeShiftState.DOWN));
	}

	/**
	 * @return Left driver joystick object.
	 */
	public static Joystick getLeftDriverJoystick() {
		return leftDriverJoystick;
	}

	/**
	 * @return Right driver joystick object.
	 */
	public static Joystick getRightDriverJoystick() {
		return rightDriverJoystick;
	}

	/**
	 * @return Left operator joystick object.
	 */
	public static Joystick getOperatorJoystick() {
		return operatorJoystick;
	}

}