package org.usfirst.frc.team2586.robot.commands;

/**
 * It's like No-Op, only takes time
 * 
 * Equally as revolutionary in making the world a better place
 */
public class Wait extends TimedCommand {

	public Wait(double duration) {
		super("Wait", duration);
	}

	@Override
	protected void initialize() {}

	@Override
	protected void execute() {}

	@Override
	protected void end() {}

	@Override
	protected void interrupted() {}

}
