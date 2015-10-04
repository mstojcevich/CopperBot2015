package org.usfirst.frc.team2586.robot.subsystems;

import org.usfirst.frc.team2586.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Controls the drive motors of the robot
 */
public class DriveTrain extends Subsystem {
	
	// TODO DriveTrainBuilder to deal with the constructor mess?
	
	private final SpeedController 
				leftRearDriveMotor,
				leftFrontDriveMotor,
				rightRearDriveMotor,
				rightFrontDriveMotor;
	
	private final Encoder
				rearLeftEncoder,
				rearRightEncoder,
				frontLeftEncoder,
				frontRightEncoder;
	
	private final RobotDrive drive;
	
	/**
	 * Create a DriveTrain using the default speed controller and encoder channels defined in RobotMap as Talons.
	 */
	public DriveTrain() {
		this(RobotMap.REAR_LEFT_DRIVE, RobotMap.REAR_RIGHT_DRIVE,
				RobotMap.FRONT_LEFT_DRIVE, RobotMap.FRONT_RIGHT_DRIVE,
				RobotMap.BACK_LEFT_ENCODER_A, RobotMap.BACK_RIGHT_ENCODER_A,
				RobotMap.FRONT_LEFT_ENCODER_A, RobotMap.BACK_RIGHT_ENCODER_A);
	}
	
	/**
	 * Create a DriveTrain using the specified speed controller channels using Talons
	 * 
	 * Creates encoders using the encoder channels specified for the A channel and them + 1 for the B channel
	 * 
	 * @param rearLeft Channel for the rear left speed controller
	 * @param rearRight Channel for the rear right speed controller
	 * @param frontLeft Channel for the front left speed controller
	 * @param frontRight Channel for the front right speed controller
	 * 
	 * @param rearLeftEnc Channel for the rear left encoder
	 * @param rearRightEnc Channel for the rear right encoder
	 * @param frontLeftEnc Channel for the front left encoder
	 * @param frontRightEnc Channel for the front right encoder
	 */
	public DriveTrain(int rearLeft, int rearRight, 
			int frontLeft, int frontRight,
			int rearLeftEnc, int rearRightEnc,
			int frontLeftEnc, int frontRightEnc) {
		this(new Talon(rearLeft), new Talon(rearRight), 
				new Talon(frontLeft), new Talon(frontRight),
				new Encoder(rearLeftEnc, rearLeftEnc + 1), new Encoder(rearRightEnc, rearRightEnc + 1),
				new Encoder(frontLeftEnc, frontLeftEnc + 1), new Encoder(frontRightEnc, frontRightEnc + 1));
	}
	
	/**
	 * Create a DriveTrain using the specified speed controller channels using Talons
	 * 
	 * Creates encoders using the encoder channels specified for the first channel and them + 1 for the second channel
	 * 
	 * @param rearLeft Channel for the rear left speed controller
	 * @param rearRight Channel for the rear right speed controller
	 * @param frontLeft Channel for the front left speed controller
	 * @param frontRight Channel for the front right speed controller
	 * 
	 * @param rearLeftEncA Channel for the rear left encoder
	 * @param rearLeftEncB Channel for the rear left encoder
	 * @param rearRightEncA Channel for the rear right encoder
	 * @param rearRightEncB Channel for the rear right encoder
	 * @param frontLeftEncA Channel for the front left encoder
	 * @param frontLeftEncB Channel for the front left encoder
	 * @param frontRightEncA Channel for the front right encoder
	 * @param frontRightEncB Channel for the front right encoder
	 */
	public DriveTrain(int rearLeft, int rearRight, 
			int frontLeft, int frontRight,
			int rearLeftEncA, int rearLeftEncB,
			int rearRightEncA, int rearRightEncB,
			int frontLeftEncA, int frontLeftEncB,
			int frontRightEncA, int frontRightEncB) {
		this(new Talon(rearLeft), new Talon(rearRight), 
				new Talon(frontLeft), new Talon(frontRight),
				new Encoder(rearLeftEncA, rearLeftEncB), new Encoder(rearRightEncA, rearRightEncB),
				new Encoder(frontLeftEncA, frontLeftEncB), new Encoder(frontRightEncA, frontRightEncB));
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
			SpeedController frontLeft, SpeedController frontRight,
			Encoder rearLeftEnc, Encoder rearRightEnc, 
			Encoder frontLeftEnc, Encoder frontRightEnc) {
		super("Drive Train");
		
		this.leftRearDriveMotor = rearLeft;
		this.rightRearDriveMotor = rearRight;
		this.leftFrontDriveMotor = frontLeft;
		this.rightFrontDriveMotor = frontRight;
		
		this.rearLeftEncoder = rearLeftEnc;
		this.rearRightEncoder = rearRightEnc;
		this.frontLeftEncoder = frontLeftEnc;
		this.frontRightEncoder = frontRightEnc;
		
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
	
	public double getLeftDistance() {
		return (rearLeftEncoder.getDistance() + frontLeftEncoder.getDistance()) / 2.0;
	}
	
	public double getRightDistance() {
		return (rearRightEncoder.getDistance() + frontRightEncoder.getDistance()) / 2.0;
	}

	@Override
	protected void initDefaultCommand() {}
	
}

