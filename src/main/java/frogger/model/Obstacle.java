package frogger.model;

import javafx.scene.image.Image;


/**
 * An Obstacle.
 * inherits Actor.
 */
public class Obstacle extends Actor {
	private double speed;

	/**
	 * it moves.
	 * @param now time
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -50 && speed<0)
			setX(600);
	}


	/**
	 * Constructor.
	 * @param imageLink Image url
	 * @param xpos initial x position
	 * @param ypos initial y position
	 * @param s speed
	 * @param w width
	 * @param h height
	 */
	public Obstacle(String imageLink, int xpos, int ypos, double s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

}
