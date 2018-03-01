package org.mort11.Commands.endeffector.ElevatorCommands.JoystickCommands;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Control.Operator;
import org.mort11.Hardware.HardwareStates;
import org.mort11.Hardware.IO;
import org.mort11.Robot;
import org.mort11.Subsystems.endeffector.FirstStageElevator;
import org.mort11.Util.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;


public class JoystickDriveFirstStageElevator extends Command {

	private double speed;
	private HardwareStates.ElevatorFirstStageState elevatorFirstStageState;
	
    public JoystickDriveFirstStageElevator(double speed) {
        super("JoystickDriveFirstStageElevator");
        requires(Robot.firstStageElevator);
        setInterruptible(true);
        if(speed < 0){
            elevatorFirstStageState = elevatorFirstStageState.TOP;
        }else if(speed > 0){
            elevatorFirstStageState = elevatorFirstStageState.BOTTOM;
        }
    }

    protected void initalize(){
        Robot.firstStageElevator.set(speed);
    }

    @Override
    protected void execute() {
    	
    	System.out.println("Top Lim: " + IO.getFirstStageElevatorLimitSwitchTop().get());
    	System.out.println("Bottom Lim: " + IO.getFirstStageElevatorLimitSwitchBottom().get());
    	
    	Robot.firstStageElevator.set(speed);
//    	
//		if (IO.getFirstStageElevatorLimitSwitchTop().get() == false) {
//			
//			System.out.println("PRESSED");
//			
//			if (speed > Constants.MOTOR_DEADZONE) {
//
//				Robot.firstStageElevator.set(speed);
//				
//				System.out.println("SET SPEED");
//				
//			} else {
//				
//				Robot.firstStageElevator.set(0);
//				
//			}
//
//		} else if (IO.getFirstStageElevatorLimitSwitchBottom().get() == false) {
//			if (speed < -Constants.MOTOR_DEADZONE) {
//				Robot.firstStageElevator.set(-speed);
////				System.out.println("We're inside");
////				IO.getFirstStageElevatorTalonMaster().set(Constants.CONTROL_MODE, -speed);
////				IO.getFirstStageElevatorTalonFollower().set(ControlMode.Follower, Constants.FIRST_STAGE_ELEVATOR_TALON_MASTER);
//
//			}
//
//		} else {
//
//			if ((speed > Constants.MOTOR_DEADZONE) || (speed < -Constants.MOTOR_DEADZONE)) {
//				Robot.firstStageElevator.set(speed);
////				IO.getFirstStageElevatorTalonMaster().set(Constants.CONTROL_MODE, speed);
////				IO.getFirstStageElevatorTalonFollower().set(ControlMode.Follower, Constants.FIRST_STAGE_ELEVATOR_TALON_MASTER);
//
//			}
//
//		}

    }

    @Override
    protected boolean isFinished() { return false;
    }
    
    protected void end() {
    	Robot.firstStageElevator.set(0);
    }

}