package org.usfirst.frc.team2586.robot.subsystems;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gyroscope extends Subsystem {
	
	private final Gyro gyro;
	
	/**
	 * Create a new gyroscope subsystem with the default channel of 0
	 */
	public Gyroscope() {
		this(0);
	}
	
	public Gyroscope(int id) {
		this.gyro = new Gyro(id);
	}
	
	/**
	 * Get the angle that the robot is facing
	 * 
	 * @return the current heading of the robot in degrees
	 */
	public double getAngle() {
		return this.gyro.getAngle();
	}
	
	/**
	 * Resets the gyro to a heading of 0
	 */
	public void reset() {
		this.gyro.reset();
	}

	@Override
	protected void initDefaultCommand() {}

}
