package frogger.view;

import frogger.model.*;
public class Level3 extends Level {

    @Override
    protected void addLogsUp() { }

    @Override
    protected void addLogsMiddle() { }

    @Override
    protected void addLogsBottom() { }

    protected void addTruck() { }

    protected void addCar() { }

    protected void addTurtle() {
        add(new Turtle(500, 376, -0.1, 130, 130));
        add(new Turtle(300, 376, -0.1, 130, 130));


        add(new Turtle(0, 166, 0.1, 130, 130));
        add(new Turtle(220, 166, 0.1, 130, 130));
        add(new Turtle(440, 166, 0.1, 130, 130));
        add(new Turtle(150, 166, 0.1, 130, 130));
        add(new Turtle(0, 229, 0.1, 130, 130));
        add(new Turtle(220, 229, 0.1, 130, 130));
        add(new Turtle(440, 229, 0.1, 130, 130));
        add(new Turtle(440, 276, 0.1, 130, 130));
    }

    protected void addWetTurtle() {
        add(new WetTurtle(400, 326, 0.1, 130, 130));
        add(new WetTurtle(700, 326, 0.1, 130, 130));
    }
}
