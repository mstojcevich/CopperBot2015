package org.usfirst.frc.team2586.robot.subsystems;

import org.usfirst.frc.team2586.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Claw extends Subsystem {
	
	private Relay openClaw = new Relay(RobotMap.OPEN_CLAW_RELAY);
	private Relay closeClaw = new Relay(RobotMap.CLOSE_CLAW_RELAY);
	
	public Claw() {
		super("Claw");
	}
	
	public void openClaw() {
		closeClaw.set(Relay.Value.kOff);
		openClaw.set(Relay.Value.kForward);
	}
	
	public void closeClaw() {
		openClaw.set(Relay.Value.kOff);
		closeClaw.set(Relay.Value.kForward);
	}

	@Override
	public void initDefaultCommand() {}
	
}

