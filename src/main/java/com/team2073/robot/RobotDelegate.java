package com.team2073.robot;
import com.team2073.common.robot.AbstractRobotDelegate;
import com.team2073.robot.subsystems.IntakeSubsystem;
import com.team2073.robot.subsystems.IntermediateSubsystem;

public class RobotDelegate extends AbstractRobotDelegate{
    private ApplicationContext appCtx = ApplicationContext.getInstance();
    private IntermediateSubsystem intermediateSubsystem = appCtx.getIntermediateSubsystem();
    private IntakeSubsystem intakeSubsystem = appCtx.getIntakeSubsystem();

    public RobotDelegate(double period) {
        super(period);
    }

    @Override
    public void robotInit() {
        intermediateSubsystem.setCurrentState(IntermediateSubsystem.IntermediateSubsystemState.IDLE);
        intakeSubsystem.setSolenoidState(IntakeSubsystem.IntakeSolenoidState.STARTING_CONFIG);
        super.robotInit();
    }

    @Override
    public void teleopInit() {
        super.teleopInit();
    }
}
