package org.usfirst.frc.team2586.robot.commands.auton;

import org.usfirst.frc.team2586.robot.Robot;
import org.usfirst.frc.team2586.robot.commands.CloseClaw;
import org.usfirst.frc.team2586.robot.commands.LiftLift;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CloseAndLift extends CommandGroup {
	
	public CloseAndLift(Robot r) {
		addSequential(new CloseClaw(r.getClaw()));
		addSequential(new LiftLift(r.getLift()));
	}

}
