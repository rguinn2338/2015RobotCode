package team.gif.commands;

import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author PatrickUbelhor
 */
public class AutoDrivePID extends Command {

	private double leftSet;
	private double rightSet;
	
    public AutoDrivePID(double leftSetpoint, double rightSetpoint) {
        requires(Robot.chassis);
        leftSet = leftSetpoint;
        rightSet = rightSetpoint;
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.chassis.drive(leftSet, rightSet);
    }

    protected boolean isFinished() {
        return false; // Need to return true at some point
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
