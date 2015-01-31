package team.gif;

public class Globals {
	
	/**
	 * This file defines the motor speeds used when each subsystem is actuated.
	 * If a value is changed, code must be redeployed.
	 * DO NOT EDIT UNLESS YOU KNOW WHAT YOU ARE DOING. PLEASE CONSULT SOMEONE WHO DOES.
	 */
	
	public static final double collectorSpeed = 0;
	public static final double pusherSpeed = 0;
	
	public static final double encoderDistPerTick = 0.1256;
	public static final boolean leftEncoderReversed = false;
	public static final boolean rightEncoderReversed = false;
	
	public static final boolean leftMotorReversed = false;
	public static final boolean rightMotorReversed = false;
	
	public static final double drivetrainP = 1;
	public static final double drivetrainI = 0;
	public static final double drivetrainD = 0;
}
