package frogger.model;

import javafx.scene.image.Image;

/**
 * A class which represents Background Image.
 */
public class BackgroundImage extends Actor{

	@Override
	public void act(long now) {

	}

	/**
	 * Constructor.
	 * set image.
	 * @param imageLink Image url
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 0, true, true));
		
	}

}
