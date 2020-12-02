package frogger.model;

import javafx.scene.image.Image;

public class Turtle extends Actor{
	Image turtle1;
	Image turtle2;
	Image turtle3;
	Image turtle4;

	protected double speed;
	public Turtle(int xpos, int ypos, double s, int w, int h) {
		initializeTurtles(w, h);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}

	protected void initializeTurtles(int w, int h) {
		turtle1 = new Image("file:src/resources/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/resources/TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image("file:src/resources/TurtleAnimation3.png", w, h, true, true);
	}
	@Override
	public void act(long now) {
		processType(now);
		moveTurtle();
	}

	protected void processType(long now) {
		switch (calculateType(now)) {
			case 0 -> setImage(turtle2);
			case 1 -> setImage(turtle1);
			case 2 -> setImage(turtle3);
			case 3 -> setImage(turtle4);
		}
	}

	protected int calculateType(long now) {
		return (int) (now/900000000 % 4);
	}

	private void moveTurtle() {
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}
}
