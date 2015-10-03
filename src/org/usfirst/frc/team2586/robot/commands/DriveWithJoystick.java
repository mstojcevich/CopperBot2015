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
    	this.drivetrain = r.getDriveTrain();
    	this.controls = r.getControls();
        this.requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	this.drivetrain.teleDrive(controls.getLeftSpeed(), controls.getRightSpeed());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; // Don't ever finish because it's a control command and should run all of teleop
    }

    // Called once after isFinished returns true
    protected void end() {
    	this.drivetrain.teleDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.drivetrain.teleDrive(0, 0);
    }
}
