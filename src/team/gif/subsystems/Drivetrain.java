package team.gif.subsystems;

import team.gif.Globals;
import team.gif.RobotMap;
import team.gif.commands.TankDriveLinear;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author PatrickUbelhor
 */
public class Drivetrain extends Subsystem {
    
	private static final CANTalon frontLeft = new CANTalon(RobotMap.frontLeft);
	private static final CANTalon frontRight = new CANTalon(RobotMap.frontRight);
	private static final CANTalon rearLeft = new CANTalon(RobotMap.rearLeft);
	private static final CANTalon rearRight = new CANTalon(RobotMap.rearRight);
	
	public int getLeftTicks() {
		return frontLeft.getEncPosition();
	}
	
	public int getRightTicks() {
		return frontRight.getEncPosition();
	}
	
	public void initBase(boolean leftEncoderReversed, boolean rightEncoderReversed,
						 boolean leftMotorsReversed, boolean rightMotorsReversed) {
		frontLeft.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		frontRight.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		
		rearLeft.changeControlMode(ControlMode.Follower);
		rearRight.changeControlMode(ControlMode.Follower);
		
		frontLeft.reverseSensor(leftEncoderReversed);
		frontRight.reverseSensor(rightEncoderReversed);
		
		frontLeft.reverseOutput(leftMotorsReversed);
		frontRight.reverseOutput(rightMotorsReversed);
	}
	
	public void enableAutoControl() {
		disableMotors();
		
		enableMotors(ControlMode.Position, frontLeft.getEncPosition(), frontRight.getEncPosition());
		
		frontLeft.setPID(Globals.drivetrainP, Globals.drivetrainI, Globals.drivetrainD);
		frontRight.setPID(Globals.drivetrainP, Globals.drivetrainI, Globals.drivetrainD);
	}
	
	public void enableTeleopControl() {
		disableMotors();
		
		enableMotors(ControlMode.PercentVbus, 0.0, 0.0);
	}

	/**
	 * Sets speed on drivetrain motors. If control mode is "kPercentVBus", this is a value from -1 to 1.
	 * If control mode is "kPosition," this is the setpoint of the PID loop.
	 * 
	 * @param leftSet Setpoint for left drive motors (dependent on control mode)
	 * @param rightSet Setpoint for right drive motors (dependent on control mode)
	 */
    public void drive(double leftSet, double rightSet) {
    	frontLeft.set(leftSet);
    	frontRight.set(rightSet);
    	rearLeft.set(RobotMap.frontLeft);
    	rearRight.set(RobotMap.frontRight);
    }
    
    private void enableMotors(ControlMode controlMode, double initLeftSetpoint, double initRightSetpoint) {
		frontLeft.changeControlMode(controlMode);
		frontRight.changeControlMode(controlMode);
		
		drive(initLeftSetpoint, initRightSetpoint);
		
		frontLeft.enableControl();
		frontRight.enableControl();
		rearLeft.enableControl();
		rearRight.enableControl();
	}
    
    private void disableMotors() {
    	if (frontLeft.isControlEnabled()) { // Redundant to make each their own statement; never enabled individually
    		frontLeft.disableControl();
        	frontRight.disableControl();
        	rearLeft.disableControl();
        	rearRight.disableControl();
    	}
    }

    public void initDefaultCommand() {
        setDefaultCommand(new TankDriveLinear());
    }
}

