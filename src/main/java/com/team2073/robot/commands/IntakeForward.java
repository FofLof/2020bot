package com.team2073.robot.commands;

import com.team2073.common.command.AbstractLoggingCommand;
import com.team2073.robot.ApplicationContext;
import com.team2073.robot.subsystems.IntakeSubsystem;

public class IntakeForward extends AbstractLoggingCommand {
    private ApplicationContext appCtx = ApplicationContext.getInstance();
    private IntakeSubsystem intakeSubsystem = appCtx.getIntakeSubsystem();

    @Override
    protected void initializeDelegate() {
        intakeSubsystem.setCurrentState(IntakeSubsystem.IntakeSubsystemState.FORWARD);
    }

    @Override
    protected void endDelegate() {
        intakeSubsystem.setCurrentState(IntakeSubsystem.IntakeSubsystemState.STOP);
    }

    @Override
    protected boolean isFinishedDelegate() {
        return false;
    }
}

