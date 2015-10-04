package org.usfirst.frc.team2586.robot.commands;

import org.usfirst.frc.team2586.robot.OI;
import org.usfirst.frc.team2586.robot.Robot;
import org.usfirst.frc.team2586.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Drive the robot using the joystick
 */
public class DriveWithJoystick extends Command {

	private final DriveTrain drivetrain;
	private final OI controls;

	public DriveWithJoystick(Robot r) {
		super("Drive with joystick");
		
		this.drivetrain = r.getDriveTrain();
		this.controls = r.getControls();
		this.requires(drivetrain);
	}

	// Called just before the Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called periodically
	@Override
	protected void execute() {
		this.drivetrain.teleDrive(controls.getLeftSpeed(), controls.getRightSpeed());
	}

	// Called to check if the command is finished
	@Override
	protected boolean isFinished() {
		// Don't ever finish because it's a control command and should run all of teleop
		return false;
	}

	// Called after the command finishes
	@Override
	protected void end() {
		this.drivetrain.teleDrive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		this.drivetrain.teleDrive(0, 0);
	}
}
