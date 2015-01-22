package team.gif.commands;

import team.gif.OI;
import team.gif.Robot;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author PatrickUbelhor
 */
public class TankDrive extends Command {

    public TankDrive() {
        requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassis.enableMotors(ControlMode.PercentVbus); // Make a command to do this at RobotInit
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.chassis.drive(OI.leftStick.getY(), OI.rightStick.getY());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
