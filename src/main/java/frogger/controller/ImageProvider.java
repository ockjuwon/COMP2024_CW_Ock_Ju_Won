package frogger.controller;


import javafx.scene.image.Image;

/**
 * An abstract class consisted of helper methods of Image providing.
 */
public abstract class ImageProvider {
    /**
     * get Image Object using url and image size.
     * @param url String represents url
     * @param imageSize int represents width and height
     * @return image
     */
    public static Image get(String url, int imageSize) {
        return new Image(url, imageSize, imageSize, true, true);
    }
    /**
     * get Image Object using url and image size.
     * @param url String represents url
     * @param width int represents width
     * @param height int represents height
     * @return image
     */
    public static Image get(String url, int width, int height) {
        return new Image(url, width, height, true, true);
    }
}
