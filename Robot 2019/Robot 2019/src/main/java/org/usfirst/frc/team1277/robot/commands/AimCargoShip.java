/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1277.robot.commands;

import org.usfirst.frc.team1277.robot.RobotMap;
import org.usfirst.frc.team1277.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class AimCargoShip extends Command {
  public AimCargoShip() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  private boolean stop = false;
  private int encoderCount, angle = 75, encoderCountPerRev = 1440;

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    encoderCount = (angle * encoderCountPerRev) / 360;
    Shooter.autoArm = true;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (RobotMap.shooterEncoder.getDistance() < encoderCount) {
      Shooter.aimDown();
    } else {
      Shooter.aimUp();
    }
    stop = Math.abs(RobotMap.shooterEncoder.getDistance()-encoderCount) < 20;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return stop;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Shooter.autoArm = false;
    Shooter.stopAim();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Shooter.autoArm = false;
    Shooter.stopAim();
  }
}
