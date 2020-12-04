package frogger.view;

import frogger.model.*;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;

import java.util.List;

public class Level2 extends Level {

    @Override
    protected void addLogsUp() {
        add(new Log("file:src/main/resources/log3.png", 150, 0, 166, 0.5));
        add(new Log("file:src/main/resources/log3.png", 150, 220, 166, 0.5));
        add(new Log("file:src/main/resources/log3.png", 150, 440, 166, 0.5));
    }

    @Override
    protected void addLogsMiddle() {
        add(new Log("file:src/main/resources/log3.png", 150, 50, 229, 0.5));
        add(new Log("file:src/main/resources/log3.png", 150, 270, 229, 0.5));
        add(new Log("file:src/main/resources/log3.png", 150, 490, 229, 0.5));
        add(new Log("file:src/main/resources/logs.png", 300, 0, 276, -0.5));
    }

    @Override
    protected void addLogsBottom() {
        add(new Log("file:src/main/resources/log3.png", 150, 50, 329, 0.5));
        add(new Log("file:src/main/resources/log3.png", 150, 270, 329, 0.5));
        add(new Log("file:src/main/resources/log3.png", 150, 490, 329, 0.5));
        add(new Log("file:src/main/resources/log3.png", 150, 0, 389, 0.5));
        add(new Log("file:src/main/resources/log3.png", 150, 220, 389, 0.5));
        add(new Log("file:src/main/resources/log3.png", 150, 440, 389, 0.5));
    }

    protected void addTruck() { }

    protected void addCar() { }
}
