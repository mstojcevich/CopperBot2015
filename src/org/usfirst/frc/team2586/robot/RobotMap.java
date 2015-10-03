package org.usfirst.frc.team2586.robot;

/**
 * Contains constants for all of the ports for various things connected to the robot.
 * 
 * This allows for pins to easily be changed without having to change every time its used.
 * It also makes it easier to read and understand which device is being used.
 */
public class RobotMap {
	
	// Control devices
	public static final int 
			JOYSTICK			= 0,
			XBOX_CONTROLLER		= 1;
	
	// Drive talons
	public static final int 
			FRONT_RIGHT_DRIVE	= 0,
			FRONT_LEFT_DRIVE	= 2,
			REAR_RIGHT_DRIVE	= 1,
			REAR_LEFT_DRIVE		= 3;
	
	// Encoders
	public static final int 
			FRONT_RIGHT_ENCODER_A	= 0,
			FRONT_RIGHT_ENCODER_B	= 1,
			FRONT_LEFT_ENCODER_A	= 2,
			FRONT_LEFT_ENCODER_B	= 3,
			BACK_RIGHT_ENCODER_A	= 4,
			BACK_RIGHT_ENCODER_B	= 5,
			BACK_LEFT_ENCODER_A		= 6,
			BACK_LEFT_ENCODER_B		= 7;
	
	
	// Solenoids
	public static final int 
			LIFT_UP_SOLENOID	= 0,
			LIFT_DOWN_SOLENOID	= 1;
	
	// Relays
	public static final int 
			OPEN_CLAW_RELAY		= 1,
			CLOSE_CLAW_RELAY	= 2;
	
}
