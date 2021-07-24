package com.team2073.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.team2073.common.periodic.AsyncPeriodicRunnable;
import com.team2073.robot.ApplicationContext;
import com.team2073.robot.OperatorInterface;
import edu.wpi.first.wpilibj.Solenoid;

public class IntakeSubsystem extends OperatorInterface implements AsyncPeriodicRunnable {
    private final ApplicationContext appCTX = ApplicationContext.getInstance();
    public IntakeSubsystemState currentState = IntakeSubsystemState.STOP;
    private final CANSparkMax intakeMotor = appCTX.getIntakeMotor();
    private Solenoid pistonTop = appCTX.getIntakeSolenoidTop();
    private Solenoid pistonBottom = appCTX.getIntakeSolenoidBottom();
    public IntakeSolenoidState solenoidState = IntakeSolenoidState.STOW;
    @Override
    public void onPeriodicAsync() {
        setOutput(currentState.getPercent());
        switch (solenoidState) {
            case STARTING_CONFIG:
                setPosition(false, false);
            case STOW:
                setPosition(true,false);
            case INTAKE_OUT:
                setPosition(true, true);
        }
    }

    public void setCurrentState(IntakeSubsystemState currentState){
        this.currentState = currentState;
    }


    public void setOutput(Double percent) {
        intakeMotor.set(percent);
    }

    public void setPosition(boolean topPiston, boolean bottomPiston) {
        pistonTop.set(topPiston);
        pistonBottom.set(bottomPiston);
    }

    public void setSolenoidState(IntakeSolenoidState solenoidState) {
        this.solenoidState = solenoidState;
    }
    public enum IntakeSolenoidState {
        STARTING_CONFIG,
        INTAKE_OUT,
        STOW,
    }

    public enum IntakeSubsystemState {
        STOP(0d),
        FORWARD(0.9d),
        BACKWARD(-0.9d);

        private Double percent;

        IntakeSubsystemState(Double percent) {
            this.percent = percent;
        }

        public Double getPercent() {
            return percent;
        }
    }
}
