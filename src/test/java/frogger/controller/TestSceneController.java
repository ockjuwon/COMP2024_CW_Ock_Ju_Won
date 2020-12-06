package frogger.controller;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class of SceneController.
 */
@ExtendWith(ApplicationExtension.class)
public class TestSceneController {
    private Stage stage;

    /**
     * Initializes test class.
     * @param stage stage
     */
    @Start
    private void start(Stage stage) {
        this.stage = stage;
        stage.show();
    }

    /**
     * Asserts first scene is start.
     * @param robot robot
     */
    @Test
    public void testScene(FxRobot robot) {
        SceneController sceneController = new SceneController(stage);
        assertEquals(sceneController.getCurrentSceneName(), "start");
    }
}