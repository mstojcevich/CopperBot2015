package org.usfirst.frc.team2586.robot.commands;

import org.usfirst.frc.team2586.robot.subsystems.Lift;

public class LowerLift extends TimedCommand {

	// How long, in seconds, it takes to lower the lift
	private static final double DURATION = 1;

	private Lift lift;

	public LowerLift(Lift lift) {
		super("Lower Lift", DURATION);
		
		this.lift = lift;
	}

	@Override
	protected void initialize() {
		this.lift.liftDown();
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
