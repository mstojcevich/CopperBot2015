package org.usfirst.frc.team2586.robot.commands;

import org.usfirst.frc.team2586.robot.subsystems.Claw;

public class CloseClaw extends TimedCommand {

	// How long, in seconds, it takes to close the claw
	private static final double DURATION = 2;

	private Claw claw;

	public CloseClaw(Claw claw) {
		super("Close Claw", DURATION);
		
		this.claw = claw;
	}

	@Override
	protected void initialize() {
		this.claw.closeClaw();
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
