package org.usfirst.frc.team1277.robot.subsystems;

import org.usfirst.frc.team1277.robot.RobotMap;


public class DriveTrain {
	public static int front = 1;
	public static double right, left;

	public static void drive(double move, double rotate) {
		double greatestControl, greatestSpeed;
		// Preliminary calculations
		greatestControl = Math.max(Math.abs(move), Math.abs(rotate));
		greatestSpeed = Math.max(Math.abs(-move - rotate), Math.abs(move - rotate));
		// if(greatestSpeed == 0) greatestSpeed = 0.1;

		// Drive the motors
		right = (move + rotate) * greatestControl / greatestSpeed;
		left = (-move + rotate) * greatestControl / greatestSpeed;
		RobotMap.talonRight.set(right);
		RobotMap.talonLeft.set(left);

	}
}
