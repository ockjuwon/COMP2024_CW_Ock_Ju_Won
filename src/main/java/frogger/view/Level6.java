package frogger.view;

import frogger.model.*;
import javafx.animation.AnimationTimer;
import javafx.scene.control.Alert;

import java.util.List;

public class Level6 extends World {

    public void act(long now) { }

    private AnimationTimer timer;
    private Animal animal;
    private ScoreBoard scoreBoard;

    public AnimationTimer getTimer() {
        return timer;
    }
//    MyStage backgroundround;

    public Level6() {
        startLevel1();
    }

    private void startLevel1() {

        //Obstacle obstacle = new Obstacle("file:src/p4_group_8_repo/truck1Right.png", 25, 25, 3);
        //Obstacle obstacle1 = new Obstacle("file:src/p4_group_8_repo/truck2Right.png", 100, 100,2 );
        //Obstacle obstacle2 = new Obstacle("file:src/p4_group_8_repo/truck1Right.png",0,  150, 1);

        BackgroundImage froggerBack = new BackgroundImage("file:src/main/resources/iKogsKW.png");
        add(froggerBack);

        scoreBoard = new ScoreBoard(getChildren());

        add(new Log("file:src/main/resources/log3.png", 150, 0, 166, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 220, 166, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 440, 166, 0.75));
        //background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 0, 166, 0.75));
        add(new Log("file:src/main/resources/logs.png", 300, 0, 276, -2));
//        add(new Log("file:src/main/resources/logs.png", 300, 400, 276, -2));
        //background.add(new Log("file:src/p4_group_8_repo/logs.png", 300, 800, 276, -2));
        add(new Log("file:src/main/resources/log3.png", 150, 50, 229, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 270, 229, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 490, 229, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 50, 329, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 270, 329, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 490, 329, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 0, 389, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 220, 389, 0.75));
        add(new Log("file:src/main/resources/log3.png", 150, 440, 389, 0.75));
        add(new FinishLine("file:src/main/resources/logs.png", 0, 100, 300, 30));
        //background.add(new Log("file:src/p4_group_8_repo/log3.png", 150, 570, 329, 0.75));

        add(new Turtle(500, 376, -1, 130, 130));
        add(new Turtle(300, 376, -1, 130, 130));
        add(new WetTurtle(700, 376, -1, 130, 130));
        add(new WetTurtle(600, 217, -1, 130, 130));
        add(new WetTurtle(400, 217, -1, 130, 130));
        add(new WetTurtle(200, 217, -1, 130, 130));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 100, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 0, 100, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 120, -1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 120, -1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 140, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 140, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 160, -1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 300, 160, -1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 180, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 180, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 200, -1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 200, -1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 100, 220, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 200, 220, 1));
        //background.add(new Log("file:src/p4_group_8_repo/log2.png", 400, 220, 1));
//        End end2 = new End();
//        End end3 = new End();
//        End end4 = new End();
//        End end5 = new End();
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
        //background.add(new Obstacle("file:src/p4_group_8_repo/truck1"+"Right.png", 720, 649, 1, 120, 120));
        add(new Obstacle("file:src/main/resources/car1Left.png", 100, 597, -1, 50, 50));
        add(new Obstacle("file:src/main/resources/car1Left.png", 250, 597, -1, 50, 50));
        add(new Obstacle("file:src/main/resources/car1Left.png", 400, 597, -1, 50, 50));
        add(new Obstacle("file:src/main/resources/car1Left.png", 550, 597, -1, 50, 50));
        add(new Obstacle("file:src/main/resources/truck2Right.png", 500, 540, 2, 200, 200));
        add(new Obstacle("file:src/main/resources/car1Left.png", 500, 490, -2, 50, 50));
        add(new Digit(0, 30, 360, 25));
        //background.add(obstacle);
        //background.add(obstacle1);
        //background.add(obstacle2);
        start();
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
                    setNumber(animal.getPoints());
                }
                if (animal.getStop()) {
                    System.out.print("STOPP:");
//                    background.stopMusic();
                    stop();
//                    background.stop();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("You Have Won The Game!");
                    alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
                    alert.setContentText("Highest Possible Score: 800");
                    alert.show();
                }
            }
        };
    }

    public void start() {
//        background.playMusic();
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
//            background.add(new Digit(k, 30, 360 - shift, 25));
            shift+=30;
        }
    }

}
