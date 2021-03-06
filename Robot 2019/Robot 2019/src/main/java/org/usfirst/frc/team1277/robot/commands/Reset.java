/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1277.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1277.robot.OI;
import org.usfirst.frc.team1277.robot.RobotMap;

/**
 * An example command. You can replace me with your own command.
 */
public class Reset extends Command {


	public Reset() {
		// Use requires() here to declare subsystem dependencies
		
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		RobotMap.releaseMotor.set(-0.25);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return !OI.button7.get();
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		RobotMap.releaseMotor.set(0.0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		RobotMap.releaseMotor.set(0.0);
	}
}
