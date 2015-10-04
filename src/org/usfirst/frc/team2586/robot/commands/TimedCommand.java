package org.usfirst.frc.team2586.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public abstract class TimedCommand extends Command {
	
	/**
	 * Duration in seconds of the command
	 */
	private final double duration;
	
	
	/**
	 * @param title String identifier for the command
	 * @param duration How long, in seconds, the command takes to complete
	 */
	public TimedCommand(String title, double duration) {
		super(title);
		
		this.duration = duration;
	}
	

	@Override
	protected boolean isFinished() {
		return this.timeSinceInitialized() > duration;
	}

}
