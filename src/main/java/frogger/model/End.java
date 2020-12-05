package frogger.model;

import javafx.scene.image.Image;

public class End extends Actor{
	boolean activated = false;


	/**
	 * it does nothing.
	 */
	@Override
	public void act(long now) { }


	/**
	 * Constructor.
	 * set images.
	 * @param x initial x position
	 * @param y initial y position
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/main/resources/End.png", 60, 60, true, true));
	}


	/**
	 * activates object.
	 */
	public void activate() {
		setImage(new Image("file:src/main/resources/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}

	/**
	 * deactivates object.
	 */
	public void deactivate() {
		setImage(new Image("file:src/main/resources/End.png", 60, 60, true, true));
		activated = false;
	}
	
	public boolean isActivated() {
		return activated;
	}

}
