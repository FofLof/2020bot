package com.team2073.robot;

import com.team2073.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OperatorInterface {

    private final ApplicationContext appCTX = ApplicationContext.getInstance();
    public final Joystick controller =  appCTX.getController();
    private final Joystick driveStick = appCTX.getDriveStick();
    private JoystickButton a = new JoystickButton(controller, 1);
    private JoystickButton x = new JoystickButton(controller, 3);
    private JoystickButton b = new JoystickButton(controller, 2);
    private JoystickButton y = new JoystickButton(controller, 4);
    private JoystickButton lb = new JoystickButton(controller, 5);
    private JoystickButton rb = new JoystickButton(controller, 6);

    public void init() {
        a.whileHeld(new IntakeForward());
        x.whileHeld(new IntakeBackward());
        b.toggleWhenPressed(new IntakeOut());
        y.whileHeld(new IntermediateGo());
        lb.whenPressed(new HopperStop());
        rb.whenActive(new HopperIdle());
    }

}
