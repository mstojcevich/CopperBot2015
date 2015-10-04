package org.usfirst.frc.team2586.robot;

import org.usfirst.frc.team2586.robot.commands.*;

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
		
	private final Button closeClawBtn, openClawBtn,
			liftUpBtn, liftDownBtn;
	
	public OI(Robot r) {		
		this.openClawBtn = new JoystickButton(primary, PrimaryJoystick.OPEN_CLAW_BTN);
		this.openClawBtn.whenPressed(new OpenClaw(r.getClaw()));
		
		this.closeClawBtn = new JoystickButton(primary, PrimaryJoystick.CLOSE_CLAW_BTN);
		this.closeClawBtn.whenPressed(new CloseClaw(r.getClaw()));
		
		this.liftUpBtn = new JoystickButton(primary, PrimaryJoystick.LIFT_UP_BTN);
		this.liftUpBtn.whenPressed(new LiftLift(r.getLift()));
		
		this.liftDownBtn = new JoystickButton(primary, PrimaryJoystick.LIFT_DOWN_BTN);
		this.liftDownBtn.whenPressed(new LowerLift(r.getLift()));
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

}
