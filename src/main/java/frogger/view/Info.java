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
    private static final String IMAGE = "file:src/main/resources/0.png";
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
        backButton.setOnAction((event) -> {
            SceneController.getInstance().changeScene("start");
        });
        getChildren().add(backButton);
    }

}

