package com.team2073.robot.commands;

import com.team2073.common.command.AbstractLoggingCommand;
import com.team2073.robot.ApplicationContext;
import com.team2073.robot.subsystems.ShooterSubsystem;

public class ShootCommand extends AbstractLoggingCommand {
    private ApplicationContext appCtx = ApplicationContext.getInstance();
    private ShooterSubsystem shooterSubsystem = appCtx.getFlywheelSubsystem();
    @Override
    protected void initializeDelegate() {
        shooterSubsystem.setCurrentState(ShooterSubsystem.ShooterState.SHOOT);
    }

    @Override
    protected void endDelegate() {
        shooterSubsystem.setCurrentState(ShooterSubsystem.ShooterState.STOP);
    }

    @Override
    protected boolean isFinishedDelegate() {
        return false;
    }
}
