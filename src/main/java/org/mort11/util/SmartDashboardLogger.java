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
		SmartDashboard.putNumber("Left Drive Talon Master", IO.getLeftDriveTalonMaster().getMotorOutputVoltage());
		SmartDashboard.putNumber("Left Drive Talon Middle", IO.getLeftDriveTalonMiddle().getMotorOutputVoltage());
		SmartDashboard.putNumber("Left Drive Talon Rear", IO.getLeftDriveTalonRear().getMotorOutputVoltage());

		SmartDashboard.putNumber("Right Drive Talon Master", IO.getRightDriveTalonMaster().getMotorOutputVoltage());
		SmartDashboard.putNumber("Right Drive Talon Middle", IO.getRightDriveTalonMiddle().getMotorOutputVoltage());
		SmartDashboard.putNumber("Right Drive Talon Rear", IO.getRightDriveTalonRear().getMotorOutputVoltage());

		SmartDashboard.putNumber("Elevator Talon Master", IO.getElevatorTalonMaster().getMotorOutputVoltage());
		SmartDashboard.putNumber("Elevator Talon Follower", IO.getElevatorTalonFollower().getMotorOutputVoltage());

		SmartDashboard.putNumber("Left Intake Roller Victor", IO.getLeftIntakeRollerVictor().getMotorOutputVoltage());
		SmartDashboard.putNumber("Right Intake Roller Victor", IO.getRightIntakeRollerVictor().getMotorOutputVoltage());
	}

	private static void initLimitSwitches() {
		SmartDashboard.putBoolean("Top Elevator Limit Switch", IO.getTopElevatorLimitSwitch().get());
		SmartDashboard.putBoolean("Bottom Elevator Limit Switch", IO.getBottomElevatorLimitSwitch().get());

		SmartDashboard.putBoolean("Left Intake Limit Switch", IO.getLeftIntakeLimitSwitch().get());
		SmartDashboard.putBoolean("Right Intake Limit Switch", IO.getRightIntakeLimitSwitch().get());
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