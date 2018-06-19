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
		SmartDashboard.putNumber("Elevator Talon Master", IO.getElevatorTalonMaster().getMotorOutputVoltage());
		SmartDashboard.putNumber("Elevator Talon Follower", IO.getElevatorTalonFollower().getMotorOutputVoltage());
	}

	private static void initLimitSwitches() {
		SmartDashboard.putBoolean("Top Elevator Limit Switch", IO.getTopElevatorLimitSwitch().get());
		SmartDashboard.putBoolean("Bottom Elevator Limit Switch", IO.getBottomElevatorLimitSwitch().get());
	}

	public static void initEncoders() {
		SmartDashboard.putNumber("First Stage Elevator Position", IO.getElevatorTalonMaster().getSelectedSensorPosition(0));
		SmartDashboard.putNumber("First Stage Velocity", IO.getElevatorTalonMaster().getSelectedSensorVelocity(0));
		SmartDashboard.putNumber("First Stage Elevator", IO.getElevatorTalonMaster().getClosedLoopError(0));
	}

}