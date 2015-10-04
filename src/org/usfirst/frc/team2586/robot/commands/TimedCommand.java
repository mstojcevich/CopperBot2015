package org.usfirst.frc.team2586.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public abstract class TimedCommand extends Command {
	
	/**
	 * @param title String identifier for the command
	 * @param duration How long, in seconds, the command takes to complete
	 */
	public TimedCommand(String title, double duration) {
		super(title);
		
		this.setTimeout(duration);
	}
	

	@Override
	protected boolean isFinished() {
		return this.isTimedOut();
	}

}
