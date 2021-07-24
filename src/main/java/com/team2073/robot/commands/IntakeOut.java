package com.team2073.robot.commands;

import com.team2073.common.command.AbstractLoggingCommand;
import com.team2073.robot.ApplicationContext;
import com.team2073.robot.subsystems.IntakeSubsystem;

public class IntakeOut extends AbstractLoggingCommand {
    private ApplicationContext appCtx = ApplicationContext.getInstance();
    private IntakeSubsystem intakeSubsystem = appCtx.getIntakeSubsystem();
    @Override
    protected void endDelegate() {
        intakeSubsystem.setSolenoidState(IntakeSubsystem.IntakeSolenoidState.STOW);
    }

    @Override
    protected void initializeDelegate() {
        intakeSubsystem.setSolenoidState(IntakeSubsystem.IntakeSolenoidState.INTAKE_OUT);
    }

    @Override
    protected boolean isFinishedDelegate() {
        return false;
    }
}
