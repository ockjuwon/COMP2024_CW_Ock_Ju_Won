package frogger.controller;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ApplicationExtension.class)
public class TestSceneController {
    private Stage stage;

    @Start
    private void start(Stage stage) {
        this.stage = stage;
        stage.show();
    }

    @Test
    public void testImage(FxRobot robot) {
        SceneController sceneController = new SceneController(stage);
        assertEquals(sceneController.getCurrentSceneName(), "start");
    }
}