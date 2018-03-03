package org.mort11.Commands.endeffector.IntakeCommands.auton;

import edu.wpi.first.wpilibj.command.TimedCommand;
import org.mort11.Hardware.HardwareStates;
import org.mort11.Robot;

public class RollIntakeTimed extends TimedCommand {
    private double speed;
    private HardwareStates.RollerState rollerState;
    public RollIntakeTimed(double speed, HardwareStates.RollerState request, double timeout){
        super(timeout);
        requires(Robot.intakeRollers);
        setInterruptible(true);
        this.speed = speed;
        this.rollerState = request;
    }

    @Override
    protected void execute(){
        switch (rollerState){
            case IN:
                Robot.intakeRollers.setRollerSpeed(-speed);
                break;

            case OUT:
                Robot.intakeRollers.setRollerSpeed(speed);
                break;

            case STOP:
                Robot.intakeRollers.setRollerSpeed(0);
                break;

            }
        }


        @Override

        protected void end (){

        Robot.intakeRollers.setRollerSpeed(0);

    }

        @Override
        protected void interrupted(){
        end();
        }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
