package org.usfirst.frc.team2586.robot.subsystems;

import org.usfirst.frc.team2586.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Controls the drive motors of the robot
 */
public class DriveTrain extends Subsystem {
	
	private final Talon leftRearDriveMotor;
	private final Talon leftFrontDriveMotor;
	private final Talon rightRearDriveMotor;
	private final Talon rightFrontDriveMotor;
	
	private final RobotDrive drive;
	
	public DriveTrain() {
		super("Drive Train");
		
		this.leftRearDriveMotor = new Talon(RobotMap.REAR_LEFT_DRIVE);
		this.leftFrontDriveMotor = new Talon(RobotMap.FRONT_LEFT_DRIVE);
		this.rightRearDriveMotor = new Talon(RobotMap.REAR_RIGHT_DRIVE);
		this.rightFrontDriveMotor = new Talon(RobotMap.FRONT_RIGHT_DRIVE);
		
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
	protected void initDefaultCommand() {
		
	}
}

