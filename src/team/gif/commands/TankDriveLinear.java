package team.gif.commands;

import team.gif.OI;
import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author PatrickUbelhor
 */
public class TankDriveLinear extends Command {

    public TankDriveLinear() {
        requires(Robot.chassis);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.chassis.drive(OI.leftStick.getY(), OI.rightStick.getY());
    	SmartDashboard.putString("UltraSonic", Robot.chassis.getUltraDist());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
