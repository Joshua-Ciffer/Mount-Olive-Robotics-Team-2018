package org.mort11.util;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.mort11.hardware.IO;

/*
 * Initializes all the Motors and sensors to the Shuffleboard
 *
 *
 */
public class SmartDashboardLogger {

    public static void init() {
        initTalonVoltage();
        initLimitSwitches();
    }

    private static void initTalonVoltage() {
        SmartDashboard.putNumber(Constants.leftDriveMasterName, IO.getLeftMaster().getMotorOutputVoltage());
        SmartDashboard.putNumber(Constants.leftDriveFollowerMiddleName, IO.getLeftSlaveMiddle().getMotorOutputVoltage());
        SmartDashboard.putNumber(Constants.leftDriveFollowerBackName, IO.getLeftSlaveBack().getMotorOutputVoltage());

        SmartDashboard.putNumber(Constants.rightDriveMasterName, IO.getRightMaster().getMotorOutputVoltage());
        SmartDashboard.putNumber(Constants.rightDriveFollowerMiddleName, IO.getRightSlaveMiddle().getMotorOutputVoltage());
        SmartDashboard.putNumber(Constants.rightDriveFollowerBackName, IO.getRightSlaveBack().getMotorOutputVoltage());

        SmartDashboard.putNumber(Constants.elevatorRightName, IO.getElevatorTalonMaster().getMotorOutputVoltage());
        SmartDashboard.putNumber(Constants.elevatorLeftName, IO.getElevatorTalonFollower().getMotorOutputVoltage());

        SmartDashboard.putNumber(Constants.intakeMotorLeftName, IO.getIntakeRollerVictorLeft().getMotorOutputVoltage());
        SmartDashboard.putNumber(Constants.intakeMotorRightName, IO.getIntakeRollerVictorRight().getMotorOutputVoltage());

    }

    private static void initLimitSwitches() {
        SmartDashboard.putBoolean(IO.getFirstStageElevatorLimitSwitchTop().getName(), IO.getFirstStageElevatorLimitSwitchTop().get());
        SmartDashboard.putBoolean(IO.getFirstStageElevatorLimitSwitchBottom().getName(), IO.getFirstStageElevatorLimitSwitchBottom().get());

        SmartDashboard.putBoolean(IO.getIntakeLimitSwitchLeft().getName(), IO.getIntakeLimitSwitchLeft().get());
        SmartDashboard.putBoolean(IO.getIntakeLimitSwitchRight().getName(), IO.getIntakeLimitSwitchRight().get());

    }

    @SuppressWarnings("unused")
    private static void initPotentiometer() {
        SmartDashboard.putNumber(Constants.potentiometerName, IO.getPotentiometer().get());
    }

    public static void initEncoders() {
        SmartDashboard.putNumber("Left DT Position", IO.getLeftMaster().getSelectedSensorPosition(0));
        SmartDashboard.putNumber("Right DT Position", IO.getRightMaster().getSelectedSensorPosition(0));
        SmartDashboard.putNumber("First Stage Elevator Position", IO.getElevatorTalonMaster().getSelectedSensorPosition(0));
        SmartDashboard.putNumber("Right Velocity", IO.getRightMaster().getSelectedSensorVelocity(0));
        SmartDashboard.putNumber("Left Velocity", IO.getLeftMaster().getSelectedSensorVelocity(0));
        SmartDashboard.putNumber("First Stage Velocity", IO.getElevatorTalonMaster().getSelectedSensorVelocity(0));
        SmartDashboard.putNumber("Right Error", IO.getRightMaster().getClosedLoopError(0));
        SmartDashboard.putNumber("Left Error", IO.getLeftMaster().getClosedLoopError(0));
        SmartDashboard.putNumber("First Stage Elevator", IO.getElevatorTalonMaster().getClosedLoopError(0));
        SmartDashboard.putNumber("Right Distance", IO.getRightMaster().getSelectedSensorPosition(0) / Constants.ENCODER_TICKS);
        SmartDashboard.putNumber("Left Distance", IO.getLeftMaster().getSelectedSensorPosition(0) / Constants.ENCODER_TICKS);
    }

}
