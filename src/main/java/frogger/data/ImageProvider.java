package frogger.data;


import javafx.scene.image.Image;

public abstract class ImageProvider {
    public static Image get(String url, int imageSize) {
        return new Image(url, imageSize, imageSize, true, true);
    }
}
