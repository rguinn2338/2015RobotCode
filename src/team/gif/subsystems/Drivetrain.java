package team.gif.subsystems;

import team.gif.Globals;
import team.gif.RobotMap;
import team.gif.commands.TankDriveLinear;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.ControlMode;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Parity;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.SerialPort.StopBits;
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
	
	private static final SerialPort ultraSonic = new SerialPort(9600, Port.kOnboard, 8, Parity.kNone, StopBits.kOne);
	
	public String getUltraDist() {
		byte[] display = ultraSonic.read(4);
    	String disp1 = Byte.toString(display[0]);
    	String disp2 = Byte.toString(display[1]);
    	String disp3 = Byte.toString(display[2]);
    	String disp4 = Byte.toString(display[3]);
    	String combined = disp1 + disp2 + disp3 + disp4;
        return combined;
	}
	
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

