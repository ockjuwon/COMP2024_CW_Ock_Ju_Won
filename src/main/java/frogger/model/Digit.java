package frogger.model;

import frogger.data.ImageProvider;
import javafx.scene.image.Image;

public class Digit extends Actor{
	@Override
	public void act(long now) {

	}
	
	public Digit(int n, int dim, int x, int y) {
		String format = "file:src/main/resources/" + n + ".png";
		Image im1 = ImageProvider.get(format, dim);
		setImage(im1);
		setVisible(true);
		setX(x);
		setY(y);
	}
}
