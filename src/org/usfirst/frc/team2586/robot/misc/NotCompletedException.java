package org.usfirst.frc.team2586.robot.misc;

/**
 * Exception thrown when a builder is built but required components are missing
 */
public class NotCompletedException extends Exception {
	
	private static final String REASON_FMT = "Missing required component: %s";

	/**
	 * @param missing The component that was missing
	 */
	public NotCompletedException(String missing) {
		super(String.format(REASON_FMT, missing));
	}

}
