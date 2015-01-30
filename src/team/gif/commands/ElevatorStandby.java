package team.gif.commands;

import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Armaan
 */
public class ElevatorStandby extends Command {
	
	double standby;

    public ElevatorStandby(double setpoint) {
    	requires(Robot.elevator);
    	standby = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.setSpeed(0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.elevator.getDist() == 0;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
