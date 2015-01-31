package team.gif.commands;

import team.gif.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Armaan
 */
public class ElevatorLower extends Command {
	
	double minHeight;

    public ElevatorLower(double setpoint) {
      requires(Robot.elevator);
      minHeight = setpoint;
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.elevator.setSpeed(-.2);
    }

    protected boolean isFinished() {
        return false; //Robot.elevator.getDist() < minHeight;
    }

    protected void end() {
    	Robot.elevator.setSpeed(0);
    }

    protected void interrupted() {
    	Robot.elevator.setSpeed(0);
    }
}
