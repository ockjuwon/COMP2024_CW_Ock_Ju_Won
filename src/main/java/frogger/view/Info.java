package frogger.view;

import frogger.model.World;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class Info extends Pane {

    private static final int infoWidth = 600;
    private static final int infoHeight = 800;
    private static final String IMAGE = "file:src/main/resources/0.png";

    BackgroundImage infoImage = new BackgroundImage(new Image(IMAGE, infoWidth, infoHeight, false, true),
            BackgroundRepeat.NO_REPEAT, null, BackgroundPosition.DEFAULT, null);
    Pane info;

    public Info() {

        info = new Pane();
        info.setPrefSize(infoWidth, infoHeight);
        info.setBackground(new Background(infoImage));
        getChildren().add(info);

    }

}

