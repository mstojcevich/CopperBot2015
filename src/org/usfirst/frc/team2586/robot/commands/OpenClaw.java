package org.usfirst.frc.team2586.robot.commands;

import org.usfirst.frc.team2586.robot.subsystems.Claw;

public class OpenClaw extends TimedCommand {

	// How long, in seconds, it takes to open the claw
	private static final double DURATION = 0.5;

	private Claw claw;

	public OpenClaw(Claw claw) {
		super("Open Claw", DURATION);
		
		this.claw = claw;
	}

	@Override
	protected void initialize() {
		this.claw.openClaw();
	}

	@Override
	protected void execute() {
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
	
}
