package org.usfirst.frc.team1277.robot.subsystems;

import org.usfirst.frc.team1277.robot.RobotMap;
import org.usfirst.frc.team1277.robot.commands.GrabHatch;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Hatch extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	private static double HATCH_MOTOR_SPEED = 0.25;

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public static void hatchRight() {
		RobotMap.hatchMotor.set(HATCH_MOTOR_SPEED);
	}

	public static void hatchLeft() {
		RobotMap.hatchMotor.set(-HATCH_MOTOR_SPEED);
	}

	public static void hatchStop() {
		if (!GrabHatch.executing) {
			RobotMap.hatchMotor.set(0.0);
		}
	}

	public static void release() {
		RobotMap.releaseMotor.set(0.5);
	}

	public static void stopRelease() {
		RobotMap.releaseMotor.set(0.0);
	}

	public static void resetRelease(double time) {
		Timer timer = new Timer();
		timer.start();
		while (timer.get() < time) {

		}
		RobotMap.releaseMotor.set(-0.5);
		while (timer.get() < time) {

		}
		RobotMap.releaseMotor.set(0.0);
	}
}
