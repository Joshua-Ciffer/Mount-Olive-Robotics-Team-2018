package org.mort11.util;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.mort11.hardware.IO;

/*
 * Initializes all the Motors and sensors to the Shuffleboard
 */
public class SmartDashboardLogger {

	public static void init() {
		initTalonVoltage();
		initLimitSwitches();
	}

	private static void initTalonVoltage() {
		SmartDashboard.putNumber(Constants.leftDriveMasterName, IO.getLeftDriveTalonMaster().getMotorOutputVoltage());
		SmartDashboard.putNumber(Constants.leftDriveFollowerMiddleName, IO.getLeftDriveTalonMiddle().getMotorOutputVoltage());
		SmartDashboard.putNumber(Constants.leftDriveFollowerBackName, IO.getLeftDriveTalonRear().getMotorOutputVoltage());

		SmartDashboard.putNumber(Constants.rightDriveMasterName, IO.getRightDriveTalonMaster().getMotorOutputVoltage());
		SmartDashboard.putNumber(Constants.rightDriveFollowerMiddleName, IO.getRightDriveTalonMiddle().getMotorOutputVoltage());
		SmartDashboard.putNumber(Constants.rightDriveFollowerBackName, IO.getRightDriveTalonRear().getMotorOutputVoltage());

		SmartDashboard.putNumber(Constants.elevatorRightName, IO.getElevatorTalonMaster().getMotorOutputVoltage());
		SmartDashboard.putNumber(Constants.elevatorLeftName, IO.getElevatorTalonFollower().getMotorOutputVoltage());

		SmartDashboard.putNumber(Constants.intakeMotorLeftName, IO.getLeftIntakeRollerVictor().getMotorOutputVoltage());
		SmartDashboard.putNumber(Constants.intakeMotorRightName, IO.getRightIntakeRollerVictor().getMotorOutputVoltage());

	}

	private static void initLimitSwitches() {
		SmartDashboard.putBoolean(IO.getTopElevatorLimitSwitch().getName(), IO.getBottomElevatorLimitSwitch().get());
		SmartDashboard.putBoolean(IO.getBottomElevatorLimitSwitch().getName(), IO.getBottomElevatorLimitSwitch().get());

		SmartDashboard.putBoolean(IO.getLeftIntakeLimitSwitch().getName(), IO.getLeftIntakeLimitSwitch().get());
		SmartDashboard.putBoolean(IO.getRightIntakeLimitSwitch().getName(), IO.getRightIntakeLimitSwitch().get());

	}

	@SuppressWarnings("unused")
	private static void initPotentiometer() {
		SmartDashboard.putNumber(Constants.potentiometerName, IO.getPotentiometer().get());
	}

	public static void initEncoders() {
		SmartDashboard.putNumber("Left DT Position", IO.getLeftDriveTalonMaster().getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Right DT Position", IO.getRightDriveTalonMaster().getSelectedSensorPosition(0));
		SmartDashboard.putNumber("First Stage Elevator Position", IO.getElevatorTalonMaster().getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Right Velocity", IO.getRightDriveTalonMaster().getSelectedSensorVelocity(0));
		SmartDashboard.putNumber("Left Velocity", IO.getLeftDriveTalonMaster().getSelectedSensorVelocity(0));
		SmartDashboard.putNumber("First Stage Velocity", IO.getElevatorTalonMaster().getSelectedSensorVelocity(0));
		SmartDashboard.putNumber("Right Error", IO.getRightDriveTalonMaster().getClosedLoopError(0));
		SmartDashboard.putNumber("Left Error", IO.getLeftDriveTalonMaster().getClosedLoopError(0));
		SmartDashboard.putNumber("First Stage Elevator", IO.getElevatorTalonMaster().getClosedLoopError(0));
		SmartDashboard.putNumber("Right Distance", IO.getRightDriveTalonMaster().getSelectedSensorPosition(0) / Constants.ENCODER_TICKS);
		SmartDashboard.putNumber("Left Distance", IO.getLeftDriveTalonMaster().getSelectedSensorPosition(0) / Constants.ENCODER_TICKS);
	}

}
