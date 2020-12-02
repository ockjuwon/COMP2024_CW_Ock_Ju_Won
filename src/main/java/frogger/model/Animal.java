package frogger.model;

import java.util.ArrayList;
import java.util.HashMap;

import frogger.controller.SceneController;
import frogger.data.ImageProvider;
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
	private boolean stop = false;
	private boolean changeScore = false;
	private int carD = 0;
	private double w = 800;
	private ScoreBoard scoreBoard = ScoreBoard.getInstance();

	enum Key {
		UP,
		LEFT,
		DOWN,
		RIGHT,
	}

	private String[] keyArray = new String[]{"Up", "Left", "Down", "Right"};
	private HashMap<KeyCode, Key> keyMap = new HashMap<>();

	ArrayList<End> inter = new ArrayList<>();

	public Animal(String imageLink) {

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

	@Override
	public void act(long now) {
		if (getY() < 0 || getY() > 734) {
			setX(300);
			setY(679.8 + movementY);
		}
		if (getX() < 0) {
			move(movementY * 2, 0);
		}
		boolean death = carDeath || waterDeath;
		if (death) {
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
			if (carD == endDeathCnt + 1) {
				if (carDeath) {
					carDeath = false;
				} else if (waterDeath) {
					waterDeath = false;
				}
				noMove = false;
				carD = 0;
				setX(300);
				setY(679.8 + movementY);
				String url = "file:src/main/resources/froggerUp.png";
				setImage(ImageProvider.get(url, imgSize));
				point = firstPoint;
				changeScore = true;
			}

		}

		if (getX() > 600) {
			move(-movementY * 2, 0);
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getX() == 240 && getY() == 82) {
			stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && !noMove) {
			Log log = getIntersectingObjects(Log.class).get(0);
			move(log.getSpeed(), 0);
		} else if (getIntersectingObjects(Turtle.class).size() >= 1 && !noMove) {
			move(-1, 0);
		} else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1, 0);
			}
		} else if (getIntersectingObjects(End.class).size() >= 1) {
			setX(300);
			setY(679.8+movementY);
			SceneController.getInstance().goNextLevel(this);
		} else if (getY() < 413) {
			waterDeath = true;
			setX(300);
			setY(679.8+movementY);
		}
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
			jumping = !jumping;
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
