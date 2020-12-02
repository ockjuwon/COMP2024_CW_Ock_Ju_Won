package frogger.model;

import javafx.scene.image.Image;

public class End extends Actor{
	boolean activated = false;

	@Override
	public void act(long now) { }
	
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/main/resources/End.png", 60, 60, true, true));
	}
	
	public void activate() {
		setImage(new Image("file:src/main/resources/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}
	
	public boolean isActivated() {
		return activated;
	}
	

}
