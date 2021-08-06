package com.team2073.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.team2073.common.command.AbstractLoggingCommand;
import com.team2073.common.periodic.AsyncPeriodicRunnable;
import com.team2073.robot.ApplicationContext;
import com.team2073.robot.OperatorInterface;

public class ShooterSubsystem extends OperatorInterface implements AsyncPeriodicRunnable {
    private final ApplicationContext appCTX = ApplicationContext.getInstance();
    private final TalonSRX shooterMotorOne = appCTX.getShooterMotorOne();
    private final VictorSPX shooterMotorTwo = appCTX.getShooterMotorTwo();
    private final VictorSPX shooterMotorThree = appCTX.getShooterMotorThree();
    public ShooterState currentState = ShooterState.STOP;
    @Override
    public void onPeriodicAsync() {
        setPercentOutput(currentState.getPercentOutput());
    }
    public void setPercentOutput(Double percentOutput) {
        shooterMotorOne.set(ControlMode.PercentOutput, percentOutput);
        shooterMotorTwo.set(ControlMode.PercentOutput, percentOutput);
        shooterMotorThree.set(ControlMode.PercentOutput, percentOutput);
    }
    public void setCurrentState(ShooterSubsystem.ShooterState currentState){
        this.currentState = currentState;
    }
    public enum ShooterState {
        SHOOT(10d),
        STOP(0d);

        Double percentOutput;
        ShooterState(double percentOutput) {
            this.percentOutput = percentOutput;
        }
        public Double getPercentOutput() {
            return percentOutput;
        }
    }
}
