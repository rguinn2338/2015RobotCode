package team.gif.commands;

import team.gif.OI;
import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author PatrickUbelhor
 */
public class TankDriveSquared extends Command {

    public TankDriveSquared() {
        requires(Robot.chassis);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.chassis.drive((OI.leftStick.getY() * Math.abs(OI.leftStick.getY())), (OI.rightStick.getY() * Math.abs(OI.rightStick.getY())));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
