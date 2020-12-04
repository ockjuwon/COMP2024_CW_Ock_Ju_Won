package frogger.model;

import java.util.ArrayList;
import java.util.HashMap;

import frogger.controller.SceneController;
import frogger.data.ImageProvider;
import frogger.view.Level;
import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Animal extends Actor {

	private int firstPoint = ScoreBoard.getInstance().getMaxScore();
	private int point = firstPoint;
	private int end = 0;
	private boolean jumping = false;
	private boolean noMove = false;

	private double movementY = (40.0 / 3.0) * 2;
	private double movementX = (32.0 / 3.0) * 2;

	private int imgSize = 40;
	private boolean carDeath = false;
	private boolean waterDeath = false;
	private boolean changeScore = false;
	private int carD = 0;
	private double w = 800;
	private ScoreBoard scoreBoard = ScoreBoard.getInstance();
	private final int initialLives = 5;
	private int lives = initialLives;
	private Level level;

	enum Key {
		UP,
		LEFT,
		DOWN,
		RIGHT,
	}

	private String[] keyArray = new String[]{"Up", "Left", "Down", "Right"};
	private HashMap<KeyCode, Key> keyMap = new HashMap<>();

	public Animal(String imageLink, Level level) {
		this.level = level;
		setImage(ImageProvider.get(imageLink, imgSize));
		setX(300);
		setY(679.8 + movementY);
		initializeKeyMap();

		setOnKeyPressed(new AnimalKeyPressedListener());
		setOnKeyReleased(new AnimalKeyReleasedListener());
	}

	private void initializeKeyMap() {
		keyMap.put(KeyCode.W, Key.UP);
		keyMap.put(KeyCode.A, Key.LEFT);
		keyMap.put(KeyCode.S, Key.DOWN);
		keyMap.put(KeyCode.D, Key.RIGHT);
	}

	private boolean OOB() {
		return getY() < 0 || getY() > 734;
	}

	private void goDefaultPosition() {
		setX(300);
		setY(679.8 + movementY);
	}

	private boolean intersectLeftBound() {
		return getX() < 0;
	}

	private boolean intersectRightBound() {
		return getX() > 600;
	}

	private void goRight() {
		move(movementX * 2, 0);
	}

	private void goLeft() {
		move(-movementX * 2, 0);
	}

	private void restartLevel() {
		ArrayList<End> ends = (ArrayList<End>) level.getObjects(End.class);

		for(End end : ends) {
			end.deactivate();
			SceneController.getInstance().resetEndCount();
		}
		lives = initialLives;
	}

	private void respawn(long now) {
		String deathCase = carDeath ? "cardeath" : "waterdeath";
		noMove = true;
		if ((now) % 11 == 0) {
			carD++;
		}
		int startDeathCnt = 1;
		int endDeathCnt = 3;
		if (waterDeath) {
			endDeathCnt++;
		}
		if (startDeathCnt <= carD && carD <= endDeathCnt) {
			String formattedUrl = String.format("file:src/main/resources/%s%d.png", deathCase, carD);
			setImage(ImageProvider.get(formattedUrl, imgSize));
		}
		if (carD != endDeathCnt + 1) {
			return;
		}
		carDeath = false;
		waterDeath = false;
		noMove = false;
		carD = 0;
		setX(300);
		setY(679.8 + movementY);
		String url = "file:src/main/resources/froggerUp.png";
		setImage(ImageProvider.get(url, imgSize));
		point = firstPoint;
		changeScore = true;
		changeScore();
		lives--;
		if(lives == 0) {
			restartLevel();
		}
	}

	private void handleInsersectObjects() {
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
			return;
		}
		if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
				return;
			} else {
				move(-1, 0);
			}
		}
		if (getIntersectingObjects(End.class).size() >= 1) {
			End end = getIntersectingObjects(End.class).get(0);
			setX(300);
			setY(679.8 + movementY);
			if(end.isActivated()) {
				return;
			}
			end.activate();
			SceneController.getInstance().touchEnd(this);
			return;
		}
		if(noMove) {
			return;
		}
		if (getIntersectingObjects(Log.class).size() >= 1) {
			Log log = getIntersectingObjects(Log.class).get(0);
			move(log.getSpeed(), 0);
		} else if (getIntersectingObjects(Turtle.class).size() >= 1) {
			move(-1, 0);
		} else if(getY() < 413) {
			waterDeath = true;
			setX(300);
			setY(679.8 + movementY);
		}
	}

	@Override
	public void act(long now) {
		if (OOB()) {
			goDefaultPosition();
		}
		if (intersectLeftBound()) {
			goRight();
		}
		if (intersectRightBound()) {
			goLeft();
		}
		boolean death = carDeath || waterDeath;
		if (death) {
			respawn(now);
		}
		handleInsersectObjects();
	}

	private class AnimalKeyReleasedListener implements EventHandler<KeyEvent> {
		public void handle(KeyEvent event) {
			if (noMove) {
				return;
			}

			KeyCode keyCode = event.getCode();
			Key mappedKey = keyMap.get(keyCode);
			if(mappedKey == null) {
				return;
			}
			Image selectedImage = getMoveImage(mappedKey, false);
			mapMove(mappedKey, movementX, movementY);
			setImage(selectedImage);
			jumping = false;
			if (mappedKey == Key.UP && getY() < w) {
				changeScore = true;
				changeScore();
				w = getY();
				point += 10;
			}
		}
	}

	private class AnimalKeyPressedListener implements EventHandler<KeyEvent> {
		public void handle(KeyEvent event) {
			if (noMove) {
				return;
			}
			KeyCode keyCode = event.getCode();
			Key mappedKey = keyMap.get(keyCode);
			if(mappedKey == null) {
				return;
			}
			Image selectedImage = getMoveImage(mappedKey, jumping);
			mapMove(mappedKey, movementX, movementY);
			setImage(selectedImage);
			jumping = true;
		}
	}

	void mapMove(Key key, double movementX, double movementY) {
		double[] dxArray = new double[]{0, -movementX, 0, movementX};
		double[] dyArray = new double[]{-movementY, 0, movementY, 0};

		double dx = dxArray[key.ordinal()];
		double dy = dyArray[key.ordinal()];

		move(dx, dy);
	}

	public boolean getStop() {
		return end == 5;
	}

	public int getPoint() {
		return point;
	}

	public boolean changeScore() {
		if (changeScore) {
			scoreBoard.update(point);
			changeScore = false;
			return true;
		}
		return false;

	}

	private Image getMoveImage(Key key, boolean isJumping) {
		String move = keyArray[key.ordinal()];
		String jump = isJumping ? "Jump" : "";
		String format = "file:src/main/resources/frogger%s%s.png";
		String formattedUrl = String.format(format, move, jump);
		return ImageProvider.get(formattedUrl, imgSize);
	}
}
