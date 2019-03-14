package org.usfirst.frc.team1277.robot.subsystems;

import org.usfirst.frc.team1277.robot.OI;
import org.usfirst.frc.team1277.robot.RobotMap;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

	public static double PUSH_SPEED = 1.0, PULL_SPEED = -1.0, TILT_SPEED_DOWN = 0.4, TILT_SPEED = -0.75;
	public static boolean autoArm = false;

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	public static void xboxShoot()
	{
		// if(!OI.button1.get())
		// {
		// 	RobotMap.shooterMotor.set(-OI.xbox.getTriggerAxis(Hand.kLeft));
		// 	RobotMap.shooterMotor.set(OI.xbox.getTriggerAxis(Hand.kRight));
		// }
	}
	public static void push() {
		RobotMap.shooterMotor.set(PUSH_SPEED);
	}

	public static void pull() {
		RobotMap.shooterMotor.set(PULL_SPEED);
	}

	public static void aimUp() {
		RobotMap.shooterAim.set(TILT_SPEED);
	}

	public static void aimDown() {
		RobotMap.shooterAim.set(TILT_SPEED_DOWN);
	}

	public static void stopShoot() {
		RobotMap.shooterMotor.set(0.0);
	}

	public static void stopAim() {
		if (!autoArm) {
			if (RobotMap.shooterEncoder.getDistance() > 0) {
				RobotMap.shooterAim.set(-0.1);
				if (RobotMap.shooterLimit.get()) {
					RobotMap.shooterAim.set(-0.2);
				}
			} else {
				RobotMap.shooterAim.set(0.0);
			}
		}
	}
}
