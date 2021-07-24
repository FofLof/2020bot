package com.team2073.robot.commands;

import com.team2073.common.command.AbstractLoggingCommand;
import com.team2073.robot.ApplicationContext;
import com.team2073.robot.subsystems.IntakeSubsystem;
import com.team2073.robot.subsystems.IntermediateSubsystem;

public class IntermediateGo extends AbstractLoggingCommand {
    private ApplicationContext appCtx = ApplicationContext.getInstance();
    private IntermediateSubsystem intermediateSubsystem = appCtx.getIntermediateSubsystem();
    @Override
    protected void initializeDelegate() {
        intermediateSubsystem.setCurrentState(IntermediateSubsystem.IntermediateSubsystemState.SHOOT);
    }

    @Override
    protected void endDelegate() {
        intermediateSubsystem.setCurrentState(IntermediateSubsystem.IntermediateSubsystemState.IDLE);
    }

    @Override
    protected boolean isFinishedDelegate() {
        return false;
    }
}
