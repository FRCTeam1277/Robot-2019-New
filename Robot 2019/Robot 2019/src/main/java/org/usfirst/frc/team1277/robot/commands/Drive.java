package org.usfirst.frc.team1277.robot.commands;

import org.usfirst.frc.team1277.robot.OI;
import org.usfirst.frc.team1277.robot.subsystems.DriveTrain;

public class Drive {
	// private static double DEAD_ZONE_TURN = 0.25, DEAD_ZONE_STRAIGHT = 0.15,
	// SPEED_MULT_TURN = 0.8, SPEED_MULT_STRAIGHT = 2, EXP = 3,
	private static double MIN_SPEED = .1;
	private static double MOVE_SPEED = 1.0f, ROTATE_SPEED = 1.0f, CONTROL_EXPONENT_MOVE = 1.0f,
			CONTROL_EXPONENT_ROTATE = 1.5f;
	private static double MOVE_DEADZONE = 0.025f, ROTATE_DEADZONE = 0.1f;
	public static double speed;

	public static double speedCap() {
		speed = (-OI.joystick.getRawAxis(3) + 1) / 2 * (1 - MIN_SPEED) + MIN_SPEED;
		return speed;
	}

	public static void tele() {
		double move, rotate;
		move = -OI.joystick.getRawAxis(1);
		rotate = OI.joystick.getRawAxis(2);

		// Adjust for Move Deadzone
		if (move >= MOVE_DEADZONE)
			move -= MOVE_DEADZONE;
		else if (move <= -MOVE_DEADZONE)
			move += MOVE_DEADZONE;
		else
			move = 0.0f;
		move /= 1.0f - MOVE_DEADZONE;

		// Adjust for Rotate Deadzone
		if (rotate >= ROTATE_DEADZONE)
			rotate -= ROTATE_DEADZONE;
		else if (rotate <= -ROTATE_DEADZONE)
			rotate += ROTATE_DEADZONE;
		else
			rotate = 0.0f;
		rotate /= 1.0f - ROTATE_DEADZONE;

		// Exponential Adjustment
		move *= Math.pow(Math.abs(move), CONTROL_EXPONENT_MOVE - 1.0f);
		rotate *= Math.pow(Math.abs(rotate), CONTROL_EXPONENT_ROTATE - 1.0f);

		// Linear Adjustment for Maximum Speed
		move *= MOVE_SPEED;
		rotate *= ROTATE_SPEED;

		// Throttle for limiting speed
		move *= speedCap();
		rotate *= speedCap();

		move *= DriveTrain.front;

		DriveTrain.drive(move, rotate);
	}
}
