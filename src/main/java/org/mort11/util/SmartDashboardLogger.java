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
		SmartDashboard.putNumber("Left Drive Talon Front", IO.getLeftDriveTalonFront().getMotorOutputVoltage());
		SmartDashboard.putNumber("Left Drive Talon Master", IO.getLeftDriveTalonMaster().getMotorOutputVoltage());
		SmartDashboard.putNumber("Left Drive Talon Rear", IO.getLeftDriveTalonRear().getMotorOutputVoltage());

		SmartDashboard.putNumber("Right Drive Talon Front", IO.getRightDriveTalonFront().getMotorOutputVoltage());
		SmartDashboard.putNumber("Right Drive Talon Master", IO.getRightDriveTalonMaster().getMotorOutputVoltage());
		SmartDashboard.putNumber("Right Drive Talon Rear", IO.getRightDriveTalonRear().getMotorOutputVoltage());

		SmartDashboard.putNumber("Elevator Talon Left", IO.getElevatorTalonLeft().getMotorOutputVoltage());
		SmartDashboard.putNumber("Elevator Talon Right", IO.getElevatorTalonRight().getMotorOutputVoltage());

		SmartDashboard.putNumber("Left Intake Roller Victor", IO.getLeftIntakeRollerVictor().getMotorOutputVoltage());
		SmartDashboard.putNumber("Right Intake Roller Victor", IO.getRightIntakeRollerVictor().getMotorOutputVoltage());
	}

	private static void initLimitSwitches() {
		SmartDashboard.putBoolean("Bottom Elevator Limit Switch", IO.getBottomElevatorLimitSwitch().get());
		SmartDashboard.putBoolean("Top Elevator Limit Switch", IO.getTopElevatorLimitSwitch().get());

	}

}