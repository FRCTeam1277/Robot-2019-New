/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1277.robot.subsystems;

import org.usfirst.frc.team1277.robot.RobotMap;
import org.usfirst.frc.team1277.robot.commands.Drive;
import org.usfirst.frc.team1277.robot.commands.Front;
import org.usfirst.frc.team1277.robot.commands.GrabHatch;
import org.usfirst.frc.team1277.robot.commands.Release;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class Dashboard {
    public static void refresh() {
        SmartDashboard.putNumber("Speed Cap", Drive.speed);
        SmartDashboard.putString("Front", Front.front);
        SmartDashboard.putNumber("Time", Release.time);
        SmartDashboard.putNumber("Right", DriveTrain.right);
        SmartDashboard.putNumber("Left", DriveTrain.left);
		SmartDashboard.putNumber("Face Encoder", RobotMap.hatchEncoder.getDistance());
        SmartDashboard.putNumber("Shooter Encoder", RobotMap.shooterEncoder.getDistance());
        SmartDashboard.putBoolean("Done Spinning", !GrabHatch.executing);
    }
}
