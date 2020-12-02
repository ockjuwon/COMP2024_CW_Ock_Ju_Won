package frogger.view;

import frogger.model.*;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;

import java.util.List;

public class Level2 extends Level {

    @Override
    protected void startLevel() {


        BackgroundImage froggerBack = new BackgroundImage("file:src/main/resources/iKogsKW.png");
        add(froggerBack);

        scoreBoard = new ScoreBoard(getChildren());

        add(new Log("file:src/main/resources/log3.png", 150, 0, 166, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 220, 166, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 440, 166, 0.75));
        add(new Log("file:src/main/resources/logs.png", 300, 0, 276, -2));
        add(new Log("file:src/main/resources/log3.png", 150, 50, 229, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 270, 229, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 490, 229, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 50, 329, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 270, 329, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 490, 329, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 0, 389, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 220, 389, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 440, 389, 0.75));

        add(new Turtle(500, 376, -1, 130, 130));
        add(new Turtle(300, 376, -1, 130, 130));
        add(new WetTurtle(700, 376, -1, 130, 130));
        add(new WetTurtle(600, 217, -1, 130, 130));
        add(new WetTurtle(400, 217, -1, 130, 130));
        add(new WetTurtle(200, 217, -1, 130, 130));

        add(new End(13, 96));
        add(new End(141, 96));
        add(new End(141 + 141 - 13, 96));
        add(new End(141 + 141 - 13 + 141 - 13 + 1, 96));
        add(new End(141 + 141 - 13 + 141 - 13 + 141 - 13 + 3, 96));
        animal = new Animal("file:src/main/resources/froggerUp.png");
        add(animal);
        add(new Obstacle("file:src/main/resources/truck1" + "Right.png", 0, 649, 1, 120, 120));
        add(new Obstacle("file:src/main/resources/truck1" + "Right.png", 300, 649, 1, 120, 120));
        add(new Obstacle("file:src/main/resources/truck1" + "Right.png", 600, 649, 1, 120, 120));
        add(new Obstacle("file:src/main/resources/car1Left.png", 100, 597, -1, 50, 50));
        add(new Obstacle("file:src/main/resources/car1Left.png", 250, 597, -1, 50, 50));
        add(new Obstacle("file:src/main/resources/car1Left.png", 400, 597, -1, 50, 50));
        add(new Obstacle("file:src/main/resources/car1Left.png", 550, 597, -1, 50, 50));
        add(new Obstacle("file:src/main/resources/truck2Right.png", 0, 540, 1, 200, 200));
        add(new Obstacle("file:src/main/resources/truck2Right.png", 500, 540, 1, 200, 200));
        add(new Obstacle("file:src/main/resources/car1Left.png", 500, 490, -5, 50, 50));
        add(new Digit(0, 30, 360, 25));

        start();
    }
}
