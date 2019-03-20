/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1277.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static Talon talonRight = new Talon(2);
	public static Talon talonLeft = new Talon(3);
	public static Talon releaseMotor = new Talon(1);
	public static Talon shooterAim = new Talon(9);
	public static Talon shooterMotor = new Talon(0);
	public static Talon hatchMotor = new Talon(8);
	public static Encoder hatchEncoder = new Encoder(3, 4);
	public static Encoder shooterEncoder = new Encoder(1, 2);
	public static DigitalInput shooterLimit = new DigitalInput(0);
	public static DigitalInput releaseLimit = new DigitalInput(5);
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
