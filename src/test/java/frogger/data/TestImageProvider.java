package frogger.data;

import frogger.controller.ImageProvider;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Test class of ImageProvider.
 */
@ExtendWith(ApplicationExtension.class)
public class TestImageProvider {

    /**
     * Initializes test class.
     * @param stage stage
     */
    @Start
    private void start(Stage stage) {
        stage.show();
    }

    /**
     * Asserts frogger image is not null.
     * @param robot robot
     */
    @Test
    public void testImage(FxRobot robot) {
        Image image = ImageProvider.get("file:src/main/resources/froggerUp.png", 200);
        assertNotEquals(image, null);
    }
}