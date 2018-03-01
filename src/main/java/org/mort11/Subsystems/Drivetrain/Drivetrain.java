package org.mort11.Subsystems.Drivetrain;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.mort11.Hardware.HardwareStates;
import org.mort11.Hardware.IO;
import org.mort11.Commands.Drivetrain.JoystickDrive;
import org.mort11.Util.Constants;

/**
 * @version 01/28/2018
 */
public class Drivetrain extends Subsystem {

    public Drivetrain() {
        super("Drivetrain");
    }


    /**
     * Set left drivetrain motor speed
     *
     * @param speed
     */
    public void setLeftDriveSpeed(double speed) {
        IO.getLeftMaster().set(IO.getLeftMaster().getControlMode(), -speed);
        IO.getLeftSlaveMiddle().set(Constants.FOLLOWER, Constants.DRIVETRAIN_LEFT_MASTER);
        IO.getLeftSlaveBack().set(Constants.FOLLOWER, Constants.DRIVETRAIN_LEFT_MASTER);
    }

    /**
     * Set right drivetrain motor speed
     * @param speed
     */
    public void setRightDriveSpeed(double speed) {
        IO.getRightMaster().set(Constants.CONTROL_MODE, speed);
        IO.getRightSlaveMiddle().set(Constants.FOLLOWER, Constants.DRIVETRAIN_RIGHT_MASTER);
        IO.getRightSlaveBack().set(Constants.FOLLOWER, Constants.DRIVETRAIN_RIGHT_MASTER);
    }

    /**
     * Shift gear
     * @param gear
     */
    public void shift(HardwareStates.Gear gear) {
        if (gear.equals(HardwareStates.Gear.HIGH)) {
            IO.getTransmission().set(DoubleSolenoid.Value.kForward);
        }

        if (gear.equals(HardwareStates.Gear.LOW)) {
            IO.getTransmission().set(DoubleSolenoid.Value.kReverse);
        }
    }

    public void setBothSides(double speed){
        setLeftDriveSpeed(speed);
        setRightDriveSpeed(speed);
        System.out.println("They are fighting");

    }
    
    public void halt (){
        setLeftDriveSpeed(0);
        setRightDriveSpeed(0);
    }

    /**
     * Default command - calls JoystickDrive
     */
    protected void initDefaultCommand() {
        setDefaultCommand(new JoystickDrive());
    }



}