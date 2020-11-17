package frogger.model;

import javafx.scene.image.Image;

public class Digit extends Actor{
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Digit(int n, int dim, int x, int y) {
		Image im1 = new Image("file:src/resources/" + n + ".png", dim, dim, true, true);
		setImage(im1);
		setX(x);
		setY(y);
	}
}
