package frogger.view;

import frogger.controller.SceneController;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

/**
 * A class shows info.
 */
public class Info extends Pane {

    private static final int infoWidth = 600;
    private static final int infoHeight = 800;
    private static final int INFO_BUTTON_START_X = 205;
    private static final int INFO_BUTTON_START_Y = 500;
    private static final String IMAGE = "file:src/main/resources/info.png";
    private StartButton backButton;

    BackgroundImage infoImage = new BackgroundImage(new Image(IMAGE, infoWidth, infoHeight, false, true),
            BackgroundRepeat.NO_REPEAT, null, BackgroundPosition.DEFAULT, null);

    /**
     * add Background image.
     * make backButton.
     */
    public Info() {
        setPrefSize(infoWidth, infoHeight);
        setBackground(new Background(infoImage));
        backButton = new StartButton("BACK");
        backButton.setLayoutX(INFO_BUTTON_START_X);
        backButton.setLayoutY(INFO_BUTTON_START_Y);
        backButton.setOnAction((event) -> {
            SceneController.getInstance().changeScene("start");
        });
        getChildren().add(backButton);
    }

}

