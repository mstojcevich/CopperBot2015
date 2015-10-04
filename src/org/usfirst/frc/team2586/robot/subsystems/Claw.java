package org.usfirst.frc.team2586.robot.subsystems;

import org.usfirst.frc.team2586.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Claw extends Subsystem {
	
	private final Relay openClaw, closeClaw;
	
	/**
	 * Create a claw using the default relay channels defined in RobotMap
	 */
	public Claw() {
		this(RobotMap.OPEN_CLAW_RELAY, RobotMap.CLOSE_CLAW_RELAY);
	}
	
	/**
	 * Create a claw using the specified relay channels
	 * 
	 * @param openChannel Relay channel used to open the claw
	 * @param closeChannel Relay channel used to close the claw
	 */
	public Claw(int openChannel, int closeChannel) {
		this(new Relay(openChannel), new Relay(closeChannel));
	}
	
	/**
	 * Creates a claw using the specified relays
	 * 
	 * @param open Relay to use to open the claw
	 * @param close Relay to use to close the claw
	 */
	public Claw(Relay open, Relay close) {
		super("Claw");
		
		this.openClaw = open;
		this.closeClaw = close;
	}
	
	/**
	 * Opens the claw
	 */
	public void openClaw() {
		closeClaw.set(Relay.Value.kOff);
		openClaw.set(Relay.Value.kForward);
	}
	
	/**
	 * Closes the claw
	 */
	public void closeClaw() {
		openClaw.set(Relay.Value.kOff);
		closeClaw.set(Relay.Value.kForward);
	}

	@Override
	public void initDefaultCommand() {}
	
}

