package frogger.data;


import javafx.scene.image.Image;

public abstract class ImageProvider {
    static Image getImage(String url, int imageSize) {
        return new Image(url, imageSize, imageSize, true, true);
    }
}
