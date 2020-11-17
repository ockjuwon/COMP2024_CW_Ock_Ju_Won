package frogger.view;

import frogger.model.World;
import javafx.scene.image.ImageView;

public class Info extends World {

    private final static String infoURL = "file:src/resources/green_button10.png";

    public Info() {
        ImageView infoView = new ImageView(infoURL);
        infoView.getImage();
    }

    @Override
    public void act(long now) {

    }


}
