package team.gif.commands;

import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Armaan
 */
public class ElevatorRaise extends Command {
	
	double maxHeight; 

    public ElevatorRaise(double setpoint) {
    	requires(Robot.elevator);
    	maxHeight = setpoint;
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.elevator.setSpeed(.2);
    }

    protected boolean isFinished() {
        return false; //Robot.elevator.getDist() > maxHeight;
    }

    protected void end() {
    	Robot.elevator.setSpeed(0);
    }

    protected void interrupted() {
    	Robot.elevator.setSpeed(0);
    }
}
