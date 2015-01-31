package team.gif;
/**
 * This class defines the port number of every sensor and actuator.
 * IT ALLOWS MECHANICAL/ELECTRICAL TO EASILY CHANGE PORT NUMBERS WITHOUT DIGGING THROUGH CODE!
 * DO NOT touch this file if you have not been informed how to properly change the code.
 */
public class RobotMap {
	
	// CAN addresses
    public static final int frontLeft = 1;
    public static final int frontRight = 2;
    public static final int rearLeft = 3;
    public static final int rearRight = 4;
    public static final int collectorLeft = 5;
    public static final int collectorRight = 6;
    public static final int elevator = 7;
    public static final int totePusher = 8;
    
    // DIO ports
    public static final int elevatorA = 4;
    public static final int elevatorB = 5;
    
    // Relay ports (solenoids)
    public static final int collectorA = 0;
    public static final int collectorB = 1;
    public static final int leftRCarmA = 2;
    public static final int leftRCarmB = 3;
    public static final int rightRCarmA = 4;
    public static final int rightRCarmB = 5;
    public static final int hooksA = 6;
    public static final int hooksB = 7;
    public static final int chopSticksA = 8;
    public static final int chopSticksB = 9;
    
}
