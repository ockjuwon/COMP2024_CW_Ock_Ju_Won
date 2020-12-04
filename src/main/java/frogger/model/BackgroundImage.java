package frogger.model;

import javafx.scene.image.Image;

public class BackgroundImage extends Actor{

	@Override
	public void act(long now) {

	}
	
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 0, true, true));
		
	}

}
