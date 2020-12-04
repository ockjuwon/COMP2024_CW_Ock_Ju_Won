package frogger.data;

import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.awt.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(ApplicationExtension.class)
public class TestImageProvider {

    @Start
    private void start(Stage stage) {
        stage.show();
    }

    @Test
    public void testImage(FxRobot robot) {
        Image image = ImageProvider.get("file:src/main/resources/froggerUp.png", 200);
        assertNotEquals(image, null);
    }
}