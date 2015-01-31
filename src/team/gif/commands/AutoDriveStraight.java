package team.gif.commands;

import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author PatrickUbelhor
 */
public class AutoDriveStraight extends Command {
	
	private double setPointDistance;

    public AutoDriveStraight(double setPointDist) {
        requires(Robot.chassis);
        setPointDistance = setPointDist;
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.chassis.drive(0.4, 0.4);
    	SmartDashboard.putNumber("Left ticks:", Robot.chassis.getLeftTicks());
    	SmartDashboard.putNumber("Right ticks:", Robot.chassis.getRightTicks());
    	SmartDashboard.putNumber("Combined distance", (Robot.chassis.getLeftTicks() + Robot.chassis.getRightTicks()) / 2);
    }

    protected boolean isFinished() {
        return ((Robot.chassis.getLeftTicks() + Robot.chassis.getRightTicks()) / 2) > setPointDistance;
    }

    protected void end() {
    	Robot.chassis.drive(0, 0);
    }

    protected void interrupted() {
    }
}
