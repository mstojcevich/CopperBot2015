
package org.usfirst.frc.team2586.robot;

import org.usfirst.frc.team2586.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team2586.robot.commands.NoOp;
import org.usfirst.frc.team2586.robot.commands.auton.CloseAndLift;
import org.usfirst.frc.team2586.robot.subsystems.AxisCamera;
import org.usfirst.frc.team2586.robot.subsystems.Claw;
import org.usfirst.frc.team2586.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2586.robot.subsystems.Gyroscope;
import org.usfirst.frc.team2586.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
	private static Lift lift;
	private static AxisCamera camera;

	private Command teleopDrive;
	private Command autonCommand;
	
	private SendableChooser autonChooser;

	/**
	 * Called when the robot starts up. Initialize stuff here.
	 */
	@Override
	public void robotInit() {
		Robot.oi = new OI(this);
		
		Robot.driveTrain = new DriveTrain();
		Robot.claw = new Claw();
		
		Robot.camera = new AxisCamera();
		camera.startAutoCapture(50);

		this.teleopDrive = new DriveWithJoystick(this);
		
		// Add auton modes to dashboard
		this.autonChooser = new SendableChooser();
		autonChooser.addDefault("Do nothing", new NoOp());
		autonChooser.addObject("Close and lift", new CloseAndLift(this));
		SmartDashboard.putData("Auton Chooser", autonChooser);
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
		this.autonCommand = (Command) autonChooser.getSelected();
		autonCommand.start();
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
		if (autonCommand != null)
			autonCommand.cancel();

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
	
	public Lift getLift() {
		return Robot.lift;
	}

	public OI getControls() {
		return Robot.oi;
	}

}
