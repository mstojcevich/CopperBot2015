package org.usfirst.frc.team2586.robot.subsystems;

import org.usfirst.frc.team2586.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Lift extends Subsystem {
	
	private final Solenoid liftUp, liftDown;
	
	/**
	 * Create a lift with the default solenoid channels defined in RobotMap
	 */
	public Lift() {
		this(RobotMap.LIFT_UP_SOLENOID, RobotMap.LIFT_DOWN_SOLENOID);
	}
	
	/**
	 * Creates a lift with the specified solenoid channels
	 * 
	 * @param upChannel solenoid channel to use to raise the lift
	 * @param downChannel solenoid channel to use to lower the lift
	 */
	public Lift(int upChannel, int downChannel) {
		this(new Solenoid(upChannel), new Solenoid(downChannel));
	}
	
	/**
	 * Creates a lift with the specified solenoids
	 * 
	 * @param up solenoid to use to raise the lift
	 * @param down solenoid to use to lower the lift
	 */
	public Lift(Solenoid up, Solenoid down) {
		super("Lift");
		
		this.liftUp = up;
		this.liftDown = down;
	}
	
	/**
	 * Lift the arm up
	 */
	public void liftUp() {
		this.liftDown.set(false);
		this.liftUp.set(true);
	}
	
	/**
	 * Lift the arm down
	 */
	public void liftDown() {
		this.liftUp.set(false);
		this.liftDown.set(true);
	}

	@Override
	protected void initDefaultCommand() {}

}
