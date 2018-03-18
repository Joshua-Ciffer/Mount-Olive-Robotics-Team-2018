package org.mort11.commands.auton;

import edu.wpi.first.wpilibj.command.Command;
import org.mort11.Robot;

public class DoNothing extends Command {


    protected void execute() {
        System.out.println("Doing Nothing. You're pretty lazy!");
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {
        Robot.driveTrain.halt();
    }
}
