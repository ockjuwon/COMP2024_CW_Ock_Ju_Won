package frogger.controller;

import frogger.model.Animal;
import frogger.model.MusicPlayer;
import frogger.model.ScoreBoard;
import frogger.model.World;
import frogger.view.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.MalformedURLException;
import java.util.HashMap;


public class SceneController extends World {
    private static SceneController instance;
    private final HashMap<String, Pane> paneHashMap = new HashMap<>();
    private String sceneName = null;
    private Pane currentPane = null;
    private final Stage primaryStage;
    static final int WORLD_WIDTH = 600;
    static final int WORLD_HEIGHT = 800;
    private MusicPlayer musicPlayer;
    private int endCount = 0;


    public SceneController(Stage primaryStage) {
        try {
            musicPlayer = new MusicPlayer();
        } catch (MalformedURLException err) {
            err.printStackTrace();
        }
        if(instance == null) {
            instance = this;
        } else {
            throw new ExceptionInInitializerError("Multiple construction of singleton class");
        }
        this.primaryStage = primaryStage;
        addScreen();
    }

    public void start() {
        changeScene("start");
    }

    private void addScreen() {
        paneHashMap.put("start", new Start());
        paneHashMap.put("info", new Info());
        paneHashMap.put("win", new Win());
        paneHashMap.put("level1", new Level1());
        paneHashMap.put("level2", new Level2());
        paneHashMap.put("level3", new Level3());
        paneHashMap.put("level4", new Level4());
        paneHashMap.put("level5", new Level5());
        paneHashMap.put("level6", new Level6());
        paneHashMap.put("level7", new Level7());
        paneHashMap.put("level8", new Level8());
        paneHashMap.put("level9", new Level9());
        paneHashMap.put("level10", new Level10());

        for(String key : paneHashMap.keySet()) {
            Pane pane = paneHashMap.get(key);
//            Scene scene = new Scene(pane, WORLD_WIDTH, WORLD_HEIGHT);
//            scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
//                final String storedKey = key;
//                @Override
//                public void handle(KeyEvent event) {
//                    if(event.getCode() == KeyCode.ESCAPE) {
//                        if(storedKey.equals("start")) {
//                            return;
//                        }
//                        changeScene("start");
//                    }
//                }
//            });
//            sceneHashMap.put(key, scene);
        }
    }

    public void touchEnd(Animal animal) {
        endCount++;
        if(endCount < 5) {
            return;
        }
        endCount = 0;
        goNextLevel(animal);
    }

    public void goNextLevel(Animal animal) {
        if(!sceneName.startsWith("level")) {
            changeScene("level1");
            return;
        }
        int idx = Integer.parseInt(String.valueOf(sceneName.charAt(sceneName.length()-1)));
        if(sceneName.equals("level10")) {
            win(animal);
            return;
        }
        idx++;
        String nextScene = String.format("level%d", idx);
        musicPlayer.stopMusic();
        if(sceneName.startsWith("level")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("You Have Won The Stage " + idx + "!");
            alert.setHeaderText("Your Current Score: "+animal.getPoint()+"!");
            alert.setContentText("Highest Possible Score: " + idx * 100);
            alert.show();
        }
        changeScene(nextScene);
    }

    public void win(Animal animal) {
        changeScene("win");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("You Have Won The Game!");
        alert.setHeaderText("Your High Score: "+animal.getPoint()+"!");
        alert.setContentText("Highest Possible Score: 1000");
        alert.show();
    }

    public void changeScene(String sceneName) {
        this.sceneName = sceneName;
        if(currentPane != null && currentPane instanceof World) {
            ((World) currentPane).stop();
        }
        musicPlayer.stopMusic();
        currentPane = paneHashMap.get(sceneName);
        primaryStage.setResizable(false);
        if(currentPane != null && currentPane instanceof World) {
            ScoreBoard scoreBoard = ((Level) currentPane).getScoreBoard();
            scoreBoard.focus();
            ((World) currentPane).start();
        }
        Scene scene = new Scene(currentPane, WORLD_WIDTH, WORLD_HEIGHT);
        if(sceneName.startsWith("info")) {
//            scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
//                final String storedKey = sceneName;
//                @Override
//                public void handle(KeyEvent event) {
//                    if(event.getCode() == KeyCode.ESCAPE) {
//                        if(storedKey.equals("start")) {
//                            return;
//                        }
//                        changeScene("start");
//                    }
//                }
//            });
        }
        primaryStage.setScene(scene);
        primaryStage.show();
        if(sceneName.startsWith("level")) {
            musicPlayer.playMusic();
        }
    }

    public Pane getCurrentPane() {
        return currentPane;
    }

    @Override
    public void act(long now) {

    }

    public static SceneController getInstance() {
        if(instance == null) {
            throw new NullPointerException("Instance is not initialized");
        }
        return instance;
    }


}
