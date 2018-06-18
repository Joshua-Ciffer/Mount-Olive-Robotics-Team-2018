package org.mort11.elevator;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;
import org.mort11.control.Operator;
import org.mort11.hardware.IO;
import org.mort11.util.Constants;

public class MoveElevatorUp extends Command {

	private double speed;

	public MoveElevatorUp() {
		super("JoystickDriveFirstStageElevatorUp");
		requires(Robot.elevator);
		setInterruptible(true);
	}

	@Override
	protected void execute() {
		speed = Operator.getLeftOperatorJoystick().getY();

		if (speed < -Constants.MOTOR_DEADZONE) {
			Robot.elevator.setVelocity(-speed);
		}
	}

	@Override
	protected boolean isFinished() {
		return !IO.getTopElevatorLimitSwitch().get() || speed > -Constants.MOTOR_DEADZONE;
	}

	@Override
	protected void end() {
		// IO.getFirstStageElevatorTalonMaster().setSelectedSensorPosition(Constants.ZERO_ENCODER_POSITION,Constants.PID_LOOP_ID, 0);
		Robot.elevator.setVelocity(0);
	}

	@Override
	protected void interrupted() {
		end();
	}

	@Override
	protected void initialize() {
		// IO.getFirstStageElevatorTalonMaster().setSelectedSensorPosition(Constants.ZERO_ENCODER_POSITION,Constants.PID_LOOP_ID, 0);
	}
}
