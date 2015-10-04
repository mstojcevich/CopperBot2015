
package org.usfirst.frc.team2586.robot;

import org.usfirst.frc.team2586.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team2586.robot.subsystems.Claw;
import org.usfirst.frc.team2586.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2586.robot.subsystems.Gyroscope;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * Then entrypoint of the robot. Everything that is called automatically happens
 * here.
 * 
 * Manages the basic subsystems and commands of the robot.
 */
public class Robot extends IterativeRobot {
	
	public static OI oi;

	private static DriveTrain driveTrain;
	private static Claw claw;
	private static Gyroscope gyro;

	private Command autonomousCommand;
	private Command teleopDrive;

	/**
	 * Called when the robot starts up. Initialize stuff here.
	 */
	@Override
	public void robotInit() {
		Robot.oi = new OI(this);
		
		Robot.driveTrain = new DriveTrain();
		Robot.claw = new Claw();

		this.teleopDrive = new DriveWithJoystick(this);
	}

	/**
	 * Called periodically when disabled
	 */
	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * Called when auton starts
	 */
	@Override
	public void autonomousInit() {
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * Called periodically during auton
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * Called when teleop begins
	 */
	@Override
	public void teleopInit() {
		// Stop auton when teleop starts
		if (autonomousCommand != null)
			autonomousCommand.cancel();

		this.teleopDrive.start();
	}

	/**
	 * Called when the disabled button is hit. Used to reset subsystems before
	 * shutting down.
	 */
	@Override
	public void disabledInit() {
		this.teleopDrive.cancel();
	}

	/**
	 * Called periodically during teleop
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * Called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}

	public DriveTrain getDriveTrain() {
		return Robot.driveTrain;
	}
	
	public Claw getClaw() {
		return Robot.claw;
	}
	
	public Gyroscope getGyroscope() {
		return Robot.gyro;
	}

	public OI getControls() {
		return Robot.oi;
	}

}
