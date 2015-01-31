package team.gif.subsystems;

import team.gif.RobotMap;
import team.gif.commands.ElevatorStandby;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/** Doin' Elevator Stuff....
 * @author Armaan
 */

public class Elevator extends Subsystem {
	
	private static final CANTalon elevator = new CANTalon(RobotMap.elevator);
	private static final Encoder height = new Encoder(RobotMap.elevatorA, RobotMap.elevatorB);
	
	public void resetEncoder() {
		height.reset();
	}
	
	public double getDist() {
		return height.get();
	}
	
	public void enableMotors(ControlMode controlMode) {
		elevator.changeControlMode(controlMode);
		
		elevator.enableControl();
	}
	
	public void setSpeed(double speed) {
    	elevator.set(speed);
    }
	
	public void disableMotors() {
		elevator.disableControl();
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new ElevatorStandby());
    }
    
}
