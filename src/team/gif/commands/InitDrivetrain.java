package team.gif.commands;

import team.gif.Robot;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author PatrickUbelhor
 */
public class InitDrivetrain extends Command {
	
	private boolean done;

    public InitDrivetrain() {
        requires(Robot.chassis);
        done = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassis.enableMotors(ControlMode.PercentVbus);
    	done = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
