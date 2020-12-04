package frogger.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import frogger.view.Level;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.ArrayList;


@ExtendWith(ApplicationExtension.class)
public class TestAnimal {

    @Start
    private void start(Stage stage) {
        stage.show();
    }

    @Test
    public void testFocus(FxRobot robot) {
        Level level = new Level();
        ScoreBoard scoreBoard = new ScoreBoard(level);
        scoreBoard.focus();
        assertEquals(ScoreBoard.getInstance(), scoreBoard);
        ArrayList<Animal> animals = new ArrayList<>();
        for(int i=0;i<4;i++) {
            Animal animal = new Animal("file:src/main/resources/froggerUp.png", level);
            animals.add(animal);
        }
        assertNotEquals(Animal.getInstance(), null);
        animals.get(2).focus();
        assertEquals(Animal.getInstance(), animals.get(2));
    }
}