package frogger.model;

import javafx.scene.image.Image;


/**
 * A log class which made of wood.
 * Animal can step on.
 */
public class Log extends Actor {

	private double speed;

	/**
	 * it moves.
	 * @param now time
	 */
	@Override
	public void act(long now) {
		move(speed , 0);
		if (getX()>600 && speed>0)
			setX(-180);
		if (getX()<-300 && speed<0)
			setX(700);
	}

	/**
	 * Constructor.
	 * @param imageLink Image url
	 * @param xpos initial x position
	 * @param ypos initial y position
	 * @param s speed
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
		
	}

	/**
	 * @return boolean check is direction left
	 */
	public boolean isDirectionLeft() {
		return speed < 0;
	}

	/**
	 * @return double speed
	 */
	public double getSpeed() {
		return speed;
	}
}
