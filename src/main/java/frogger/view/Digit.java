package frogger.view;

import frogger.controller.ImageProvider;
import frogger.model.Actor;
import javafx.scene.image.Image;

/**
 * A class represents digit.
 */
public class Digit extends Actor {
	@Override
	public void act(long now) {

	}

	/**
	 * Constructs digit.
	 * @param n digit
	 * @param dim size
	 * @param x x position
	 * @param y y position
	 */
	public Digit(int n, int dim, int x, int y) {
		String format = "file:src/main/resources/" + n + ".png";
		Image im1 = ImageProvider.get(format, dim);
		setImage(im1);
		setVisible(true);
		setX(x);
		setY(y);
	}
}
