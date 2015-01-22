package team.gif.subsystems;

import team.gif.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
    
	private static final CANTalon frontLeft = new CANTalon(RobotMap.frontLeft);
	private static final CANTalon frontRight = new CANTalon(RobotMap.frontRight);
	private static final CANTalon rearLeft = new CANTalon(RobotMap.rearLeft);
	private static final CANTalon rearRight = new CANTalon(RobotMap.rearRight);
	
	public void enableMotors(ControlMode controlMode) {
		frontLeft.changeControlMode(controlMode);
		frontRight.changeControlMode(controlMode);
		rearLeft.changeControlMode(controlMode);
		rearRight.changeControlMode(controlMode);
		
		frontLeft.enableControl();
		frontRight.enableControl();
		rearLeft.enableControl();
		rearRight.enableControl();
	}
	
    public void drive(double leftSpeed, double rightSpeed) {
    	frontLeft.set(leftSpeed);
    	frontRight.set(rightSpeed);
    	rearLeft.set(leftSpeed);
    	rearRight.set(rightSpeed);
    }
    
    public void disableMotors() {
    	frontLeft.disableControl();
    	frontRight.disableControl();
    	rearLeft.disableControl();
    	rearRight.disableControl();
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

