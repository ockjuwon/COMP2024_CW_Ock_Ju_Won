package frogger.view;

import frogger.model.*;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;

import java.util.List;

public class Level5 extends Level {
    @Override
    protected void addLogsUp() {
        add(new Log("file:src/main/resources/log3.png", 150, 0, 166, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 220, 166, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 440, 166, 0.75));
    }

    @Override
    protected void addLogsMiddle() {
        add(new Log("file:src/main/resources/log3.png", 150, 50, 229, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 270, 229, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 490, 229, 0.75));
        add(new Log("file:src/main/resources/logs.png", 300, 0, 276, -2));
    }

    @Override
    protected void addLogsBottom() {
        add(new Log("file:src/main/resources/log3.png", 150, 50, 329, 2));
        add(new Log("file:src/main/resources/log3.png", 150, 270, 329, 2));
        add(new Log("file:src/main/resources/log3.png", 150, 490, 329, 2));
        add(new Log("file:src/main/resources/log3.png", 150, 0, 389, 2));
        add(new Log("file:src/main/resources/log3.png", 150, 220, 389, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 440, 389, 0.75));
    }

    protected void addTruck() {
        add(new Obstacle("file:src/main/resources/truck1" + "Right.png", 0, 649, 1, 120, 120));
        add(new Obstacle("file:src/main/resources/truck1" + "Right.png", 300, 649, 1, 120, 120));
        add(new Obstacle("file:src/main/resources/truck1" + "Right.png", 600, 649, 1, 120, 120));
        add(new Obstacle("file:src/main/resources/truck2Right.png", 0, 540, 1, 200, 200));
        add(new Obstacle("file:src/main/resources/truck2Right.png", 500, 540, 1, 200, 200));
    }

    protected void addCar() {
        add(new Obstacle("file:src/main/resources/car1Left.png", 100, 597, 1, 50, 50));
        add(new Obstacle("file:src/main/resources/car1Left.png", 400, 597, -1, 50, 50));
        add(new Obstacle("file:src/main/resources/car1Left.png", 500, 490, -5, 50, 50));
    }

    @Override
    protected void addTurtle() {
        add(new Turtle(400, 376, 0.2, 60, 60));
        add(new Turtle(300, 356, 0.2, 120, 60));

    }

    @Override
    protected void addWetTurtle() {
        add(new WetTurtle(700, 376, -0.2, 130, 130));
        add(new WetTurtle(600, 597, -0.2, 130, 130));
        add(new WetTurtle(400, 217, -0.2, 130, 130));
        add(new WetTurtle(200, 217, -0.2, 130, 130));
    }
}
