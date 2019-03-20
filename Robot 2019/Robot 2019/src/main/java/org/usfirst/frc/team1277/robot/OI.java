/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1277.robot;

import org.usfirst.frc.team1277.robot.commands.Front;
import org.usfirst.frc.team1277.robot.commands.FullShoot;
import org.usfirst.frc.team1277.robot.commands.GrabHatch;
import org.usfirst.frc.team1277.robot.commands.HomeShooter;
import org.usfirst.frc.team1277.robot.commands.PickUpBall;
import org.usfirst.frc.team1277.robot.commands.Pull;
import org.usfirst.frc.team1277.robot.commands.Release;
import org.usfirst.frc.team1277.robot.commands.Reset;
import org.usfirst.frc.team1277.robot.commands.Shoot;
import org.usfirst.frc.team1277.robot.commands.SlowShoot;
import org.usfirst.frc.team1277.robot.commands.ZeroEncoders;
import org.usfirst.frc.team1277.robot.commands.AimCargoShip;
import org.usfirst.frc.team1277.robot.subsystems.Hatch;
import org.usfirst.frc.team1277.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	public static Joystick joystick = new Joystick(0);
	public static Button button0 = new JoystickButton(joystick, 0);
	public static Button button1 = new JoystickButton(joystick, 1);
	public static Button button2 = new JoystickButton(joystick, 2);
	public static Button button3 = new JoystickButton(joystick, 3);
	public static Button button4 = new JoystickButton(joystick, 4);
	public static Button button5 = new JoystickButton(joystick, 5);
	public static Button button6 = new JoystickButton(joystick, 6);
	public static Button button7 = new JoystickButton(joystick, 7);
	public static Button button8 = new JoystickButton(joystick, 8);
	public static Button button9 = new JoystickButton(joystick, 9);
	public static Button button10 = new JoystickButton(joystick, 10);
	public static Button button11 = new JoystickButton(joystick, 11);
	public static Button button12 = new JoystickButton(joystick, 12);

	public OI() {
		// Joystick
		button1.whileHeld(new Shoot());
		button2.whileHeld(new Pull());
		button3.whenPressed(new Release());
		button4.whenPressed(new GrabHatch());
		button5.whenPressed(new SlowShoot());
		button6.whenPressed(new FullShoot());
		button7.whenPressed(new Reset());
		button8.whenPressed(new Front());
		button9.whenPressed(new PickUpBall());
		button12.whenPressed(new ZeroEncoders());

	}

	public static void POV() {
		if (joystick.getPOV() == 0) {
			Shooter.aimUp();
		}
		if (joystick.getPOV() == 180) {
			Shooter.aimDown();
		}
		if (OI.joystick.getPOV() == 90) {
			Hatch.hatchRight();
		}
		if (joystick.getPOV() == 270) {
			Hatch.hatchLeft();
		}
		if (joystick.getPOV() == -1) {
			Shooter.stopAim();
			Hatch.hatchStop();
		}
	}
}
