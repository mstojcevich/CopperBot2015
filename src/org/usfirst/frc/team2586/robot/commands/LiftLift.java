package org.usfirst.frc.team2586.robot.commands;

import org.usfirst.frc.team2586.robot.subsystems.Lift;

public class LiftLift extends TimedCommand {

	// How long, in seconds, it takes to lift the lift
	private static final double DURATION = 1;

	private Lift lift;

	public LiftLift(Lift lift) {
		super("Lift Lift", DURATION);
		
		this.lift = lift;
	}

	@Override
	protected void initialize() {
		this.lift.liftUp();
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
