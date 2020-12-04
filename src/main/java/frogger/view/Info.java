package frogger.view;

import frogger.controller.SceneController;
import frogger.model.Animal;
import frogger.model.StartButton;
import frogger.model.World;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;

public class Info extends Pane {

    private static final int infoWidth = 600;
    private static final int infoHeight = 800;
    private static final String IMAGE = "file:src/main/resources/0.png";
    private StartButton backButton;

    BackgroundImage infoImage = new BackgroundImage(new Image(IMAGE, infoWidth, infoHeight, false, true),
            BackgroundRepeat.NO_REPEAT, null, BackgroundPosition.DEFAULT, null);

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

