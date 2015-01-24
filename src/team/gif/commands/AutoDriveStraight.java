package team.gif.commands;

import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author PatrickUbelhor
 * TODO: Split the drivetrain into two parts (right and left). Make two commands,
 * one for controlling each side. Use CommandGroups to synchronize movement.
 */
public class AutoDriveStraight extends Command {
	
	private double setPointDistance;

    public AutoDriveStraight(double setPointDist) {
        requires(Robot.chassis);
        setPointDistance = setPointDist;
    }

    protected void initialize() {
    	Robot.chassis.resetEncoders();
    }

    protected void execute() {
    	Robot.chassis.drive(0.4, 0.4);
    	SmartDashboard.putNumber("Left distance:", Robot.chassis.getLeftDist());
    	SmartDashboard.putNumber("Right distance:", Robot.chassis.getRightDist());
    	SmartDashboard.putNumber("Combined distance", (Robot.chassis.getLeftDist() + Robot.chassis.getRightDist()) / 2);
    }

    protected boolean isFinished() {
        return ((Robot.chassis.getLeftDist() + Robot.chassis.getRightDist()) / 2) > setPointDistance;
    }

    protected void end() {
    	Robot.chassis.drive(0, 0);
    }

    protected void interrupted() {
    }
}
