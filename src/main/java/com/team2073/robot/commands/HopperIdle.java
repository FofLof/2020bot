package com.team2073.robot.commands;

import com.team2073.common.command.AbstractLoggingCommand;
import com.team2073.robot.ApplicationContext;
import com.team2073.robot.subsystems.HopperSubsystem;

public class HopperIdle extends AbstractLoggingCommand {
    private ApplicationContext appCTX = ApplicationContext.getInstance();
    private HopperSubsystem hopperSubsystem = appCTX.getHopperSubsystem();
    @Override
    protected void initializeDelegate() {
        hopperSubsystem.setCurrentState(HopperSubsystem.HopperState.IDLE);
    }

    @Override
    protected boolean isFinishedDelegate() {
        return false;
    }
}
