package com.team2073.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.team2073.common.periodic.AsyncPeriodicRunnable;
import com.team2073.robot.ApplicationContext;
import com.team2073.robot.OperatorInterface;

public class IntermediateSubsystem extends OperatorInterface implements AsyncPeriodicRunnable {
    private final ApplicationContext appCTX = ApplicationContext.getInstance();
    public IntermediateSubsystemState currentState = IntermediateSubsystemState.STOP;
    private TalonSRX topMotor = appCTX.getBagMotor();
    private CANSparkMax bottomMotor = appCTX.getIntermediateMotor();
    @Override
    public void onPeriodicAsync() {
        setOutput(currentState.getRPM(), currentState.getPercent());
    }
    public void setCurrentState(IntermediateSubsystemState currentState){
        this.currentState = currentState;
    }

    public void setOutput(Double bottomRPM, Double topPercent) {
        topMotor.set(ControlMode.PercentOutput, topPercent);
        bottomMotor.set(bottomRPM);
    }
    public enum IntermediateSubsystemState {
        SHOOT(1100d, .9d),
        IDLE(-60d, 0d),
        STOP(0d, 0d);

        private Double bottomRPM;
        private Double topPercent;

        IntermediateSubsystemState(Double bottomRPM, Double topPercent) {
            this.bottomRPM = bottomRPM;
            this.topPercent = topPercent;
        }
        public Double getPercent() {
            return topPercent;
        }
        public Double getRPM(){
            return bottomRPM;
        }
    }
}
