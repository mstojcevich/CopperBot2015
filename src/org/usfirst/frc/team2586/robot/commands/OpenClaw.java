package org.usfirst.frc.team2586.robot.commands;

import org.usfirst.frc.team2586.robot.subsystems.Claw;

import edu.wpi.first.wpilibj.command.Command;

// TODO create TimedCommand abstract superclass to use for all commands with a duration
public class OpenClaw extends Command {

	// How long, in seconds, it takes to open the claw
	private static final double DURATION = 0.5;

	private Claw claw;

	public OpenClaw(Claw claw) {
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
	protected boolean isFinished() {
		return this.timeSinceInitialized() > DURATION;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
	
}
