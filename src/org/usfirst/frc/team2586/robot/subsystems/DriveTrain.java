package org.usfirst.frc.team2586.robot.subsystems;

import org.usfirst.frc.team2586.robot.RobotMap;
import org.usfirst.frc.team2586.robot.misc.Builder;
import org.usfirst.frc.team2586.robot.misc.NotCompletedException;

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
	 * 
	 * If you want to be more specific and use non-defaults, use DriveTrain.DriveTrainBuilder
	 */
	public DriveTrain() {
		this(
				new Talon(RobotMap.REAR_LEFT_DRIVE), new Talon(RobotMap.REAR_RIGHT_DRIVE),
				new Talon(RobotMap.FRONT_LEFT_DRIVE), new Talon(RobotMap.FRONT_RIGHT_DRIVE),
				new Encoder(RobotMap.BACK_LEFT_ENCODER_A, RobotMap.BACK_LEFT_ENCODER_B), 
				new Encoder(RobotMap.BACK_RIGHT_ENCODER_A, RobotMap.BACK_RIGHT_ENCODER_B),
				new Encoder(RobotMap.FRONT_LEFT_ENCODER_A, RobotMap.FRONT_LEFT_ENCODER_B), 
				new Encoder(RobotMap.FRONT_RIGHT_ENCODER_A, RobotMap.FRONT_RIGHT_ENCODER_B)
				);
	}
	
	/**
	 * Create a DriveTrain using the spcified speed controllers
	 * 
	 * @param rearLeft Rear left speed controller
	 * @param rearRight Rear right speed controller
	 * @param frontLeft Front left speed controller
	 * @param frontRight Front right speed controller
	 * 
	 * @param rearLeftEnc Rear left encoder
	 * @param rearRightEnc Rear right encoder
	 * @param frontLeftEnc Front left encoder
	 * @param frontRightEnc Front right encoder
	 */
	private DriveTrain(SpeedController rearLeft, SpeedController rearRight, 
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
	
	public static class DriveTrainBuilder implements Builder<DriveTrain> {

		private SpeedController 
				rearLeftSC,
				rearRightSC,
				frontLeftSC,
				frontRightSC;

		private Encoder
				rearLeftEnc,
				rearRightEnc,
				frontLeftEnc,
				frontRightEnc;
		
		@Override
		public DriveTrain build() throws NotCompletedException {
			// Make sure all speed controllers were set
			if(rearLeftSC == null)
				throw new NotCompletedException("Rear-left speed controller");
			if(rearRightSC == null)
				throw new NotCompletedException("Rear-right speed controller");
			if(frontLeftSC == null)
				throw new NotCompletedException("Front-left speed controller");
			if(frontRightSC == null)
				throw new NotCompletedException("Front-right speed controller");
			
			// Make sure all encoders were set
			if(rearLeftEnc == null)
				throw new NotCompletedException("Rear-left encoder");
			if(rearRightEnc == null)
				throw new NotCompletedException("Rear-right encoder");
			if(frontLeftEnc == null)
				throw new NotCompletedException("Front-left encoder");
			if(frontRightEnc == null)
				throw new NotCompletedException("Front-right encoder");
			
			return new DriveTrain(
					rearLeftSC, rearRightSC, frontLeftSC, frontRightSC,
					rearLeftEnc, rearRightEnc, frontLeftEnc, frontRightEnc
					);
		}
		
		public DriveTrainBuilder setFrontLeftSC(SpeedController sc) {
			this.frontLeftSC = sc;
			return this;
		}
		
		public DriveTrainBuilder setFrontRightSC(SpeedController sc) {
			this.frontRightSC = sc;
			return this;
		}
		
		public DriveTrainBuilder setRearLeftSC(SpeedController sc) {
			this.rearLeftSC = sc;
			return this;
		}
		
		public DriveTrainBuilder setRearRightSC(SpeedController sc) {
			this.rearRightSC = sc;
			return this;
		}
		
		public DriveTrainBuilder setFrontLeftEnc(Encoder e) {
			this.frontLeftEnc = e;
			return this;
		}
		
		public DriveTrainBuilder setFrontRightEnc(Encoder e) {
			this.frontRightEnc = e;
			return this;
		}
		
		public DriveTrainBuilder setRearLeftEnc(Encoder e) {
			this.rearLeftEnc = e;
			return this;
		}
		
		public DriveTrainBuilder setRearRightEnc(Encoder e) {
			this.rearRightEnc = e;
			return this;
		}
		
	}
	
}

