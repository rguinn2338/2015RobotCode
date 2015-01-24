package team.gif.subsystems;

import team.gif.Globals;
import team.gif.RobotMap;
import team.gif.commands.TankDriveLinear;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author PatrickUbelhor
 */
public class Drivetrain extends Subsystem {
    
	private static final CANTalon frontLeft = new CANTalon(RobotMap.frontLeft);
	private static final CANTalon frontRight = new CANTalon(RobotMap.frontRight);
	private static final CANTalon rearLeft = new CANTalon(RobotMap.rearLeft);
	private static final CANTalon rearRight = new CANTalon(RobotMap.rearRight);
	
	private static final Encoder leftEncoder = new Encoder(RobotMap.leftEncoderA, RobotMap.leftEncoderB);
	private static final Encoder rightEncoder = new Encoder(RobotMap.rightEncoderA, RobotMap.rightEncoderB);
	
	public void initEncoders() {
		leftEncoder.setDistancePerPulse(Globals.encoderDistPerTick);
		rightEncoder.setDistancePerPulse(Globals.encoderDistPerTick);
		
		leftEncoder.setReverseDirection(Globals.leftEncoderReversed);
		rightEncoder.setReverseDirection(Globals.rightEncoderReversed);
	}
	
	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	public int getLeftTicks() {
		return leftEncoder.get();
	}
	
	public int getRightTicks() {
		return rightEncoder.get();
	}
	
	public double getLeftDist() {
		return leftEncoder.getDistance();
	}
	
	public double getRightDist() {
		return rightEncoder.getDistance();
	}
	
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
        setDefaultCommand(new TankDriveLinear());
    }
}

