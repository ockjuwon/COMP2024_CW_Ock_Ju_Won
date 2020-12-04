package frogger.view;

import frogger.model.*;
import javafx.animation.AnimationTimer;

import java.util.List;

public class Level extends World {

    public void act(long now) { }

    protected AnimationTimer timer;
    protected Animal animal;
    protected ScoreBoard scoreBoard;

    public AnimationTimer getTimer() {
        return timer;
    }

    public Level() {
        startLevel();
    }

    protected void startLevel() {

        BackgroundImage froggerBack = new BackgroundImage("file:src/main/resources/iKogsKW.png");
        add(froggerBack);

        scoreBoard = new ScoreBoard(this);


        addObstacles();
        addLogs();
        addTurtle();
        addWetTurtle();
        addEnd();
        addAnimal();
        start();
    }



    protected void addLogs() {
        addLogsUp();
        addLogsMiddle();
        addLogsBottom();
    }

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

    protected void addTurtle() {
        add(new Turtle(500, 376, -0.1, 130, 130));
        add(new Turtle(300, 376, -0.1, 130, 130));

    }

    protected void addWetTurtle() {
        add(new WetTurtle(700, 376, -0.1, 130, 130));
        add(new WetTurtle(600, 217, -0.1, 130, 130));
        add(new WetTurtle(400, 217, -0.1, 130, 130));
        add(new WetTurtle(200, 217, -0.1, 130, 130));
    }

    protected void addAnimal() {
        animal = new Animal("file:src/main/resources/froggerUp.png", this);
        add(animal);
    }

    protected void addEnd() {
        add(new End(13, 96));
        add(new End(141, 96));
        add(new End(141 + 141 - 13, 96));
        add(new End(141 + 141 - 13 + 141 - 13 + 1, 96));
        add(new End(141 + 141 - 13 + 141 - 13 + 141 - 13 + 3, 96));
    }

    protected void addObstacles() {
        addTruck();
        addCar();
    }

    protected void addTruck() {
        add(new Obstacle("file:src/main/resources/truck1" + "Right.png", 0, 649, 0.1, 120, 120));
        add(new Obstacle("file:src/main/resources/truck1" + "Right.png", 300, 649, 0.1, 120, 120));
        add(new Obstacle("file:src/main/resources/truck1" + "Right.png", 600, 649, 0.1, 120, 120));
        add(new Obstacle("file:src/main/resources/truck2Right.png", 0, 540, 0.1, 200, 200));
        add(new Obstacle("file:src/main/resources/truck2Right.png", 500, 540, 0.1, 200, 200));
    }

    protected void addCar() {
        add(new Obstacle("file:src/main/resources/car1Left.png", 100, 597, -0.1, 50, 50));
        add(new Obstacle("file:src/main/resources/car1Left.png", 250, 597, -0.1, 50, 50));
        add(new Obstacle("file:src/main/resources/car1Left.png", 400, 597, -0.1, 50, 50));
        add(new Obstacle("file:src/main/resources/car1Left.png", 550, 597, -0.1, 50, 50));
        add(new Obstacle("file:src/main/resources/car1Left.png", 500, 490, -0.1, 50, 50));
    }

    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                act(now);
                List<Actor> actors = getObjects(Actor.class);

                for (Actor anActor: actors) {
                    anActor.act(now);
                }

                if (animal.changeScore()) {
                    setNumber(animal.getPoint());
                }
                if (animal.getStop()) {
                    System.out.print("STOPP:");
                    stop();
                }
            }
        };
    }

    public void start() {
        createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }

    public void setNumber(int n) {
        int shift = 0;
        while (n > 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            shift+=30;
        }
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

}
