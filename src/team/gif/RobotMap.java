package team.gif;
/**
 * This class defines the port number of every sensor and actuator.
 * IT ALLOWS MECHANICAL/ELECTRICAL TO EASILY CHANGE PORT NUMBERS WITHOUT DIGGING THROUGH CODE!
 * DO NOT touch this file if you have not been informed how to properly change the code.
 */
public class RobotMap {
	
	// CAN addresses
    public static final int frontLeft = 0;
    public static final int frontRight = 1;
    public static final int rearLeft = 2;
    public static final int rearRight = 3;
    public static final int collectorLeft = 4;
    public static final int collectorRight = 5;
    public static final int elevator = 6;
    public static final int totePusher = 7;
    public static final int toteGrabber = 8;
    
    // DIO ports
    public static final int leftEncoderA = 0;
    public static final int leftEncoderB = 1;
    public static final int rightEncoderA = 2;
    public static final int rightEncoderB = 3;
    public static final int elevatorA = 4;
    public static final int elevatorB = 5;
    
    // Relay ports (solenoids)
    // Based off the list found here (1/21/15): http://oswegofirst.org/forum/viewtopic.php?f=12&t=2968
    public static final int collectorA = 0;
    public static final int collectorB = 1;
    public static final int leftRCArmA = 2;
    public static final int leftRCArmB = 3;
    public static final int rightRCArmA = 4;
    public static final int rightRCArmB = 5;
    public static final int hooksA = 6;
    public static final int hooksB = 7;
    public static final int chopSticks = 8;
    
    // Analog ports
    public static final int gyroRate = 0; // Gyro MUST be on either 0 or 1
    
}
