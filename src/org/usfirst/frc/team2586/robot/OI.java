package org.usfirst.frc.team2586.robot;

import org.usfirst.frc.team2586.robot.commands.CloseClaw;
import org.usfirst.frc.team2586.robot.commands.OpenClaw;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	private static final float PRIMARY_DEADZONE = 0.1f;

	private final Joystick primary = new Joystick(RobotMap.JOYSTICK),
			secondary = new Joystick(RobotMap.XBOX_CONTROLLER);
		
	private final Button closeClawBtn, openClawBtn;
	
	public OI(Robot r) {		
		this.openClawBtn = new JoystickButton(primary, PrimaryJoystick.OPEN_CLAW_BTN);
		this.openClawBtn.whenPressed(new OpenClaw(r.getClaw()));
		
		this.closeClawBtn = new JoystickButton(primary, PrimaryJoystick.CLOSE_CLAW_BTN);
		this.closeClawBtn.whenPressed(new CloseClaw(r.getClaw()));
	}

	// TODO factor rotate into left and right speeds

	public double getLeftSpeed() {
		return getAxisDeadzoned(primary, PrimaryJoystick.Y_AXIS, PRIMARY_DEADZONE);
	}

	public double getRightSpeed() {
		return getAxisDeadzoned(primary, PrimaryJoystick.Y_AXIS, PRIMARY_DEADZONE);
	}

	/**
	 * Gets the value of an axis on a joystick using a deadzone
	 * 
	 * @param stick Joystick the axis is on
	 * @param axis Axis number on the joystick
	 * @param deadzone Minimum axis value to return non-zero
	 * @return Axis value if >= deadzone, 0 otherwise
	 */
	private double getAxisDeadzoned(Joystick stick, int axis, float deadzone) {
		double value = stick.getRawAxis(axis);

		return Math.abs(value) >= deadzone ? value : 0;
	}

	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
