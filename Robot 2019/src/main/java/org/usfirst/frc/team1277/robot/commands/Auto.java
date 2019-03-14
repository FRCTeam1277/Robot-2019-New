/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1277.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1277.robot.OI;
import org.usfirst.frc.team1277.robot.subsystems.Dashboard;

/**
 * An example command. You can replace me with your own command.
 */
public class Auto extends Command {

	public Auto() {
		// Use requires() here to declare subsystem dependencies

	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Drive.tele();
		OI.POV();
		OI.rumble();
		Dashboard.refresh();
		OI.button1.whileHeld(new Shoot());
		OI.button2.whileHeld(new Pull());
		OI.button3.whenPressed(new Release());
		OI.button4.whenPressed(new GrabHatch());
		OI.button5.whenPressed(new SlowShoot());
		OI.button6.whenPressed(new FullShoot());
		OI.button7.whenPressed(new Reset());
		OI.button8.whenPressed(new Front());
		OI.button12.whenPressed(new ZeroEncoders());
		// Xbox
		// OI.yButton.whenPressed(new Release());
		// OI.menuButton.whenPressed(new Reset());
		// OI.viewButton.whenPressed(new Front());
		// OI.aButton.whenPressed(new GrabHatch());
		// OI.lButton.whenPressed(new PickUpBall());
		// OI.rButton.whenPressed(new AimCargoShip());
		// OI.xButton.whenPressed(new HomeShooter());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
