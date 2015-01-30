package team.gif.commands;

import team.gif.Robot;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Armaan
 */
public class InitElevator extends Command {

	private boolean done;
	
    public InitElevator() {
    	requires(Robot.elevator); 
    	done = false;
    }

    protected void initialize() {
    	Robot.elevator.enableMotors(ControlMode.PercentVbus);
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
