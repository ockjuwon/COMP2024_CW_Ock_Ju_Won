package frogger.model;

import frogger.data.ImageProvider;
import javafx.scene.image.Image;

public class Digit extends Actor{
	@Override
	public void act(long now) {

	}
	
	public Digit(int n, int dim, int x, int y) {
		Image im1 = ImageProvider.get(String.format("file:src/resources/%d.png", n), dim);
		setImage(im1);
		setX(x);
		setY(y);
	}
}
