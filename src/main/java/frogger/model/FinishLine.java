package frogger.model;

import javafx.scene.image.Image;
public class FinishLine extends Actor {
    @Override
    public void act(long now) {

    }

    public FinishLine(String imageLink, int xpos, int ypos, int w, int h) {
        setImage(new Image(imageLink, w,h, true, true));
        setFitWidth(w);
        setFitHeight(h);
        setX(xpos);
        setY(ypos);
    }
}
