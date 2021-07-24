package com.team2073.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.team2073.common.periodic.AsyncPeriodicRunnable;
import com.team2073.robot.ApplicationContext;
import com.team2073.robot.OperatorInterface;

public class HopperSubsystem extends OperatorInterface implements AsyncPeriodicRunnable {
    private final ApplicationContext appCTX = ApplicationContext.getInstance();
    private HopperState currentState = HopperState.STOP;
    private static final double MAX_RPM = 11000/149d;


    private CANSparkMax hopperMotor = appCTX.getHopperMotor();

    @Override
    public void onPeriodicAsync() {
        switch (currentState) {
            case STOP:
                setOutput(0d);
            case JAM:
                setOutput(currentState.getRPM());
            case FLIP:

            case IDLE:
                setOutput(currentState.getRPM());
            case SHOOT:

            case PREP_SHOT:
        }
    }
    public void setCurrentState(HopperState currentState){
        this.currentState = currentState;
    }

    public void setOutput(Double rpm) {
        hopperMotor.set(rpm/MAX_RPM);
    }

    public enum HopperState {
        STOP(0),
        IDLE(20d),
        PREP_SHOT(30d),
        SHOOT(35d),
        JAM(0d),
        FLIP(40d);

        public Double rpm;

        HopperState(double rpm) {
            this.rpm = rpm;
        }

        public double getRPM() {
            return rpm;
        }
    }
}
