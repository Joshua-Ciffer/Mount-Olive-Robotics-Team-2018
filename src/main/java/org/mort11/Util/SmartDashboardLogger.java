package org.mort11.Util;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.mort11.Hardware.IO;

/*
* Initializes all the Motors and sensors to the Shuffleboard
*
*
    */
public class SmartDashboardLogger {

    public static void init(){
        initTalonVoltage();
        initLimitSwitches();
    }

    private static void initTalonVoltage(){
        SmartDashboard.putNumber(Constants.leftDriveMasterName, IO.getLeftMaster().getMotorOutputVoltage());
        SmartDashboard.putNumber(Constants.leftDriveFollowerMiddleName, IO.getLeftSlaveMiddle().getMotorOutputVoltage());
        SmartDashboard.putNumber(Constants.leftDriveFollowerBackName, IO.getLeftSlaveBack().getMotorOutputVoltage());

        SmartDashboard.putNumber(Constants.rightDriveMasterName, IO.getRightMaster().getMotorOutputVoltage());
        SmartDashboard.putNumber(Constants.rightDriveFollowerMiddleName, IO.getRightSlaveMiddle().getMotorOutputVoltage());
        SmartDashboard.putNumber(Constants.rightDriveFollowerBackName, IO.getRightSlaveBack().getMotorOutputVoltage());

        SmartDashboard.putNumber(Constants.firstStageElevatorRightName, IO.getFirstStageElevatorTalonMaster().getMotorOutputVoltage());
        SmartDashboard.putNumber(Constants.firstStageElevatorLeftName, IO.getFirstStageElevatorTalonFollower().getMotorOutputVoltage());

        SmartDashboard.putNumber(Constants.secondStageElevatorName, IO.getSecondStageElevatorTalon().getMotorOutputVoltage());

        SmartDashboard.putNumber(Constants.fourbarName, IO.getFourbarTalon().getMotorOutputVoltage());

        SmartDashboard.putNumber(Constants.intakeMotorLeftName, IO.getIntakeRollerVictorLeft().getMotorOutputVoltage());
        SmartDashboard.putNumber(Constants.intakeMotorRightName, IO.getIntakeRollerVictorRight().getMotorOutputVoltage());

    }

    private static void initLimitSwitches(){
        SmartDashboard.putBoolean(IO.getFirstStageElevatorLimitSwitchTop().getName(), IO.getFirstStageElevatorLimitSwitchTop().get());
        SmartDashboard.putBoolean(IO.getFirstStageElevatorLimitSwitchBottom().getName(), IO.getFirstStageElevatorLimitSwitchBottom().get());

        SmartDashboard.putBoolean(IO.getSecondStageElevatorLimitSwitchBottom().getName(), IO.getSecondStageElevatorLimitSwitchBottom().get());
        SmartDashboard.putBoolean(IO.getSecondStageElevatorLimitSwitchTop().getName(), IO.getFirstStageElevatorLimitSwitchTop().get());

        SmartDashboard.putBoolean(IO.getIntakeLimitSwitchLeft().getName(), IO.getIntakeLimitSwitchLeft().get());
        SmartDashboard.putBoolean(IO.getIntakeLimitSwitchRight().getName(), IO.getIntakeLimitSwitchRight().get());

    }

    private static void initPotentiometer() {

        SmartDashboard.putNumber(Constants.potentiometerName, IO.getPotentiometer().get());

    }

}
