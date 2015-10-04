package org.usfirst.frc.team2586.robot.commands;

import org.usfirst.frc.team2586.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Rotate extends Command {
	
	private final Robot robot;
	private final double amount;
	private final double epsilon;
	
	private double beginHeading;
	
	/**
	 * @param r Robot to rotate
	 * @param amount Amount, in degrees, to rotate
	 * @param epsilon Amount, in degrees, difference from the amount 
	 * 			to turn to consider accurate enough to stop turning
	 */
	public Rotate(Robot r, double amount, double epsilon) {
		this.robot = r;
		
		this.amount = amount;
		this.epsilon = epsilon;
		
		this.requires(r.getDriveTrain());
	}

	@Override
	protected void initialize() {
		this.beginHeading = robot.getGyroscope().getAngle();
	}

	@Override
	protected void execute() {
		boolean direction = (robot.getGyroscope().getAngle() - beginHeading) > amount;
		
		// Turn right if the angle needs to be greater
		// Turn left if the angle needs to be less
		// TODO are we going the right direction?
		robot.getDriveTrain().teleDrive(direction ? -1 : 1, direction ? 1 : -1);
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(robot.getGyroscope().getAngle() - beginHeading - amount) > epsilon;
	}

	@Override
	protected void end() {
		robot.getDriveTrain().teleDrive(0, 0);
	}

	@Override
	protected void interrupted() {}

}
