package org.usfirst.frc.team2586.robot.subsystems;

import org.usfirst.frc.team2586.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Controls the drive motors of the robot
 */
public class DriveTrain extends Subsystem {
	
	private final SpeedController leftRearDriveMotor;
	private final SpeedController leftFrontDriveMotor;
	private final SpeedController rightRearDriveMotor;
	private final SpeedController rightFrontDriveMotor;
	
	private final RobotDrive drive;
	
	/**
	 * Create a DriveTrain using the default speed controller channels defined in RobotMap as Talons.
	 */
	public DriveTrain() {
		this(RobotMap.REAR_LEFT_DRIVE, RobotMap.REAR_RIGHT_DRIVE,
				RobotMap.FRONT_LEFT_DRIVE, RobotMap.FRONT_RIGHT_DRIVE);
	}
	
	/**
	 * Create a DriveTrain using the specified speed controller channels using Talons
	 * 
	 * @param rearLeft Channel for the rear left speed controller
	 * @param rearRight Channel for the rear right speed controller
	 * @param frontLeft Channel for the front left speed controller
	 * @param frontRight Channel for the front right speed controller
	 */
	public DriveTrain(int rearLeft, int rearRight, int frontLeft, int frontRight) {
		this(new Talon(rearLeft), new Talon(rearRight), 
				new Talon(frontLeft), new Talon(frontRight));
	}
	
	/**
	 * Create a DriveTrain using the spcified speed controllers
	 * 
	 * @param rearLeft Rear left speed controller
	 * @param rearRight Rear right speed controller
	 * @param frontLeft Front left speed controller
	 * @param frontRight Front right speed controller
	 */
	public DriveTrain(SpeedController rearLeft, SpeedController rearRight, 
			SpeedController frontLeft, SpeedController frontRight) {
		super("Drive Train");
		
		this.leftRearDriveMotor = rearLeft;
		this.rightRearDriveMotor = rearRight;
		this.leftFrontDriveMotor = frontLeft;
		this.rightFrontDriveMotor = frontRight;
		
		this.drive = new RobotDrive(
				leftFrontDriveMotor, leftRearDriveMotor,
				rightFrontDriveMotor, rightRearDriveMotor
				);
		
		this.drive.setSafetyEnabled(true);
	}
	
	/**
	 * Drive the robot with a left and right speed
	 * @param leftSpeed Number between 0 and 1 representing the speed to drive the left side
	 * @param rightSpeed Number between 0 and 1 representing the speed to drive the right side
	 */
	public void teleDrive(double leftSpeed, double rightSpeed) {
		this.drive.tankDrive(leftSpeed, rightSpeed);
	}

	@Override
	protected void initDefaultCommand() {}
	
}

