package frogger.view;

import frogger.model.*;

public class Level1 extends Level {
    protected void addLogsUp() {
        add(new Log("file:src/main/resources/log3.png", 150, 0, 166, 0.1));
        add(new Log("file:src/main/resources/log3.png", 150, 220, 166, 0.1));
        add(new Log("file:src/main/resources/log3.png", 150, 440, 166, 0.1));
    }

    protected void addLogsMiddle() {
        add(new Log("file:src/main/resources/log3.png", 150, 50, 229, 0.1));
        add(new Log("file:src/main/resources/log3.png", 150, 270, 229, 0.1));
        add(new Log("file:src/main/resources/log3.png", 150, 490, 229, 0.1));

        add(new Log("file:src/main/resources/logs.png", 300, 0, 276, -0.1));
    }

    protected void addLogsBottom() {
        add(new Log("file:src/main/resources/log3.png", 150, 50, 329, 0.1));
        add(new Log("file:src/main/resources/log3.png", 150, 270, 329, 0.1));
        add(new Log("file:src/main/resources/log3.png", 150, 490, 329, 0.1));

        add(new Log("file:src/main/resources/log3.png", 150, 0, 389, 0.1));
        add(new Log("file:src/main/resources/log3.png", 150, 220, 389, 0.1));
        add(new Log("file:src/main/resources/log3.png", 150, 440, 389, 0.1));
    }


    @Override
    protected void addTruck() { }

    @Override
    protected void addCar() { }

    @Override
    protected void addTurtle() { }

    @Override
    protected void addWetTurtle() { }
}
