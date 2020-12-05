package frogger.model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import frogger.view.Level;
import frogger.view.ScoreBoard;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;


/**
 * Test class of ScoreBoard.
 */
@ExtendWith(ApplicationExtension.class)
public class TestScoreBoard {

    /**
     * Initializes test class.
     * @param stage stage
     */
    @Start
    private void start(Stage stage) {
        stage.show();
    }

    /**
     * Tests maxScore works properly.
     * @param robot robot
     */
    @Test
    public void testMaxScore(FxRobot robot) {
        final int targetScore = 500;
        Level level = new Level();
        ScoreBoard scoreBoard = new ScoreBoard(level);
        assertEquals(ScoreBoard.getCurrentScore(), 0);
        scoreBoard.focus();
        scoreBoard.update(targetScore);
        assertEquals(ScoreBoard.getCurrentScore(), targetScore);
    }
}