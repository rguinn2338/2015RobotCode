package team.gif.commands;

import team.gif.Globals;
import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author PatrickUbelhor
 */
public class InitDrivetrainAuto extends Command {
	
	private boolean done;

    public InitDrivetrainAuto() {
        requires(Robot.chassis);
        done = false;
    }

    protected void initialize() {
    	Robot.chassis.initBase(Globals.leftEncoderReversed, Globals.rightEncoderReversed,
    	                       Globals.rightMotorReversed, Globals.leftMotorReversed);
    	Robot.chassis.enableAutoControl();
    	done = true;
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
