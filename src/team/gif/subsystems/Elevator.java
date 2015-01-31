package team.gif.subsystems;

import team.gif.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/** Doin' Elevator Stuff....
 * @author Armaan
 */

public class Elevator extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
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
	
	public void disableMotors() {
		elevator.disableControl();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setSpeed(double speed) {
    	elevator.set(speed);
    }
}
